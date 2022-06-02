package Game.Item.Food;

import Game.Character.Player;

public class Fish extends SpecialFood{
    public Fish(String iName, String iDesc) {
        super(iName, iDesc);
    }

    public String eat(Player player) {
        String message = "Warf! The fish was delicious, you feel your stomach rumble though...\n";
        message += player.unlockDeadlyFart();
        return message;
    }
}
