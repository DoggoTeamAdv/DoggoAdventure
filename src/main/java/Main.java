import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        String input,output;
        OutputGame game = new OutputGame();
        br = new BufferedReader(new InputStreamReader(System.in));

        /*GAME START*/
        game.showIntro();
        do{
            System.out.print("Command : ");
            input = br.readLine();
            output = game.run(input);
            System.out.println(output);
        } while (true);
    }
}
