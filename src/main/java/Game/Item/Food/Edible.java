package Game.Item.Food;
import Game.Item.DataItem;
import Game.Character.Player;

public class Edible extends DataItem{
    public Edible(String iName, String iDesc) {
        super(iName, iDesc);
    }

    public String eat(Player player){
        player.removeItem(this);
        return "You eat the " + getName() + ". You know you deserved it, you good boy";
    }
}

