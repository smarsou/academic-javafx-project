package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Menu1viewController {
    private Model model;

    // @FXML
    // private Label Question;

    // @FXML
    // private Label Question;

    public Menu1viewController(){}

    public void menu(){
        // model.sc.afficherParent("Page");
    }

    public void fermer(){
        Platform.exit();
    }


}
