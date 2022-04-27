package Game.Command;
import Game.Character.Player;
import Game.Item.Item;

public class DropCommand implements Command{
    private Player player;
    private Item item;

    public DropCommand(Player player, Item item){
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
