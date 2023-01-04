package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Set;

public class VueAccueilController implements Observer{
    
    Model model;

    @FXML
    ListView<String> PileSpace;

    @FXML
    Button PlayButton;

    @FXML
    Button DeleteButton;

    @FXML
    Button AddButton;

    public VueAccueilController(Model model){
        this.model = model;
        chargePile();
    }

    public void chargePile(){
        //Obtenir l'ensemble des clés du dictionnaire
        Set<String> pileNames = (Set<String>) model.stockFromDisk.EnsembleDesPiles;
        if (pileNames == null){
            return;
        }

        for (String pileName : pileNames) {
            String NameDescription;
            String Name= model.stockFromDisk.EnsembleDesPiles.get(pileName).getNom();
            String Description= model.stockFromDisk.EnsembleDesPiles.get(pileName).getDescription();
            NameDescription = Name + "   :  " + Description;
            PileSpace.getItems().add(NameDescription);
        }
    }

    public void Play(){
        model.sc.afficherParent("Jeu");
    }

    public void Seetings(){
        model.sc.afficherParent("Reglage");
    }


    public void addPile(){
        model.sc.afficherParent(null);
    }
    


    public void refresh(){
        model.callObservers();
    }

}
