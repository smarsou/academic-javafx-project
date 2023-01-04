package eu.groupnine.codingweak;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import eu.groupnine.codingweak.stockage.Carte;
import eu.groupnine.codingweak.stockage.Pile;
import eu.groupnine.codingweak.stockage.Stockage;

public class Model extends Observateur{
    SceneController sc;
    Stockage stockFromDisk;

    public Model() throws FileNotFoundException, IOException{
        stockFromDisk = new Stockage();
        stockFromDisk.load();
    }
    

    public void exemple(){
        Pile pile1 = new Pile();

        pile1.setNom("pile1");
        pile1.setDescription("description pile 1");
        Carte carte1 = new Carte(1,"question1","reponse1");
        Carte carte2 = new Carte(2,"question1","reponse1");
        Carte carte3 = new Carte(3,"question1","reponse1");

        ArrayList<Carte> cars = new ArrayList<Carte>();
        cars.add(carte1);
        cars.add(carte2);
        cars.add(carte3);
        pile1.cartes = cars;
    }
    
}
