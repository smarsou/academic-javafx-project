package eu.groupnine.codingweak;



import java.io.File;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuViewController implements Observer{

    private static Model model;
    public static Stage stage;

    @FXML private Menu menuEdit;

    public MenuViewController(){
        model.observers.add(this);
    }

    public static void setModel(Model m){
        model = m;
    }

    public void accueil(){
        model.sc.afficherParent("Page");
        model.callObservers();
    }

    public void fermer(){
        Platform.exit();
    }

    public void openStats(){
        model.sc.afficherParent("StatGlobal");
        model.callObservers();
    }

    public void importPile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open JSON file");
        fileChooser.getExtensionFilters().setAll(
     new FileChooser.ExtensionFilter("Text Files", "*.json")
);
        File file = fileChooser.showOpenDialog(stage);
        
    }

    public void refresh(){
        if (model.sc.strMain != "Page"){
            menuEdit.setVisible(false);
        }else{
            menuEdit.setVisible(true);
        }
    }


}