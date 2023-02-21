import Ingredients.*;
import Recipes.*;

import java.util.ArrayList;
import java.util.Vector;

public class Manager {
    private Vector<Recipe> vRecipes;
    private Vector<Ingredient> vIngr;
    private ArrayList<Integer> quantityInBasket;
    private HashNode[] aIngr;
    private final int aIngrCapacity = 401;
    public Manager(){
        vRecipes = new Vector<Recipe>();
        vIngr = new Vector<Ingredient>();
        quantityInBasket = new ArrayList<Integer>();
        aIngr = new HashNode[aIngrCapacity];
    }
    public Manager(Vector<Recipe> vRecipes, Vector<Ingredient> vIngr, ArrayList<Integer> quantityInBasket, HashNode[] aIngr){
        this.vRecipes = vRecipes;
        this.vIngr = vIngr;
        this.quantityInBasket = quantityInBasket;
        this.aIngr = aIngr;
    }
    public Manager(Vector<Recipe> vRecipes){
        this.vRecipes = vRecipes;
        vIngr = new Vector<Ingredient>();
        quantityInBasket = new ArrayList<Integer>();
        aIngr = new HashNode[aIngrCapacity];
    }

    public Vector<Recipe> getvRecipes() {
        return vRecipes;
    }

    public Vector<Ingredient> getvIngr() {
        return vIngr;
    }

    public void addIngrToBasket(Ingredient ingr, int quantity){
        vIngr.add(ingr);
        quantityInBasket.add(quantity);
        //spr czy aIngr[getHashIndex(ingr)] jest nullem, tak dodaj, nie zwroc ostatni node i dodaj tam
        if (aIngr[getHashIndex(ingr)] == null){
            aIngr[getHashIndex(ingr)] = new HashNode(ingr, getHashIndex(ingr), quantity);
        }
        else{
            HashNode tmp = retLastOfSameHash(getHashIndex(ingr));
            tmp.next = new HashNode(ingr, getHashIndex(ingr), quantity);
        }
    }

    public void addRecipe(Recipe rec){
        vRecipes.add(rec);
    }

    public ArrayList<Integer> getQuantityInBasket() {
        return quantityInBasket;
    }

    public HashNode[] getaIngr() {
        return aIngr;
    }

    public int getaIngrCapacity() {
        return aIngrCapacity;
    }

    public class HashNode{
        Ingredient ingr;
        int quantity;
        int hashCode;
        HashNode next;
        HashNode(Ingredient ingr, int hashCode, int quantity){
            this.quantity = quantity;
            this.ingr = ingr;
            this.hashCode = hashCode;
            this.next = null;
        }

        public void setNext(HashNode next) {
            this.next = next;
        }

        public Ingredient getIngr() {
            return ingr;
        }

        public int getHashCode() {
            return hashCode;
        }

        public HashNode getNext() {
            return next;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    private HashNode retLastOfSameHash(int hashcode){
        HashNode tmp = aIngr[hashcode];
        if (tmp == null){
            return null;
        }
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }

    public boolean checkForQuantity(int hashcode, int quantity){
        HashNode tmp = aIngr[hashcode];
        if (tmp == null){
            return false;
        }
        else if(tmp.quantity > quantity){
            return true;
        }
        while(tmp.next != null){
            if(tmp.quantity > quantity){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    public boolean checkForNameAndQuantity(int hashcode, String name, int quantity){
        HashNode tmp = aIngr[hashcode];
        if (tmp == null){
            return false;
        }
        else if(tmp.ingr.getName().toUpperCase().equals(name.toUpperCase())){
            if(tmp.quantity > quantity){
                return true;
            }
        }
        while(tmp.next != null){
            if(tmp.ingr.getName().toUpperCase().equals(name.toUpperCase())){
                if(tmp.quantity > quantity){
                    return true;
                }
            }
            tmp = tmp.next;
        }
        return false;
    }

    public int getHashIndex(Ingredient toHash){
        int mainKind = -1;
        switch(toHash.getKind()) {
            case ALCOHOL -> {
                mainKind = 0;
            }
            case SOFT -> {
                mainKind = 1;
            }
            case OTHER -> {
                mainKind = 2;
            }
        }
        int subKind = toHash.getIntOfSubType();
        int subSubKind = toHash.getIntOfSubSubType();
        return (mainKind*100 + subKind*10 + subSubKind) % aIngrCapacity;
    }
}
