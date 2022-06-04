package Game.Command;

import Game.Character.Player;
import Game.Scene_Stuff.Scene;

public class LocationCommand implements Command{
    private Player player;

    public LocationCommand(Player player){
        this.player = player;
    }

    public String location(){
        Scene playerLocation = player.getLocation();
        String sceneDescription = playerLocation.getDescription();
        return "Location : " + playerLocation.getName() + "\nDescription : " + sceneDescription;
    }

    public String execute(){
        return location();
    }
}
