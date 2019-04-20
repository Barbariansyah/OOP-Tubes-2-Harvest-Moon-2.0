package entity;
import model.*;
import product.ChickenEgg;
import product.ChickenMeat;

//! Kelas Chicken
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas chicken
  Berisi sebuah konstruktor, implementasi fungsi render(), dan implementasi fungsi sounds()
*/
public class Chicken extends FarmAnimal
    {
        // Atribut

        // Method

        //! Konstruktor dari kelas Chicken
        /*!
        */
        public Chicken(int _pos_x , int _pos_y)
            {
                pos_x = _pos_x;
                pos_y = _pos_y;
                availableProduct = false;
                hunger_countdown = 5;
                allowed_tiles = "Coop";
            }

        //! Implementasi dari fungsi render()
        /*!
        Digunakan untuk menampilkan Chicken pada Map
        @return karakter serta kode warna yang sesuai dengan Chicken.
        */
        public String render()
            {
                if(getHungerCountdown() <= 0 && getHungerCountdown() > -6){
                    return "c";
                }
                else if (getHungerCountdown() > 0){
                    return "C";
                }                
                else{
                    return null;
                }
            }

        //! Implementasi dari fungsi sounds()
        /*!
        Digunakan untuk mengeluarkan suara chicken
        */
        public void sounds()
            {
                System.out.println("Kukuruyukkkk :v");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Chicken, berupa ChickenEgg
        */
        public void getProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Player.getInstance().getInventory().add(new ChickenEgg());
                    }
                else
                    {
                        throw new IllegalAccessException("Egg not available");
                    }
            }

        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan produk hasil kill dari kelas Chicken, berupa ChickenMeat
        */
        public void getKilledProduct() 
            {
                try{
                    Player.getInstance().getInventory().add(new ChickenMeat());
                } catch (IllegalAccessException e) {
                    //Do nothing
                }
            }
    }