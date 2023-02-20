package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Aother extends ALCOHOL {
    public Aother(String name,  String description){
        super(name, description, typeOfAlc.OTHER, true);
    }
    public String getStringOfSubSubType(){
        return "Other";
    }
    public int getIntOfSubSubType(){
        return 0;
    }
}
