package Ingredients;

public abstract class ALCOHOL extends Ingredient {
    protected typeOfAlc type;
    public ALCOHOL(String name, String description, typeOfAlc type, boolean isSubSubTypeImportant){
        super(name, whatKindOfIngredient.ALCOHOL, description, isSubSubTypeImportant);
        this.type=type;
    }
    public enum typeOfAlc{
        VODKA, WHISKEY, BRANDY,GIN,LIQUEUR,RUM,TEQUILLA,VERMOUTH,OTHER
    }
    public abstract String getStringOfSubSubType();
    public abstract int getIntOfSubSubType();
    public String getStringOfSubType(){
        switch(type){
            case VODKA -> {
                return "Vodka";
            }
            case WHISKEY -> {
                return "Whiskey";
            }
            case BRANDY -> {
                return "Brandy";
            }
            case GIN -> {
                return "Gin";
            }
            case LIQUEUR -> {
                return "Liqueur";
            }
            case RUM -> {
                return "Rum";
            }
            case TEQUILLA -> {
                return "Tequilla";
            }
            case VERMOUTH -> {
                return "Vermouth";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfAlc getType() {
        return type;
    }
    public int getIntOfSubType(){
        switch(type){
            case VODKA -> {
                return 0;
            }
            case WHISKEY -> {
                return 1;
            }
            case BRANDY -> {
                return 2;
            }
            case GIN -> {
                return 3;
            }
            case LIQUEUR -> {
                return 4;
            }
            case RUM -> {
                return 5;
            }
            case TEQUILLA -> {
                return 6;
            }
            case VERMOUTH -> {
                return 7;
            }
            case OTHER -> {
                return 8;
            }
            default -> {
                return 9;
            }
        }
    }
}
