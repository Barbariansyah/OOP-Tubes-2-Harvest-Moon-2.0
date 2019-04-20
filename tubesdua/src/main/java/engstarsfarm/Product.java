package model;

/**
 * Base class Product.
 * Memiliki atribut price dan name yang dimiliki semua product turunan
 */
public class Product{
    protected double price;
    protected String name;

    /**
     * Konstruktor product.
     * @param _price harga yang ditentukan
     * @param _name nama produk
     */
    public Product(double _price, String _name){
        price = _price;
        name = _name;
    }
    /**
     * Getter harga.
     * Mengembalikan nilai harga dari suatu produk
     * @return harga produk
     */
    public double getPrice(){
        return price;
    }
    /**
     * Getter nama.
     * Mengembalikan nama dari suatu produk
     * @return nama produk
     */
    public String getName(){
        return name;
    } 
    /**
     * method Print.
     * Method ini mencetak atribut name dan price
     * Method ini mencetak produk yang tampilannya akan berbeda antara side product dengan farm product
     */
    public void print(){
        System.out.println("Name : "+name);
        System.out.println("Price : "+price);
    }

    /**
     * Implementasi method equals
     * Digunakan untuk membandingkan product this dengan p
     * @return boolean kesamaan product
     */
    public boolean equals(Object p){
        if(p == null){
            return false;
        }
        if (! (p instanceof Product)){
            return false;
        }
        Product temp = (Product) p;
        
        if(name != temp.getName()){
            return false;
        }

        return true;
    }
}