import {parse} from './ql-parser';
import {QuestionType} from '../app/domain/ast';

const simpleForm =
  `
    form form {
      question: "Question?" boolean
    }
  `;

const multipleQuestionForm =
  `
    form form {
      questionOne: "Question1?" boolean
      questionTwo: "Question2?" string
      questionThree: "Question3?" date
      questionFour: "Question4?" money
    }
  `;

const ifQuestionForm =
  `
    form form {
      question: "Question?" boolean
      if (question) {
        questionIf: "QuestionIf?" integer
      }
    }
  `;

const formWrongName =
  `
    form form! {
      question: "Question?" boolean
    }
  `;

const formWrongQuestionName =
  `
    form form {
      questionå: "Question?" boolean
    }
  `;

describe('The parser', () => {
  it('Should parse simple form', () =>  {
    const output = parse(simpleForm, {});
    expect(output).not.toBeNull();
    console.log(output);
    expect(output.name).toBe('form');
    expect(output.statements.length).toBe(1);
    expect(output.statements[0].name).toBe('question');
    expect(output.statements[0].label).toBe('Question?');
    expect(output.statements[0].type).toBe(QuestionType.BOOLEAN);
  });

  it('Should parse form only with certain characters', () => {
    expect(() => parse(formWrongName, {})).toThrow();
    expect(() => parse(formWrongQuestionName, {})).toThrow();
  });

  it('Should parse multiple questions', () => {
    const output = parse(multipleQuestionForm, {});
    expect(output).not.toBeNull();
    expect(output.name).toBe('form');
    expect(output.statements.length).toBe(4);
    expect(output.statements[0].name).toBe('questionOne');
    expect(output.statements[0].type).toBe(QuestionType.BOOLEAN);
    expect(output.statements[0].label).toBe('Question1?');
    expect(output.statements[1].name).toBe('questionTwo');
    expect(output.statements[1].label).toBe('Question2?');
    expect(output.statements[1].type).toBe(QuestionType.STRING);
    expect(output.statements[2].name).toBe('questionThree');
    expect(output.statements[2].label).toBe('Question3?');
    expect(output.statements[2].type).toBe(QuestionType.DATE);
    expect(output.statements[3].name).toBe('questionFour');
    expect(output.statements[3].label).toBe('Question4?');
    expect(output.statements[3].type).toBe(QuestionType.MONEY);
  });

  it('should parse a form with an if statement', () => {
    const output = parse(ifQuestionForm, {});
    expect(output).not.toBeNull();
    expect(output.name).toBe('form');
    expect(output.statements.length).toBe(2);
    expect(output.statements[0].name).toBe('question');
    expect(output.statements[0].label).toBe('Question?');
    expect(output.statements[0].type).toBe(QuestionType.BOOLEAN);

    const ifStatement = output.statements[1];
    expect(ifStatement.condition).toBe('question');
    expect(ifStatement.statements.length).toBe(1);
    expect(ifStatement.statements[0].name).toBe('questionIf');
    expect(ifStatement.statements[0].label).toBe('QuestionIf?');
    expect(ifStatement.statements[0].type).toBe(QuestionType.INT);
  });
});
