package y23mo.a1basic

import javafx.scene.control.Label

// Act as a view of the application
// Display the number of taken courses
class CourseTaken(private val model: Model) : Label() {
    init {
        model.coursesView = this;
        update();
    }

    fun update() {
        text = model.getTaken().toString();
    }
}
