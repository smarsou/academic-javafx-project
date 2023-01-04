package eu.groupnine.codingweak;

import eu.groupnine.codingweak.stockage.Pile;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.Set;

public class VueAccueilController implements Observer{
    
    Model model;
    ListView<Pile> PileSpace;
    Button PlayButton;
    Button DeleteButton;
    Button AddButton;

    public VueAccueilController(Model model){
        this.model = model;
    }

    public void chargePile(){

    }
    


    public void refresh(){
        
    }

}
