package Game.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<Item>();

    public void addItem(Item it) {
        items.add(it);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public Item getItem(String itName) {
        String formattedItemToSearch = itName.toLowerCase().trim();
        for (Item item : items) {
            String formattedItemName = item.getName().toLowerCase().trim();
            if (formattedItemName.equals(formattedItemToSearch)) {
                return item;
            }
        }
        return null;
    }
}
