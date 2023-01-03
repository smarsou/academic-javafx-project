package eu.groupnine.codingweak.controller;

import eu.groupnine.codingweak.Model;

public class VueReglageController implements Observer{
    Model model;

    public VueReglageController(Model model){
        this.model = model;
    }
    public void refresh(){
        
    }
}
