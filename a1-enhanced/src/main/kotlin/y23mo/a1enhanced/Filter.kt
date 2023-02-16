package y23mo.a1enhanced

import javafx.scene.control.ChoiceBox

// Act as a controller to the application
// Update the filtering method to Model
class Filter(model: Model) : ChoiceBox<String>() {
    init{
        items.addAll("All courses", "CS courses only",
            "MATH courses only", "Other courses");
        value = items[0];
        valueProperty().addListener { _, _, newValue -> // String
            model.filterBy(newValue);
        }
    }
}
