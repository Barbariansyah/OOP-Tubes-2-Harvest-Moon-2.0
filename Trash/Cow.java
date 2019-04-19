//! Kelas Cow
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas cow
  Berisi sebuah konstruktor, implementasi fungsi Render(), dan implementasi fungsi Sounds()
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

        //! Implementasi dari fungsi Render()
        /*!
        Digunakan untuk menampilkan cow pada Map
        @return karakter serta kode warna yang sesuai dengan Cow.
        */
        public String Render()
            {
                if(GetHungerCountdown() <= 0 && GetHungerCountdown() > -5){
                    return "ċ";
                }
                else if (GetHungerCountdown() > 0){
                    return "S";
                }
                else{
                    return null;
                }
            }

        //! Implementasi dari fungsi Sounds()
        /*!
        Digunakan untuk mengeluarkan suara cow
        TBD!
        */
        public void Sounds()
            {
                System.out.println("Moooooo :o");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Cow, berupa CowMilk
        */
        public void GetProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Game.getPlayer().getInventory().add(new CowMilk());
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
        public void GetKilledProduct()
            {
                Game.getPlayer().getInventory().add(new CowMeat());
            }
    }