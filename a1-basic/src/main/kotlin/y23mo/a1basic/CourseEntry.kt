package y23mo.a1basic

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.*
import javafx.scene.paint.Color

// Act as a view of the application, but it is a subsystem about a course entry at the same time
// Display, update, and delete information of a course entry
class CourseEntry(model:Model, index:String, title:String, term:String, grade:String): HBox() {
    private val Index: String;
    private var Title: String;
    private var Term: String;
    private var Grade: String;
    init {
        Index = index;
        Title = title;
        Term = term;
        Grade = grade;
        val updateButton = UpdateButton(model, this);
        val deleteButton = DeleteButton(model, index);
        val indexField = IndexField(index);
        val titleField = TitleField(updateButton, title);
        val termField = TermField(updateButton, term);
        val gradeField = GradeField(updateButton, grade);
        children.add(indexField);
        children.add(titleField);
        children.add(termField);
        children.add(gradeField);
        children.add(updateButton);
        children.add(deleteButton);
        alignment = Pos.CENTER_LEFT;
        padding = Insets(20.0)
        spacing = 10.0;
        setHgrow(titleField, Priority.ALWAYS);
        changeColor();
    }

    // Change color of the background
    fun changeColor() {
        if (Grade == "WD") {
            background = Background(BackgroundFill(Color.DARKSLATEGRAY, CornerRadii(5.0), null));
        }
        else {
            val intGrade = Grade.toInt();
            if (intGrade in 0..49) {
                background = Background(BackgroundFill(Color.LIGHTCORAL, CornerRadii(5.0), null));
            }
            else if (intGrade in 50..59) {
                background = Background(BackgroundFill(Color.LIGHTBLUE, CornerRadii(5.0), null));
            }
            else if (intGrade in 60..90) {
                background = Background(BackgroundFill(Color.LIGHTGREEN, CornerRadii(5.0), null));
            }
            else if (intGrade in 91..95) {
                background = Background(BackgroundFill(Color.SILVER, CornerRadii(5.0), null));
            }
            else {
                background = Background(BackgroundFill(Color.GOLD, CornerRadii(5.0), null));
            }
        }
    }

    fun getIndex():String {
        return Index;
    }

    fun getTitle():String {
        return Title;
    }

    fun getTerm():String {
        return Term;
    }

    fun getGrade():String {
        return Grade;
    }

    // called when filter() in Model.kt encounters "WD" as course grade
    fun getNeg1():Int {
        return -1;
    }

    fun setTitle(s:String) {
        Title = s;
    }

    fun setTerm(s:String) {
        Term = s;
    }

    fun setGrade(s:String) {
        Grade = s;
    }
}
