package Game.Command;

public class QuitCommand implements  Command{

        private String quit(){
            System.exit(0);
            return null;
        }
        public String execute() {
            return quit();
        }
}
