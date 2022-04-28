package Game.Item;

public abstract class DataItem {
    private String name,description;

    public DataItem(String iName,String iDesc)
    {
        this.name = iName;
        this.description = iDesc;
    }

    //NAME
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //DESCRIPTION
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
}
