package org.uva.sc.cr.qsl.interpreter

import javafx.stage.Stage
import javax.inject.Inject
import org.uva.sc.cr.ql.interpreter.QLJavaFxApplication
import org.uva.sc.cr.qsl.QSLStandaloneSetup
import org.uva.sc.cr.qsl.interpreter.service.StyleService
import org.uva.sc.cr.qsl.qSL.Model

class QSLJavaFxApplication extends QLJavaFxApplication {

	@Inject
	var StyleService styleService

	override createInjector() {
		return new QSLStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	override getForm() {
		val model = astData.allContents.head() as Model
		return model.form
	}

	def private getStylesheet() {
		val model = astData.allContents.head() as Model
		return model.stylesheet
	}

	override start(Stage primaryStage) {
		val stylesheet = getStylesheet()
		if (stylesheet !== null) {
			stageBuilder.buildGuiLayout(form)
			val wizard = styleService.styleLayout(stylesheet)
			wizard.title = form.name
			wizard.showAndWait()
		} else {
			super.start(primaryStage)
		}
	}

}
