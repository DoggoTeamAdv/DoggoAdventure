package Game;

import Game.Character.Player;
import Game.Command.*;
import Game.Item.*;
import Game.Item.Food.Edible;
import Game.Scene_Stuff.Direction;
import Game.Scene_Stuff.Scene;

public class CommandChecker {
    private OutputGame game;
    private Player player;

    public CommandChecker(OutputGame game) {
        this.game = game;
        this.player = game.getPlayer();
    }

    public String check (String[] words) {
        Item item;
        switch (words[0]) {
            case "quit":
                System.exit(0);
                break;
            case "bark":
                return new BarkCommand(player).execute();
            case "fart":
                return new FartCommand(game).execute();
            case "use":
                item = player.getItem(words[1]);
                if (item==null) {
                    return "There's no such item on you";
                }
                if(!(item instanceof Usable)){
                    return item.getName() + " is not usable";
                }
                return new UseCommand(player, (Usable) item).execute();
            case "location":
                return new LocationCommand(player).execute();
            case "move":
            case "go":
                Direction direction = Direction.convert(words[1]);
                if (direction == Direction.noPoint) {
                    return "Can't go " + words[1];
                }
                Scene destination = player.getLocation().getSceneInDirection(direction);
                if (destination==null) {
                    return "There's no point going there";
                }
                return new GoCommand(player,direction).execute();
            case "inventory":
                return new InventoryCommand(player).execute();
            case "grab":
            case "take":
                item = player.getLocation().getItem(words[1]);
                if (item==null) {
                    return "There's no such item around you";
                }
                if(!(item instanceof Takeable)){
                    return "You can't take the " + item.getName();
                }
                return new TakeCommand(player, (Takeable) item).execute();
            case "drop":
                item = player.getItem(words[1]);
                if (item==null) {
                    return "There's no such item on you";
                }
                if(!(item instanceof Droppable)){
                    return "You can't drop that!";
                }
                return new DropCommand(player, (Droppable) item).execute();
            case "eat":
                item = player.getItem(words[1]);
                if (item==null) {
                    item = player.getLocation().getItem(words[1]);
                }
                if (item==null) {
                    return "You sniff everywhere but can't find any " + words[1];
                }
                if (!(item instanceof Edible)) {
                    return "You can't eat " + item.getName() + ".. You're smarter than that!";
                }
                return new EatCommand(player, (Edible)item).execute();
            default:
                return "Woof! What does " + words[0] + " mean?";
        }
        return "If you see this, run";
    }
}
