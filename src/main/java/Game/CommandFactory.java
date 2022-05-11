package Game;

import Game.Character.Player;
import Game.Command.*;
import Game.Item.*;
import Game.Item.Food.Edible;
import Game.Scene_Stuff.Direction;
import Game.Scene_Stuff.Scene;

import java.util.List;

public class CommandFactory {
    private OutputGame game;
    private Player player;

    public CommandFactory(OutputGame game) {
        this.game = game;
        this.player = game.getPlayer();
    }

    public Command getInstance(List<String> parts) throws Exception {
        Item item;
        switch (parts.get(0)) {
            case "quit":
               return new QuitCommand();
            case "bark":
                return new BarkCommand(player);
            case "fart":
                return new FartCommand(game);
            case "use":
                item = player.getItem(parts.get(1));
                if (item==null) {
                    throw new Exception("There's no such item on you");
                }
                if(!(item instanceof Usable)){
                    throw new Exception(item.getName() + " is not usable");
                }
                return new UseCommand(player, (Usable) item);
            case "location":
                return new LocationCommand(player);
            case "move":
            case "go":
                Direction direction = Direction.convert(parts.get(1));
                if (direction == Direction.noPoint) {
                    throw new Exception("Can't go " + parts.get(1));
                }
                Scene destination = player.getLocation().getSceneInDirection(direction);
                if (destination==null) {
                    throw new Exception("There's no point going there");
                }
                return new GoCommand(player,direction);
            case "inventory":
                return new InventoryCommand(player);
            case "grab":
            case "take":
                item = player.getLocation().getItem(parts.get(1));
                if (item==null) {
                    throw new Exception("There's no such item around you");
                }
                if(!(item instanceof Takeable)){
                    throw new Exception("You can't take the " + item.getName());
                }
                return new TakeCommand(player, (Takeable) item);
            case "drop":
                item = player.getItem(parts.get(1));
                if (item==null) {
                    throw new Exception("There's no such item on you");
                }
                if(!(item instanceof Droppable)){
                    throw new Exception("You can't drop that!");
                }
                return new DropCommand(player, (Droppable) item);
            case "eat":
                item = player.getItem(parts.get(1));
                if (item==null) {
                    item = player.getLocation().getItem(parts.get(1));
                }
                if (item==null) {
                    throw new Exception("You sniff everywhere but can't find any " + parts.get(1));
                }
                if (!(item instanceof Edible)) {
                    throw new Exception("You can't eat " + item.getName() + ".. You're smarter than that!");
                }
                return new EatCommand(player, (Edible)item);
            default:
                throw new Exception("Woof! What does " + parts.get(0) + " mean?");
        }
    }
}
