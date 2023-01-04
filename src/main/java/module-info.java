module eu.telecomnancy.visualcards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;
    opens eu.groupnine.codingweak to javafx.fxml;
    exports eu.groupnine.codingweak;

    exports eu.groupnine.codingweak.stockage;
    opens eu.groupnine.codingweak.stockage;
    
    
}