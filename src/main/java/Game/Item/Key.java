package Game.Item;

import Game.Character.Player;

public class Key extends DataItem implements Takeable,Usable,Droppable{

    public Key(String iName, String iDesc) {
        super(iName, iDesc);
    }
    public String use(Player player){
        //TODO: Develop use of Key
        return "To be developed";
    }
}
