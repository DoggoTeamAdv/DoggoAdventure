package Game.Command;

import Game.Parser.Verb;

public class HelpCommand implements Command {
    public String help() {
        StringBuilder messageBuilder = new StringBuilder("Your options are...\n");
        for (Verb verb : Verb.values()) {
            messageBuilder.append(verb.getStr());
            messageBuilder.append('\n');
        }
        return messageBuilder.toString().trim();
    }

    public String execute() {
        return help();
    }
}
