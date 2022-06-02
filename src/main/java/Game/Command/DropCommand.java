package Game.Command;
import Game.Character.Player;
import Game.Item.Droppable;
import Game.Scene_Stuff.Scene;

public class DropCommand implements Command{
    private Player player;
    private Droppable item;

    public DropCommand(Player player, Droppable item){
        this.player = player;
        this.item =item;
    }

    public String drop(){
        Scene playerLocation = player.getLocation();
        player.removeItem(item);
        playerLocation.addItem(item);
        return "Item " + item.getName() + " dropped";
    }

    public String execute(){
        return drop();
    }
}
