import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Load {
    File textfile = new File("src/main/java/userData.txt");

    public boolean isLoadFileValid(){
        if(textfile.exists())
            return true;
        else
            return false;
    }

    public void loadFile() throws IOException{
        String locationLoad;
        boolean loadFileValidation = isLoadFileValid();

        if(loadFileValidation == false)
            System.out.println("Save file not found, please save your game first");
        else{
            locationLoad = Files.readAllLines(Paths.get("src/main/java/userData.txt")).get(0);
            System.out.println(locationLoad);
        }    
    }
}

