package y23mo.a1basic

import javafx.scene.control.TextField

// Act as a sub-controller to CreateButton
// Change the course code info stored in CreateButton
class IndexBox(createButton: CreateButton): TextField() {
    init {
        prefHeight = 10.0;
        prefWidth = 80.0;
        textProperty().addListener { _, _, newValue -> // String
            createButton.addIndex(newValue);
        }
    }
}
