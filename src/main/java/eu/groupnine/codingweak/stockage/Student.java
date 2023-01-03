package eu.groupnine.codingweak.stockage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Student {

    private long studentId;
    private String studentName;

    public Student(long studentId, String studentName) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }



    public static void init() throws FileNotFoundException, IOException {

        ArrayList<String> jours = new ArrayList<>();
        // Ajout d'éléments dans l'ArrayList
        jours.add("Lundi");
        jours.add("Mardi");
        jours.add("Mercredi");
        jours.add("Jeudi");
        jours.add("Vendredi");
        jours.add("Samedi");
        jours.add("Dimanche");

        String fileName = "src/main/java/eu/groupnine/codingweak/stockage/data.json";

        Path path = Paths.get(fileName);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonElement tree = gson.toJsonTree(jours);
            gson.toJson(tree, writer);
        }

        System.out.println("Students written to file");
    }
}
