module y23mo.a1basic {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens y23mo.a1basic to javafx.fxml;
    exports y23mo.a1basic;
}