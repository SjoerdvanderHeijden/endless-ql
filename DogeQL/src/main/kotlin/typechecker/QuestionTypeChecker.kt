package typechecker

import common.Name
import data.Question
import java.util.HashMap

class QuestionTypeChecker() : TypeChecker{

    fun findDuplicateLabels(table : HashMap<Name, Question>): List<String> {

        val uniqueLabels = HashSet<String>()

        val duplicateLabels = ArrayList<String>()

        table.forEach{
            _, question ->
            if (!uniqueLabels.add(question.label)){
                duplicateLabels.add(question.label)
            }
        }

        duplicateLabels.forEach{
            label ->
            println("Warning duplicate label: $label")
        }

        return duplicateLabels
    }
}