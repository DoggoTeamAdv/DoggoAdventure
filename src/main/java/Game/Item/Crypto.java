package Game.Item;

import Game.Character.Player;

public class Crypto extends DataItem implements Takeable,Usable  {
    public Crypto(String iName, String iDesc) {
        super(iName, iDesc);
    }
    public String use(Player player){
        //TODO:Develop use of Crypto
        return "To be developed";
    }
}
