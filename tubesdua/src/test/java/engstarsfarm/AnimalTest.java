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
    @BeforeClass
    public static void init()
    {
        Chicken chi = new Chicken(0,0);
    }
}
