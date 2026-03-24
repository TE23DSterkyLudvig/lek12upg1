package poop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import 

public class Main {
    public static void main(String[] args) 
    {
        try 
        {
          Path fil = Paths.get("medlemmar.json"); 
          String medlemmar_json = Files.readString(fil);
          
        } 
        catch (Exception e) 
        {
            
        }
        


    }
}