package y23mo.a1basic

import javafx.scene.control.ChoiceBox

// Act as a sub-controller to CreateButton
// Change the term info stored in CreateButton
class TermSelect(createButton: CreateButton): ChoiceBox<String>() {
    init{
        items.addAll("F20", "W21", "S21", "F21", "W22", "S22", "F22", "W23", "S23");
        valueProperty().addListener { _, _, newValue -> // String
            createButton.addTerm(newValue);
        }
    }
}