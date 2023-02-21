package Recipes;
import Ingredients.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Recipe implements Serializable {
    private Vector<Ingredient> rIngr;
    private ArrayList<Integer> quantity;
    private String method;
    private String glass;
    private String description;
    private String iceType;
    private String name;
    private ArrayList<Boolean> canBeSubstituted;
    public Recipe(Vector<Ingredient> rIngr, ArrayList<Integer>quantity, String method, String glass, String description, String iceType, String name, ArrayList<Boolean> canBeSubstituted){
        this.rIngr=rIngr;
        this.quantity = quantity;
        this.method = method;
        this.glass = glass;
        this.description = description;
        this.iceType = iceType;
        this.name = name;
        this.canBeSubstituted = canBeSubstituted;
    }


    public Vector<Ingredient> getrIngr() {
        return rIngr;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public String getMethod() {
        return method;
    }

    public String getGlass() {
        return glass;
    }

    public String getDescription() {
        return description;
    }

    public String getIceType() {
        return iceType;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Boolean> getCanBeSubstituted() {
        return canBeSubstituted;
    }

    public String toString(){
        //name;method;glass;description;iceType;ingrs(@name#kind#isSubSubTypeImportant#subtype#subsubtype#descr#quantity);canBeSubs(@)
        StringBuilder test = new StringBuilder();
        test.append("<").append(name).append(";").append(method).append(";").append(glass).append(";").append(description).
                append(";").append(iceType).append(";");
        for (int i = 0; i < rIngr.size(); i++) {
            test.append("@").append(rIngr.elementAt(i).getName()).append("#").
                    append(rIngr.elementAt(i).getKindString()).append("#").
                    append(rIngr.elementAt(i).getIsSubSubTypeImportant()).append("#").
                    append(rIngr.elementAt(i).getStringOfSubType()).append("#").
                    append(rIngr.elementAt(i).getStringOfSubSubType()).append("#").append(rIngr.elementAt(i).getDescription());//
        }
        test.append(";");
        for(int i = 0;i < canBeSubstituted.size(); i++){
            test.append("@").append(canBeSubstituted.get(i));
        }
        test.append(";");
        for(int i = 0;i < quantity.size(); i++){
            test.append("@").append(quantity.get(i));
        }
        test.append(";");
        return test.toString();
    }

}
