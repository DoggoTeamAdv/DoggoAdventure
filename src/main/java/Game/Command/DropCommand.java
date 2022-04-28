package Game.Command;
import Game.Character.Player;
import Game.Item.Droppable;
import Game.Item.Item;

public class DropCommand implements Command{
    private Player player;
    private Droppable item;

    public DropCommand(Player player, Droppable item){
        this.player = player;
        this.item =item;
    }

    public String drop(){
        player.removeItem(item);
        player.getLocation().addItem(item);
        return "Item " + item.getName() + " dropped";
    }

    public String execute(){
        return drop();
    }
}
