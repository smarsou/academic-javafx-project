package eu.groupnine.codingweak.controller;

import eu.groupnine.codingweak.Model;
import eu.groupnine.codingweak.Observer;

public class VueStatPartieController implements Observer{
    Model model;

    public VueStatPartieController(Model model){
        this.model = model;
    }
    public void refresh(){
        
    }
}