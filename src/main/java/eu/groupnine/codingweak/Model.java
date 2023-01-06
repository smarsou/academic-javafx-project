package eu.groupnine.codingweak;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

import eu.groupnine.codingweak.stockage.Stats;
import org.controlsfx.control.PropertySheet.Mode;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;


public class Model extends Observateur{
        /* label pour page d'erreur */
    @FXML
    public Label texteErreur;
    private String messageErreur = new String();

    SceneController sc;
    ArrayList<Carte> PileCartes;
    String keyClicked;
    // public long time = 5;

    public long time;
    public Boolean ordrePile; /* true = ordre direct, false = ordre aléatoire  */
    public int frequencePile;
    public Boolean smartModePile; /* true = activé, false = desactivé  */

    Stockage stockFromDisk;

    Stats currentStats = new Stats();
    // Carte currentCarte;
    public int indexCurrentCarte = 0;

    public Model() throws FileNotFoundException, IOException{
        super();
        stockFromDisk = new Stockage();
        stockFromDisk.load();
        //initialiser PilesCartes
        Set<String> pileNames = stockFromDisk.EnsembleDesPiles.keySet();
        for (String pilename : pileNames){
            keyClicked = pilename;
            PileCartes = getCurrentPile().cartes;
            break;
        }
    }

    public Boolean checkPile(){
        if (PileCartes==null){
            System.err.println("PilesCartes is null");
            return false;
        }
        if (PileCartes.size()==0){
            System.err.println("Aucune cartes dans la Pile. Remplissez la Pile dans Réglage avant de jouer.");
            return false;
        }
        return true;

    }

    public Carte nexCarte(){
        if (PileCartes == null){
            System.err.println("ERROR: PilesCartes is null");
            return null;
        }
        else if (this.PileCartes.isEmpty()) {
            System.err.println("ERROR:PilesCartes is empty");
            return null;

        }
        return PileCartes.get(indexCurrentCarte);
    }

    public void mettreOrdreCartesAleat(){
        if (ordrePile==false){
            Collections.shuffle(PileCartes); 
        }
    }

    public void gestionFrequence(){
        ArrayList<Carte> PileCartesBis = new ArrayList<Carte>() ;
        for (int i = 0; i< frequencePile;i++){
            PileCartesBis.addAll(PileCartes);
        }
        PileCartes = PileCartesBis;
    }

    public void ajouterCarteSmart(){
        if (smartModePile){
            PileCartes.add(PileCartes.get(indexCurrentCarte));
        }
    }

    public boolean findNomInPiles(String nom) {
        
        for (Pile p : this.stockFromDisk.EnsembleDesPiles.values()) {
            if (p.getNom().equals(nom)) {
                return true;

            }

        }
        return false;


    }

    public boolean findDescInPiles(String desc) {
        
        for (Pile p : this.stockFromDisk.EnsembleDesPiles.values()) {
            if (p.getDescription().equals(desc)) {
                return true;
            }
            
        }
        return false;

    }

    public Pile getCurrentPile(){
        // System.out.println("pile choisie");
        return this.stockFromDisk.EnsembleDesPiles.get(keyClicked);
    }

    public void setStast(){
        currentStats.cartesTrouvees= 15;
        currentStats.cartesNonTrouvees=8;
    }


    public void setCard(){
        this.PileCartes = getCurrentPile().cartes;
    }

    

    public void ModifyQuestionCarte(int id, String q) {
        this.PileCartes.get(id).setQuestion(q);
    }

    public void ModifyReponseCarte(int id, String rep) {
        this.PileCartes.get(id).setReponse(rep);
    }
    
    public void reinit(){
        this.indexCurrentCarte = 0;
        currentStats = new Stats();
        PileCartes = getCurrentPile().cartes;
    }

    public void suppCarte(int parseInt) {
        this.PileCartes.remove(parseInt);
    }

    public Carte getCard(int id) {
        for (Carte c : this.PileCartes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @FXML
    public void afficherErreur() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("VueErreur.fxml"));
        loader.setControllerFactory(iC->this);
        Parent rootPage = loader.load();

        // afficher les données de la page
        this.texteErreur.setText(messageErreur);

        Scene scene = new Scene(rootPage);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
    }

    public void setErrorMessage(String error){
        this.messageErreur = error;
    }

    public boolean findQuestionInPile(String quest) {
        
        for (Carte c : this.PileCartes) {
            if (c.getQuestion().equals(quest)) {
                return true;

            }
        }
        return false;


    }

    public boolean findReponseInPile(String rep) {
        for (Carte c : this.PileCartes) {
            if (c.getReponse().equals(rep)) {
                return true;

            }
        }
        return false;

    }

    
}
