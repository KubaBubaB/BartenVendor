package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Tequilla extends ALCOHOL {
    private typeOfTequilla tType;
    public Tequilla(String name, String description, typeOfTequilla tType, boolean isSubSubTypeImportant){
        super(name, description, typeOfAlc.TEQUILLA, isSubSubTypeImportant);
        this.tType=tType;
    }

    public enum typeOfTequilla{
        BIANCO, REPOSADO, ANEJO, EXTRA_ANEJO, CRISTALINO
    }
    public String getStringOfSubSubType(){
        switch(tType){
            case BIANCO -> {
                return "Bianco";
            }
            case REPOSADO -> {
                return "Reposado";
            }
            case ANEJO -> {
                return "Anejo";
            }
            case EXTRA_ANEJO -> {
                return "Extra Anejo";
            }
            case CRISTALINO -> {
                return "Cristalino";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfTequilla gettType() {
        return tType;
    }

    public int getIntOfSubSubType(){
        switch(tType){
            case BIANCO -> {
                return 0;
            }
            case REPOSADO -> {
                return 1;
            }
            case ANEJO -> {
                return 2;
            }
            case EXTRA_ANEJO -> {
                return 3;
            }
            case CRISTALINO -> {
                return 4;
            }
            default -> {
                return -1;
            }
        }
    }
}
