//! Kelas Goat
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas goat
  Berisi sebuah konstruktor, implementasi fungsi Render(), dan implementasi fungsi Sounds()
*/
public class Goat extends FarmAnimal implements Renderable
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

        //! Implementasi dari fungsi Render()
        /*!
        Digunakan untuk menampilkan goat pada Map
        @return karakter serta kode warna yang sesuai dengan Goat.
        */
        public String Render()
            {
                if(GetHungerCountdown() <= 0 && GetHungerCountdown() > -5){
                    return "g";
                }
                else if (GetHungerCountdown() > 0){
                    return "G";
                }
                else{
                        return null;
                }     
            }           
            
        //! Implementasi dari fungsi Sounds()
        /*!
        Digunakan untuk mengeluarkan suara goat
        */
        public void Sounds()
            {
                System.out.println("Baaaaaaaa :9");
            }
 
        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan produk hasil kill dari kelas Goat, berupa GoatMeat
        */
        public void GetKilledProduct()
            {

            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Goat, berupa GoatMilk
        */        
        public void GetProduct()
            {
                if (availableProduct)
                    {

                    }
                else
                    {
                        throw new IllegalArgumentException("Milk not available");
                    }
            }
    }