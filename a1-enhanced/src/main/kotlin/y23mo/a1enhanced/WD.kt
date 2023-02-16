package y23mo.a1enhanced

import javafx.scene.control.CheckBox

// Act as a controller to the application
// Update the WD option to Model
class WD(model: Model): CheckBox("Include WD") {
    init {
        isSelected = true;
        selectedProperty().addListener { _, _, newValue -> // Boolean
            if (newValue.not()){
                model.uncheck();
            }
            else {
                model.check();
            }
        }
    }
}
