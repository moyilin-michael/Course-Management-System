package y23mo.a1enhanced

import javafx.scene.control.Label

// Act as a view of the application
// Display the number of failed courses
class CourseFailed(private val model: Model) : Label() {
    init {
        model.failedView = this;
        update();
    }

    fun update() {
        text = model.getFailed().toString();
    }
}
