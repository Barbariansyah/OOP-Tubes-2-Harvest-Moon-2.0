//! Kelas Renderable
/*!
   Merupakan sebuah interface
   untuk melakukan output pada setiap objek yang mengimplementasikannya
   Memiliki sebuah method Render()
*/
public interface Renderable
    {
        // Atribut

        // Kamus

        /**
         * Method Render()
         * Mengembalikan string dari objek tertentu
         * @return String sesuai objek
         */
        public String Render();
    }