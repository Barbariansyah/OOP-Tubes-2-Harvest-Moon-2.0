package view;

//! Kelas Renderable
/*!
   Merupakan sebuah interface
   untuk melakukan output pada setiap objek yang mengimplementasikannya
   Memiliki sebuah method render()
*/
public interface Renderable
    {
        // Atribut

        // Kamus

        /**
         * Method render()
         * Mengembalikan string dari objek tertentu
         * @return String sesuai objek
         */
        public String render();
    }