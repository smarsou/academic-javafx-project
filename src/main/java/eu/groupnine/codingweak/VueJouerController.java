package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Set;

public class VueJouerController implements Observer{
    Model model;

    @FXML
    Label valeurTemps,valeurFrequence;

    @FXML
    Button boutonJouer;

    @FXML
    SplitMenuButton valeurOrdre;

    @FXML
    CheckBox valeurSmartMode;

    public VueJouerController(Model model){
        this.model = model;
    }

    public void choixOrdre(){
        
    }
    public void choixJouer(){
        model.sc.afficherParent("Jeu");
        model.sc.callFunctFromController("startQuestion");
    }

    public void refresh(){
        
    }
}
