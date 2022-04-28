package Game.Command;

import Game.Character.Player;
import Game.Item.Item;
import Game.Item.Takeable;

public class TakeCommand implements Command{
    private Player player;
    private Takeable item;

    public TakeCommand(Player player, Takeable item){
        this.player = player;
        this.item =item;
    }

    public String take(){
        player.addItem(item);
        player.getLocation().remove(item);
        return "Item " + item.getName() + " taken";
    }

    public String execute(){
        return take();
    }
}
