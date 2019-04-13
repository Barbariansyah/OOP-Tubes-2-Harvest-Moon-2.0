//! Kelas Entity
/*!
    Merupakan Class untuk merepresentasikan entitas yang ada pada permainan ini
    memiliki atribut posisi X dan posisi Y
*/
public class Entity 
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
        public int GetX()
            {
                return pos_x;
            }
        
        //! Fungsi getter y
        /*!
        Digunakan untuk mendapatkan atribut pos_y oleh objek lain
        @return Y;
        */
        public int GetY()   
            {
                return pos_y;
            }
    }