import {parse} from './ql-parser';
import {QuestionType} from '../app/domain/ast/index';
import {gen, check, property, sample, sampleOne} from 'testcheck';

const simpleForm =
  `
    form form {
      question: "Question?" boolean
    }
  `;

const expressionQuestionForm =
  `
    form form {
      question: "Question?" integer
      exprQuestion: "Expression?" integer = (question + 500)
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

function questionTypeToString(type: QuestionType): string {
  switch (type) {
    case QuestionType.BOOLEAN: return 'boolean';
    case QuestionType.DATE: return 'date';
    case QuestionType.DECIMAL: return 'decimal';
    case QuestionType.MONEY: return 'money';
    case QuestionType.STRING: return 'string';
    case QuestionType.INT: return 'integer';
    default: console.log(`Unknown type ${type}`);
  }
}

describe('Generated forms', () => {
  it('Should parse correctly generated forms', () => {
    check(property(gen.intWithin(0, 50), x => {
      const formName = sampleOne(gen.alphaNumString.notEmpty());
      const questions = sample(gen.alphaNumString.notEmpty(), x * 2);
      const types = sample(gen.intWithin(QuestionType.INT, QuestionType.BOOLEAN), x);
      let form = `form ${formName} { \r\n`;

      for (let i = 0, n = 0; i < questions.length; i += 2, n++) {
        form += `${questions[i]}: "${questions[i + 1]}" ${questionTypeToString(types[n])}\r\n`;
      }

      form += ' }';

      const output = parse(form, {});
      expect(output).not.toBeNull();
      expect(output.name).toBe(formName);
      expect(output.statements.length).toBe(x);
    }), {numTests: 100});
  });
});

describe('The parser', () => {
  it('Should parse simple form', () =>  {
    const output = parse(simpleForm, {});
    expect(output).not.toBeNull();
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

  it('Should parse expression questions', () =>  {
    const output = parse(expressionQuestionForm, {});
    expect(output).not.toBeNull();
    expect(output.name).toBe('form');
    expect(output.statements.length).toBe(2);
    expect(output.statements[0].name).toBe('question');
    expect(output.statements[0].label).toBe('Question?');
    expect(output.statements[0].type).toBe(QuestionType.INT);
    expect(output.statements[1].name).toBe('exprQuestion');
    expect(output.statements[1].label).toBe('Expression?');
    expect(output.statements[1].type).toBe(QuestionType.INT);
    expect(output.statements[1].expression).toBe('question + 500');
  });
});
