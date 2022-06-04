package Game.Parser;

import java.util.Collections;
import java.util.List;

public enum Noun {
    CHINGCHONGKEY("ching chong key"),
    RUSTYKEY("rusty key"),
    BITCOIN("bitcoin"),
    ETHERIUM("etherium"),
    SOLANA("solana"),
    LUNA("luna"),
    FISH("fish"),
    AXE("axe"),
    WEST("west"),
    EAST("east"),
    NORTH("north"),
    SOUTH("south");

    private final List<String> synonyms;

    Noun(String str) {
        this.synonyms = Collections.singletonList(str);
    }

    Noun(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public static Noun convert(String str) {
        String formattedStr = str.toLowerCase();

        for (Noun noun : Noun.values()) {
            if (noun.synonyms.contains(formattedStr)) {
                return noun;
            }
        }
        return null;
    }

    public String getStr() {
        return synonyms.get(0);
    }
}
