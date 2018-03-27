import WidgetAttribute from "../WidgetAttribute";
import { TextWidgetComponent } from "../../../../rendering/components/widgets/TextWidgetComponent";

// text (for numbers and strings)
export default class TextWidgetAttribute extends WidgetAttribute {
  getRenderComponent() {
    return TextWidgetComponent;
  }
}