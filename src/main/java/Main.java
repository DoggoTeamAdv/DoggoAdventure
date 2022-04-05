import java.io.IOException;


//TODO: add more comments for documentation
//TODO: CLEAR PREVIOUS OUTPUT WHEN PICKING NEW/LOAD GAME

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Main mainGame;
        Menu mainMenu = new Menu();
        OutputGame game = new OutputGame();
        Parser pars = new Parser();

        mainMenu.showMenu();
        mainMenu.menuOption();

    }
}
