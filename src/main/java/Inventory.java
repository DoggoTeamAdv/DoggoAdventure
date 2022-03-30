import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<Item>();

    //It searches if the item exists and if not, it returns -1
    private int indexOf(String itemName) {
        for (int i = 0; i<items.size(); ++i) {
            if (items.get(i).getName().toLowerCase().trim().equals(itemName.toLowerCase().trim())) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(Item it){
        items.add(it);
    }

    //It tries to remove the item with the given name. It returns it after removing it or returns null if not found
    public Item removeItem(String itemName){
        int index = indexOf(itemName);
        if (index==-1) {
            return null;
        }
        Item item = items.get(index);
        items.remove(index);
        return item;
    }
    //Gets the name of an Item and returns it if it belongs to the list
    public Item getItem(String itName){
        int result= indexOf(itName);
        if(result==-1) {
           return null;
        }
        else
            return items.get(result);
    }
}
