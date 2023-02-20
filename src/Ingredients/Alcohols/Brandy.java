package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Brandy extends ALCOHOL {
    private typeOfBrandy bType;
    public Brandy(String name, String description, typeOfBrandy bType,boolean isSubSubTypeImportant){
        super(name,description, typeOfAlc.BRANDY,isSubSubTypeImportant);
        this.bType=bType;
    }
    public enum typeOfBrandy{
        COGNAC,OTHER
    }
    public String getStringOfSubSubType(){
        if (bType == typeOfBrandy.COGNAC){
            return "Cognac";
        }
        return "Other";
    }
    public typeOfBrandy getbType() {
        return bType;
    }
    public int getIntOfSubSubType(){
        if (bType == typeOfBrandy.COGNAC){
            return 0;
        }
        return 1;
    }
}
