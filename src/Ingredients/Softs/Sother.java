package Ingredients.Softs;

import Ingredients.SOFT;

public class Sother extends SOFT {
    public Sother(String name, String description){
        super(name, description, typeOfSoft.OTHER);
    }
    public String getStringOfSubSubType(){
        return "Other";
    }

    public int getIntOfSubSubType(){
        return 0;
    }
}
