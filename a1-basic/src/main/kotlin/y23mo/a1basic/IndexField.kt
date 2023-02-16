package y23mo.a1basic

import javafx.scene.control.TextField

// Act as a view to the subsystem about a course entry, and its content does not change after initialization
class IndexField(index: String): TextField(index) {
    init {
        prefHeight = 10.0;
        prefWidth = 80.0;
        isEditable = false;
    }
}
