package entity;
import model.*;
import product.CowMilk;
import product.CowMeat;

//! Kelas Cow
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas cow
  Berisi sebuah konstruktor, implementasi fungsi render(), dan implementasi fungsi sounds()
*/
public class Cow extends FarmAnimal
    {
        // Atribut

        // Method

        //! Konstruktor dari kelas cow
        /*!
        */
        public Cow(int _pos_x , int _pos_y)
            {
                pos_x = _pos_x;
                pos_y = _pos_y;
                availableProduct = false;
                hunger_countdown = 5;
                allowed_tiles = "Grassland";
            }

        //! Implementasi dari fungsi render()
        /*!
        Digunakan untuk menampilkan cow pada Map
        @return karakter serta kode warna yang sesuai dengan Cow.
        */
        public String render()
            {
                if(getHungerCountdown() <= 0 && getHungerCountdown() > -5){
                    return "ċ";
                }
                else if (getHungerCountdown() > 0){
                    return "S";
                }
                else{
                    return null;
                }
            }

        //! Implementasi dari fungsi sounds()
        /*!
        Digunakan untuk mengeluarkan suara cow
        TBD!
        */
        public void sounds()
            {
                System.out.println("Moooooo :o");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Cow, berupa CowMilk
        */
        public void getProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Player.getInstance().getInventory().add(new CowMilk());
                    }
                else
                    {
                        throw new IllegalAccessException("Milk not available");
                    }
            }

        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan produk hasil kill dari kelas Cow, berupa CowMeat
        */
        public void getKilledProduct() 
            {
                try{
                    Player.getInstance().getInventory().add(new CowMeat());
                } catch (IllegalAccessException e) {
                    //Do nothing
                }
            }
    }