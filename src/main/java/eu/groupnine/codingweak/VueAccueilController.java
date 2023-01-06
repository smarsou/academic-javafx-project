package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
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
        setIcone();
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
        this.model.callObservers();
        //model.sc.callFunctFromController("startQuestion");
        //model.PileCartes = model.getCurrentPile().cartes;
        // model.callObservers();
    }

    public void Seetings(){
        model.sc.afficherParent("Reglage");
        //model.sc.callFunctFromController("InitializeReglage");
        // System.out.println(model.keyClicked);
        model.PileCartes = model.getCurrentPile().cartes;
        this.model.callObservers();
        
    }


    public void addPile() throws InterruptedException{
        Pile nouvellePile = new Pile();
        String nouvelleCle = "";
        Set<String> pileNames = model.stockFromDisk.EnsembleDesPiles.keySet();
        int indexPile = model.stockFromDisk.EnsembleDesPiles.size();
        int x = 1;
        while (x==1){
            if (indexPile == 0){
                x = 0;
                nouvelleCle = "nouvelle pile n° " + indexPile;
            }
            
            else{
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

    public void DeletePile() throws FileNotFoundException, IOException {
        model.stockFromDisk.EnsembleDesPiles.remove(model.keyClicked);
        model.stockFromDisk.save();
        model.callObservers();
    }

    public void setIcone(){
        Image image1 = new Image(getClass().getResource("/icone/jouer.png").toExternalForm()); 
        ImageView icon1 = new ImageView(image1);
        icon1.setFitWidth(30);
        icon1.setFitHeight(30); 
        PlayButton.setGraphic(icon1);
        PlayButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        Image image2 = new Image(getClass().getResource("/icone/option.png").toExternalForm()); 
        ImageView icon2 = new ImageView(image2);
        icon2.setFitWidth(30);
        icon2.setFitHeight(30); 
        SeetingsButton.setGraphic(icon2);
        SeetingsButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        Image image3 = new Image(getClass().getResource("/icone/supprimer.png").toExternalForm()); 
        ImageView icon3 = new ImageView(image3);
        icon3.setFitWidth(30);
        icon3.setFitHeight(30); 
        DeleteButton.setGraphic(icon3);
        DeleteButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        Image image4 = new Image(getClass().getResource("/icone/ajouter.png").toExternalForm()); 
        ImageView icon4 = new ImageView(image4);
        icon4.setFitWidth(30);
        icon4.setFitHeight(30); 
        AddButton.setGraphic(icon4);
        AddButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        
    }

    public void refresh() {
        initialize(null, null);
        
    }

}
