package Game;

import java.io.IOException;

public class Parser {
    private CommandChecker commandChecker;

    public Parser(OutputGame game) {
        commandChecker = new CommandChecker(game);
    }

    public String run(String userInput, OutputGame game) throws IOException {
        String[] words = userInput.toLowerCase().split(" ");
        if (words.length > 2) {
            System.out.println("Doggo doesn't understand more than 2 words :(");
        }
        if (words.length == 0) {
            System.out.println("Doggo needs commands to achieve world domination...i mean to become famous!!!");
        }

        switch (words[0]) {
            case "quit":
            case "bark":
            case "fart":
            case "location":
            case "inventory":
            // TODO: case "help":
                if (words.length!=1) {
                    return "This command is a lone wolf.. not a two+ word one";
                }
                return commandChecker.check(words);
            case "use":
            case "move":
            case "go":
            case "grab":
            case "take":
            case "drop":
            case "eat":
                if (words.length!=2) {
                    return "This command is not a lone wolf but a two word one";
                }
                return commandChecker.check(words);
            default:
                return "Woof! What does " + words[0] + " mean?";
        }
    }

}
