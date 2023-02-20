package Ingredients.Softs;

import Ingredients.SOFT;

public class Juice extends SOFT {
    private typeOfJuice jType;
    public Juice(String name, String description, typeOfJuice jType){
        super(name, description, typeOfSoft.JUICE);
        this.jType = jType;
    }

    public enum typeOfJuice{
        ORANGE,LEMON,LIME,PINEAPPLE, CRANBERRY, OTHER
    }
    public String getStringOfSubSubType(){
        switch (jType){
            case ORANGE -> {
                return "Orange";
            }
            case LEMON -> {
                return "Lemon";
            }
            case LIME -> {
                return "Lime";
            }
            case PINEAPPLE -> {
                return "Pineapple";
            }
            case CRANBERRY -> {
                return "Cranberry";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfJuice getjType() {
        return jType;
    }

    public int getIntOfSubSubType(){
        switch (jType){
            case ORANGE -> {
                return 0;
            }
            case LEMON -> {
                return 1;
            }
            case LIME -> {
                return 2;
            }
            case PINEAPPLE -> {
                return 3;
            }
            case CRANBERRY -> {
                return 4;
            }
            case OTHER -> {
                return 5;
            }
            default -> {
                return -1;
            }
        }
    }
}
