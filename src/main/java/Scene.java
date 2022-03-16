public class Scene {
    private String name, description;
    private String north,east,west,south;

    public Scene(String sName, String sDescription, String sNorth, String sEast, String sSouth, String sWest) {
        this.name = sName;
        this.description = sDescription;
        this.north = sNorth;
        this.south = sSouth;
        this.east = sEast;
        this.west = sWest;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }
    public void setWest(String west) {
        this.west = west;
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
}
