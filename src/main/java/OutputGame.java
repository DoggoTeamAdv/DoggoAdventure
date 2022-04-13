import Scene_Stuff.Direction;
import Scene_Stuff.Map;

//TODO: Make the Descriptions changable
//TODO: help command to show at user the available commands
//TODO: Fix go south east bug



public class OutputGame {
    private Player doggo;
    private Map map;

    public OutputGame() {
        map = new Map();
        doggo = new Player("Doggo", map.getScene("Start"));

    }

    public String bark() {
        return doggo.bark();
    }

    public String use(String itemStr) {
        return doggo.use(itemStr);
    }

    public String fart() {
        return doggo.fart();
    }

    public String eat(String itemStr) {
        return doggo.eat(itemStr);
    }

    public String getLocationInfo() {
        String playerLocation, sceneDescription;
        playerLocation = doggo.getLocation().getName();
        sceneDescription = doggo.getLocation().getDescription();
        return "Location : " + playerLocation + " ( Place Description : " + sceneDescription + " ) ";
    }

    public String movePlayer(String directionStr) {
        String message;
        boolean moved = doggo.goTowards(Direction.convert(directionStr));
        if (moved) {
            return doggo.getLocation().getDescription();
        } else {
            return "Can't go " + directionStr;
        }
    }

    public String getInventory(){
        //TODO : Make it work
        return "Under Construction";
    }

    public String takeItem(String itemStr) {
        return doggo.take(itemStr);
    }

    public String dropItem(String itemStr) {
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


    /*public void showMenu() {
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
    }*/
}
