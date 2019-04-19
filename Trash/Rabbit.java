//! Kelas Rabbit
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas Rabbit
  Berisi sebuah konstruktor, implementasi fungsi Render(), dan implementasi fungsi Sounds()
*/
public class Rabbit extends FarmAnimal
    {
        // Atribut

        // Method

        //! Konstruktor dari kelas rabbit
        /*!
        TBD!
        */
        public Rabbit(int _pos_x , int _pos_y)
            {
                pos_x = _pos_x;
                pos_y = _pos_y;
                hunger_countdown = 5;
                allowed_tiles = "Barn";
            }

        //! Implementasi dari fungsi Render()
        /*!
        Digunakan untuk menampilkan rabbit pada Map
        @return karakter serta kode warna yang sesuai dengan Player.
        */
        public String Render()
            {
                if(GetHungerCountdown() <= 0 && GetHungerCountdown() > -5){
                    return "r";
                }
                else if (GetHungerCountdown() > 0){
                    return "R";
                } else {
                    return null;
                }
            }

        //! Implementasi dari fungsi Sounds()
        /*!
        Digunakan untuk mengeluarkan suara rabbit
        */
        public void Sounds()
            {
                System.out.println("Chill :3");
            }
        
        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Rabbit, akan menghasilkan throws error karena rabbit tidak memiliki product
        */
        public void GetProduct() throws IllegalAccessException
            {
                throw new IllegalAccessException("Can't be interracted");
            }

        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan produk hasil kill dari kelas Rabbit, berupa RabbitMeat
        */
        public void GetKilledProduct()
            {
                Game.getPlayer().getInventory().add(new RabbitMeat());
            }
    }