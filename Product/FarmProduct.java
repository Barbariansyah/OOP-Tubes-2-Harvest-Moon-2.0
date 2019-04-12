/**
 * Base class FarmProduct.
 * Kelas turunan dari product untuk produk hasil interact/kill terhadap farm animal
 */
public class FarmProduct extends Product{
    /**
     * Konstruktor farm product.
     * @param _price harga dari produk hasil interact/kill
     * @param _name nama produk
     */
    public FarmProduct(double _price, String _name){
        super(_price, _name);
    }

}