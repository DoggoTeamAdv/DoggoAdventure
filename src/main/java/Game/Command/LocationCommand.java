package Game.Command;

import Game.Character.Player;

public class LocationCommand implements Command{
    private Player player;

    public LocationCommand(Player player){
        this.player = player;
    }

    public String location(){
        String playerLocation, sceneDescription;
        playerLocation = player.getLocation().getName();
        sceneDescription = player.getLocation().getDescription();
        return "Location : " + playerLocation + " ( Place Description : " + sceneDescription + " ) ";
    }

    public String execute(){
        return location();
    }
}
