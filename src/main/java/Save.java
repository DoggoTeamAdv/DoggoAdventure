import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    File textfile = new File("src/main/java/userData.txt");

    public void saveFileCreation() throws IOException{
        textfile.createNewFile();
        System.out.println("File Created : " + textfile.getName());
    }

    public boolean isSaveFileValid() throws IOException {
        
        if(textfile.exists())
            return true;
        else
            return false;
    }


    public void saveFile(OutputGame game) throws IOException {
        FileWriter userData = new FileWriter(textfile);
        boolean saveFileValidation = isSaveFileValid();

        if(saveFileValidation == false){ 
            saveFileCreation();
        }

        userData.write("");
        
        userData.flush();
        userData.close();
        System.out.println("Successfully Saved");
    }

   
}
