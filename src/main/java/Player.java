import java.util.List;

public class Player {
    private String name;
    private Scene location;
    private Inventory inventory = new Inventory();

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
    public void addItem(Item it){
        inventory.addItem(it);
    }
    public Item removeItem(String itemName){
        return inventory.removeItem(itemName);
    }

    public Item getItem(String itName) {
        return inventory.getItem(itName);
    }

    public String take(String itName) {
        String message = "";
        if (itName.equals("")) {
            message = "Such item doesn't exist";
            return message;
        }
        Item it = getLocation().getItem(itName);
        if (it == null) {
            message = "No such item exists here";
        } else {
             addItem(it);
             location.removeItem(itName);
             message = "Item " + itName +" added";
        }
        return message;
    }
    public String drop(String itName) {
        String message = "";
        if (itName.equals("")) {
            message = "Such item doesn't exist";
        }
        Item it = inventory.getItem(itName);
        if (it == null) {
            message = "No such item exists in your inventory";
        } else {
            removeItem(itName);
            location.addItem(it);
            message = "Item " + itName + " removed";
        }
        return message;
    }

}
