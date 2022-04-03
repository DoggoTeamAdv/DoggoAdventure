package Item;

import java.util.List;

abstract public class Item {
    private String name,description;
    List<Category> categories;

    public Item(String iName,String iDesc, List<Category> iCategories)
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
    public boolean isInCategory(Category category) {
        for (Category myCategory : categories) {
            if (myCategory==category) {
                return true;
            }
        }
        return false;
    }




}
