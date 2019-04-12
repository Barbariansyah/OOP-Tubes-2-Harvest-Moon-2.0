public class Main{
    public static void main(String[] args){
        Product a = new Product(10000, "Cow Meat");
        Product b = new Product(10000, "Cow Meat");
        Product c = new Product(10000, "Cow Milk");

        System.out.println("equal: "+a.equals(b));
        System.out.println("Not equal: "+a.equals(c));

    }
}