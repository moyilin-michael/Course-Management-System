package y23mo.a1enhanced

import javafx.scene.control.ScrollPane

// Act as a view to the application
// Wraps the views in variable displayEntry in Model
class ScrollView(model: Model) : ScrollPane() {
    init {
        model.scrollView = this;
        isFitToHeight = true;
        isFitToWidth = true;
        prefViewportHeight = 100000.0;
    }
}
