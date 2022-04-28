package Game.Item;
import Game.Character.Player;

public class Weapon extends DataItem implements Usable,Droppable,Takeable {
    public Weapon(String iName, String iDesc) {
        super(iName, iDesc);
    }
    public String use(Player player){
        return "To be developed";
    }

}
