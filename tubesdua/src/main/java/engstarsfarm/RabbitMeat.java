package product;

/**
 * Kelas RabbitMeat, kelas riil turunan farm product.
 * Didapatkan dari aksi kill terhadap farm animal rabbit
 */
public class RabbitMeat extends FarmProduct{
    /**
     * Konstruktor RabbitMeat.
     */
    public RabbitMeat(){
        super(62000, "Rabbit Meat");
    }
}