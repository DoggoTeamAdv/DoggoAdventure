import java.io.*;
import java.util.Scanner;

public class Save {
    File textfile = new File("src/main/java/userData.txt");


    public void isFileValid(File textfile) throws IOException {
        if(textfile.createNewFile())
            System.out.println("File Created : " + textfile.getName());
        else
            System.out.println("File Already Exists");
    }


    public void saveFile(OutputGame game) throws IOException {

            FileWriter userData = new FileWriter(textfile);
            isFileValid(textfile);

            userData.write("1ST LINE \n");
            userData.write("2ND LINE \n");
            userData.write("3RD LINE \n");
            userData.flush();
            userData.close();
            System.out.println("Successfully Saved");
    }

    public void loadFile() throws IOException {
        FileReader fr = new FileReader(textfile);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }


    }
}
