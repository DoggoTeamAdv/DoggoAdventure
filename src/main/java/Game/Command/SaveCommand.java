package Game.Command;

import Game.Character.Player;
import Game.Item.Inventory;
import Game.Scene_Stuff.Scene;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveCommand implements Command {
    File textfile = new File("src/main/java/userData.txt");
    private final Player player;

    public SaveCommand(Player player) {
        this.player = player;
    }

    public String save(String fileName) throws IOException {
        FileWriter userData = new FileWriter(textfile);

        Scene getLocation = player.getLocation();
        List<String> getInventory =player.getItemNames();
        userData.write(getLocation.getName());
        userData.write("\n");
        userData.write(String.valueOf(getInventory));
        userData.write("\n");

        userData.flush();
        userData.close();

        return "Saved Successfully";
}


    public String execute() throws IOException {
        return save("filename.txt");
    }
}
