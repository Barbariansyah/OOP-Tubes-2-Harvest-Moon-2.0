//! Kelas Duck
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas duck
  Berisi sebuah konstruktor, implementasi fungsi Render(), dan implementasi fungsi Sounds()
*/
public class Duck extends FarmAnimal implements Renderable
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

        //! Implementasi dari fungsi Render()
        /*!
        Digunakan untuk menampilkan duck pada Map
        @return karakter serta kode warna yang sesuai dengan Duck.
        */
        public String Render()
            {
                if(GetHungerCountdown() <= 0 && GetHungerCountdown() > -5){
                    return "d";
                }
                else if (GetHungerCountdown() > 0){
                    return "D";
                }
                else {
                    return null;
                }
            }

        //! Implementasi dari fungsi Sounds()
        /*!
        Digunakan untuk mengeluarkan suara duck
        TBD!
        */
        public void Sounds()
            {
                System.out.println("Wkwkwkwkwk :D");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Duck, berupa DuckEgg
        */
        public void GetProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Game.getPlayer().getInventory().add(new DuckEgg());
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
        public void GetKilledProduct()
            {

            }

    }