package y23mo.a1basic

import javafx.event.EventHandler
import javafx.scene.control.Button

/* Act as a controller to the application,but it is a model to sub-controllers including IndexBox, TitleBox,
TermSelect, and GradeBox.
 */
// Add a new course to Model
class CreateButton(private val model: Model)
    : Button("Create") {
    private var index: String;
    private var title: String;
    private var term: String;
    private var grade: String;

    init {
        index = "";
        title = "";
        term = "";
        grade = "";
        onAction = EventHandler {
            this.createClass();
        }
    }

    fun addIndex(s:String) {
        index = s;
    }

    fun addTitle(s:String) {
        title = s;
    }

    fun addTerm(s:String) {
        term = s;
    }

    fun addGrade(s:String) {
        val num:Int? = s.toIntOrNull();
        if (s == "WD" || (num != null && num in 0..100)) {
            grade = s;
        }
        else {
            grade = "";
        }
    }

    private fun createClass() {
        if (index != "" && term != "" && grade != "") {
            val course = mutableListOf(index, title, term, grade);
            model.addClass(course);
        }
    }
}
