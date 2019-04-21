package entity;
import model.*;
import product.DinoEgg;

//! Kelas Dino
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas dino
  Berisi sebuah konstruktor, implementasi fungsi render(), dan implementasi fungsi sounds()
*/
public class Dino extends FarmAnimal
    {
        // Atribut
        
        // Method

        //! Konstruktor dari kelas Dino
        /*!
        TBD!
        */
        public Dino(int _pos_x , int _pos_y)
            {
                pos_x = _pos_x;
                pos_y = _pos_y;
                availableProduct = false;
                hunger_countdown = 5;
                allowed_tiles = "Coop";
            }

        //! Implementasi dari fungsi render()
        /*!
        Digunakan untuk menampilkan Dino pada Map
        @return karakter serta kode warna yang sesuai dengan Dino.
        */
        public String render()
            {
                if(getHungerCountdown() <= 0 && getHungerCountdown() > -5){
                    return "u";
                }
                else if (getHungerCountdown() > 0){
                    return "U";
                }
                else{
                    return null;
                }                
            }

        //! Implementasi dari fungsi sounds()
        /*!
        Digunakan untuk mengeluarkan suara dino
        TBD!
        */
        public String sounds(){
        return ("Rawrrrr :<");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Dino, berupa DinoEgg
        */
        public void getProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Player.getInstance().getInventory().add(new DinoEgg());
                    }
                else
                    {
                        throw new IllegalAccessException("Egg not available");
                    }
            }

        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Dino, akan menghasilkan throws error karena dino tidak bisa dibunuh
        */
        public void getKilledProduct() 
            {
                throw new IllegalArgumentException("Can't be killed");
            }

    }