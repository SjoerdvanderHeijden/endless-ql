import Form from "../../../form/Form";
import PagedFormState from "./PagedFormState";
import FieldNode from "../../../form/nodes/fields/FieldNode";
import StyleSheetNode from "../form/nodes/StyleSheet";
import FieldVisitor from "../../../form/nodes/visitors/FieldVisitor";
import PageNode from "./nodes/containers/PageNode";
import { filterNodes } from "../../../form/form_helpers";
import StyledFieldNode from "./StyledFieldNode";
import FormNode from "../../../form/nodes/FormNode";

export default class StyledForm implements Form {
  private baseForm: Form;
  private stylesheetNode: StyleSheetNode;

  constructor(baseForm: Form, stylesheetNode: StyleSheetNode) {
    this.stylesheetNode = stylesheetNode;
    this.baseForm = baseForm;
  }

  getName(): string {
    return this.baseForm.getName();
  }

  getFields(): FieldNode[] {
    return filterNodes(
        (node) => {
          return node instanceof StyledFieldNode;
        },
        this.baseForm.getRootNode()
    );
  }

  getState(): PagedFormState {
    return this.baseForm.getState();
  }

  setAnswer(identifier: string, value: any): Form {
    const newBaseForm = this.baseForm.setAnswer(identifier, value);
    return new StyledForm(newBaseForm, this.stylesheetNode);
  }

  getRootNode(): FormNode {
    return this.baseForm.getRootNode();
  }

  getAnswer(identifier: string): any {
    return this.baseForm.getAnswer(identifier);
  }

  accept(visitor: FieldVisitor): any {
    return this.baseForm.accept(visitor);
  }

  getPages(): PageNode[] {
    return this.stylesheetNode.getPages();
  }
}