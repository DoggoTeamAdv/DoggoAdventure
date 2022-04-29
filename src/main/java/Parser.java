import java.io.IOException;

public class Parser {
    Menu mainMenu;
    Execute exec;

    public String run(String userInput, OutputGame game,Save saveGame) throws IOException {
        String[] words = userInput.toLowerCase().split(" ");
        exec = new Execute();
        if (words.length > 2) {
            System.out.println("Doggo don't understand more than 2 words :(");
        }
        if (words.length == 0) {
            System.out.println("Doggo needs commands to achieve world domination...i mean to become famous!!!");
        }

        return exec.commandExecute(words,game,saveGame);
    }
}