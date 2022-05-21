package Game.Command;

import Game.Character.Player;
import Game.Scene_Stuff.Scene;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LoadCommand implements Command{
    private final String filePathStr = "src/main/java/userData.txt";
    File textFile = new File(filePathStr);
    private final Player player;

    public LoadCommand(Player player) {
        this.player = player;
    }

    public boolean isLoadFileValid(){
        return textFile.exists();
    }

    public String load() throws IOException {
            String locationLoad;
            boolean loadFileValidation = isLoadFileValid();

            if(!loadFileValidation)
                return "Save file not found, please save your game first";
            else{
                Path path = Paths.get(filePathStr);
                List allLines = Files.readAllLines(path);
                Scene location = new Scene(allLines.get(0).toString(),allLines.get(1).toString());

        }
            return null;
    }


    public String execute() throws IOException {
        return load();
    }
}
