//! Kelas Chicken
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas chicken
  Berisi sebuah konstruktor, implementasi fungsi Render(), dan implementasi fungsi Sounds()
*/
public class Chicken extends FarmAnimal implements Renderable
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

        //! Implementasi dari fungsi Render()
        /*!
        Digunakan untuk menampilkan Chicken pada Map
        @return karakter serta kode warna yang sesuai dengan Chicken.
        */
        public String Render()
            {
                if(GetHungerCountdown() <= 0 && GetHungerCountdown() > -6){
                    return "c";
                }
                else if (GetHungerCountdown() > 0){
                    return "C";
                }                
                else{
                    return null;
                }
            }

        //! Implementasi dari fungsi Sounds()
        /*!
        Digunakan untuk mengeluarkan suara chicken
        */
        public void Sounds()
            {
                System.out.println("Kukuruyukkkk :v");
            }

        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Chicken, berupa ChickenEgg
        */
        public void GetProduct() throws IllegalAccessException
            {
                if (availableProduct)
                    {
                        Game.getPlayer().getInventory().add(new ChickenEgg());
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
        public void GetKilledProduct()
            {
                Game.getPlayer().getInventory().add(new ChickenMeat());
            }
    }