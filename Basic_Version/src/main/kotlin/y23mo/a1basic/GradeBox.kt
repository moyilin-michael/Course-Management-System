package y23mo.a1basic

import javafx.scene.control.TextField

// Act as a sub-controller to CreateButton
// Change the grade info stored in CreateButton
class GradeBox(createButton: CreateButton): TextField() {
    init {
        prefHeight = 10.0;
        prefWidth = 40.0;
        textProperty().addListener { _, _, newValue -> // String
            createButton.addGrade(newValue);
        }
    }
}
