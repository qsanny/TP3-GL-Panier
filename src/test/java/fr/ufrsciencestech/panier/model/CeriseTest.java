package fr.ufrsciencestech.panier.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CeriseTest {
   Cerise b1, b2;

    @Before
    public void setup()  {
        b1 = new Cerise();
        b2 = new Cerise(15, "Espagne");
    }

    @Test
    public void testGetPrixMock() {
        double res = b1.getPrix();
        assertEquals(0.25, res, 0);
    }

    @Test
    public void testGetPrix2Mock() {
        double res = b2.getPrix();
        assertEquals(15, res, 0);
    }
}
