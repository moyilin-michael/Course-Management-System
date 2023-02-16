package y23mo.a1basic

import javafx.scene.control.TextField

// Act as a sub-controller to UpdateButton
// Change the grade info of a single course entry stored in UpdateButton
class GradeField(updateButton: UpdateButton, grade: String): TextField(grade) {
    init {
        prefHeight = 10.0;
        prefWidth = 40.0;
        textProperty().addListener { _, _, newValue -> // String
            updateButton.addGrade(newValue);
            updateButton.isDisable = false;
        }
    }
}
