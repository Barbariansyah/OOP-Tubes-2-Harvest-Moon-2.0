package engstarsfarm;

import static org.junit.Assert.*;

import org.junit.*;
import entity.Player;

/**
 * Unit test for simple App.
 */
public class PlayerTest 
{
    @BeforeClass
    public static void setup() {
        Player.initialize("budi", 5, 0, 0, 0);
    }

    @Test
    public void playerInitializeTest()
    {
        Player p = null;
        try{
            p = Player.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(p);
    }

    @Test
    public void playerInitialStateTest()
    {
        Player p = null;
        try{
            p = Player.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(5,p.GetWaterContainer());
        assertEquals("budi",p.GetName());
        assertEquals(0.0,p.GetMoney(),0.0);
        assertEquals("P",p.render());
    }
}
