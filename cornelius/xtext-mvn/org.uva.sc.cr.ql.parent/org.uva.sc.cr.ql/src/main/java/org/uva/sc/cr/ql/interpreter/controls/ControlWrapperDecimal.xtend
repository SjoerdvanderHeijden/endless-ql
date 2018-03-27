package org.uva.sc.cr.ql.interpreter.controls

import javafx.beans.binding.StringBinding
import javafx.scene.control.TextField
import javafx.scene.control.TextFormatter
import javafx.util.converter.DoubleStringConverter
import org.uva.sc.cr.ql.qL.Question
import org.eclipse.xtend.lib.annotations.Accessors

class ControlWrapperDecimal extends ControlWrapper {

	static val DEFAULT_VALUE = 0

	@Accessors(PUBLIC_GETTER)
	var TextField textField

	new(Question question, StringBinding binding) {
		super(question, binding)
		if (question.expression !== null) {
			textField.textProperty().bind(binding)
		} else {
			textField.text = "" + DEFAULT_VALUE
		}
	}

	override getValue() {
		return textField.text
	}

	override getControl() {
		return textField
	}

	override protected buildControl() {
		textField = new TextField()
		textField.textFormatter = new TextFormatter(new DoubleStringConverter())
	}

}
