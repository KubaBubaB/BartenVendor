package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Vermouth extends ALCOHOL {
    private typeOfVermouth verType;
    public Vermouth(String name, String description,  typeOfVermouth verType, boolean isSubSubTypeImportant){
        super(name, description, typeOfAlc.VERMOUTH, isSubSubTypeImportant);
        this.verType=verType;
    }

    public enum typeOfVermouth{
        EXTRA_DRY, SWEET_WHITE, RED, AMBER, ROSE
    }
    public String getStringOfSubSubType(){
        switch (verType){
            case EXTRA_DRY -> {
                return "Extra Dry";
            }
            case SWEET_WHITE -> {
                return "Sweet White";
            }
            case RED -> {
                return "Red";
            }
            case AMBER -> {
                return "Amber";
            }
            case ROSE -> {
                return "Rose";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfVermouth getVerType() {
        return verType;
    }

    public int getIntOfSubSubType(){
        switch (verType){
            case EXTRA_DRY -> {
                return 0;
            }
            case SWEET_WHITE -> {
                return 1;
            }
            case RED -> {
                return 2;
            }
            case AMBER -> {
                return 3;
            }
            case ROSE -> {
                return 4;
            }
            default -> {
                return -1;
            }
        }
    }
}
