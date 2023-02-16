package y23mo.a1enhanced

import javafx.scene.control.ChoiceBox
import javafx.scene.control.TextArea

// Act as a sub-controller to UpdateButton
// Change the term info of a single course entry stored in UpdateButton
class TermField(updateButton: UpdateButton, term: String): ChoiceBox<String>() {
    init {
        items.addAll("F20", "W21", "S21", "F21", "W22", "S22", "F22", "W23", "S23");
        value = term;
        valueProperty().addListener { _, _, newValue -> // String
            updateButton.addTerm(newValue);
            updateButton.isDisable = false;
        }
    }
}
