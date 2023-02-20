package Ingredients;

public class Others extends Ingredient{
    public Others (String name, String description){
        super(name, whatKindOfIngredient.OTHER, description, true);
    }
    public String getStringOfSubSubType(){
        return "Other";
    }
    public String getStringOfSubType(){
        return "Other";
    }
    public int getIntOfSubType(){
        return 0;
    }
    public int getIntOfSubSubType(){
        return 0;
    }
}
