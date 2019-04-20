package engstarsfarm;

import static org.junit.Assert.*;
import org.junit.*;

import model.*;
import entity.FarmAnimal;
import entity.Chicken;
import entity.Cow;
import entity.Dino;
import entity.Duck;
import entity.Goat;
import entity.Rabbit;

public class AnimalTest 
{

    @Test
    public void animalInitTest()
    {
        Chicken ci = new Chicken(0,0);
        Cow co = new Cow(1,1);
        Dino di = new Dino(2,2);
        Duck du = new Duck(3,3);
        Goat go = new Goat(4,4);
        Rabbit ra = new Rabbit(5,5);

        assertEquals(0, ci.getX());
        assertEquals(1, co.getX());
        assertEquals(2, di.getX());
        assertEquals(3, du.getX());
        assertEquals(4, go.getX());
        assertEquals(5, ra.getX());

        assertEquals(0, ci.getY());
        assertEquals(1, co.getY());
        assertEquals(2, di.getY());
        assertEquals(3, du.getY());
        assertEquals(4, go.getY());
        assertEquals(5, ra.getY());

        assertEquals(5, ci.getHungerCountdown());
        assertEquals(5, co.getHungerCountdown());
        assertEquals(5, di.getHungerCountdown());
        assertEquals(5, du.getHungerCountdown());
        assertEquals(5, go.getHungerCountdown());
        assertEquals(5, ra.getHungerCountdown());

        assertEquals("C", ci.render());
        assertEquals("S", co.render());
        assertEquals("U", di.render());
        assertEquals("D", du.render());
        assertEquals("G", go.render());
        assertEquals("R", ra.render());

        
    }

    @Test
    public void renderHungry()
    {
        Chicken ci = new Chicken(0,0);
        Cow co = new Cow(1,1);
        Dino di = new Dino(2,2);
        Duck du = new Duck(3,3);
        Goat go = new Goat(4,4);
        Rabbit ra = new Rabbit(5,5);

        assertEquals(5, ci.getHungerCountdown());
        assertEquals(5, co.getHungerCountdown());
        assertEquals(5, di.getHungerCountdown());
        assertEquals(5, du.getHungerCountdown());
        assertEquals(5, go.getHungerCountdown());
        assertEquals(5, ra.getHungerCountdown());

        ci.reduceHungerCountdown();
        ci.reduceHungerCountdown();
        ci.reduceHungerCountdown();
        ci.reduceHungerCountdown();
        ci.reduceHungerCountdown();

        co.reduceHungerCountdown();
        co.reduceHungerCountdown();
        co.reduceHungerCountdown();
        co.reduceHungerCountdown();
        co.reduceHungerCountdown();

        di.reduceHungerCountdown();
        di.reduceHungerCountdown();
        di.reduceHungerCountdown();
        di.reduceHungerCountdown();
        di.reduceHungerCountdown();

        du.reduceHungerCountdown();
        du.reduceHungerCountdown();
        du.reduceHungerCountdown();
        du.reduceHungerCountdown();
        du.reduceHungerCountdown();

        go.reduceHungerCountdown();
        go.reduceHungerCountdown();
        go.reduceHungerCountdown();
        go.reduceHungerCountdown();
        go.reduceHungerCountdown();

        ra.reduceHungerCountdown();
        ra.reduceHungerCountdown();
        ra.reduceHungerCountdown();
        ra.reduceHungerCountdown();
        ra.reduceHungerCountdown();

        assertEquals(0, ci.getHungerCountdown());
        assertEquals(0, co.getHungerCountdown());
        assertEquals(0, di.getHungerCountdown());
        assertEquals(0, du.getHungerCountdown());
        assertEquals(0, go.getHungerCountdown());
        assertEquals(0, ra.getHungerCountdown());

        assertEquals("c", ci.render());
        assertEquals("ċ", co.render());
        assertEquals("u", di.render());
        assertEquals("d", du.render());
        assertEquals("g", go.render());
        assertEquals("r", ra.render());

        
    }

}
