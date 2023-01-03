package eu.groupnine.codingweak.controller;

import eu.groupnine.codingweak.Model;
import eu.groupnine.codingweak.Observer;

public class VueAccueilController implements Observer{
    
    Model model;

    public VueAccueilController(Model model){
        this.model = model;
    }

    public void refresh(){
        
    }

}
