package entity;
import model.*;
import product.GoatMilk;
import product.GoatMeat;

//! Kelas Goat
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas goat
  Berisi sebuah konstruktor, implementasi fungsi render(), dan implementasi fungsi sounds()
*/
public class Goat extends FarmAnimal
    {
        // Atribut

        // Method

        //! Konstruktor dari kelas Goat
        /*!
        */
        public Goat(int _pos_x, int _pos_y)
            {
                pos_x = _pos_x;
                pos_y = _pos_y;
                availableProduct = false;
                hunger_countdown = 5;
                allowed_tiles = "Grassland";
            }

        //! Implementasi dari fungsi render()
        /*!
        Digunakan untuk menampilkan goat pada Map
        @return karakter serta kode warna yang sesuai dengan Goat.
        */
        public String render()
            {
                if(getHungerCountdown() <= 0 && getHungerCountdown() > -5){
                    return "g";
                }
                else if (getHungerCountdown() > 0){
                    return "G";
                }
                else{
                        return null;
                }     
            }           
            
        //! Implementasi dari fungsi sounds()
        /*!
        Digunakan untuk mengeluarkan suara goat
        */
        public void sounds()
            {
                System.out.println("Baaaaaaaa :9");
            }
 
        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan produk hasil kill dari kelas Goat, berupa GoatMeat
        */
        public void getKilledProduct()
            {
                try{
                    Player.getInstance().getInventory().add(new GoatMeat());
                } catch (IllegalAccessException e) {
                    //Do nothing
                }
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Goat, berupa GoatMilk
        */        
        public void getProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Player.getInstance().getInventory().add(new GoatMilk());
                    }
                else
                    {
                        throw new IllegalAccessException("Milk not available");
                    }
            }
    }