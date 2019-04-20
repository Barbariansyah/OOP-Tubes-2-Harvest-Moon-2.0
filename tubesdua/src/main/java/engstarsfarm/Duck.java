package entity;
import model.*;
import product.DuckEgg;
import product.DuckMeat;

//! Kelas Duck
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas duck
  Berisi sebuah konstruktor, implementasi fungsi render(), dan implementasi fungsi sounds()
*/
public class Duck extends FarmAnimal
    {
        // Atribut

        // Method

        //! Konstruktor dari kelas duck
        /*!
        */
        public Duck(int _pos_x , int _pos_y)
            {
                pos_x = _pos_x;
                pos_y = _pos_y;
                availableProduct = false;
                hunger_countdown = 5;
                allowed_tiles = "Coop";
            }

        //! Implementasi dari fungsi render()
        /*!
        Digunakan untuk menampilkan duck pada Map
        @return karakter serta kode warna yang sesuai dengan Duck.
        */
        public String render()
            {
                if(getHungerCountdown() <= 0 && getHungerCountdown() > -5){
                    return "d";
                }
                else if (getHungerCountdown() > 0){
                    return "D";
                }
                else {
                    return null;
                }
            }

        //! Implementasi dari fungsi sounds()
        /*!
        Digunakan untuk mengeluarkan suara duck
        TBD!
        */
        public void sounds()
            {
                System.out.println("Wkwkwkwkwk :D");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Duck, berupa DuckEgg
        */
        public void getProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Player.getInstance().getInventory().add(new DuckEgg());
                    }
                else
                    {
                        throw new IllegalAccessException("Egg not available");
                    }
            }

        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan produk hasil kill dari kelas Duck, berupa DuckMeat
        */
        public void getKilledProduct()
            {
                try{
                    Player.getInstance().getInventory().add(new DuckMeat());
                } catch (IllegalAccessException e) {
                    //Do nothing
                }
            }

    }