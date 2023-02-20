package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Whiskey extends ALCOHOL {
    private typeOfWhiskey wType;
    public Whiskey(String name, String description, typeOfWhiskey wType, boolean isSubSubTypeImportant){
        super(name, description, typeOfAlc.WHISKEY, isSubSubTypeImportant);
        this.wType=wType;
    }
    public enum typeOfWhiskey{
        SCOTCH,IRISH,AMERICAN,BOURBON,OTHER
    }
    public String getStringOfSubSubType(){
        switch(wType){
            case SCOTCH -> {
                return "Scotch";
            }
            case IRISH -> {
                return "Irish";
            }
            case AMERICAN -> {
                return "American";
            }
            case BOURBON -> {
                return "Bourbon";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfWhiskey getwType() {
        return wType;
    }

    public int getIntOfSubSubType(){
        switch(wType){
            case SCOTCH -> {
                return 0;
            }
            case IRISH -> {
                return 1;
            }
            case AMERICAN -> {
                return 2;
            }
            case BOURBON -> {
                return 3;
            }
            case OTHER -> {
                return 4;
            }
            default -> {
                return -1;
            }
        }
    }
}
