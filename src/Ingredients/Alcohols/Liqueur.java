package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Liqueur extends ALCOHOL {
    private typeOfLiqueur lType;
    public Liqueur(String name, String description, typeOfLiqueur lType, boolean isSubSubTypeImportant){
        super(name, description, typeOfAlc.LIQUEUR, isSubSubTypeImportant);
        this.lType = lType;
    }

    public enum typeOfLiqueur{
        TRIPLE_SEC, ELDERFLOWER, IRISH_CREAM, COFFEE, COCONUT, PEACH, BLUE_CURACAO, OTHER
    }

    public String getStringOfSubSubType(){
        switch (lType){
            case TRIPLE_SEC -> {
                return "Triple Sec";
            }
            case ELDERFLOWER -> {
                return "Elderflower";
            }
            case IRISH_CREAM -> {
                return "Irish Cream";
            }
            case COFFEE -> {
                return "Coffee";
            }
            case COCONUT -> {
                return "Coconut";
            }
            case PEACH -> {
                return "Peach";
            }
            case BLUE_CURACAO -> {
                return "Blue Curacao";
            }
            case OTHER -> {
                return "Other";
            }
        }
        return "";
    }
    public Liqueur.typeOfLiqueur getlType() {
        return lType;
    }

    public int getIntOfSubSubType(){
        switch (lType){
            case TRIPLE_SEC -> {
                return 0;
            }
            case ELDERFLOWER -> {
                return 1;
            }
            case IRISH_CREAM -> {
                return 2;
            }
            case COFFEE -> {
                return 3;
            }
            case COCONUT -> {
                return 4;
            }
            case PEACH -> {
                return 5;
            }
            case BLUE_CURACAO -> {
                return 6;
            }
            case OTHER -> {
                return 7;
            }
        }
        return -1;
    }
}
