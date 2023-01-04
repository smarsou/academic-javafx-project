package eu.groupnine.codingweak.stockage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import eu.groupnine.codingweak.stockage.Pile;

public class Stockage {
    public HashMap<String,Pile> EnsembleDesPiles;
    
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


    }

    //Permet de mettre à jour EnsembleDesPiles par rapport aux données stockées en dur
    public void load(){

    }
    //Permet de mettre à jour les données stockées en dur par rapport à EnsembleDesPiles
    public void save() throws FileNotFoundException, IOException {
        HashMap<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(1, "new Employee(1l, , LocalDate.of(1990, 01, 01)");
        employeeMap.put(2, "new Employee(2l, , LocalDate.of(1990, 02, 01)");

        String fileName = "src/main/java/eu/groupnine/codingweak/stockage/data.json";
        Path path = Paths.get(fileName);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String jsonString = gson.toJson(employeeMap);            
            gson.toJson(jsonString, writer);
            // gson.toJson(tree, writer);

        }

    }


    // // plus utile
    // public Pile getPile(){
    //     return null;
    // }
}
