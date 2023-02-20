package Ingredients.Softs;

import Ingredients.SOFT;

public class Syrup extends SOFT {
    private typeOfSyrup sType;
    public Syrup(String name, String description, typeOfSyrup sType){
        super(name, description, typeOfSoft.SYRUP);
        this.sType = sType;
    }

    public enum typeOfSyrup{
        SIMPLE, CINNAMOON, FALERNUM, GRENADINE, ELDERFLOWER, LEMON_GRASS, RASPBERRY, VANILLA, OTHER
    }
    public String getStringOfSubSubType(){
        switch (sType){
            case SIMPLE -> {
                return "Simple";
            }
            case CINNAMOON -> {
                return "Cinnamoon";
            }
            case FALERNUM -> {
                return "Falernum";
            }
            case GRENADINE -> {
                return "Grenadine";
            }
            case ELDERFLOWER -> {
                return "Elderflower";
            }
            case LEMON_GRASS -> {
                return "Lemon Grass";
            }
            case RASPBERRY -> {
                return "Raspberry";
            }
            case VANILLA -> {
                return "Vanilla";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfSyrup getsType() {
        return sType;
    }

    public int getIntOfSubSubType(){
        switch (sType){
            case SIMPLE -> {
                return 0;
            }
            case CINNAMOON -> {
                return 1;
            }
            case FALERNUM -> {
                return 2;
            }
            case GRENADINE -> {
                return 3;
            }
            case ELDERFLOWER -> {
                return 4;
            }
            case LEMON_GRASS -> {
                return 5;
            }
            case RASPBERRY -> {
                return 6;
            }
            case VANILLA -> {
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
