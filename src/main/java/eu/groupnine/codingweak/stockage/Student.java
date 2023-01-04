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


    public String firstName;
    public String lastName;
    public int age;
    public String address;
    public Student(String firstName, String lastName, int age, String address) {
       super();
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
       this.address = address;
    }
    public String getFirstName() {
       return firstName;
    }
    public void setFirstName(String firstName) {
       this.firstName = firstName;
    }
    public String getLastName() {
       return lastName;
    }
    public void setLastName(String lastName) {
       this.lastName = lastName;
    }
    public int getAge() {
       return age;
    }
    public void setAge(int age) {
       this.age = age;
    }
    public String getAddress() {
       return address;
    }
    public void setAddress(String address) {
       this.address = address;
    }
    public String toString() {
       return "Student[ " +
                " firstName = " + firstName +
                ", lastName = " + lastName +
                ", age = " + age +
                ", address = " + address +
                " ]";
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


/*
 * dans main:
 *         Student student = new Student(2,"szdc");
        Student.init();
 */