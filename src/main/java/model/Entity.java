package model;
import view.Renderable;

//! Kelas Entity
/*!
    Merupakan Class untuk merepresentasikan entitas yang ada pada permainan ini
    memiliki atribut posisi X dan posisi Y
*/
public abstract class Entity implements Renderable
    {
        // Atribut
        protected int pos_x;
        protected int pos_y;

        // Method

        //! Fungsi getter x
        /*!
        Digunakan untuk mendapatkan atribut pos_x oleh objek lain
        @return X;
        */
        public int getX()
            {
                return pos_x;
            }
        
        //! Fungsi getter y
        /*!
        Digunakan untuk mendapatkan atribut pos_y oleh objek lain
        @return Y;
        */
        public int getY()   
            {
                return pos_y;
            }

        /**
         * Method render()
         * Mengembalikan string dari objek tertentu
         * @return String sesuai objek
         */
        public abstract String render();
    }