module eu.telecomnancy.visualcards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens eu.groupnine.codingweak to javafx.fxml;
    exports eu.groupnine.codingweak;
    
}