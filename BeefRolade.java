package product;
import model.LinkedList;
import model.Product;

/**
 * Kelas BeefRolade, kelas riil turunan side product.
 * Terbuat dari cow meat dan chicken egg.
 */
public class BeefRolade extends SideProduct{
    private static LinkedList<Product> recipe = new LinkedList<Product>();
    /**
     * initRecipe.
     * Melakukan inisiasi resep
     */
    public static void initRecipe(){
        CowMeat a = new CowMeat();
        ChickenEgg b = new ChickenEgg();
        recipe.add(a);
        recipe.add(b);
    }
    /**
     * Konstruktor BeefRolade.
     * Harus Melakukan pemanggilan validasi resep sebelum pembuatan objek
     */
    public BeefRolade(){
        super(80000,"Beef Rolade");
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