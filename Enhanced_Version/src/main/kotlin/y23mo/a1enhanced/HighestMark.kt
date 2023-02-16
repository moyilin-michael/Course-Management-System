package y23mo.a1enhanced

import javafx.scene.control.Label

// Act as a view of the application
// Display the highest score information
class HighestMark(private val model: Model) : Label() {
    init {
        model.hmarkView = this;
        update();
    }

    fun update() {
        text = model.getHmark().toString();
    }
}
