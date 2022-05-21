package Game.Command;

import Game.Character.Player;
import Game.Item.Usable;

public class UseCommand implements Command{
    private Player player;
    private Usable item;

    public UseCommand(Player player, Usable item){
        this.player = player;
        this.item =item;
    }

    public String use(){
      return item.use(player);
    }

    public String execute(){
        return use();
    }
}
