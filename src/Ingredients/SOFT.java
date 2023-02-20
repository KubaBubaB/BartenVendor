package Ingredients;

public abstract class SOFT extends Ingredient{
    protected typeOfSoft type;
    public SOFT(String name, String description, typeOfSoft type){
        super(name, whatKindOfIngredient.SOFT, description, true);
        this.type = type;
    }
    public enum typeOfSoft{
        JUICE, SYRUP, SDRINK, OTHER
    }
    public abstract String getStringOfSubSubType();
    public abstract int getIntOfSubSubType();
    public String getStringOfSubType(){
        switch (type){
            case JUICE -> {
                return "Juice";
            }
            case SYRUP -> {
                return "Syrup";
            }
            case SDRINK -> {
                return "Soft Drink";
            }
            case OTHER -> {
                return "Other";
            }
            default -> {
                return "";
            }
        }
    }
    public typeOfSoft getType() {
        return type;
    }
    public int getIntOfSubType(){
        switch (type){
            case JUICE -> {
                return 0;
            }
            case SYRUP -> {
                return 1;
            }
            case SDRINK -> {
                return 2;
            }
            case OTHER -> {
                return 3;
            }
            default -> {
                return 4;
            }
        }
    }
}
