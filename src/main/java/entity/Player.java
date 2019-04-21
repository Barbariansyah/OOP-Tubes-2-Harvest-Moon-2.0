package entity;
import model.*;
import product.*;
import cell.*;
import viewcontroller.Game;
import java.util.Scanner;

//! Kelas Player
/*!
   Merupakan Kelas untuk pengguna dalam permainan ini
   Memiliki semua atribut dan method yang dimiliki oleh pengguna, sesuai spesifikasi
   Berisi konstruktor default dan user defined, setter dan getter, serta method-method untuk berinteraksi pada game
*/

public class Player extends Entity implements LiveEntity
    {
        // Atribut
        private String name;
        private int water_container;
        private double money;
        LinkedList<Product> inventory;

        //! Static variable untuk type Player
        /*!
        Digunakan untuk membuat objek singleton dari kelas ini
        */
        private static Player player_instance = null;
        private static int inventory_size = 7;
        
        // Method

        //! Konstruktor default Player()
        /*!
        Digunakan untuk membuat objek dari kelas ini
        */
        private Player()
            {
                this.name = "Player";
                this.water_container = 0;
                this.money = 0;
                this.inventory = new LinkedList<Product>();
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
        private Player(String _name , int _water_container , double _money, int x, int y)
            {
                this.name = _name;
                this.water_container = _water_container;
                this.money = _money;
                this.inventory = new LinkedList<Product>();
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
        @return Player
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
        public void setName(String _name)
            {
                this.name = _name;
            }

        //! Fungsi setter watercontainer
        /*!
        @param _waterContainer isi container air
        */
        public void setWaterContainer(int _waterContainer)
            {
                this.water_container = _waterContainer;
            }

        //! Fungsi setter money
        /*!
        @param _money jumlah uang baru
        */
        public void setMoney(double _money)
            {
                this.money = _money;
            }

        //! Fungsi getter nama
        /*!
        @return nama player
        */
        public String getName()
            {
                return name;
            }

        //! Fungsi getter isi water container
        /*!
        @return isi water container
        */
        public int getWaterContainer()
            {
                return water_container;
            }

        //! Fungsi getter money
        /*!
        @return money
        */
        public double getMoney()
            {
                return money;
            }

        /**
         * Implementasi fungsi render dari kelas renderer.
         * @return karakter serta kode warna yang sesuai dengan Player.
         */
        public String render()
            {
                return "P";
            }
        
        /**
        * Digunakan untuk berpindah secara random
        * @param dir arah pergerakan, 0 : UP , 1 : DOWN , 2 : LEFT , 3 : RIGHT
        */
        public void move(int dir)
            {
                Game.setEntity(pos_x,pos_y,null);

                if (dir == 0 && Game.isValidPosition(pos_x-1,pos_y) && !Game.isValidEntity(pos_x-1,pos_y))
                    {
                        pos_x = pos_x - 1;
                    }
                else if (dir == 1 && Game.isValidPosition(pos_x+1, pos_y) && !Game.isValidEntity(pos_x+1, pos_y))
                    {
                        pos_x = pos_x + 1;
                    }
                else if (dir == 2 && Game.isValidPosition(pos_x, pos_y-1) && !Game.isValidEntity(pos_x, pos_y-1))
                    {
                        pos_y = pos_y - 1;
                    }
                else if (dir == 3 && Game.isValidPosition(pos_x, pos_y+1) && !Game.isValidEntity(pos_x, pos_y+1))
                    {
                        pos_y = pos_y + 1;
                    }
                
                Game.setEntity(pos_x,pos_y,player_instance);
            }

        //! Implementasi dari fungsi talk()
        /*!
        Digunakan untuk melakukan interaksi dengan animal
        */
        public String talk()
            {
                try {
                    FarmAnimal fa = Game.getAnimal(pos_x+1, pos_y);
                    return fa.sounds();
                } catch (Exception e) {

                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x, pos_y+1);
                    return fa.sounds();
                } catch (Exception e) {
                    
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x, pos_y-1);
                    return fa.sounds();
                } catch (Exception e) {
                    
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x-1, pos_y);
                    return fa.sounds();
                } catch (Exception e) {
                    
                }
                return "";
            }

        //! Implementasi dari fungsi interact()
        /*!
        Fungsi interact(), digunakan untuk mengambil product dari Milk Producing Farm Animal dan Egg Producing Farm Animal
        ATAU 
        untuk melakukan interaksi dengan Facility
        */
        public void interact()
            {
                boolean notfound = false;

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x+1, pos_y);
                    if (inventory.length() < inventory_size )
                        {
                            fa.getProduct();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                    return;
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x, pos_y+1);
                    if (inventory.length() < inventory_size )
                        {
                            fa.getProduct();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                    return;
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x, pos_y-1);
                    if (inventory.length() < inventory_size )
                        {
                            fa.getProduct();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                    return;
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x-1, pos_y);
                    if (inventory.length() < inventory_size )
                        {
                            fa.getProduct();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                    return;
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    Truck t = Truck.getInstance();
                    try {
                        if (Game.isAdjacent(pos_x, pos_y, t.getX(), t.getY()))  
                            {
                                t.setAwayCounter(5);
                                double selling = 0;
                                for (int i = 0 ; i < inventory.length() ; i++)
                                    {
                                        selling = selling + inventory.get(i).getPrice();
                                    }
                                
                                money = money + selling;
                                inventory.removeAll();
                                return;
                            }
                        else{
                            throw new IllegalAccessException("Truck is not nearby");
                        }
                    } catch (Exception e) {
                        
                    }
                    
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    Well w = Well.getInstance();
                    try {
                        if (Game.isAdjacent(pos_x, pos_y, w.getX(), w.getY()))  
                            {
                                water_container = 5;
                                return;
                            }     
                        else
                            {
                                throw new IllegalAccessException("Well is not nearby");
                            }                   
                    } catch (Exception e) {

                    }
                } catch (Exception e) {
                    notfound = true;
                }

                if (notfound)
                    {
                        System.out.println("Nothing to interract to :(");
                    }
            }

        //! Implementasi dari fungsi kill()
        /*!
        Digunakan untuk membunuh animal dan mendapatkan dagingnya
        */
        public void kill()
            {
                boolean notfound = false;

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x+1, pos_y);
                    if (inventory.length() < inventory_size)
                        {
                            fa.getKilledProduct();
                            fa.SetKilled();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x, pos_y+1);
                    if (inventory.length() < inventory_size)
                        {
                            fa.getKilledProduct();
                            fa.SetKilled();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x, pos_y-1);
                    if (inventory.length() < inventory_size)
                        {
                            fa.getKilledProduct();
                            fa.SetKilled();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                } catch (Exception e) {
                    notfound = true;
                }

                try {
                    FarmAnimal fa = Game.getAnimal(pos_x-1, pos_y);
                    if (inventory.length() < inventory_size)
                        {
                            fa.getKilledProduct();
                            fa.SetKilled();
                            return;
                        }
                    else
                        {
                            System.out.println("Inventory is Full");
                        }
                } catch (Exception e) {
                    notfound = true;
                }

                if (notfound)
                    {
                        System.out.println("There is nothing to kill");
                    }
                
            }
        
        //! Implementasi dari fungsi grow()
        /*!
        Digunakan untuk menumbuhkan rumput pada cell
        */
        public void grow()
            {
                if (water_container > 0 )
                    {
                        Land la = Game.getLand(pos_x,pos_y);
                        if (!la.isGrass())
                            {
                                la.growGrass();
                                water_container--;
                            }
                    }
                else
                    {
                        System.out.println("Water out of stock");
                    }
            }

        //! Implementasi dari fungsi mix()
        /*!
        Digunakan untuk membuat side product dari farm product
        */
        public void mix()
            {
                try {
                    int x_mixer = Mixer.getInstance().getX();
                    int y_mixer = Mixer.getInstance().getY();

                    if (Game.isAdjacent(pos_x, pos_y, x_mixer, y_mixer))
                        {
                            System.out.println("What do you want ? ");
                            System.out.println("1. Beef Rolade");
                            System.out.println("2. Pancake");
                            System.out.println("3. Chicken Buttermilk");
                            System.out.println("4. Goat Cheese");

                            int choice;
                            Scanner scan = new Scanner(System.in);

                            choice = scan.nextInt();
                            if (choice == 1)
                                {
                                    if ( BeefRolade.validateRecipe(inventory))
                                        {
                                            BeefRolade br = new BeefRolade();
                                            inventory.add(br);

                                            LinkedList<Product> l_p = BeefRolade.getRecipe();

                                            for (int i = 0 ; i < l_p.length() ; i++)
                                                {
                                                    inventory.remove(l_p.get(i));
                                                }
                                        }
                                }
                            else if ( choice == 2)
                                {
                                    if ( Pancake.validateRecipe(inventory))
                                        {
                                            Pancake p = new Pancake();
                                            inventory.add(p);

                                            LinkedList<Product> l_p = Pancake.getRecipe();

                                            for (int i = 0 ; i < l_p.length() ; i++)
                                                {
                                                    inventory.remove(l_p.get(i));
                                                }
                                        }

                                }
                            else if ( choice == 3)
                                {
                                    if ( ChickenButterMilk.validateRecipe(inventory))
                                        {
                                            ChickenButterMilk cbm = new ChickenButterMilk();
                                            inventory.add(cbm);

                                            LinkedList<Product> l_p = ChickenButterMilk.getRecipe();

                                            for (int i = 0 ; i < l_p.length() ; i++)
                                                {
                                                    inventory.remove(l_p.get(i));
                                                }
                                        }
                                }
                            else
                                {
                                    if ( GoatCheese.validateRecipe(inventory))
                                        {
                                            GoatCheese gc = new GoatCheese();
                                            inventory.add(gc);

                                            LinkedList<Product> l_p = GoatCheese.getRecipe();

                                            for (int i = 0 ; i < l_p.length() ; i++)
                                                {
                                                    inventory.remove(l_p.get(i));
                                                }
                                        }
                                }
                        }
                } catch (Exception e) {

                }
                
            }

        //! Implementasi dari fungsi printInventory()
        /*!
        Digunakan untuk mengeluarkan daftar isi dari inventory yang dimiliki player
        */
        public void printInventory()
            {
                for (int i = 0 ; i < inventory.length() ;i++)
                    {
                        System.out.println(inventory.get(i).getName());
                    }
            }
        
        //! Implementasi dari fungsi printStatus()
        /*!
        Digunakan untuk mengeluarkan status dari player
        Berisi inventory, jumlah uang, dan jumlah water_container yang dimiliki
        */
        public void printStatus()
            {
                System.out.println("Water Container : " + water_container);
                System.out.println("Money : " + money);
                printInventory();
            }

        //! Implementasi dari fungsi getter GetInventory()
        /*!
        Digunakan untuk mendapatkan inventory dari pengguna
        @return inventory
        */
        public LinkedList<Product> getInventory()
            {
                return inventory;
            }
    }