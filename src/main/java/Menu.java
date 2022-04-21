import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: CHANGE "isMenuOptionValid = true" WHEN LOAD GAME IS COMPLETED
//TODO:
public class Menu {
    BufferedReader brOption = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader brGame = new BufferedReader(new InputStreamReader(System.in));
    OutputGame game = new OutputGame();
    Parser pars = new Parser();
    Execute exec;

    String playerOption,input,output;
    boolean isMenuOptionValid = false;


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

    public void menuOption() throws IOException
    {

        do{
            System.out.print("Pick An Option (Number) : ");
            playerOption = brOption.readLine();

            switch (playerOption)
            {
                case "1":
                    newGame(playerOption);
                    isMenuOptionValid = true;
                    break;
                case "2":
                    loadGame();
                    isMenuOptionValid = false;
                    break;
                case "3":
                    quitGame();
                    isMenuOptionValid = true;
                    break;
                default:
                    System.out.println("" + playerOption + " Is Not A Valid Option! \n");
            }

        }while (!isMenuOptionValid);
    }

    public void newGame(String playerOption) throws IOException{
        game.showIntro();
        do {
            System.out.print("Command : ");
            input = brGame.readLine();
            output = pars.run(input, game);

        }while(true);
    }

    public void loadGame() {
        //TODO: FUNCTIONAL LOAD GAME
        System.out.println("UNDER CONSTRUCTION");
    }

    public void quitGame(){
        System.exit(0);
    }
}
