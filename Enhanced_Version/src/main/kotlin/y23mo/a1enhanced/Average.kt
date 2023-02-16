package y23mo.a1enhanced

import javafx.scene.control.Label

// Act as a view of the application
// Display average score information
class Average(private val model: Model) : Label() {
    init {
        model.averageView = this;
        update();
    }

    fun update() {
        text = model.getAverage().toString();
    }
}