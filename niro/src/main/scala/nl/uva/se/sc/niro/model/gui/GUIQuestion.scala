package nl.uva.se.sc.niro.model.gui

import nl.uva.se.sc.niro.gui.widget.Component
import nl.uva.se.sc.niro.model.AnswerType
import nl.uva.se.sc.niro.model.expressions.Expression

case class GUIQuestion(
    id: String,
    answerType: AnswerType,
    label: String,
    isReadOnly: Boolean,
    visibility: Expression, // Holds the accumulated if-conditions.
    var component: Option[Component] = None
)
