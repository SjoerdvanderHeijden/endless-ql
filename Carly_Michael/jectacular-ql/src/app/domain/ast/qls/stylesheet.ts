import {Page} from './page';
import {Location} from '../location';
import {QlsNode, QuestionWithAppliedStyles} from './qls-node';
import {Style} from './style';
import {DefaultStyling} from './default-styling';
import {QlQuestion as QlQuestion} from '../ql';
import * as _ from 'lodash';
import {MissingIdentifierError} from '../../errors';
import {QlsVisitor} from './visitors/collect-styles-for-question-visitor';

export class Stylesheet extends QlsNode {
  constructor(readonly name: string, readonly pages: Page[], readonly location: Location) {
    super();
  }

  accept<T>(visitor: QlsVisitor<T>): T {
    return visitor.visitStylesheet(this);
  }

  getQuestions(parentStyles: ReadonlyArray<Style>): ReadonlyArray<QuestionWithAppliedStyles> {
    let questions = [];

    for (const page of this.pages) {
      questions = questions.concat(page.getQuestions([]));
    }

    return questions;
  }

  checkStylesheet(parentDefaults: ReadonlyArray<DefaultStyling>, allQuestions: ReadonlyArray<QlQuestion>): void {
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
