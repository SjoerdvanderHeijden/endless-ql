package ui.view

import tornadofx.*
import ui.model.QuestionFormModel


class DogeMainView : View() {

    private val model: QuestionFormModel by inject()

    override val root = scrollpane()

    init {
        root.minHeight = 400.0
        root.minWidth = 400.0

        with(root) {
            form {
                fieldset {
                    children.bind(model.questions) {
                        field(it.item.label) {
                            add(QuestionField(it))
                        }
                    }
                }
                button("Save") {
                    action {
                        save()
                    }
                }
            }

            runAsync {
                model.load()
            }
        }
    }

    private fun save() {
        model.commit()
        model.load()
    }
}
