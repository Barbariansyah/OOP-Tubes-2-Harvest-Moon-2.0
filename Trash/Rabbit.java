//! Kelas Rabbit
/*!
  Sebuah kelas riil dari FarmAnimal, yaitu kelas Rabbit
  Berisi sebuah konstruktor, implementasi fungsi render(), dan implementasi fungsi sounds()
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

        //! Implementasi dari fungsi render()
        /*!
        Digunakan untuk menampilkan rabbit pada Map
        @return karakter serta kode warna yang sesuai dengan Player.
        */
        public String render()
            {
                if(getHungerCountdown() <= 0 && getHungerCountdown() > -5){
                    return "r";
                }
                else if (getHungerCountdown() > 0){
                    return "R";
                } else {
                    return null;
                }
            }

        //! Implementasi dari fungsi sounds()
        /*!
        Digunakan untuk mengeluarkan suara rabbit
        */
        public void sounds()
            {
                System.out.println("Chill :3");
            }
        
        //! Implementasi dari fungsi getProduct()
        /*!
        Getter untuk mendapatkan product dari kelas Rabbit, akan menghasilkan throws error karena rabbit tidak memiliki product
        */
        public void getProduct() throws IllegalAccessException
            {
                throw new IllegalAccessException("Can't be interracted");
            }

        //! Implementasi dari fungsi getKilledProduct()
        /*!
        Getter untuk mendapatkan produk hasil kill dari kelas Rabbit, berupa RabbitMeat
        */
        public void getKilledProduct() 
            {
                try{
                    Player.getInstance().getInventory().add(new RabbitMeat());
                } catch (IllegalAccessException e) {
                    //Do nothing
                }
            }
    }