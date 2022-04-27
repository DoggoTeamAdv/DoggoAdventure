package Game.Command;
import Game.Character.Player;

public class BarkCommand implements Command {
    private Player player;

    public  BarkCommand(Player player) {
        this.player = player;
    }

    private String bark(){
        switch (player.getLocation().getName()) {
            case "Pigeons":
                return "Wow! you scared the pigeons away but look.. Something shiny is there.... A crypto! Quick! Take it before they come back";
            case "Castle":
                return "Elon Musk : HAHAHA, you can't scare ME little one. I am unbarkable";
            default:
                return "You scared a bee away..this seems useful";
        }
    }
    public String execute() {
        return bark();
    }
}
