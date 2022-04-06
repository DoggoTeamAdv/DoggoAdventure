import java.io.IOException;


//TODO: add more comments for documentation
//TODO: CLEAR PREVIOUS OUTPUT WHEN PICKING NEW/LOAD GAME

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Menu mainMenu = new Menu();

        mainMenu.showMenu();
        mainMenu.menuOption();

    }
}
