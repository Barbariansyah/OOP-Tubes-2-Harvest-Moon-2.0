public class Main{
    public static void main(String[] args){
        System.out.println("---Product Test---");
        System.out.println();
        Product a = new Product(10000, "Cow Meat");
        Product b = new Product(10000, "Cow Meat");
        Product c = new Product(10000, "Cow Milk");

        System.out.println("equal: "+a.equals(b));
        System.out.println("Not equal: "+a.equals(c));

        System.out.println();
        System.out.println("---FarmProduct Test---");
        System.out.println();

        FarmProduct d = new FarmProduct(10000, "Chicken Egg");
        d.Print();

        System.out.println();
        System.out.println("---FarmProduct children Test---");
        System.out.println();

        ChickenEgg e = new ChickenEgg();
        e.Print();
        System.out.println();
        ChickenMeat f = new ChickenMeat();
        f.Print();
        System.out.println();
        CowMeat g = new CowMeat();
        g.Print();
        System.out.println();
        CowMilk h = new CowMilk();
        h.Print();
        System.out.println();
        DinoEgg i = new DinoEgg();
        i.Print();
        System.out.println();
        DuckEgg j = new DuckEgg();
        j.Print();
        System.out.println();
        DuckMeat k = new DuckMeat();
        k.Print();
        System.out.println();
        GoatMeat l = new GoatMeat();
        l.Print();
        System.out.println();
        GoatMilk m = new GoatMilk();
        m.Print();
        System.out.println();
        RabbitMeat n = new RabbitMeat();
        n.Print();
        System.out.println();



    }
}