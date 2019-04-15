/**
 * Kelas ChickenButtermilk, kelas riil turunan side product.
 * Terbuat dari chicken meat dan cow milk
 */
public class ChickenButterMilk extends SideProduct{
    private static LinkedList<Product> recipe = new LinkedList<Product>();
    /**
     * initRecipe.
     * Melakukan inisiasi resep
     */
    public static void initRecipe(){
        CowMilk a = new CowMilk();
        ChickenMeat b = new ChickenMeat();
        recipe.add(a);
        recipe.add(b);
    }
    /**
     * Konstruktor ChickenButtermilk.
     * Harus Melakukan pemanggilan validasi resep sebelum pembuatan objek
     */
    public ChickenButterMilk(){
        super(90000,"Chicken Butter Milk");
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