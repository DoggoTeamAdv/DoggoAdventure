package Game;

import Game.Command.Command;
import Game.Command.LoadCommand;
import Game.Parser.Parser;
import Game.Parser.Sentence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: CHANGE "isMenuOptionValid = true" WHEN LOAD GAME IS COMPLETED

public class Menu {
    BufferedReader brOption = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader brGame = new BufferedReader(new InputStreamReader(System.in));
    OutputGame game = new OutputGame();
    Parser pars = new Parser();
    CommandFactory commandFactory= new CommandFactory(game);

    String playerOption,input,output;
    boolean isMenuOptionValid = false;

    LoadCommand loadCommand = new LoadCommand();


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
                    break;
                case "2":
                    loadGame();
                    break;
                case "3":
                    quitGame();
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
            Command command;
            try {
                Sentence sentence = pars.parse(input);
                command = commandFactory.getInstance(sentence);
                output = command.execute();
                System.out.println(output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(!game.isFinished());
    }

    public void loadGame() throws IOException{
        Command command;
        loadCommand.execute();
        for (int i = 0; i<loadCommand.getLoad().size(); i++){
            try {
                Sentence sentence = pars.parse(loadCommand.getLoad().get(i));
                command = commandFactory.getInstance(sentence);
                command.execute();
                System.out.println("Load Successfully");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
                }

        do {
            System.out.print("Command : ");
            input = brGame.readLine();
            try {
                Sentence sentence = pars.parse(input);
                command = commandFactory.getInstance(sentence);
                output = command.execute();
                System.out.println(output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(!game.isFinished());

    }

    public void quitGame(){
        System.exit(0);
    }
}
