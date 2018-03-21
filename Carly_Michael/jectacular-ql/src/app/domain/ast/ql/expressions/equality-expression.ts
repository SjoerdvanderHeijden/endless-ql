import {Expression} from './expression';
import {Location} from '../../location';
import {BinaryExpression} from './binary-expression';
import {ExpressionVisitor} from '../visitors/expression-visitor';

export class EqualExpression extends BinaryExpression {
  constructor(left: Expression, right: Expression, location: Location) {
    super(left, right, location);
  }

  accept<T>(visitor: ExpressionVisitor<T>): T {
    return visitor.visitEqualExpression(this);
  }
}

export class UnequalExpression extends BinaryExpression {
  constructor(left: Expression, right: Expression, location: Location) {
    super(left, right, location);
  }

  accept<T>(visitor: ExpressionVisitor<T>): T {
    return visitor.visitUnequalExpression(this);
  }
}
