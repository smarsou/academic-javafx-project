package eu.groupnine.codingweak.stockage;

import java.util.ArrayList;

public class Pile {
    public String nom;
    private String description;
    public ArrayList<Carte> cartes;
    Stats stats;
    public Pile() {
        cartes = new ArrayList<>();

    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }

    public String getNom() {
        return this.nom;
    }
}
