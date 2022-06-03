import Game.Menu;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Menu mainMenu = new Menu();
        mainMenu.showMenu();
        mainMenu.menuOption();

    }
}
