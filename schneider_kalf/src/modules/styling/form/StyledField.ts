import FieldNode from "../../../form/nodes/fields/FieldNode";
import MergedFieldStyle from "./MergedFieldStyle";
import QuestionStyle from "./nodes/children/QuestionStyle";
import Page, { default as PageNode } from "./nodes/containers/PageNode";
import { FieldType } from "../../../form/FieldType";
import { Maybe } from "../../../helpers/type_helper";

export default class StyledField {
  private fieldNode: FieldNode;
  private mergedStyle: MergedFieldStyle;
  private styleNode: Maybe<QuestionStyle>;

  constructor(field: FieldNode, mergedStyle: MergedFieldStyle, questionStyleNode?: QuestionStyle) {
    this.fieldNode = field;
    this.mergedStyle = mergedStyle;
    this.styleNode = questionStyleNode;
  }

  public getFieldNode(): FieldNode {
    return this.fieldNode;
  }

  public getType(): FieldType {
    return this.fieldNode.type;
  }

  public getIdentifier(): string {
    return this.fieldNode.identifier;
  }

  public getMergedStyle(): MergedFieldStyle {
    return this.mergedStyle;
  }

  public getPage(): Maybe<Page> {
    if (!this.styleNode) {
      return undefined;
    }

    return this.styleNode.getNearestParent(parent => parent.isPage());
  }

  public isOnPage(otherPage?: PageNode): boolean {
    const page = this.getPage();

    if (!page || !otherPage) {
      return false;
    }

    return page.isEqual(otherPage);
  }

  static makeFromCollections(fieldNode: FieldNode, merged: MergedFieldStyle[], questions: QuestionStyle[]) {
    let mergedFieldStyle = merged.find(style => style.appliesToField(fieldNode));
    const questionStyle = questions.find(style => style.appliesToField(fieldNode));

    if (!mergedFieldStyle) {
      mergedFieldStyle = MergedFieldStyle.makeEmpty(fieldNode);
    }

    return new StyledField(fieldNode, mergedFieldStyle, questionStyle);
  }
}