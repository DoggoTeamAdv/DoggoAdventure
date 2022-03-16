public class Scene {
    private String name,description;
    private int north,south,east,west;

    public Scene(String sName, String sDescription, int sNorth,int sEast,int sSouth,int sWest){
        this.name=sName;
        this.description=sDescription;
        north=sNorth;
        south=sSouth;
        east=sEast;
        west=sWest;
    }

    public int getNorth() {
        return north;
    }
    public void setNorth(int north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }
    public void setEast(int east) {
        this.east = east;
    }

    public int getSouth() {
        return south;
    }
    public void setSouth(int south) {
        this.south = south;
    }

    public int getWest() {
        return west;
    }
    public void setWest(int west) {
        this.west = west;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
