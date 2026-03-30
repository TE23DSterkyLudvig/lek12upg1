package poop;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class Main {
    public static void main(String[] args) 
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String medlemmar_json = "";
        String f_hjälpen_json = "";
        String besökande_json = "";
        String avstängda_json = "";
        try 
        {
          Path fil = Paths.get("medlemmar.json"); 
          medlemmar_json = Files.readString(fil);

          Path fil2 = Paths.get("f_hjälpen.json");
          f_hjälpen_json = Files.readString(fil2);

          Path fil3 = Paths.get("besökande.json");
          besökande_json = Files.readString(fil3);

          Path fil4 = Paths.get("avstängda.json");
          avstängda_json = Files.readString(fil4);
          
        } 
        catch (IOException e) 
        {
            System.out.println("Fel i inläsning: " + e.getMessage());
            e.printStackTrace();
            System.out.println("Stänger program.");
            System.exit(0);
        }

        Type typ = new TypeToken<ArrayList<Person>>(){}.getType();

        ArrayList<Person> medlemmar = gson.fromJson(medlemmar_json, typ);
        ArrayList<Person> avstängda = gson.fromJson(avstängda_json,typ);
        ArrayList<Person> f_hjälpen = gson.fromJson(f_hjälpen_json,typ);
        ArrayList<Person> besökande = gson.fromJson(besökande_json,typ);

        HashSet <Person> med_set = new HashSet<Person>(medlemmar);
        HashSet <Person> fh_set = new HashSet<Person>(f_hjälpen);


        med_set.retainAll(fh_set);

        System.out.println("antal som kan första hjälpen\n" +med_set.size());
        for (Person p : med_set) {
            System.out.println(p.getNamn());
        }
        
        System.out.println("----------------------------");

        String medlemString = gson.toJson(med_set);

        try 
        {
            
            Path nyFil = Paths.get("förstahjälpen.json");
            Files.writeString(nyFil,medlemString);

        } 
        catch (IOException e) 
        {
            System.out.println("Fel uppstod: " + e.getMessage());
        }




        HashSet <Person> med_tävling = new HashSet<Person>(medlemmar);
        HashSet <Person> avstängd_set = new HashSet<Person>(avstängda);
        HashSet <Person> besök_set = new HashSet<Person>(besökande);

        med_tävling.removeAll(avstängd_set);
        

        System.out.println("Antal tävlande i uppgift b: " + med_tävling.size());
        for (Person p : med_tävling) 
        {
            System.out.println(p.getNamn());
        }

        String med_buppgift = gson.toJson(med_tävling);

        try 
        {
            
            Path b_sökväg = Paths.get("Uppgift b tävlande.json");
            Files.writeString(b_sökväg,med_buppgift);

        } 
        catch (IOException e) 
        {
            System.out.println("Fel upptäckt: " + e.getMessage());
        }













        


    }
}