public class Player {
    private String name;
    private Scene location;
    public Player(String pName,  Scene pLocation){
        this.name=pName;
        location=pLocation;
    }

    public void setLocation(Scene location) {
        this.location = location;
    }

    public Scene getLocation() {
        return location;
    }
    public boolean goTowards(Direction dir){
        int go;
        switch(dir){
            case north:
                go=location.getNorth();
                break;
            case east:
                go=location.getEast();
                break;
            case west:
                go=location.getWest();
                break;
            case south:
                go=location.getSouth();
                break;
            default:
                return false;

        }
        if (false){
            System.out.println("No");
        }
        else{
            getLocation().getDescription();
        }
        return true;
    }
}
