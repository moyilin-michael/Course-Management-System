module y23mo.a1enhanced {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens y23mo.a1enhanced to javafx.fxml;
    exports y23mo.a1enhanced;
}