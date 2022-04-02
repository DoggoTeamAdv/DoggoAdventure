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
            "bark", "go", "take", "drop", "use", "eat", "fart", "quit"));
    List<String> noun = new ArrayList<>(Arrays.asList(
            "north", "west", "south", "east", "door", "key", "crypto", "chest"));

    private Player doggo;

    List<Scene> map = new ArrayList<Scene>();

    public OutputGame() {
        map.add(new Scene("Start", "It's a beautiful day to be the most famous crypto!", "Castle", "Old House", "Pigeons", "West Side"));
        map.get(0).addItem(new Item("Chest Key", "A key that opens a chest", ""));

        map.add(new Scene("West Side", "Welcome to the West Side,wait..is that Will Smith?", "", "Start", "China Town", ""));
        map.get(1).addItem(new Item("Crypto1", "West sides crypto", ""));

        map.add(new Scene("China Town", "Ching Chang Chong,shame the door of the diner is locked", "West Side", "", "", ""));
        map.get(2).addItem(new Item("Store Key", "A key that opens the door", ""));
        map.get(2).addItem(new Item("Crypto2", "China towns crypto", ""));
        map.get(2).addItem(new Item("Fish", "A drowning fish", ""));

        map.add(new Scene("Old House", "A rusty old house, my dog sense smells something in there", "", "", "", "Start"));
        map.get(3).addItem(new Item("Chest", "A chest with a key and a crypto inside", ""));
        map.get(3).addItem(new Item("Axe", "An axe that breaks doors", ""));
        map.get(3).addItem(new Item("Crypto3", "Old houses crypto", ""));

        map.add(new Scene("Pigeons", "Cooo cooooo,those pigeons seem very anxious", "Start", "West Side", "", "Old House"));
        map.get(4).addItem(new Item("Crypto4", "Pigeons crypto", ""));

        map.add(new Scene("Castle", "That's a big castle,with a big lock on its entrance", "", "", "Start", ""));


        doggo = new Player("Doggo", map.get(0));

    }

    public String getLocationInfo() {
        String playerLocation, sceneDescription;
        playerLocation = doggo.getLocation().getName();
        sceneDescription = doggo.getLocation().getDescription();
        return "Location : " + playerLocation + " ( Place Description : " + sceneDescription + " ) ";
    }

    public String movePlayer(String directionStr) {
        String message;
        boolean moved = doggo.goTowards(Direction.convert(directionStr), map);
        if (moved) {
            return  doggo.getLocation().getDescription();
        } else {
            return "Can't go " + directionStr;
        }
    }

    public String getInventory(){
        // TODO: develop
       return "Not developed yet";
    }

    public String takeItem(String itemStr ){
        return doggo.take(itemStr);
    }

    public String dropItem(String itemStr ){
        return doggo.drop(itemStr);
    }



    public void showIntro() {
        String intro;
        intro = "Welcome to The Doggo Adventure! \n" +
                "Your goal is to become the most famous Crypto that has ever existed\n" +
                "To do so, you must collect the 4 most famous Cryptos and enter the Castle\n" +
                "BUT BE CAREFUL!Doors,especially Castle ones, are locked for a reason!\n" +
                "Good luck!";
        System.out.println(intro);
    }


    public void showMenu() {
        String menu;
        menu = "====================================================================================\n" +
                "▀█▀ █ █ █▀▀   █▀▄ █▀█ █▀▀ █▀▀ █▀█   ▄▀▄ █▀▄ █ █ █▀▀ █▄ █ ▀█▀ █ █ █▀█ █▀▀ \n" +
                " █  █▀█ ██▄   █▄▀ █▄█ █▄█ █▄█ █▄█   █▀█ █▄▀ ▀▄▀ ██▄ █ ▀█  █  █▄█ █▀▄ ██▄ \n" +
                "====================================================================================\n" +
                "                                    1.NEW GAME                                       \n" +
                "                                    2.LOAD GAME                                      \n" +
                "                                    3.QUIT                                           \n" +
                "------------------------------------------------------------------------------------\n";

        System.out.println(menu);
    }
}
