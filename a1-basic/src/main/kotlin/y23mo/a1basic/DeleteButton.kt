package y23mo.a1basic

import javafx.event.EventHandler
import javafx.scene.control.Button

// Act as a controller to the application
// Delete a course from Model
class DeleteButton(model: Model, index: String): Button("Delete") {
    init {
        onAction = EventHandler {
            model.deleteClass(index);
        }
    }
}
