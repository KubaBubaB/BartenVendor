package Ingredients;

public abstract class Ingredient {
    private String name;
    private whatKindOfIngredient kind;
    private String description;
    private boolean isSubSubTypeImportant;
    public Ingredient(String name, whatKindOfIngredient kind, String description, boolean isSubSubTypeImportant){
        this.name = name;
        this.kind = kind;
        this.description = description;
        this.isSubSubTypeImportant = isSubSubTypeImportant;
    }

    public boolean getIsSubSubTypeImportant() {
        return isSubSubTypeImportant;
    }

    public enum whatKindOfIngredient{
        ALCOHOL,
        SOFT,
        OTHER
    }

    public abstract String getStringOfSubSubType();
    public abstract String getStringOfSubType();

    public abstract int getIntOfSubSubType();
    public abstract int getIntOfSubType();

    //GETTERS
    public String getName(){
        return name;
    }
    public whatKindOfIngredient getKind(){
        return kind;
    }
    public String getDescription(){
        return description;
    }
    public String getKindString() {
        if(kind == whatKindOfIngredient.ALCOHOL){
            return "Alcohol";
        }
        else if(kind == whatKindOfIngredient.SOFT){
            return "Soft";
        }
        else{
            return "Other";
        }
    }
}
