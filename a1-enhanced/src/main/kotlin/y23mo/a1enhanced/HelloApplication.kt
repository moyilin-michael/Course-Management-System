package y23mo.a1enhanced

import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.Separator
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        // The model of application
        val model = Model();

        // First row of the toolbar
        val sortLabel = Label("Sort by:");
        val sort = Sort(model);
        val filterLabel = Label("Filter by:");
        val filter = Filter(model);
        val wd = WD(model);
        val tools = HBox(sortLabel, sort, Separator(), filterLabel, filter, Separator(), wd);

        // Second row of the toolbar
        val add = Label("Add Course:");
        val createButton = CreateButton(model);
        val indexBox = IndexBox(createButton);
        val titleBox = TitleBox(createButton);
        val termSelect = TermSelect(createButton);
        val gradeBox = GradeBox(createButton);
        val adder = HBox(add, indexBox, titleBox, termSelect, gradeBox, createButton).apply() {
            alignment = Pos.CENTER_LEFT;
            padding = Insets(10.0)
            background = Background(BackgroundFill(Color.DARKGREY, CornerRadii(5.0), null));
            spacing = 10.0;
            HBox.setHgrow(titleBox, Priority.ALWAYS);
        };

        // The section for displaying available courses
        val scrollView = ScrollView(model);

        // The status bar
        val average = Average(model);
        val courseTaken = CourseTaken(model);
        val courseFailed = CourseFailed(model);
        val highestMark = HighestMark(model);
        val footnote = HBox(Label("Course average:"), average, Separator(),
            Label("Courses taken:"), courseTaken, Separator(),
            Label("Courses failed:"), courseFailed, Separator(),
            Label("Highest mark:"), highestMark);

        // The scene content
        val root = VBox(tools, Separator(), adder, scrollView, footnote);
        VBox.setMargin(adder, Insets(8.0));

        stage.apply {
            title = "CS349 - A1 My Mark Management - y23mo"
            scene = Scene(root, 800.0, 600.0)
        }.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}