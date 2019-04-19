package product;
import model.*;

/**
 * Base class SideProduct.
 * Kelas turunan dari product untuk produk olahan/hasil mixer
 */
public class SideProduct extends Product{
    /**
     * Konstruktor side product.
     * @param _price harga yang ditentukan dari barang yang dibuat
     * @param _name nama produk
     */
    public SideProduct(double _price, String _name){
        super(_price, _name);
    }
    
}