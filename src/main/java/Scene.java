public class Scene {
    private String name, description;
    private String north,east,west,south;
    private Inventory sceneItems = new Inventory();

    public Scene(String sName, String sDescription, String sNorth, String sEast, String sSouth, String sWest) {
        this.name = sName;
        this.description = sDescription;
        this.north = sNorth;
        this.south = sSouth;
        this.east = sEast;
        this.west = sWest;
    }

    //NORTH
    public String getNorth() {
        return north;
    }
    public void setNorth(String north) {
        this.north = north;
    }
    //EAST
    public String getEast() {
        return east;
    }
    public void setEast(String east) {
        this.east = east;
    }
    //SOUTH
    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }
    //WEST
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

    public void addItem(Item it){
        sceneItems.addItem(it);
    }
    public Item removeItem(String itemName){
       return sceneItems.removeItem(itemName);
    }

    public Item getItem(String itName) {
        return sceneItems.getItem(itName);
    }
}
