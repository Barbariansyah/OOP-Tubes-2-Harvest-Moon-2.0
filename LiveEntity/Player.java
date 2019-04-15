//! Kelas Player
/*!
   Merupakan Kelas untuk pengguna dalam permainan ini
   Memiliki semua atribut dan method yang dimiliki oleh pengguna, sesuai spesifikasi
   Berisi konstruktor default dan user defined, setter dan getter, serta method-method untuk berinteraksi pada game
*/

import java.util.*;

public class Player extends Entity implements LiveEntity, Renderable
    {
        // Atribut
        private String name;
        private int water_container;
        private double money;
        //LinkedList<Product> inventory;

        // Method

        //! Static variable untuk type Player
        /*!
        Digunakan untuk membuat objek singleton dari kelas ini
        */
        private static Player player_instance = null;

        //! Konstruktor default Player()
        /*!
        Digunakan untuk membuat objek dari kelas ini
        */
        private Player()
            {
                this.name = "Player";
                this.water_container = 0;
                this.money = 0;
                pos_x = 0;
                pos_y = 0;
            }

        //! Konstruktor user defined Player()
        /*!
        Digunakan untuk membuat objek dari kelas ini, sesuai dengan parameter dari pengguna
        @param _name nama player
        @param _water_container container air awal
        @param _money nilai awal uang
        */
        public Player(String _name , int _water_container , double _money, int x, int y)
            {
                this.name = _name;
                this.water_container = _water_container;
                this.money = _money;
                pos_x = x;
                pos_y = y;
            }
        
        //! Inisialisasi untuk membuat konstruktor Player
        /*!
        Digunakan untuk membuat objek dari kelas Player
        */ 
        public static void initialize(String _name , int _water_container , double _money, int x, int y)
            {
                if (player_instance == null)
                    {
                        player_instance = new Player(_name , _water_container , _money, x, y);
                    }
            }
        //! Method static untuk membuat kelas Player
        /*!
        Digunakan untuk membuat objek dari kelas Player
        */   
        public static Player getInstance() throws IllegalAccessException
            {
                if (player_instance != null)
                    {
                        return player_instance;
                    }
                else
                    {
                        throw new IllegalAccessException("Player not initialized");
                    }
            }

        //! Fungsi setter nama
        /*!
        @param _name nama baru
        */
        public void SetName(String _name)
            {
                this.name = _name;
            }

        //! Fungsi setter watercontainer
        /*!
        @param _waterContainer isi container air
        */
        public void SetWaterContainer(int _waterContainer)
            {
                this.water_container = _waterContainer;
            }

        //! Fungsi setter money
        /*!
        @param _money jumlah uang baru
        */
        public void SetMoney(double _money)
            {
                this.money = _money;
            }

        //! Fungsi getter nama
        /*!
        @return nama player
        */
        public String GetName()
            {
                return name;
            }

        //! Fungsi getter isi water container
        /*!
        @return isi water container
        */
        public int GetWaterContainer()
            {
                return water_container;
            }

        //! Fungsi getter money
        /*!
        @return money
        */
        public double GetMoney()
            {
                return money;
            }

        /**
         * Implementasi fungsi render dari kelas renderer.
         * @return karakter serta kode warna yang sesuai dengan Player.
         */
        public String Render()
            {
                return "P";
            }
        
        //! Implementasi dari fungsi Move()
        /*!
        Digunakan untuk melakukan perpindahan pada map 
        */
        public void Move()
            {
                String direction;
                Scanner scan = new Scanner(System.in);

                direction = scan.nextLine();

                if (direction == "UP")
                    {
                        pos_x = pos_x - 1;
                    }
                else if (direction == "DOWN")
                    {
                        pos_x = pos_x + 1;
                    }
                else if (direction == "LEFT")
                    {
                        pos_y = pos_y - 1;
                    }
                else if (direction == "RIGHT")
                    {
                        pos_y = pos_y + 1;
                    }
                
                scan.close();
            }

        //! Implementasi dari fungsi Talk()
        /*!
        Digunakan untuk melakukan interaksi dengan animal
        */
        public void Talk()
            {

            }

        //! Implementasi dari fungsi Interact()
        /*!
        Fungsi interact(), digunakan untuk mengambil product dari Milk Producing Farm Animal dan Egg Producing Farm Animal
        ATAU 
        untuk melakukan interaksi dengan Facility
        */
        public void Interact()
            {

            }

        //! Implementasi dari fungsi Kill()
        /*!
        Digunakan untuk membunuh animal dan mendapatkan dagingnya
        */
        public void Kill()
            {

            }
        
        //! Implementasi dari fungsi Grow()
        /*!
        Digunakan untuk menumbuhkan rumput pada cell
        */
        public void Grow()
            {

            }

        //! Implementasi dari fungsi Mix()
        /*!
        Digunakan untuk membuat side product dari farm product
        */
        public void Mix()
            {

            }

        //! Implementasi dari fungsi PrintInventory()
        /*!
        Digunakan untuk mengeluarkan daftar isi dari inventory yang dimiliki player
        */
        public void PrintInventory()
            {

            }
        
        //! Implementasi dari fungsi PrintStatus()
        /*!
        Digunakan untuk mengeluarkan status dari player
        Berisi inventory, jumlah uang, dan jumlah water_container yang dimiliki
        */
        public void PrintStatus()
            {
                System.out.println("Water Container : " + water_container);
                System.out.println("Money : " + money);
                PrintInventory();
            }

        //! Implementasi dari fungsi getter GetInventory()
        /*!
        Digunakan untuk mendapatkan inventory dari pengguna
        @return inventory
        */
        //LinkedList<Product*>& GetInventory();        
    }