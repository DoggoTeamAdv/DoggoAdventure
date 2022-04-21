public class Execute {

    public String commandExecute(String[] words, OutputGame game){
        switch (words[0]) {
            case "quit":
                System.exit(0);
                break;
            case "bark":
                return game.bark();
            case "fart":
                return game.fart();
            case "use":
                return game.use(words[1]);
            case "location":
                return game.getLocationInfo();
            case "move":
            case "go":
                return game.movePlayer(words[1]);
            case "inventory":
                return game.getInventory();
            case "grab":
            case "take":
                return game.takeItem(words[1]);
            case "drop":
                return game.dropItem(words[1]);
            case "eat":
                return game.eat(words[1]);
            default:
                return "Woof! What does " + words[0] + " mean?";
        }
        return "If you see this, run";
    }
}