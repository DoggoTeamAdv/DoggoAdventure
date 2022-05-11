package Game.Parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Verb {
    HELP("help", false),
    QUIT("quit", false),
    BARK("bark", false),
    FART("fart", false),
    LOCATION("location", false),
    INVENTORY("inventory", false),
    USE("use", true),
    MOVE(Arrays.asList("move", "go"), true),
    TAKE(Arrays.asList("take", "grab"), true),
    DROP("drop", true),
    EAT("eat", true);

    private final List<String> synonyms;
    public final boolean needsNoun;

    Verb(String str, boolean needsNoun) {
        this.synonyms = Collections.singletonList(str);
        this.needsNoun = needsNoun;
    }

    Verb(List<String> synonyms, boolean needsNoun) {
        this.synonyms = synonyms;
        this.needsNoun = needsNoun;

    }

    public static Verb convert(String str) {
        String formattedStr = str.toLowerCase();
        for (Verb verb : Verb.values()) {
            for (String synonym : verb.synonyms) {
                if (formattedStr.equals(synonym)) {
                    return verb;
                }
            }
        }
        return null;
    }
}
