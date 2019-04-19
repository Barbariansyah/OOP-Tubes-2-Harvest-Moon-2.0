package product;
import model.LinkedList;
import model.Product;

/**
 * Kelas GoatCheese, kelas riil turunan side product.
 * Terbuat dari dua goat milk
 */
public class GoatCheese extends SideProduct{
    private static LinkedList<Product> recipe = new LinkedList<Product>();
    /**
     * initRecipe.
     * Melakukan inisiasi resep
     */
    public static void initRecipe(){
        GoatMilk a = new GoatMilk();
        GoatMilk b = new GoatMilk();
        recipe.add(a);
        recipe.add(b);
    }
     /**
     * Konstruktor GoatCheese.
     * Harus Melakukan pemanggilan validasi resep sebelum pembuatan objek
     */
    public GoatCheese(){
        super(50000,"Goat Cheese");
    }
     /**
     * getRecipe.
     * Melakukan pengembalian recipe
     */
    public static LinkedList<Product> getRecipe(){
        return recipe;
    }
     /**
      * validateRecipe.
      * Melakukan validasi resep
      */
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