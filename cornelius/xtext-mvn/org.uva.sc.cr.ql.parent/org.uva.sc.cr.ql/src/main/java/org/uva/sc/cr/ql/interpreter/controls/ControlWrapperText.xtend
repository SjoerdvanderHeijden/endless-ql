package org.uva.sc.cr.ql.interpreter.controls

import javafx.beans.binding.StringBinding
import javafx.scene.control.TextField
import org.uva.sc.cr.ql.qL.Question

class ControlWrapperText extends ControlWrapper {

	var TextField control

	new(Question question, StringBinding binding) {
		super(question, binding)
		if (question.expression !== null) {
			control.textProperty().bind(binding)
		}
	}

	override getValue() {
		return control.text
	}

	override getControl() {
		return control
	}

	override protected buildControl() {
		control = new TextField()
	}

}
