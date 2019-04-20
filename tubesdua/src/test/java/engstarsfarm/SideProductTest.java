package engstarsfarm;

import static org.junit.Assert.*;
import org.junit.*;

import product.SideProduct;
import model.*;
import product.*;

public class SideProductTest 
{
    @Test
    public void sideProductInitTest()
    {
        LinkedList<Product> brR = new LinkedList<Product>();
        BeefRolade.initRecipe();
        BeefRolade br = new BeefRolade();
        assertEquals("Beef Rolade", br.getName());
        assertEquals(80000.0, br.getPrice(), 0.0);

        LinkedList<Product> cbmR = new LinkedList<Product>();
        ChickenButterMilk.initRecipe();
        ChickenButterMilk cbm = new ChickenButterMilk();
        assertEquals("Chicken Butter Milk", cbm.getName());
        assertEquals(90000.0, cbm.getPrice(), 0.0);

        LinkedList<Product> gcR = new LinkedList<Product>();
        GoatCheese.initRecipe();
        GoatCheese gc = new GoatCheese();
        assertEquals("Goat Cheese", gc.getName());
        assertEquals(50000.0, gc.getPrice(), 0.0);

        LinkedList<Product> pR = new LinkedList<Product>();
        Pancake.initRecipe();
        Pancake p = new Pancake();
        assertEquals("Pancake", p.getName());
        assertEquals(40000.0, p.getPrice(), 0.0);

    }
    @Test
    public void recipeTest()
    {
        LinkedList<Product> brR = new LinkedList<Product>();
        BeefRolade.initRecipe();
        BeefRolade br = new BeefRolade();
        CowMeat a = new CowMeat();
        ChickenEgg b = new ChickenEgg();
        brR.add(a);
        brR.add(b);
        assertTrue(br.validateRecipe(brR));

        LinkedList<Product> cbmR = new LinkedList<Product>();
        ChickenButterMilk.initRecipe();
        ChickenButterMilk cbm = new ChickenButterMilk();
        CowMilk c = new CowMilk();
        ChickenMeat d = new ChickenMeat();
        cbmR.add(c);
        cbmR.add(d);
        assertTrue(cbm.validateRecipe(cbmR));
        

        LinkedList<Product> gcR = new LinkedList<Product>();
        GoatCheese.initRecipe();
        GoatCheese gc = new GoatCheese();
        GoatMilk e = new GoatMilk();
        GoatMilk f = new GoatMilk();
        gcR.add(e);
        gcR.add(f);
        assertTrue(gc.validateRecipe(gcR));
        

        LinkedList<Product> pR = new LinkedList<Product>();
        Pancake.initRecipe();
        Pancake p = new Pancake();
        CowMilk g = new CowMilk();
        ChickenEgg h = new ChickenEgg();
        pR.add(g);
        pR.add(h);
        assertTrue(p.validateRecipe(pR));
        
    }
}