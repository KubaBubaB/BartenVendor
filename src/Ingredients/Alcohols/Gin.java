package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Gin extends ALCOHOL {
    private typeOfGin gType;
    public Gin(String name,  String description, typeOfGin gType, boolean isSubSubTypeImportant){
        super(name, description, typeOfAlc.GIN, isSubSubTypeImportant);
        this.gType=gType;
    }
    public enum typeOfGin{
        LONDON_DRY,OTHER
    }

    public String getStringOfSubSubType(){
        if (gType == typeOfGin.LONDON_DRY){
            return "London Dry";
        }
        return "Other";
    }
    public typeOfGin getgType() {
        return gType;
    }

    public int getIntOfSubSubType(){
        if (gType == typeOfGin.LONDON_DRY){
            return 0;
        }
        return 1;
    }
}
