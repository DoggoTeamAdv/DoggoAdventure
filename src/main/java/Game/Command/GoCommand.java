package Game.Command;

import Game.Character.Player;
import Game.Scene_Stuff.Scene;
import Game.Scene_Stuff.Direction;


public class GoCommand implements Command{
    private final Player player;
    private final Direction direction;

    public GoCommand(Player player, Direction direction) {
        this.player = player;
        this.direction = direction;
    }

    public String goTowards(Direction dir) {
        Scene currentLocation, sceneToGoTo;
        currentLocation = player.getLocation();
        sceneToGoTo = currentLocation.getSceneInDirection(dir);
        player.setLocation(sceneToGoTo);
        return sceneToGoTo.getDescription();
    }

    public String execute(){
        return goTowards(direction);
    }

}
