package eu.groupnine.codingweak.stockage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import eu.groupnine.codingweak.stockage.Pile;



public class Stockage {
    public static HashMap<String,Pile> EnsembleDesPiles;
    
    public Stockage() throws FileNotFoundException, IOException{
        // this.load();
    }

    public void init(){
        HashMap<String,Pile> EnsembleDesPiles2 = new HashMap<>();
        Pile pile1 = new Pile();

        pile1.setNom("didacticiel");
        pile1.setDescription("description de votre première pile");


        EnsembleDesPiles2.put("pile1",pile1);

        this.EnsembleDesPiles = EnsembleDesPiles2;

        Carte carte1 = new Carte(1,"la face avant de votre première carte","la face arrière");
        Carte carte2 = new Carte(2,"une deuxième carte","la face arrière");

        Stats stat1 = new Stats();

        Couple taux1 = new Couple();

        ArrayList<String> nombrePartieJouer1 = new ArrayList<String>();
        ArrayList<String> nombrePartieJouer2 = new ArrayList<String>();
        nombrePartieJouer1.add("0");
        nombrePartieJouer2.add("1");
        nombrePartieJouer1.add("2");
        nombrePartieJouer2.add("3");
        ArrayList<Float> tauxDeReussite1 = new ArrayList<Float>();
        ArrayList<Float> tauxDeReussite2 = new ArrayList<Float>();
        tauxDeReussite1.add((float) 1);
        tauxDeReussite2.add((float) 20);
        tauxDeReussite1.add((float) 70);
        tauxDeReussite2.add((float) 90);


        ArrayList<Carte> cars = new ArrayList<Carte>();
        cars.add(carte1);
        cars.add(carte2);

        pile1.cartes = cars;
        pile1.stats = stat1;
        pile1.stats.taux = taux1;
        pile1.stats.taux.nombrePartieJouer = nombrePartieJouer1;
        pile1.stats.taux.tauxDeReussite = tauxDeReussite1;


    
    }

    //Permet de mettre à jour EnsembleDesPiles par rapport aux données stockées en dur
    public void load() throws FileNotFoundException, IOException {
        String fileName = "src/main/java/eu/groupnine/codingweak/stockage/data2.json";
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path);) {

            Gson gson = new Gson();
            Type fooType = new TypeToken<HashMap<String,Pile>>() {}.getType();
            EnsembleDesPiles = gson.fromJson(reader, fooType);
<<<<<<< HEAD
            if (EnsembleDesPiles==null){
                init();
                save();
            }
            // System.out.println(EnsembleDesPiles2.get("pile1").nom);
=======

>>>>>>> b61924dfef29be97ac6a41ae351d5ea0945a2d90
        }
    }

    public Boolean loadFrom(String filePath) throws FileNotFoundException, IOException, JsonSyntaxException {
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path);) {

            Gson gson = new Gson();
            Type fooType = new TypeToken<HashMap<String,Pile>>() {}.getType();
            HashMap<String,Pile> EnsembleToAdd;
            try{
            EnsembleToAdd = gson.fromJson(reader, fooType);
            }catch(JsonSyntaxException e){
                System.err.println("Error import weird json");
                return false;
            }

            Set<String> pileNamesToAddUpdate = EnsembleToAdd.keySet();
            for (String pileNameToAdd : pileNamesToAddUpdate){
                    EnsembleDesPiles.put(pileNameToAdd, EnsembleToAdd.get(pileNameToAdd));
                }
            }
        return true;
        }

    //Permet de mettre à jour les données stockées en dur par rapport à EnsembleDesPiles
    public void save() throws FileNotFoundException, IOException {
        
        String fileName = "src/main/java/eu/groupnine/codingweak/stockage/data2.json";
        Path path = Paths.get(fileName);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(EnsembleDesPiles, writer);

        }

    }

    public void saveAt(String pathStr)throws IOException{

        Path path = Paths.get(pathStr);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(EnsembleDesPiles, writer);

        }

    }


}
