package eu.groupnine.codingweak;

import org.controlsfx.control.PropertySheet.Mode;

import eu.groupnine.codingweak.stockage.Stockage;

public class Model extends Observateur{
    SceneController sc;
    private Stockage stockFromDisk;

    public Model() {
        this.stockFromDisk = new Stockage();
    }

    public Stockage getStock() {
        return this.stockFromDisk;
    }



    
}
