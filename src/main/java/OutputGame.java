import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: Make the Descriptions changable
//TODO: Make Scenes into Scenes by declaring a tasks at a direction rather than a new "Room"
//TODO: help command to show at user the available commands
//TODO: Fix go south east bug
//TODO: Items->Class with categories etc edible, drinkable


public class OutputGame {
    List<String> verb = new ArrayList<>(Arrays.asList(
            "go", "take", "unlock", "open", "use", "quit"));
    List<String> noun = new ArrayList<>(Arrays.asList(
            "north", "west", "south", "east", "bark", "door", "key", "crypto", "chest"));

    private Player doggo;

    List<Scene> map = new ArrayList<Scene>();
    public OutputGame () {
        map.add(new Scene("Start", "It's a beautiful day to be the most famous crypto!", "", "Old House", "", "West Side"));
        map.add(new Scene("West Side", "Welcome to the West Side,wait..is that Will Smith?", "", "Start", "China Town", ""));
        map.add(new Scene("China Town", "Ching Chang Chong,shame the door of the diner is locked", "West Side", "", "", ""));
        map.add(new Scene("Old House", "A rusty old house, my dog sense smells something in there", "", "", "", "Start"));
        map.add(new Scene("Pigeons", "Cooo cooooo,those pigeons seem very anxious", "Start", "West Side", "", "Old House"));
        map.add(new Scene("Castle", "That's a big castle,with a big lock on its entrance", "", "", "Start", ""));

        doggo = new Player("Doggo", map.get(0));

    }

    public void showIntro() {
        String intro;
        intro = "Welcome to The Doggo Adventure! \n" +
                "Your goal is to become the most famous Crypto that has ever existed\n" +
                "To do so, you must collect the 4 most famous Cryptos and enter the Castle\n" +
                "BUT BE CAREFUL!Doors,especially Castle ones, are locked for a reason!\n"+
                "Good luck!";
        System.out.println(intro);
    }

    public String run(String userInput) {
        String playerLocation = "";
        String SceneDescription = "";
        String message = "";
        String[] words = userInput.toLowerCase().split(" ");
        if (words.length > 2) {
            System.out.println("Doggo don't understand more than 2 words :(");
        }
        if (words.length == 0) {
            System.out.println("Doggo needs commands to achieve world domination...i mean to become famous!!!");
        }

        switch (words[0]) {
            case "quit":
                System.exit(0);
                break;
            case "location":
                playerLocation = doggo.getLocation().getName();
                SceneDescription = doggo.getLocation().getDescription();
                message = "Location : " + playerLocation + ". " + SceneDescription;
                break;
            case "go":
                boolean moved = doggo.goTowards(Direction.convert(words[1]),map);
                if (moved) {
                    message = doggo.getLocation().getDescription();
                } else {
                    message = "Can't go " + words[1];
                }
                break;
            default:
                message = "Woof! What does " + words[0] + " mean";
                break;

        }
        return message;
    }
}
