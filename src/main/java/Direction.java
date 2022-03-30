public enum Direction {
    north,
    south,
    west,
    east,
    noPoint;

    public static Direction convert(String str) {
        switch (str.toLowerCase().trim()) {
            case "north":
                return north;
            case "south":
                return south;
            case "west":
                return west;
            case "east":
                return east;
            default:
                return noPoint;
        }
    }
}
