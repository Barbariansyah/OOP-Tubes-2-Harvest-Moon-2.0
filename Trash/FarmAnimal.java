//! Kelas Farm Animal
/*!
    Sebuah Kelas sebagai representasi binatang yang ada pada permainan
    Akan diinherit dengan semua animal yang ada di permainan
    Berisi fungsi Eat(), pure virtual Sounds(), GetHungerCountdown(), dan IsProductAvailable()
*/
import java.util.*;

public abstract class FarmAnimal extends Entity implements LiveEntity
    {
        // Atribut
        protected int hunger_countdown;
        protected String allowed_tiles;
        protected boolean availableProduct;

        // Method

        //! Fungsi eat()
        /*!
        Digunakan untuk memakan grass yang ada pada cell
        */
        public void Eat()
            {
                if (hunger_countdown <= 0 )
                    {
                        hunger_countdown = 5;
                        availableProduct = true;
                    }
            }
        
        //! Abstract Method Sounds()
        /*!
        Digunakan untuk menampilkan suara pada hewan
        Abstract karena akan diimplementasikan di kelas riil
        */
        public abstract void Sounds();

        //! Fungsi Getter GetHungerCountdown()
        /*!
        Getter untuk mendapatkan countdown lapar animal
        @return jumlah tick kelaparan, positif berarti kenyang, nol lapar, -5 mati
        */
        public int GetHungerCountdown()
            {
                return hunger_countdown;
            }        
        
        //! Fungsi untuk mengurangi hunger countdown
        /*!
        Fungsi untuk mengurangi hunger countdown
        */
        public void ReduceHungerCountdown()
            {
                hunger_countdown = hunger_countdown - 1;
            }        
        
        /**
        * Digunakan untuk berpindah secara random
        * @param dir arah pergerakan, 0 : UP , 1 : DOWN , 2 : LEFT , 3 : RIGHT
        */
        public void Move(int dir)
            {
                Game.setEntity(pos_x,pos_y,null);

                if ( dir == 0 )
                    {
                        if(Game.isValidPosition(pos_x-1, pos_y) && Game.getLand(pos_x-1, pos_y).getType() == allowed_tiles && !Game.isValidEntity(pos_x-1, pos_y))
                            {
                                pos_x = pos_x - 1;
                            }
                    }
                else if ( dir == 1 )
                    {
                        if(Game.isValidPosition(pos_x+1, pos_y) && Game.getLand(pos_x+1, pos_y).getType() == allowed_tiles && !Game.isValidEntity(pos_x+1,pos_y))
                            {
                                pos_x = pos_x + 1;
                            }
                    }
                else if ( dir == 2 )
                    {
                        if(Game.isValidPosition(pos_x, pos_y-1) && Game.getLand(pos_x, pos_y-1).getType() == allowed_tiles && !Game.isValidEntity(pos_x, pos_y-1))
                            {
                                pos_y = pos_y - 1;
                            }
                    }
                else if ( dir == 3)
                    {
                        if(Game.isValidPosition(pos_x, pos_y+1) && Game.getLand(pos_x, pos_y+1).getType() == allowed_tiles && !Game.isValidEntity(pos_x, pos_y+1))
                            {
                                pos_y = pos_y + 1;
                            }
                    }

                Game.setEntity(pos_x,pos_y,this);
            }

        //! Fungsi Getter getProduct()
        /*!
        Getter untuk mendapatkan product dari hewan yang tidak dibunuh
        @return product dari tiap hewan
        */
        public abstract void GetProduct() throws IllegalAccessException;

        //! Fungsi Getter GetKilledProduct()
        /*!
        Getter untuk mendapatkan product dari hewan yang dibunuh
        */
        public abstract void GetKilledProduct();

        //! Fungsi setter SetKilled()
        /*!
        Setter untuk membunuh hewan yang dilakukan proses KILL, menghilangkan hewan dari permainan
        */
        public void SetKilled()
            {
                hunger_countdown = -99;
                Game.setEntity(pos_x,pos_y,null);
                Game.removeAnimal(this);
            }
        
        //! Fungsi abstract render
        /*!
        Digunakan untuk mengeluarkan character pada map
        @return sesuai kelas masing-masing
        */
        public abstract String Render();
    }