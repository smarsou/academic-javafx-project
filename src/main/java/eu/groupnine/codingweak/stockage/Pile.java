package eu.groupnine.codingweak.stockage;

import java.util.ArrayList;

public class Pile {
    private String nom;
    private String description;
    public ArrayList<Carte> cartes;
    Stats stats;
    public Pile() {
        cartes = new ArrayList<>();
<<<<<<< HEAD
        this.stats = new Stats();
        this.stats.taux = new Couple();
        this.stats.taux.nombrePartieJouer = new ArrayList<String>();
        this.stats.taux.nombrePartieJouer.add("0");
        this.stats.taux.tauxDeReussite = new ArrayList<Float>();
        this.stats.taux.tauxDeReussite.add((float) 0);

=======
        stats = new Stats();
>>>>>>> 6684aed6d88bd4f8c44c966aeed16836e3b5c655
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
    
<<<<<<< HEAD
    public void addStats(int cnt, int ct,int cj, float cpm, int tp, String cnp, Float cta){
=======
    public void addStats(int cnt, int ct,int cj, float cpm, float tp){
>>>>>>> 6684aed6d88bd4f8c44c966aeed16836e3b5c655
        stats.cartesNonTrouvees+= cnt;
        stats.cartesTrouvees+=ct;
        stats.cartesJouees+=cj;
        stats.cartesParMinutes+=cpm;
        stats.tempsPasse+=tp;
        stats.taux.nombrePartieJouer.add(cnp);
        stats.taux.tauxDeReussite.add(cta);
    }

}
