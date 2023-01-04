package eu.groupnine.codingweak.stockage;

import java.util.ArrayList;

public class Pile {
    private String nom;
    private String description;
    ArrayList<Carte> cartes;
    Stats stats;

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getNom(){
        return this.nom;
    }

    public String getDescription(){
        return this.description;
    }
}
