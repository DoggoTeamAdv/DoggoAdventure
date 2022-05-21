package Game;

import Game.Character.Player;
import Game.Command.*;
import Game.Item.*;
import Game.Item.Food.Edible;
import Game.Parser.Sentence;
import Game.Scene_Stuff.Direction;
import Game.Scene_Stuff.Scene;

public class CommandFactory {
    private OutputGame game;
    private Player player;

    public CommandFactory(OutputGame game) {
        this.game = game;
        this.player = game.getPlayer();
    }

    public Command getInstance(Sentence sentence) throws Exception {
        Item item;
        Scene playerLocation = player.getLocation();
        switch (sentence.verb) {
            case QUIT:
                return new QuitCommand();
            case HELP:
                return new HelpCommand();
            case SAVE:
                return new SaveCommand(player);
            case LOAD:
                return new LoadCommand(player);
            case BARK:
                return new BarkCommand(player);
            case FART:
                return new FartCommand(game);
            case USE:
                item = player.getItem(sentence.noun.getStr());
                if (item == null) {
                    throw new Exception("There's no such item on you");
                }
                if (!(item instanceof Usable)) {
                    throw new Exception(item.getName() + " is not usable");
                }
                return new UseCommand(player, (Usable) item);
            case LOCATION:
                return new LocationCommand(player);
            case MOVE:
                Direction direction = Direction.convert(sentence.noun.getStr());
                if (direction == Direction.noPoint) {
                    throw new Exception("Can't go " + sentence.noun.getStr());
                }
                Scene destination = playerLocation.getSceneInDirection(direction);
                if (destination == null) {
                    throw new Exception("There's no point going there");
                }
                return new GoCommand(player, direction);
            case INVENTORY:
                return new InventoryCommand(player);
            case TAKE:
                item = playerLocation.getItem(sentence.noun.getStr());
                if (item == null) {
                    throw new Exception("There's no such item around you");
                }
                if (!(item instanceof Takeable)) {
                    throw new Exception("You can't take the " + item.getName());
                }
                return new TakeCommand(player, (Takeable) item);
            case DROP:
                item = player.getItem(sentence.noun.getStr());
                if (item == null) {
                    throw new Exception("There's no such item on you");
                }
                if (!(item instanceof Droppable)) {
                    throw new Exception("You can't drop that!");
                }
                return new DropCommand(player, (Droppable) item);
            case EAT:
                item = player.getItem(sentence.noun.getStr());
                if (item == null) {
                    item = playerLocation.getItem(sentence.noun.getStr());
                }
                if (item == null) {
                    throw new Exception("You sniff everywhere but can't find any " + sentence.noun.getStr());
                }
                if (!(item instanceof Edible)) {
                    throw new Exception("You can't eat " + item.getName() + ".. You're smarter than that!");
                }
                return new EatCommand(player, (Edible) item);
            default:
                throw new Exception("Woof! What does " + sentence.verb.getStr() + " mean?");
        }
    }
}
