package Game.Scene_Stuff;

import Game.Item.Inventory;
import Game.Item.Item;

public class Scene {
    private String name, description;
    private Scene north,east,west,south;
    private Inventory sceneItems = new Inventory();

    public Scene(String sName, String sDescription) {
        this.name = sName;
        this.description = sDescription;
    }

    //NORTH
    public Scene getNorth() {
        return north;
    }
    public void setNorth(Scene north) {
        this.north = north;
    }
    //EAST
    public Scene getEast() {
        return east;
    }
    public void setEast(Scene east) {
        this.east = east;
    }
    //SOUTH
    public Scene getSouth() {
        return south;
    }

    public void setSouth(Scene south) {
        this.south = south;
    }
    //WEST
    public Scene getWest() {
        return west;
    }
    public void setWest(Scene west) {
        this.west = west;
    }

    public Scene getSceneInDirection(Direction direction) {
        switch (direction) {
            case north:
                return north;
            case east:
                return east;
            case south:
                return south;
            case west:
                return west;
            default:
                return null;
        }
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addItem(Item it){
        sceneItems.addItem(it);
    }
    public void remove(Item item){
       sceneItems.remove(item);
    }

    public Item getItem(String itName) {
        return sceneItems.getItem(itName);
    }
}
