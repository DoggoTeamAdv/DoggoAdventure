package Game.Command;

import Game.CommandFactory;
import Game.OutputGame;
import Game.Parser.Parser;
import Game.Parser.Sentence;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoadCommand implements Command{
    private final String filePathStr = "src/main/java/userData.txt";
    File textFile = new File(filePathStr);
    List<String> loadData = new ArrayList<>();

    public LoadCommand() {
    }

    public String load() throws IOException {
        if (!this.textFile.exists())
            return "Save file not found, please save your game first";
        else {
            System.out.println("Load Successfully");
            List<String> allLines = Files.readAllLines(Paths.get(this.filePathStr));
            for (int i = 0; i < allLines.size(); i++) {
                this.loadData.add(allLines.get(i));
            }
            return null;
        }
    }


        public String execute() throws IOException {
            return load();
        }

        public List<String> getLoad(){
          return this.loadData;
        }
    }
