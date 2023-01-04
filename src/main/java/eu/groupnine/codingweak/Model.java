package eu.groupnine.codingweak;

import java.util.ArrayList;

import org.controlsfx.control.PropertySheet.Mode;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;

public class Model extends Observateur{
    SceneController sc;
    Stockage stockFromDisk;
    ArrayList<Carte> PileCartes;


    

    public void setCard(){
        
        Carte carte1 = new Carte(1,"question1","reponse1");
        Carte carte2 = new Carte(2,"question1","reponse1");
        Carte carte3 = new Carte(3,"question1","reponse1");

        
        this.PileCartes.add(carte1);
        this.PileCartes.add(carte2);
        this.PileCartes.add(carte3);
        
    }
    
}
