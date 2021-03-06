import {QuestionBase} from './question-base';
import {FormGroup} from '@angular/forms';

export class BooleanQuestion extends QuestionBase<string> {
  constructor(key: string,
              label: string,
              value,
              type: string,
              hiddenCondition: (form: FormGroup) => boolean) {
    super(key, label, value, type, 'checkbox', hiddenCondition);
  }
}
