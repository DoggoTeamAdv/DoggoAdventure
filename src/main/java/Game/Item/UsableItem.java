package Game.Item;

import Game.Character.Player;

abstract public class UsableItem extends Item{
    public UsableItem(String iName, String iDesc) {
        super(iName, iDesc);
    }

    abstract public String use(Player player);
}
