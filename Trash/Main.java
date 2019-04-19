public class Main{
    public static void main(String[] args){
        // System.out.println("---Product Test---");
        // System.out.println();
        // Product a = new Product(10000, "Cow Meat");
        // Product b = new Product(10000, "Cow Meat");
        // Product c = new Product(10000, "Cow Milk");

        // System.out.println("equal: "+a.equals(b));
        // System.out.println("Not equal: "+a.equals(c));

        // System.out.println();
        // System.out.println("---FarmProduct Test---");
        // System.out.println();

        // CowMeat cow1 = new CowMeat();
        // CowMeat cow2 = new CowMeat();

        // System.out.println("cow == cow ?: "+ cow1.equals(cow2));

        // FarmProduct d = new FarmProduct(10000, "Chicken Egg");
        // d.Print();

        // System.out.println();
        // System.out.println("---FarmProduct children Test---");
        // System.out.println();

        // ChickenEgg e = new ChickenEgg();
        // e.Print();
        // System.out.println();
        // ChickenMeat f = new ChickenMeat();
        // f.Print();
        // System.out.println();
        // CowMeat g = new CowMeat();
        // g.Print();
        // System.out.println();
        // CowMilk h = new CowMilk();
        // h.Print();
        // System.out.println();
        // DinoEgg i = new DinoEgg();
        // i.Print();
        // System.out.println();
        // DuckEgg j = new DuckEgg();
        // j.Print();
        // System.out.println();
        // DuckMeat k = new DuckMeat();
        // k.Print();
        // System.out.println();
        // GoatMeat l = new GoatMeat();
        // l.Print();
        // System.out.println();
        // GoatMilk m = new GoatMilk();
        // m.Print();
        // System.out.println();
        // RabbitMeat n = new RabbitMeat();
        // n.Print();
        // System.out.println();


        // System.out.println();
        // System.out.println("---SideProduct children Test---");
        // System.out.println();
        // BeefRolade.initRecipe();
        // ChickenButterMilk.initRecipe();
        // Pancake.initRecipe();
        // GoatCheese.initRecipe();
        
        // System.out.println("Beef Rolade Recipe:");
        // for(int it = 0; it < BeefRolade.getRecipe().length(); it++){
        //     System.out.println(BeefRolade.getRecipe().get(it).getName());
        // }
        // System.out.println();

        // System.out.println();
        // System.out.println("---SideProduct children recipe validation Test---");
        // System.out.println();
        // System.out.println("---All value below should be true---");
        // System.out.println();

        // LinkedList<Product> testInventory1 = new LinkedList<Product>();
        // testInventory1.add(new ChickenEgg());
        // testInventory1.add(new CowMeat());
        // System.out.println("Recipe validated: "+ BeefRolade.validateRecipe(testInventory1));
        
        // LinkedList<Product> testInventory2 = new LinkedList<Product>();
        // testInventory2.add(new ChickenMeat());
        // testInventory2.add(new CowMilk());
        // System.out.println("Recipe validated: "+ ChickenButterMilk.validateRecipe(testInventory2));

        // LinkedList<Product> testInventory3 = new LinkedList<Product>();
        // testInventory3.add(new ChickenEgg());
        // testInventory3.add(new CowMilk());
        // System.out.println("Recipe validated: "+ Pancake.validateRecipe(testInventory3));

        // LinkedList<Product> testInventory4 = new LinkedList<Product>();
        // testInventory4.add(new GoatMilk());
        // testInventory4.add(new GoatMilk());
        // System.out.println("Recipe validated: "+ GoatCheese.validateRecipe(testInventory4));

        // System.out.println();
        // System.out.println("---All value below should be false---");
        // System.out.println();

        // LinkedList<Product> testInventory5 = new LinkedList<Product>();
        // testInventory5.add(new ChickenEgg());
        // testInventory5.add(new CowMilk());
        // testInventory5.add(new CowMilk());
        // System.out.println("Recipe validated: "+ BeefRolade.validateRecipe(testInventory5));
        
        // LinkedList<Product> testInventory6 = new LinkedList<Product>();
        // testInventory6.add(new ChickenMeat());
        // System.out.println("Recipe validated: "+ ChickenButterMilk.validateRecipe(testInventory6));

        // LinkedList<Product> testInventory7 = new LinkedList<Product>();
        // testInventory7.add(new ChickenEgg());
        // System.out.println("Recipe validated: "+ Pancake.validateRecipe(testInventory7));

        // LinkedList<Product> testInventory8 = new LinkedList<Product>();
        // testInventory8.add(new GoatMilk());
        // System.out.println("Recipe validated: "+ GoatCheese.validateRecipe(testInventory8));

        // System.out.println();
        // System.out.println("---END OF TEST---");
        
        try{
            Game.initialize("tes.txt", 3, 4);
            Game.drawScreen();
            while (true){
                Game.tick();
                Game.drawScreen();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

}