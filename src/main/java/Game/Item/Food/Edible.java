package Game.Item.Food;
import Game.Item.Item;
import Game.Character.Player;

import java.util.List;

public class Edible extends Item {
    public Edible(String iName, String iDesc) {
        super(iName, iDesc);
    }

    public String eat(Player player){
        player.removeItem(this);
        return "You eat the " + getName() + ". You know you deserved it, you good boy";
    }
}

