package eu.groupnine.codingweak.stockage;

import java.util.ArrayList;

public class Pile {
    private String nom;
    private String description;
    public ArrayList<Carte> cartes;
    Stats stats;
    public Pile() {
        cartes = new ArrayList<>();
        stats = new Stats();
    }

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

    public Stats geStats(){
        return this.stats;
    }
    
    public void addStats(int cnt, int ct,int cj, float cpm, float tp){
        stats.cartesNonTrouvees+= cnt;
        stats.cartesTrouvees+=ct;
        stats.cartesJouees+=cj;
        stats.cartesParMinutes+=cpm;
        stats.tempsPasse+=tp;
    }

}
