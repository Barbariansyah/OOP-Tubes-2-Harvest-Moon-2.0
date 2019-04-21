package engstarsfarm;

import static org.junit.Assert.*;
import org.junit.*;

import product.FarmProduct;

import product.ChickenEgg;
import product.ChickenMeat;

import product.CowMilk;
import product.CowMeat;

import product.DinoEgg;

import product.DuckEgg;
import product.DuckMeat;

import product.GoatMilk;
import product.GoatMeat;

import product.RabbitMeat;

public class FarmProductTest 
{
    @Test
    public void farmProductInitTest()
    {
        ChickenEgg ce = new ChickenEgg();
        ChickenMeat cm = new ChickenMeat();

        assertEquals("Chicken Egg", ce.getName());
        assertEquals("Chicken Meat", cm.getName());
        assertEquals(2000.0, ce.getPrice(), 0.0);
        assertEquals(35000.0, cm.getPrice(), 0.0);

        CowMilk cmi = new CowMilk();
        CowMeat cme = new CowMeat();

        assertEquals("Cow Milk", cmi.getName());
        assertEquals("Cow Meat", cme.getName());
        assertEquals(15000.0, cmi.getPrice(), 0.0);
        assertEquals(50000.0, cme.getPrice(), 0.0);

        DinoEgg die = new DinoEgg();

        assertEquals("Dino Egg", die.getName());
        assertEquals(100000.0, die.getPrice(), 0.0);

        DuckEgg de = new DuckEgg();
        DuckMeat dm = new DuckMeat();

        assertEquals("Duck Egg", de.getName());
        assertEquals("Duck Meat", dm.getName());
        assertEquals(6000.0, de.getPrice(), 0.0);
        assertEquals(40000.0, dm.getPrice(), 0.0);

        GoatMilk gi = new GoatMilk();
        GoatMeat ge = new GoatMeat();

        assertEquals("Goat Milk", gi.getName());
        assertEquals("Goat Meat", ge.getName());
        assertEquals(22000.0, gi.getPrice(), 0.0);
        assertEquals(55000.0, ge.getPrice(), 0.0);

        RabbitMeat rm = new RabbitMeat();

        assertEquals("Rabbit Meat", rm.getName());
        assertEquals(62000.0, rm.getPrice(), 0.0);

        
    }
}