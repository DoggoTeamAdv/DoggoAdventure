import java.util.List;

public class Player {
    private String name;
    private Scene location;

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
            if (scene.getName()==sceneToGoTo) {
                location = scene;
                return true;
            }
        }
        return false;
    }
}

//TEST