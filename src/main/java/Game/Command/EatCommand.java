package Game.Command;

import Game.Item.Food.Edible;
import Game.Character.Player;

public class EatCommand implements Command{
    private final Player player;
    private final Edible edible;

    public EatCommand(Player player, Edible edible) {
        this.player = player;
        this.edible = edible;
    }

    private String eat(){
        return edible.eat(player);
    }

    public String execute() {
        return eat();
    }
}
