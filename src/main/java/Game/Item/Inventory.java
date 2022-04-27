package Game.Item;

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

    public void remove(Item item) {
        items.remove(item);
    }

    //Gets the name of an Item.Item and returns it if it belongs to the list
    public Item getItem(String itName){
        int result= indexOf(itName);
        if(result==-1) {
           return null;
        }
        else
            return items.get(result);
    }
}
