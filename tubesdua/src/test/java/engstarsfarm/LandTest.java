package engstarsfarm;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import cell.Land;
import cell.Barn;
import cell.Coop;
import cell.Grassland;

public class LandTest 
{
    @Test
    public void allGrassFalse()
    {
        Barn b = new Barn();
        Coop c = new Coop();
        Grassland g = new Grassland();
        assertFalse(b.isGrass());
        assertFalse(c.isGrass());
        assertFalse(g.isGrass());
    }

    @Test
    public void allGrassTrue()
    {
        Barn b = new Barn();
        Coop c = new Coop();
        Grassland g = new Grassland();
        b.growGrass();
        c.growGrass();
        g.growGrass();
        assertTrue(b.isGrass());
        assertTrue(c.isGrass());
        assertTrue(g.isGrass());
    }

    @Test
    public void allTypeEqual()
    {
        Barn b = new Barn();
        Coop c = new Coop();
        Grassland g = new Grassland();
        assertEquals("Barn", b.getType());
        assertEquals("Coop", c.getType());
        assertEquals("Grassland", g.getType());
    }

    @Test
    public void removeGrassSucceed()
    {
        Barn b = new Barn();
        Coop c = new Coop();
        Grassland g = new Grassland();
        b.growGrass();
        c.growGrass();
        g.growGrass();
        b.removeGrass();
        c.removeGrass();
        g.removeGrass();
        assertFalse(b.isGrass());
        assertFalse(c.isGrass());
        assertFalse(g.isGrass());
    }
    
    @Test
    public void renderEqual()
    {
        Barn b = new Barn();
        Coop c = new Coop();
        Grassland g = new Grassland();
        assertEquals("X", b.render());
        assertEquals("O", c.render());
        assertEquals("-", g.render());
        b.growGrass();
        c.growGrass();
        g.growGrass();
        assertEquals("@", b.render());
        assertEquals("*", c.render());
        assertEquals("#", g.render());
    }
}
