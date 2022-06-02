package Game.Command;

import Game.OutputGame;

public class FartCommand implements Command {
    private OutputGame game;

    public FartCommand(OutputGame game) {
        this.game = game;
    }

    public String fart() {
        return game.fart();
    }

    public String execute() {
        return fart();
    }
}
