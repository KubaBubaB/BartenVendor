import Ingredients.*;
import Ingredients.Alcohols.*;
import Ingredients.Softs.*;
import Recipes.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JMenuItem addRecipe;
    private JMenuItem addIngr;
    private JMenuItem showRecipe;
    private JMenuItem showIngr;
    private JMenuItem showDrinks;
    private JMenuItem showHelp;
    private JMenu menuR;
    private JMenu menuI;
    private JMenu menuD;
    private JMenu menuHelp;
    private JMenuBar menuBar;
    private Manager menago;
    private JScrollPane sPane;
    private ArrayList<Ingredient> missingIngr;

    public GUI() {
        //UTILITIES
        menago = new Manager();
        missingIngr = new ArrayList<Ingredient>();
        //FRAME
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BartenVendor v0.1");

        //MENU
        menuBar = new JMenuBar();
        menuI = new JMenu("Ingerdients");
        menuR = new JMenu("Recipes");
        menuD = new JMenu("Available Drinks");
        menuHelp = new JMenu("You need help?");
        showHelp = new JMenuItem("Show help!");
        showDrinks = new JMenuItem("Show me!");
        addIngr = new JMenuItem("Add Ingredient");
        addRecipe = new JMenuItem("Add Recipe");
        showIngr = new JMenuItem("Show Ingredients");
        showRecipe = new JMenuItem("Show Recipes");
        showHelp.addActionListener(this);
        addIngr.addActionListener(this);
        addRecipe.addActionListener(this);
        showIngr.addActionListener(this);
        showRecipe.addActionListener(this);
        showDrinks.addActionListener(this);
        menuI.add(addIngr);
        menuI.add(showIngr);
        menuR.add(addRecipe);
        menuR.add(showRecipe);
        menuD.add(showDrinks);
        menuHelp.add(showHelp);
        menuBar.add(menuI);
        menuBar.add(menuR);
        menuBar.add(menuD);
        menuBar.add(menuHelp);
        frame.setJMenuBar(menuBar);

        //LABEL
        label = new JLabel("<html> Hi, firstly add ingredients you own :) <br/> " +
                "Then add recipes if you wish, then click \"Available Drinks\", then \"Show me!\" to see what cocktails you can make!</html>", SwingConstants.CENTER);
        label.setSize(300, 100);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.darkGray);
        sPane = new JScrollPane(label);
        sPane.getViewport().setBackground(Color.BLACK);


        //PANEL ITSELF
        panel = new JPanel();
        panel.setBounds(30, 30, 400, 800);
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(sPane, BorderLayout.CENTER);
        frame.add(panel);
        frame.pack();
        frame.setSize(700, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addIngr) {
            addIngr();
        } else if (e.getSource() == addRecipe) {
            addRecipe();
        } else if (e.getSource() == showIngr) {
            showIngred();
        } else if (e.getSource() == showRecipe) {
            showRecipesfunc();
        } else if (e.getSource() == showDrinks) {
            showAllRecipes();
        } else if (e.getSource() == showHelp) {

        }
    }
    //Adds ingredient to 'basket', connects gui with manager
    private void addIngr() {
        Ingredient tmp = createIngr(false);
        if (tmp ==null){
            ///ADD INFO ABOUT ERROR
            return;
        }
        menago.addIngrToBasket(tmp, inputQuant());
    }
    //Adds recipe to 'book', connects gui with manager
    private void addRecipe(){
        Recipe tmp = createRecipe();
        if (tmp == null){
            //IMPLEMENT MORE ERROR HANDLING
            return;
        }
        //IMPLEMENT CHECKING IF NAME IS TAKEN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        menago.addRecipe(tmp);
    }
    //Reads name given by the user, probably cant be left empty. Should be changed to if null -> stop the process of adding
    private String inputName() {
        String name = null;
        while (name == null) {
            name = (String) JOptionPane.showInputDialog(
                    frame,
                    "Write the name",
                    "Name",
                    JOptionPane.PLAIN_MESSAGE, null,
                    null, null);
        }
        return name;
    }
    //Reads description of a thing, given by the user
    private String inputDescr() {
        return (String) JOptionPane.showInputDialog(
                frame,
                "Write the description, you can leave it empty",
                "Description",
                JOptionPane.PLAIN_MESSAGE, null,
                null, " ");
    }
    //Reads ??? thing given by the user
    private String inputX(String title, String message){
        String name = null;
        while (name == null) {
            name = (String) JOptionPane.showInputDialog(
                    frame,
                    message,
                    title,
                    JOptionPane.PLAIN_MESSAGE, null,
                    null, null);
        }
        return name;
    }
    //Reads int input from user
    private int inputQuant() {
        /////NOT OPTIMAL IN ANY WAY, OPEN TO ABUSE FOR STACK OVERFLOW DUE TO POSSIBLE NEVER ENDING RECURSION
        int quan = 0;
        try {
            quan = Integer.parseInt((String) JOptionPane.showInputDialog(
                    frame,
                    "Type the quantity (liquids in ml, objects in number of objects)",
                    "Quantity",
                    JOptionPane.PLAIN_MESSAGE, null,
                    null, null));
            System.out.println(quan);
        } catch (NumberFormatException nfe) {
            quan = inputQuant();
        }
        while (quan <= 0) {
            quan = inputQuant();
        }
        return quan;
    }
    //Handles alcohol adding
    private Ingredient addAlcHandler(boolean askForSubSubImportance) {
        String name;
        String desc;
        boolean isSubSubTypeImportant;
        Object[] possibilities2 = {ALCOHOL.typeOfAlc.VODKA, ALCOHOL.typeOfAlc.WHISKEY, ALCOHOL.typeOfAlc.BRANDY, ALCOHOL.typeOfAlc.GIN, ALCOHOL.typeOfAlc.LIQUEUR,
                ALCOHOL.typeOfAlc.RUM, ALCOHOL.typeOfAlc.TEQUILLA, ALCOHOL.typeOfAlc.VERMOUTH, ALCOHOL.typeOfAlc.OTHER};
        ALCOHOL.typeOfAlc alcType = (ALCOHOL.typeOfAlc) JOptionPane.showInputDialog(
                frame,
                "Select the type of alcohol",
                "Type of alcohol",
                JOptionPane.PLAIN_MESSAGE, null,
                possibilities2,
                null);
        Object[] posiibilieties3;

        if (askForSubSubImportance){
            int result = JOptionPane.showConfirmDialog(frame,"Will the subtype of alc matter?(ie. no in whiskey sour, yes in black russian)", "Importance of Subtype",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                isSubSubTypeImportant = true;
            }
            else if (result == JOptionPane.NO_OPTION){
                isSubSubTypeImportant = false;
            }
            else{
                //ADD HANDLING NULL
                return null;
            }
        }
        else{
            isSubSubTypeImportant = true;
        }
        if (alcType != null) {
            switch (alcType) {
                case VODKA -> {
                    posiibilieties3 = new Object[]{Vodka.typeOfVodka.PLAIN, Vodka.typeOfVodka.FLAVOURED, Vodka.typeOfVodka.FRUIT, Vodka.typeOfVodka.OTHER};
                    Vodka.typeOfVodka vType;
                    if (isSubSubTypeImportant) {
                        vType = (Vodka.typeOfVodka) JOptionPane.showInputDialog(
                                frame,
                                "Select the type of vodka",
                                "Type of vodka",
                                JOptionPane.PLAIN_MESSAGE, null,
                                posiibilieties3,
                                null);
                    }
                    else{
                        vType = Vodka.typeOfVodka.OTHER;
                    }
                    if (vType != null) {
                        name = inputName();
                        desc = inputDescr();
                        return new Vodka(name, desc, vType, isSubSubTypeImportant);
                    }
                }
                case WHISKEY -> {
                    posiibilieties3 = new Object[]{Whiskey.typeOfWhiskey.SCOTCH, Whiskey.typeOfWhiskey.IRISH, Whiskey.typeOfWhiskey.AMERICAN, Whiskey.typeOfWhiskey.BOURBON, Whiskey.typeOfWhiskey.OTHER};
                    Whiskey.typeOfWhiskey wType;
                    if(isSubSubTypeImportant) {
                        wType = (Whiskey.typeOfWhiskey) JOptionPane.showInputDialog(frame,
                                "Select the type of whiskey", "Type of whiskey",
                                JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    }
                    else{
                        wType = Whiskey.typeOfWhiskey.OTHER;
                    }
                    if (wType != null) {
                        name = inputName();
                        desc = inputDescr();
                        return new Whiskey(name, desc, wType, isSubSubTypeImportant);
                    }
                }
                case BRANDY -> {
                    posiibilieties3 = new Object[]{Brandy.typeOfBrandy.COGNAC, Brandy.typeOfBrandy.OTHER};
                    Brandy.typeOfBrandy bType;
                    if (isSubSubTypeImportant){
                        bType = (Brandy.typeOfBrandy) JOptionPane.showInputDialog(frame,
                                "Select the type of brandy", "Type of brandy",
                                JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    }
                    else{
                        bType = Brandy.typeOfBrandy.OTHER;
                    }
                    if (bType != null) {
                        name = inputName();
                        desc = inputDescr();
                        return new Brandy(name, desc, bType, isSubSubTypeImportant);
                    }
                }
                case GIN -> {
                    posiibilieties3 = new Object[]{Gin.typeOfGin.LONDON_DRY, Gin.typeOfGin.OTHER};
                    Gin.typeOfGin gType;
                    if (isSubSubTypeImportant){
                        gType = (Gin.typeOfGin) JOptionPane.showInputDialog(frame,
                                "Select the type of gin", "Type of gin",
                                JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    }
                    else{
                        gType = Gin.typeOfGin.OTHER;
                    }
                    if (gType != null) {
                        name = inputName();
                        desc = inputDescr();
                        return new Gin(name, desc, gType, isSubSubTypeImportant);
                    }
                }
                case LIQUEUR -> {
                    posiibilieties3 = new Object[]{Liqueur.typeOfLiqueur.TRIPLE_SEC,Liqueur.typeOfLiqueur.PEACH, Liqueur.typeOfLiqueur.IRISH_CREAM, Liqueur.typeOfLiqueur.ELDERFLOWER, Liqueur.typeOfLiqueur.COFFEE, Liqueur.typeOfLiqueur.BLUE_CURACAO,Liqueur.typeOfLiqueur.COCONUT,Liqueur.typeOfLiqueur.OTHER};
                    Liqueur.typeOfLiqueur lType;
                    if(isSubSubTypeImportant) {
                        lType = (Liqueur.typeOfLiqueur) JOptionPane.showInputDialog(frame,
                                "Select the type of liqueur", "Type of liqueur",
                                JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    }
                    else {
                        lType = Liqueur.typeOfLiqueur.OTHER;
                    }
                    name = inputName();
                    desc = inputDescr();
                    return new Liqueur(name, desc, lType, isSubSubTypeImportant);
                }
                case RUM -> {
                    posiibilieties3 = new Object[]{Rum.typeOfRum.WHITE, Rum.typeOfRum.DARK, Rum.typeOfRum.GOLD, Rum.typeOfRum.PACIFIC, Rum.typeOfRum.AGRICOLE, Rum.typeOfRum.OVERPROOF, Rum.typeOfRum.AGED, Rum.typeOfRum.OTHER};
                    Rum.typeOfRum rType;
                    if (isSubSubTypeImportant) {
                        rType = (Rum.typeOfRum) JOptionPane.showInputDialog(frame,
                                "Select the type of rum", "Type of rum",
                                JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    }
                    else{
                        rType = Rum.typeOfRum.OTHER;
                    }
                    if (rType != null) {
                        name = inputName();
                        desc = inputDescr();
                        return new Rum(name, desc, rType, isSubSubTypeImportant);
                    }
                }
                case TEQUILLA -> {
                    //BIANCO, REPOSADO, ANEJO, EXTRA_ANEJO, CRISTALINO
                    posiibilieties3 = new Object[]{Tequilla.typeOfTequilla.BIANCO, Tequilla.typeOfTequilla.REPOSADO, Tequilla.typeOfTequilla.ANEJO, Tequilla.typeOfTequilla.EXTRA_ANEJO, Tequilla.typeOfTequilla.CRISTALINO};
                    Tequilla.typeOfTequilla tType;
                    if (isSubSubTypeImportant) {
                        tType = (Tequilla.typeOfTequilla) JOptionPane.showInputDialog(frame,
                                "Select the type of tequilla", "Type of tequilla",
                                JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    }
                    else {
                        tType = Tequilla.typeOfTequilla.BIANCO;
                    }
                    if (tType != null) {
                        name = inputName();
                        desc = inputDescr();
                        return new Tequilla(name, desc, tType, isSubSubTypeImportant);
                    }
                }
                case VERMOUTH -> {
                    //EXTRA_DRY, SWEET_WHITE, RED, AMBER, ROSE
                    posiibilieties3 = new Object[]{Vermouth.typeOfVermouth.EXTRA_DRY, Vermouth.typeOfVermouth.SWEET_WHITE, Vermouth.typeOfVermouth.RED, Vermouth.typeOfVermouth.AMBER, Vermouth.typeOfVermouth.ROSE};
                    Vermouth.typeOfVermouth vermType;
                    if (isSubSubTypeImportant) {
                        vermType = (Vermouth.typeOfVermouth) JOptionPane.showInputDialog(frame,
                                "Select the type of vermouth", "Type of vermouth",
                                JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    }
                    else{
                        vermType = Vermouth.typeOfVermouth.RED;
                    }
                    if (vermType != null) {
                        name = inputName();
                        desc = inputDescr();
                        return new Vermouth(name, desc, vermType, isSubSubTypeImportant);
                    }
                }
                case OTHER -> {
                    name = inputName();
                    desc = inputDescr();
                    return new Aother(name, desc);
                }
            }
            //If you are here - alc is not other nor liqueur
        }
        return null;
    }
    //Handles soft adding
    private Ingredient addSoftHandler() {
        String name;
        String desc;
        Object subType;
        Ingredient domType;
        Object[] posiibilieties3;
        Object[] possibilities2 = {SOFT.typeOfSoft.SYRUP, SOFT.typeOfSoft.JUICE, SOFT.typeOfSoft.SDRINK, SOFT.typeOfSoft.OTHER};
        SOFT.typeOfSoft softType = (SOFT.typeOfSoft) JOptionPane.showInputDialog(
                frame,
                "Select the type of soft",
                "Type of soft",
                JOptionPane.PLAIN_MESSAGE, null,
                possibilities2,
                null);
        if (softType != null) {
            switch (softType) {
                case SYRUP -> {
                    posiibilieties3 = new Object[]{Syrup.typeOfSyrup.SIMPLE, Syrup.typeOfSyrup.VANILLA, Syrup.typeOfSyrup.RASPBERRY, Syrup.typeOfSyrup.LEMON_GRASS, Syrup.typeOfSyrup.GRENADINE,
                            Syrup.typeOfSyrup.CINNAMOON, Syrup.typeOfSyrup.ELDERFLOWER, Syrup.typeOfSyrup.FALERNUM, Syrup.typeOfSyrup.OTHER};
                    subType = (Syrup.typeOfSyrup) JOptionPane.showInputDialog(frame,
                            "Select the type of syrup", "Type of syrup",
                            JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    if (subType == null) {
                        return null;
                    }
                    name = inputName();
                    desc = inputDescr();
                    domType = new Syrup(name, desc, (Syrup.typeOfSyrup) subType);
                }

                case JUICE -> {
                    posiibilieties3 = new Object[]{Juice.typeOfJuice.PINEAPPLE, Juice.typeOfJuice.ORANGE, Juice.typeOfJuice.LIME, Juice.typeOfJuice.LEMON, Juice.typeOfJuice.CRANBERRY, Juice.typeOfJuice.OTHER};
                    subType = JOptionPane.showInputDialog(frame,
                            "Select the type of juice", "Type of juice",
                            JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    if (subType == null) {
                        return null;
                    }
                    name = inputName();
                    desc = inputDescr();
                    domType = new Juice(name, desc, (Juice.typeOfJuice) subType);
                }

                case SDRINK -> {
                    posiibilieties3 = new Object[]{Sdrink.typeOfSdrink.SPARKLING_WATER, Sdrink.typeOfSdrink.COLA, Sdrink.typeOfSdrink.SPRITE, Sdrink.typeOfSdrink.FANTA, Sdrink.typeOfSdrink.OTHER};
                    subType = JOptionPane.showInputDialog(frame,
                            "Select the type of juice", "Type of juice",
                            JOptionPane.PLAIN_MESSAGE, null, posiibilieties3, null);
                    if (subType == null) {
                        return null;
                    }
                    name = inputName();
                    desc = inputDescr();
                    domType = new Sdrink(name, desc, (Sdrink.typeOfSdrink) subType);
                }
                case OTHER -> {
                    name = inputName();
                    desc = inputDescr();
                    return new Sother(name, desc);
                }
                default -> {
                    return null;
                }
            }
            return domType;
        }
        return null;
    }
    //Displays ingredients in 'basket'
    private void showIngred() {
        StringBuilder test = new StringBuilder();
        ArrayList<Integer> quantityArr = menago.getQuantityInBasket();
        Vector<Ingredient> whatIngr = menago.getvIngr();
        test.append("<html>");
        for (int i = 0; i < whatIngr.size(); i++) {
            test.append("Name: ").append(whatIngr.elementAt(i).getName()).
                    append(" Type: ").append(whatIngr.elementAt(i).getStringOfSubType()).
                    append(" Subtype: ").append(whatIngr.elementAt(i).getStringOfSubSubType()).
                    append(" Quantity: ").append(Integer.toString(quantityArr.get(i))).
                    append(" Description: ").append(whatIngr.elementAt(i).getDescription()).
                    append("<br/>").append("<br/>");//
        }
        test.append("</html>");
        label.setText(test.toString());
        frame.repaint();
    }
    //Gives user the choice which recipe to display
    private void showRecipesfunc(){
        Vector<Recipe> tmp = menago.getvRecipes();
        //SHOW CHOICE WHICH RECIPE TO SHOW IN SHOWRECIPE FUNC
        if(tmp.isEmpty()){
            //DISPLAY INFO ABOUT NO AVAILABLE RECIPES
            return;
        }
        String [] choices = new String[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            choices[i] = tmp.elementAt(i).getName();
        }
        String choice = (String)JOptionPane.showInputDialog(
                frame,
                "Select recipe you would like to see",
                "Recipes",
                JOptionPane.PLAIN_MESSAGE, null,
                choices,
                null);
        if (choice == null){
            //ERROR HANDLING TBC
            return;
        }
        ///GETTING BACK INDEX
        int index = -1;
        for (int i = 0; i < tmp.size();i++){
            if(Objects.equals(choices[i], choice)){
                index = i;
                break;
            }
        }
        if (index < 0){
            //HANDLE
            return;
        }
        label.setText(showRecipefunc(tmp.elementAt(index)));
        frame.repaint();
    }
    //Transforms recipe to String given recipe
    private String showRecipefunc(Recipe rec){
        //SHOW RECIPE CHOSEN IN SHOWRECIPES FUNCTION IN THE SAME WAY AS SHOWINGRED FUNCTION WORKS
        StringBuilder test = new StringBuilder();
        test.append("<html>").append("Name: ").
                append(rec.getName()).append("<br/>").append("Method: ").
                append(rec.getMethod()).append("<br/>").append("Glass: ").
                append(rec.getGlass()).append("<br/>").append("Ice: ").
                append(rec.getIceType()).append("<br/>").append("Description: ").
                append(rec.getDescription()).append("<br/>").append("<br/>");

        for (int i = 0; i < rec.getrIngr().size(); i++) {
            test.append("Name: ").append(rec.getrIngr().elementAt(i).getName()).append(" Type: ").append(rec.getrIngr().elementAt(i).getStringOfSubType()).append(" Subtype: ").append(rec.getrIngr().elementAt(i).getStringOfSubSubType()).append(" Quantity: ").append(Integer.toString(rec.getQuantity().get(i))).append(" Description: ").append(rec.getrIngr().elementAt(i).getDescription()).append("<br/>").append("<br/>");//
        }
        test.append("</html>");
        return test.toString();
    }
    //Handles creating Ingredient
    private Ingredient createIngr(boolean askForSubSubImportance) {
        Object[] possibilities = {"Alcohol", "Soft", "Other"};
        String s = (String) JOptionPane.showInputDialog(
                frame,
                "Select the type of ingredient",
                "Type of Ingredient",
                JOptionPane.PLAIN_MESSAGE, null,
                possibilities,
                "Alcohol");

        //If a string was returned
        if ((s != null) && (s.length() > 0)) {
            switch (s) {
                case "Alcohol" -> {
                    return addAlcHandler(askForSubSubImportance);
                }
                case "Soft" -> {
                    return addSoftHandler();
                }
                case "Other" -> {
                    String name = inputName();
                    String desc = inputDescr();
                    return new Others(name, desc);
                }
            }
        }
        return null;
    }

    //Handles creating Recipe
    private Recipe createRecipe(){
        String name = inputName();
        Vector<Ingredient> rIngr = new Vector<Ingredient>();
        ArrayList<Integer> quantity = new ArrayList<Integer>();
        ArrayList<Boolean> canBeSubstituted = new ArrayList<Boolean>();
        Ingredient tmp = createIngr(true);
        if (tmp == null){
            //IMPLEMENT ERROR HANDLING
            return null;
        }
        rIngr.add(tmp);
        int qtity = inputQuant();
        quantity.add(qtity);

        int substituted;
        if (isSubstituable(canBeSubstituted, tmp)) return null;


        boolean flag = true;
        while (flag){
            int result = JOptionPane.showConfirmDialog(frame,"Was it the last ingredient?", "Last?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                flag = false;
            }
            else if (result == JOptionPane.NO_OPTION){
                tmp = createIngr(true);
                if (tmp == null){
                    //IMPLEMENT ERROR HANDLING
                    return null;
                }
                rIngr.add(tmp);
                qtity = inputQuant();
                quantity.add(qtity);
                if (isSubstituable(canBeSubstituted, tmp)) return null;
            }
            else {
                return null;
            }
        }

        return new Recipe(rIngr, quantity, inputX("Method", "What is the method? (i.e. shaking, stirring)"),
                inputX("Glass", "What is the glass you should serve your cocktail in?"),
                inputDescr(),inputX("Ice","Type of ice:"),name, canBeSubstituted);
    }
    //Checks if ingredient can be substituted in creating recipe
    private boolean isSubstituable(ArrayList<Boolean> canBeSubstituted, Ingredient tmp) {
        int substituted;
        //IS SECOND CONDITION IN FIRST IF IMPORTANT???
        if (!tmp.getIsSubSubTypeImportant() && !Objects.equals(tmp.getStringOfSubType(), "Other")){
            canBeSubstituted.add(true);
        }
        else if (Objects.equals(tmp.getStringOfSubType(), "Other") || Objects.equals(tmp.getStringOfSubSubType(), "Other")){
            canBeSubstituted.add(false);
        }
        else{
            substituted = JOptionPane.showConfirmDialog(frame,"Can this ingredient be substituted by another of its kind?",
                    "Can be substituted?",JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (substituted == JOptionPane.YES_OPTION){
                canBeSubstituted.add(true);
            }
            else if (substituted == JOptionPane.NO_OPTION){
                canBeSubstituted.add(false);
            }
            else{
                return true;
            }
        }
        return false;
    }

    private int[] classifyRecipes(){
        //Managed to rewrite this part from O(n^4) to O(n^2) at the expense of space complexity
        Vector<Recipe> vRecipes = menago.getvRecipes();
        Manager.HashNode[] aIngr = menago.getaIngr();
        int[] classsifiedRecipes = new int[vRecipes.size()];
        if(missingIngr != null) {
            missingIngr.clear();
        }
        //this loop flags all recipes how many ingredients each one is missing
        int iterator = 0;
        for (Recipe rec : vRecipes){
            Vector<Ingredient> rIngr = rec.getrIngr();
            ArrayList<Integer> quantity = rec.getQuantity();
            ArrayList<Boolean> canBeSubstituted = rec.getCanBeSubstituted();

            //Counts how many ingredients is missing in single recipe
            int missedIngred = 0;
            for(int i = 0; i< canBeSubstituted.size(); i++){
                Ingredient needed = rIngr.elementAt(i);
                //if ingredient can be substituted check only for quantity, else check for name

                //subSubType is important
                if(needed.getIsSubSubTypeImportant()) {
                    if (canBeSubstituted.get(i)) {
                        if (!menago.checkForQuantity(menago.getHashIndex(needed), quantity.get(i))) {
                            missedIngred++;
                            missingIngr.add(needed);
                        }
                    } else {
                        if (!menago.checkForNameAndQuantity(menago.getHashIndex(needed), needed.getName(), quantity.get(i))) {
                            missingIngr.add(needed);
                            missedIngred++;
                        }
                    }
                }
                //subSubType is not important
                else{
                    int checkCounter = needed.getIntOfSubSubType();
                    int hash = menago.getHashIndex(needed) - checkCounter;
                    boolean isThereIngr = false;
                    for (int h = 0; h< 10; h++){
                        if (canBeSubstituted.get(i)) {
                            if (menago.checkForQuantity(hash, quantity.get(i))) {
                                isThereIngr = true;
                                break;
                            }
                        } else {
                            if (menago.checkForNameAndQuantity(hash, needed.getName(), quantity.get(i))) {
                                isThereIngr = true;
                                break;
                            }
                        }
                        hash++;
                    }
                    if (!isThereIngr){
                        missingIngr.add(needed);
                        missedIngred++;
                    }
                }
            }
            classsifiedRecipes[iterator] = missedIngred;
            iterator++;
        }
        //At this point classifiedRecipes table holds information for how many ingredients our recipe is missing
        return classsifiedRecipes;
    }

    private void showAllRecipes(){
        int[] howManyIsMissed = classifyRecipes();
        Vector<Recipe> tmp = menago.getvRecipes();
        StringBuilder test = new StringBuilder();
        int iterator = 0;
        int howManyToSkip=0;
        test.append("<html>");
        for (Recipe rec : tmp) {
            test.append("Name: ").
                    append(rec.getName()).append("<br/>").append("Method: ").
                    append(rec.getMethod()).append("<br/>").append("Glass: ").
                    append(rec.getGlass()).append("<br/>").append("Ice: ").
                    append(rec.getIceType()).append("<br/>").append("Description: ").
                    append(rec.getDescription()).append("<br/>").append("<br/>");


            for (int i = 0; i < rec.getrIngr().size(); i++) {
                test.append("Name: ").append(rec.getrIngr().elementAt(i).getName()).
                        append("   Type: ").append(rec.getrIngr().elementAt(i).getStringOfSubType()).
                        append("   Subtype: ").append(rec.getrIngr().elementAt(i).getStringOfSubSubType()).
                        append("   Quantity: ").append(Integer.toString(rec.getQuantity().get(i))).append("   Description: ").
                        append(rec.getrIngr().elementAt(i).getDescription()).append("<br/>").append("<br/>");//
            }
            if(howManyIsMissed[iterator] == 0){
                test.append("YOU HAVE ALL ITEMS NEEDED TO DO THIS RECIPE<br/><br/>");
            }
            else {
                test.append("<br/><br/>").append("Missing Ingredients:<br/>");
                for (int i = 0; i < howManyIsMissed[iterator]; i++) {
                    test.append("Name: ").append(missingIngr.get(howManyToSkip + i).getName()).
                            append("   Type: ").append(missingIngr.get(howManyToSkip + i).getStringOfSubType()).
                            append("   Subtype: ").append(missingIngr.get(howManyToSkip + i).getStringOfSubSubType()).
                            append("   Description: ").append(missingIngr.get(howManyToSkip + i).getDescription()).
                            append("<br/>").append("<br/>");
                }
            }
            howManyToSkip += howManyIsMissed[iterator];
            iterator++;
        }
        test.append("</html>");
        label.setText(test.toString());
        frame.repaint();
    }
}

