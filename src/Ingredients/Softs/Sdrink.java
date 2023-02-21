package Ingredients.Softs;

import Ingredients.SOFT;

public class Sdrink extends SOFT {
    private typeOfSdrink sdType;
    public Sdrink(String name, String description, typeOfSdrink sdType){
        super(name, description, typeOfSoft.SDRINK);
        this.sdType = sdType;
    }

    public enum typeOfSdrink{
        COLA, SPARKLING_WATER, SPRITE, FANTA, OTHER
    }
    public String getStringOfSubSubType(){
        switch (sdType){
            case COLA -> {
                return "Cola";
            }
            case SPARKLING_WATER -> {
                return "Sparkling water";
            }
            case SPRITE -> {
                return "Sprint";
            }
            case FANTA -> {
                return "Fanta";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }

    public typeOfSdrink getsdType() {
        return sdType;
    }

    public int getIntOfSubSubType(){
        switch (sdType){
            case COLA -> {
                return 0;
            }
            case SPARKLING_WATER -> {
                return 1;
            }
            case SPRITE -> {
                return 2;
            }
            case FANTA -> {
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
