import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputGame {
    List<String> verb = new ArrayList<>(Arrays.asList(
            "go", "take", "unlock", "open", "use", "quit"));
    List<String> noun = new ArrayList<>(Arrays.asList(
            "north", "west", "south", "east", "bark", "door", "key", "crypto", "chest"));

    private Player doggo;

    public Player getPlayer() {

        return doggo;
    }

    public void setPlayer(Player nDoggo) {

        doggo = nDoggo;
    }

    List<Scene> map = new ArrayList<Scene>();
    public OutputGame () {
        map.add(new Scene("Start", "You are finally awake, go get them!", "", "Old House", "", "West Side"));
        map.add(new Scene("West Side", "Welcome to the West Side, you must find Will Smith", "", "Start", "China Town", ""));
        map.add(new Scene("China Town", "Ching Chang Chong, the pigeons infront of you are looking sus..", "West Side", "", "", ""));
        map.add(new Scene("Old House", "Rusty old house, it seems like someone was here recently...", "", "", "", "Start"));
        doggo = new Player("Doggo", map.get(0));

    }

    public void showMenu() {
        String s;
        s = "Welcome to The Doggo Adventures! \n" +
                "Your goal is to become the best Crypto that has ever existed\n" +
                "Therefore, you must destroy all the top ones so go find them!\n" +
                "Good luck!";
        System.out.println(s);
    }

    public String run(String userInput) {
        String message = "";
        String[] words = userInput.toLowerCase().split(" ");
        if (words.length > 2) {
            System.out.println("Doggo don't understand more than 2 words :(");
        }
        if (words.length == 0) {
            System.out.println("Doggo needs commands to achieve world domination!!!!");
        }

        switch (words[0]) {
            case "quit":
                System.exit(0);
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
                message = "Doggo doesn't know how to " + words[0] + "....";
                break;

        }
        return message;
    }
}