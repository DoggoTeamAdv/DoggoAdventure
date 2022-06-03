package Game.Parser;

public class Sentence {
    public final Verb verb;
    public final Noun noun;
    Sentence(Verb verb, Noun noun) {
        this.verb = verb;
        this.noun = noun;
    }

    private String getVerb(){
        return this.verb.getStr();
    }
    private String getNoun(){
        return this.noun.getStr();
    }

    public String convertSentence(){
        return this.getVerb() + " " + this.getNoun();
    }
}
