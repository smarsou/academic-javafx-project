package eu.groupnine.codingweak;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class VueJouerController implements Observer{
    private Model model;

    @FXML
    private Label Question;

    @FXML
    private Label Reponse;

    @FXML
    private ProgressBar bar;

    @FXML
    private Button trouve;

    @FXML
    private Button pastrouve;

    private static int indexCourant = 0;

    

    

    public VueJouerController(Model model){
        this.model = model;
    }

    @FXML
    public void ShowAnswer() {

        trouve.setDisable(false);
        pastrouve.setDisable(false);



    }
    @FXML
    public void Found() {
        //mettre à jour les stats

        //Passer à carte suivante
        VueJouerController.indexCourant++;
        int ind = VueJouerController.indexCourant;
        

    }

    @FXML
    public void NotFound() {
        //mettre à jour les stats
        //Passer à carte suivante
        VueJouerController.indexCourant++;
        int ind = VueJouerController.indexCourant;

    }


    public void refresh(){
        //choisir question et reponses dans pile
        
        
    }
}
