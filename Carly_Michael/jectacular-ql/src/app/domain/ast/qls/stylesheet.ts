import {Page} from './page';
import {Location} from '../location';
import {Node, QuestionWithAppliedStyles} from './node';
import {Style} from './style';
import {Default} from './default';
import {QlQuestion as QlQuestion} from '../ql';
import * as _ from 'lodash';
import {MissingIdentifierError} from '../../errors';

export class Stylesheet extends Node {
  constructor(readonly name: string, readonly pages: Page[], readonly location: Location) {
    super();
  }

  getQuestions(parentStyles: ReadonlyArray<Style>): ReadonlyArray<QuestionWithAppliedStyles> {
    let questions = [];

    for (const page of this.pages) {
      questions = questions.concat(page.getQuestions([]));
    }

    return questions;
  }

  checkStylesheet(parentDefaults: ReadonlyArray<Default>, allQuestions: QlQuestion[]): void {
    for (const page of this.pages) {
      page.checkStylesheet(parentDefaults, allQuestions);
    }

    // Check that all questions defined in QL are mentioned in QLS
    const allQlsQuestions = this.getQuestions([]);

    for (const qlQuestion of allQuestions) {
      const qlsQuestion = _.find(allQlsQuestions, (question: QuestionWithAppliedStyles) => {
        return question.question.name === qlQuestion.name;
      });

      if (!qlsQuestion) {
        throw new MissingIdentifierError(`QL question ${qlQuestion.name} does not have a matching QLS question.`);
      }
    }
  }
}
