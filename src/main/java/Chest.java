public class Chest {
    Item item;
    String name,desc,keyID;

    public Chest(String cName,String cDesc,String cKeyID,Item cItem)
    {
        this.name = cName;
        this.desc = cDesc;
        this.keyID = cKeyID;
        item = cItem;
    }
    
}
