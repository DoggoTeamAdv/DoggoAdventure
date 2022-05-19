package Game.Command;

import Game.Character.Player;
import Game.Item.Takeable;
import Game.Scene_Stuff.Scene;

public class TakeCommand implements Command{
    private Player player;
    private Takeable item;

    public TakeCommand(Player player, Takeable item){
        this.player = player;
        this.item =item;
    }

    public String take(){
        Scene playerLocation = player.getLocation();
        player.addItem(item);
        playerLocation.remove(item);
        return "Item " + item.getName() + " taken";
    }

    public String execute(){
        return take();
    }
}
