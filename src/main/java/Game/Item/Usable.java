package Game.Item;

import Game.Character.Player;

public interface Usable extends Item{
    public String use(Player player);
}
