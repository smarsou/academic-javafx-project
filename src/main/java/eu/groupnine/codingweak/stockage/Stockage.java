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
    public  HashMap<String,Pile> EnsembleDesPiles;
    
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
        Stats stat1 = new Stats();
        Stats stat2 = new Stats();
        Couple taux1 = new Couple();
        Couple taux2 = new Couple();
        ArrayList<String> nombrePartieJouer1 = new ArrayList<String>();
        ArrayList<String> nombrePartieJouer2 = new ArrayList<String>();
        nombrePartieJouer1.add("0");
        nombrePartieJouer2.add("0");
        nombrePartieJouer1.add("1");
        nombrePartieJouer2.add("1");
        ArrayList<Float> tauxDeReussite1 = new ArrayList<Float>();
        ArrayList<Float> tauxDeReussite2 = new ArrayList<Float>();
        tauxDeReussite1.add((float) 0);
        tauxDeReussite2.add((float) 0);
        tauxDeReussite1.add((float) 2);
        tauxDeReussite2.add((float) 4);


        ArrayList<Carte> cars = new ArrayList<Carte>();
        cars.add(carte1);
        cars.add(carte2);
        cars.add(carte3);
        pile1.cartes = cars;
        pile1.stats = stat1;
        pile1.stats.taux = taux1;
        pile1.stats.taux.nombrePartieJouer = nombrePartieJouer1;
        pile1.stats.taux.tauxDeReussite = tauxDeReussite1;

        ArrayList<Carte> cars2 = new ArrayList<Carte>();
        cars2.add(carte1);
        cars2.add(carte2);
        cars2.add(carte3);
        pile2.cartes = cars2;
        pile2.stats = stat2;
        pile2.stats.taux = taux2;
        pile2.stats.taux.nombrePartieJouer = nombrePartieJouer2;
        pile2.stats.taux.tauxDeReussite = tauxDeReussite2;
    
    }

    //Permet de mettre à jour EnsembleDesPiles par rapport aux données stockées en dur
    public void load() throws FileNotFoundException, IOException {
        String fileName = "src/main/java/eu/groupnine/codingweak/stockage/data2.json";
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path);) {

            Gson gson = new Gson();
            Type fooType = new TypeToken<HashMap<String,Pile>>() {}.getType();
            EnsembleDesPiles = gson.fromJson(reader, fooType);

            // System.out.println(EnsembleDesPiles2.get("pile1").nom);
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
            // Set<String> pileNamesToAdd = EnsembleToAdd.keySet();
            // for (String pileNameToAdd : pileNamesToAdd){
            //     if (EnsembleDesPiles.containsKey(pileNameToAdd)){
            //         System.err.println("Import Warning: Import Pile with an existing name failed");
            //         EnsembleToAdd.remove(pileNameToAdd);
            //     }
            // }
            Set<String> pileNamesToAddUpdate = EnsembleToAdd.keySet();
            for (String pileNameToAdd : pileNamesToAddUpdate){
                    EnsembleDesPiles.put(pileNameToAdd, EnsembleToAdd.get(pileNameToAdd));
                }
            }
        return true;
            // System.out.println(EnsembleDesPiles2.get("pile1").nom);
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


    // // plus utile
    // public Pile getPile(){
    //     return null;
    // }
}
