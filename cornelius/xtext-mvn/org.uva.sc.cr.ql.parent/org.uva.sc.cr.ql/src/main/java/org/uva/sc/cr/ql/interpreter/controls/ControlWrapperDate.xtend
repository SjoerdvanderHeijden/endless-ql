package org.uva.sc.cr.ql.interpreter.controls

import javafx.beans.binding.BooleanBinding
import javafx.scene.control.DatePicker
import org.uva.sc.cr.ql.qL.Question

class ControlWrapperDate extends ControlWrapper {

	private var DatePicker control

	new(Question question, BooleanBinding binding) {
		super(question, binding)
	}

	override getValue() {
		return control.value
	}

	override getControl() {
		return control
	}

	override protected buildControl() {
		control = new DatePicker()
	}

}
