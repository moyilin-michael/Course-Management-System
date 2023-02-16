package y23mo.a1basic

import javafx.event.EventHandler
import javafx.scene.control.Button

/* Act as a controller to the application,but it is a model to sub-controllers including IndexField, TitleField,
TermField, and GradeField.
 */
// Update a new course's info to Model
class UpdateButton(model: Model, course: CourseEntry): Button("Update") {
    private val Index: String;
    private var Title: String;
    private var Term: String;
    private var Grade: String;

    init {
        Index = course.getIndex();
        Title = course.getTitle();
        Term = course.getTerm();
        Grade = course.getGrade();
        onAction = EventHandler {
            model.updateClass(Index, Title, Term, Grade);
            isDisable = true;
        }
        isDisable = true;
    }

    fun addTitle(s:String) {
        Title = s;
    }

    fun addTerm(s:String) {
        Term = s;
    }

    fun addGrade(s:String) {
        val num:Int? = s.toIntOrNull();
        if (s == "WD" || (num != null && num <= 100 && num >= 0)) {
            Grade = s;
        }
    }
}
