module eu.telecomnancy.visualcards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens eu.group9.codingweak to javafx.fxml;
    exports eu.group9.codingweak;
}