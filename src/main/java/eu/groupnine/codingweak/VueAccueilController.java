package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

public class VueAccueilController implements Observer, Initializable{
    
    Model model;

    @FXML
    ListView<String> PileSpace;

    @FXML
    Button PlayButton;

    @FXML
    Button DeleteButton;

    @FXML
    Button SeetingsButton;

    @FXML
    Button AddButton;

    
    
    
    public VueAccueilController(Model model){
        this.model = model;
        model.observers.add(this);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PileSpace.getItems().clear();
        PlayButton.setDisable(true);
        DeleteButton.setDisable(true);
        SeetingsButton.setDisable(true);
        chargePile();
        
    }
    


    public void chargePile(){
        //Obtenir l'ensemble des clés du dictionnaire
        Set<String> pileNames = model.stockFromDisk.EnsembleDesPiles.keySet();
        
        if (pileNames == null){
            return;
        }

        for (String pileName : pileNames) {
            String NameDescription;
            String Name= model.stockFromDisk.EnsembleDesPiles.get(pileName).getNom();
            String Description= model.stockFromDisk.EnsembleDesPiles.get(pileName).getDescription();
            NameDescription = Name + " : " + Description;
            PileSpace.getItems().add(NameDescription);
        }

    }

    public void Play(){
        model.sc.afficherParent("Jouer");
        // model.sc.callFunctFromController("startQuestion");
    }

    public void Seetings(){
        model.sc.afficherParent("Reglage");
        model.sc.callFunctFromController("InitializeReglage");
    }


    public void addPile() throws InterruptedException{
        Pile nouvellePile = new Pile();
        String nouvelleCle = "";
        Set<String> pileNames = model.stockFromDisk.EnsembleDesPiles.keySet();
        int indexPile = model.stockFromDisk.EnsembleDesPiles.size();

        int x = 1;
        while (x==1){
            System.out.println("aaaaaaaaaa");
            for (String pileName : pileNames) {
                nouvelleCle = "nouvelle pile n° " + indexPile;
                if (pileName.equals(nouvelleCle)){
                    x = 1;
                }
                else{
                    x = 0;
                    
                }
            }
        }
        nouvellePile.setNom(nouvelleCle);
        nouvellePile.setDescription("no description");
        model.stockFromDisk.EnsembleDesPiles.put(nouvelleCle, nouvellePile);
        model.callObservers();
    }

    public void ActivateButton(){
        if(PileSpace.getSelectionModel().getSelectedIndex() >= 0){
            savePileClicked();
            PlayButton.setDisable(false);
            DeleteButton.setDisable(false);
            SeetingsButton.setDisable(false);
        }
    }

    //Cette méthode sauvegarde la clé de la pile cliquée
    public void savePileClicked(){
        Set<String> pileNames = model.stockFromDisk.EnsembleDesPiles.keySet();
            int i = 0;
            for (String pileName : pileNames) {
                if (i == PileSpace.getSelectionModel().getSelectedIndex()){
                    model.keyClicked = pileName;
                }
                i++;
            }
    }

    public void DeletePile() {
        model.stockFromDisk.EnsembleDesPiles.remove(model.keyClicked);
        model.callObservers();
    }

    public void refresh() throws InterruptedException{
        System.out.println("Refresh accueil");
        initialize(null, null);
    }

}
