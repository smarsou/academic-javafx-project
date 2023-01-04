package eu.groupnine.codingweak;

import java.util.concurrent.TimeUnit;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
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

    @FXML
    private Button brep;

    private static int indexCourant = 0;

    

    

    public VueJouerController(Model model){
        this.model = model;
        this.model.setCard();
    }

    @FXML
    public void ShowAnswer() {
        int id = VueJouerController.indexCourant;
        Carte c = this.model.PileCartes.get(id);
        this.Reponse.setText(c.getReponse());

        trouve.setDisable(false);
        pastrouve.setDisable(false);
        this.brep.setDisable(true);

    }
    @FXML
    public void Found() throws InterruptedException {
        //mettre à jour les stats

        //Passer à carte suivante
        if (VueJouerController.indexCourant < this.model.PileCartes.size()) {
            VueJouerController.indexCourant++;
            this.refresh();

        }

    }

    @FXML
    public void NotFound() throws InterruptedException {
        //mettre à jour les stats
        //Passer à carte suivante
        if (VueJouerController.indexCourant < this.model.PileCartes.size()) {
            VueJouerController.indexCourant++;
            this.refresh();

        }
        
        

    }

    


    public void refresh() throws InterruptedException {
        //choisir question et reponses dans pile
        int id = VueJouerController.indexCourant;
        Carte card = this.model.PileCartes.get(id);
        this.Question.setText(card.getQuestion());
        this.brep.setDisable(false);
        //Set le temps
        TimeUnit.SECONDS.sleep(this.model.time);
        
    }
}
