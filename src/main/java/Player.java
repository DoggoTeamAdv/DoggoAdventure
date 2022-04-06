import Item.*;

import java.util.List;

public class Player {
    private String name;
    private Scene location;
    private Inventory inventory = new Inventory();
    private boolean fartIsDeadly = false;

    public Player(String pName, Scene pLocation) {
        this.name = pName;
        location = pLocation;
    }

    public void setLocation(Scene location) {
        this.location = location;
    }

    public Scene getLocation() {
        return location;
    }

    public boolean goTowards(Direction dir, List<Scene> map) {
        String sceneToGoTo;
        switch (dir) {
            case north:
                sceneToGoTo = location.getNorth();
                break;
            case east:
                sceneToGoTo = location.getEast();
                break;
            case west:
                sceneToGoTo = location.getWest();
                break;
            case south:
                sceneToGoTo = location.getSouth();
                break;
            default:
                return false;
        }
        if (sceneToGoTo.isEmpty()) {
            return false;
        }
        for (Scene scene : map) {
            if (scene.getName().equals(sceneToGoTo)) {
                location = scene;
                return true;
            }
        }
        return false;
    }

    public void addItem(Item it) {
        inventory.addItem(it);
    }

    public Item removeItem(String itemName) {
        return inventory.removeItem(itemName);
    }

    private Item findItem(String itName) {
        Item item = inventory.getItem(itName);
        if (item != null) {
            return item;
        }
        item = location.getItem(itName);
        return item;
    }

    public String take(String itName) {
        Item it = getLocation().getItem(itName);
        if (it == null) {
            return "No such item exists here";
        }
        if (!it.isInCategory(Category.takeable)) {
            return it.getName() + " can not be taken!";
        }
        addItem(it);
        location.removeItem(itName);
        return "Item " + itName + " added";

    }

    public String drop(String itName) {
        Item it = inventory.getItem(itName);
        if (it == null) {
            return "No such item exists in your inventory";
        }
        if (!it.isInCategory(Category.dropable)) {
            return it.getName() + " is not droppable!";
        }
        removeItem(itName);
        location.addItem(it);
        return "Item " + itName + " dropped";
    }

    public String eat(String itemStr) {
        Item item = findItem(itemStr);
        if (item == null) {
            return "Doggo can't sniff this food anywhere here";
        }
        if (!(item instanceof Food && item.isInCategory(Category.eatable))) {
            return item.getName() + " is not eatable! You are smarter than that...";
        }

        inventory.removeItem(itemStr);
        if (item.getName().equals("Fish")) {
            fartIsDeadly = true;
            return "Warf! The fish was delicious, you feel your stomach rumble though... ";
        }
        return "You eat the " + item.getName() + ". You know you deserved it, you good boy";
    }

    public String use(String itemStr) {
        Item item = findItem(itemStr);
        if (item == null) {
            return "Doggo can't find this item anywhere here";
        }
        if (!item.isInCategory(Category.usable)) {
            return item.getName() + " is not usable! You are smarter than that...";
        }

        if (item instanceof Weapon) {
            return "To be developed";
        } else if (item instanceof Key) {
            return "To be developed";
        } else if (item instanceof Crypto) {
            return "To be developed";
        } else {
            return "I don't know how to use this..";
        }
    }

    public String bark() {
        switch (location.getName()) {
            case "Pigeons":
                return "Wow! you scared the pigeons away but look.. Something shiny is there.... A crypto! Quick! Take it before they come back";
            case "Castle":
                return "Elon Musk : HAHAHA, you can't scare ME little one. I am unbarkable";
            default:
                return "You scared a bee away..this seems useful";
        }
    }

    public String fart() {
        if(location.getName().equals("Castle")){
            if (fartIsDeadly) {
                return "YES. Elon Musk is dead. YOU are the toppest crypto of them all. Good job buddy";
        }else {
                return "Elon Musk: Your fart is smelly but not deadly...at least not yet.";
            }
        }
        else{
            if (fartIsDeadly) {
                return "The plants next to you died from the smell...this seems useful";
            }
            else{
                return "The fly puked by the smell and judged you as it was leaving..you feel embarrassed.";
            }
        }
    }
}
