import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: add more comments for documentation
//TODO: CLEAR PREVIOUS OUTPUT WHEN PICKING NEW/LOAD GAME

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)),br2 = new BufferedReader(new InputStreamReader(System.in));
        String input,output,startOption;
        OutputGame game = new OutputGame();

        game.showMenu();
        System.out.print("Pick An Option (Number) : ");
        startOption = br2.readLine();

        switch(startOption){
            //NEW GAME
            case "1":
                game.showIntro();

                do{
                    System.out.print("Command : ");
                    input = br.readLine();
                    output = game.run(input);
                    System.out.println(output);

                }while (true);
            //LOAD GAME
            case "2":
                System.out.println("COMING SOON...");
                break;
            //QUIT GAME
            case "3":
                System.exit(0);
                break;
        }

    }
}
