module com.example.fxhi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.fxhi to javafx.fxml;
    exports com.example.fxhi;
}