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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import eu.groupnine.codingweak.stockage.Pile;



public class Stockage {
    public HashMap<String,Pile> EnsembleDesPiles;
    
    public Stockage() throws FileNotFoundException, IOException{
        // this.load();
    }

    public void init(){
        HashMap<String,Pile> EnsembleDesPiles2 = new HashMap<>();
        Pile pile1 = new Pile();
        Pile pile2 = new Pile();

        pile1.setNom("pile1");
        pile1.setDescription("description pile 1");
        pile2.setNom("pile2");
        pile2.setDescription("description pile 2");

        EnsembleDesPiles2.put("pile1",pile1);
        EnsembleDesPiles2.put("pile2",pile2);
        this.EnsembleDesPiles = EnsembleDesPiles2;

        Carte carte1 = new Carte(1,"question1","reponse1");
        Carte carte2 = new Carte(2,"question1","reponse1");
        Carte carte3 = new Carte(3,"question1","reponse1");

        ArrayList<Carte> cars = new ArrayList<Carte>();
        cars.add(carte1);
        cars.add(carte2);
        cars.add(carte3);
        pile1.cartes = cars;

        ArrayList<Carte> cars2 = new ArrayList<Carte>();
        cars2.add(carte1);
        cars2.add(carte2);
        cars2.add(carte3);
        pile2.cartes = cars2;
    
    }

    //Permet de mettre à jour EnsembleDesPiles par rapport aux données stockées en dur
    public void load() throws FileNotFoundException, IOException {
        String fileName = "src/main/java/eu/groupnine/codingweak/stockage/data.json";
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path);) {

            Gson gson = new Gson();
            Type fooType = new TypeToken<HashMap<String,Pile>>() {}.getType();  
            HashMap<String,Pile> EnsembleDesPiles2 = gson.fromJson(reader, fooType);
            this.EnsembleDesPiles = EnsembleDesPiles2;
            // System.out.println(EnsembleDesPiles2.get("pile1").nom);
        }

    }
    //Permet de mettre à jour les données stockées en dur par rapport à EnsembleDesPiles
    public void save() throws FileNotFoundException, IOException {

        String fileName = "src/main/java/eu/groupnine/codingweak/stockage/data.json";
        Path path = Paths.get(fileName);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(EnsembleDesPiles, writer);

        }

    }


    // // plus utile
    // public Pile getPile(){
    //     return null;
    // }
}
