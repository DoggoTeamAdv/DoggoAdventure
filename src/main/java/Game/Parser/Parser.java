package Game.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    List<String> splitInput(String input) {
        List<String> words = Arrays.asList(input.split(" "));
        List<String> parts = new ArrayList<String>();

        if (words.size() >= 1) {
            parts.add(words.get(0));
        }
        if (words.size() >= 2) {
            String secondPart = "";
            for (int i=1; i<words.size(); ++i) {
                if (i==words.size()-1) {
                    secondPart = secondPart.concat(words.get(i));
                } else {
                    secondPart = secondPart.concat(words.get(i)+" ");
                }
            }
            parts.add(secondPart);
        }
        return parts;
    }

    public List<String> parse(String userInput) throws Exception {
        List<String> inputParts = splitInput(userInput);
        if (inputParts.size() == 0) {
            throw new Exception("Doggo needs commands to achieve world domination...i mean to become famous!!!");
        }

        Verb verb = null;
        Noun noun = null;
        verb = Verb.convert(inputParts.get(0));
        if (verb == null) {
            throw new Exception("Woof! What does " +inputParts.get(0) + " mean?");
        }
        if (inputParts.size()== 2) {
            noun = Noun.convert(inputParts.get(1));
            if (noun == null) {
                throw new Exception("Woof! What is a " +inputParts.get(1) + "?");
            }
        }

        if ((verb.needsNoun) && (noun == null)) {
            throw new Exception("This command is not a lone wolf. " + inputParts.get(0) + " ....?");
        } else if ((!verb.needsNoun) && (noun != null)) {
            throw new Exception("This command is a lone wolf..");
        }
        return inputParts;
    }
}
