package engstarsfarm;

import static org.junit.Assert.*;
import org.junit.*;

import model.Entity;
import entity.Facility;
import entity.Mixer;
import entity.Well;
import entity.Truck;

public class FacilityTest 
{
    @BeforeClass
    public static void init()
    {
        Mixer.initialize(0,0);
        Well.initialize(1,1);
        Truck.initialize(2,2);
    }

    @Test
    public void facilityInitTest()
    {
        Mixer m = null;
        try{
            m = Mixer.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(m);

        Well w = null;
        try{
            w = Well.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(w);

        Truck t = null;
        try{
            t = Truck.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(t);
    }

    @Test
    public void renderEqual()
    {
        Mixer m = null;
        try{
            m = Mixer.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        Well w = null;
        try{
            w = Well.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        Truck t = null;
        try{
            t = Truck.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        assertEquals("M", m.render());
        assertEquals("W", w.render());
        assertEquals("T", t.render());
    }

    @Test
    public void positionEqual()
    {
        Mixer m = null;
        try{
            m = Mixer.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        Well w = null;
        try{
            w = Well.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        Truck t = null;
        try{
            t = Truck.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(0, m.getX());
        assertEquals(1, w.getX());
        assertEquals(2, t.getX());
        assertEquals(0, m.getY());
        assertEquals(1, w.getY());
        assertEquals(2, t.getY());
    }

    @Test
    public void awayCounterTruckTest()
    {
        Truck t = null;
        try{
            t = Truck.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(0, t.getAwayCounter());
        t.setAwayCounter(5);
        assertEquals(5, t.getAwayCounter());
        t.tickTruck();
        assertEquals(4, t.getAwayCounter());
    }

    



    
}
