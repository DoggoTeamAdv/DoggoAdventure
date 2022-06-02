package Game.Command;

import Game.Character.Player;

import java.util.List;

public class InventoryCommand implements Command {
    private Player player;

    public InventoryCommand (Player player) {
        this.player = player;
    }

    public String inventory(){
        StringBuilder messageBuilder = new StringBuilder("Your items are...\n");
        List<String> inventoryList = player.getItemNames();
        if(inventoryList.isEmpty()) {
            return "You have no items..";
        }
        for(String item : inventoryList){
            messageBuilder.append(item);
            messageBuilder.append('\n');
        }
        return messageBuilder.toString().trim();
    }

    public String execute() {
        return inventory();
    }
}
