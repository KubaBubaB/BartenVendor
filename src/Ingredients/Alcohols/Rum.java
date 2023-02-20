package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Rum extends ALCOHOL {
    private typeOfRum rType;
    public Rum(String name, String description, typeOfRum rType, boolean isSubSubTypeImportant){
        super(name,description, typeOfAlc.RUM, isSubSubTypeImportant);
        this.rType=rType;
    }

    public enum typeOfRum{
        WHITE, DARK, GOLD, PACIFIC, AGRICOLE, OVERPROOF, SPICED, AGED, OTHER
    }
    public String getStringOfSubSubType(){
        switch(rType){
            case WHITE -> {
                return "White";
            }
            case DARK -> {
                return "Dark";
            }
            case GOLD -> {
                return "Gold";
            }
            case PACIFIC -> {
                return "Pacific";
            }
            case AGRICOLE -> {
                return "Agricole";
            }
            case OVERPROOF -> {
                return "Overproof";
            }
            case SPICED -> {
                return "Spiced";
            }
            case AGED -> {
                return "Aged";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfRum getrType() {
        return rType;
    }

    public int getIntOfSubSubType(){
        switch(rType){
            case WHITE -> {
                return 0;
            }
            case DARK -> {
                return 1;
            }
            case GOLD -> {
                return 2;
            }
            case PACIFIC -> {
                return 3;
            }
            case AGRICOLE -> {
                return 4;
            }
            case OVERPROOF -> {
                return 5;
            }
            case SPICED -> {
                return 6;
            }
            case AGED -> {
                return 7;
            }
            case OTHER -> {
                return 8;
            }
            default -> {
                return -1;
            }
        }
    }
}
