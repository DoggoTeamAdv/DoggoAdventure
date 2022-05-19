package Game.Command;

import Game.Character.Player;

public class InventoryCommand implements Command {
    private Player player;

    public InventoryCommand (Player player) {
        this.player = player;
    }

    public String inventory(){
        // TODO: make inventory command
        return "Under Construction";
    }

    public String execute() {
        return inventory();
    }
}
