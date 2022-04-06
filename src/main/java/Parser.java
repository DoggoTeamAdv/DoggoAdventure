public class Parser {
    public String run(String userInput, OutputGame game) {
        String[] words = userInput.toLowerCase().split(" ");
        if (words.length > 2) {
            System.out.println("Doggo don't understand more than 2 words :(");
        }
        if (words.length == 0) {
            System.out.println("Doggo needs commands to achieve world domination...i mean to become famous!!!");
        }

        // TODO: make functions for checks
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
