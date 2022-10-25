module com.solanaCRMproject {
    requires javafx.controls;
    requires javafx.fxml;


    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.solanacrm to javafx.fxml;
    exports com.solanacrm;
}