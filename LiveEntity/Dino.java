//! Kelas Dino
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas dino
  Berisi sebuah konstruktor, implementasi fungsi Render(), dan implementasi fungsi Sounds()
*/
public class Dino extends FarmAnimal implements Renderable
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

        //! Implementasi dari fungsi Render()
        /*!
        Digunakan untuk menampilkan Dino pada Map
        @return karakter serta kode warna yang sesuai dengan Dino.
        */
        public String Render()
            {
                if(GetHungerCountdown() <= 0 && GetHungerCountdown() > -5){
                    return "u";
                }
                else if (GetHungerCountdown() > 0){
                    return "U";
                }
                else{
                    return null;
                }                
            }

        //! Implementasi dari fungsi Sounds()
        /*!
        Digunakan untuk mengeluarkan suara dino
        TBD!
        */
        public void Sounds()
            {
                System.out.println("Rawrrrr :<");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Dino, berupa DinoEgg
        */
        public void GetProduct()
            {
                if (availableProduct)
                    {
                    
                    }
                else
                    {
                        throw new IllegalArgumentException("Egg not available");
                    }
            }

        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Dino, akan menghasilkan throws error karena dino tidak bisa dibunuh
        */
        public void GetKilledProduct()
            {
                throw new IllegalArgumentException("Can't be killed");
            }

    }