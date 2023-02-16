package y23mo.a1enhanced

import javafx.scene.control.TextField

// Act as a sub-controller to CreateButton
// Change the course name info stored in CreateButton
class TitleBox(createButton: CreateButton): TextField() {
    init {
        prefHeight = 10.0;
        prefWidth = 400.0;
        textProperty().addListener { _, _, newValue -> // String
            createButton.addTitle(newValue);
        }
    }
}
