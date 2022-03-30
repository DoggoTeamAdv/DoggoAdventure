public class Item {
    private String name,description,categories;

    public Item(String iName,String iDesc,String iCategories)
    {
        this.name = iName;
        this.description = iDesc;
        this.categories = iCategories;
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

    //CATEGORIES
    public String getCategories()
    {
        return categories;
    }
    public void setCategories(String categories)
    {
        this.categories = categories;
    }




}
