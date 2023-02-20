package Ingredients.Alcohols;

import Ingredients.ALCOHOL;

public class Vodka extends ALCOHOL {
    private typeOfVodka vType;
    public Vodka(String name, String description, typeOfVodka vType, boolean isSubSubTypeImportant){
        super(name, description, typeOfAlc.VODKA, isSubSubTypeImportant);
        this.vType=vType;
    }
    public enum typeOfVodka{
        PLAIN, FLAVOURED, FRUIT,OTHER
    }
    public String getStringOfSubSubType(){
        switch (vType){
            case PLAIN ->{
                return "Plain";
            }
            case FLAVOURED -> {
                return "Flavoured";
            }
            case FRUIT -> {
                return "Fruit";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfVodka getvType() {
        return vType;
    }
    public int getIntOfSubSubType(){
        switch (vType){
            case PLAIN ->{
                return 0;
            }
            case FLAVOURED -> {
                return 1;
            }
            case FRUIT -> {
                return 2;
            }
            case OTHER -> {
                return 3;
            }
            default -> {
                return -1;
            }
        }
    }
}
