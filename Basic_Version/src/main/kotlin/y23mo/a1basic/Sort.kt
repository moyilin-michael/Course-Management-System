package y23mo.a1basic

import javafx.scene.control.ChoiceBox

// Act as a controller to the application
// Update the sorting method to Model
class Sort(model: Model): ChoiceBox<String>() {
    init{
        items.addAll("Course code(alphabetically)", "Term(earlier to recent)",
            "Grade(in ascending order)", "Grade(in descending order)");
        valueProperty().addListener { _, _, newValue -> // String
            model.sortBy(newValue);
        }
    }
}
