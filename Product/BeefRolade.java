

public class BeefRolade extends SideProduct{
    private static LinkedList<Product> recipe = new LinkedList<Product>();

    public static void initRecipe(){
        CowMeat a = new CowMeat();
        ChickenEgg b = new ChickenEgg();
        recipe.add(a);
        recipe.add(b);
    }

    public BeefRolade(){
        super(80000,"Beef Rolade");
    }

    public static LinkedList<Product> getRecipe(){
        return recipe;
    }

    public static boolean  validateRecipe(LinkedList<Product> inventory){

        LinkedList<Product> temp = new LinkedList<Product>(inventory);
        LinkedList<Product> tempRecipe = new LinkedList<Product>(recipe);

        while(!tempRecipe.isEmpty()){
            int del = temp.find(tempRecipe.get(0));
            if(del == -1){
                return false;
            }
            else{
                temp.remove(temp.get(del));
                tempRecipe.remove(tempRecipe.get(0));
            }
        }
        return true;
    }
}