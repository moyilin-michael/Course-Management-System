package y23mo.a1enhanced

import javafx.scene.control.TextField

// Act as a sub-controller to UpdateButton
// Change the course name info of a single course entry stored in UpdateButton
class TitleField(updateButton: UpdateButton, title: String): TextField(title) {
    init {
        prefHeight = 10.0;
        prefWidth = 400.0;
        textProperty().addListener { _, _, newValue -> // String
            updateButton.addTitle(newValue);
            updateButton.isDisable = false;
        }
    }
}
