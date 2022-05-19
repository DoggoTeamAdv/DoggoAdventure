package Game.Character;

import Game.Item.*;
import Game.Scene_Stuff.Scene;

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


    public void addItem(Item it) {
        inventory.addItem(it);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public Item getItem(String itName) {
        return inventory.getItem(itName);
    }

    public boolean isFartDeadly() {
        return fartIsDeadly;
    }

    public String unlockDeadlyFart(){
        fartIsDeadly = true;
        return "You feel a pressure in your butt and feel your tummy ruble with power";
    }

    public List<String> getItemNames(){
        return inventory.getItemNames();
    }
}
