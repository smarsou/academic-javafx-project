package eu.groupnine.codingweak.controller;

import eu.groupnine.codingweak.Model;

public class VueJouerController implements Observer{
    Model model;

    public VueJouerController(Model model){
        this.model = model;
    }
    public void refresh(){
        
    }
}
