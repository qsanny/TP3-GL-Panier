package fr.ufrsciencestech.panier.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PanierTest {
    Panier p0, p2, p2plein, p3, p4;
    Fruit o1, o2, o3;
    Fruit mock1, mock2;

    @Before
    public void setup() throws PanierPleinException {
        p0 = new Panier(0);
        p2 = new Panier(2);
        p2plein = new Panier(2);
        p3 = new Panier(3);
        p4 = new Panier(4);
        o1 = new Orange(0.5, "Espagne");
        o2 = new Orange(0.5, "France");
        o3 = new Orange(0.5, "USA");

        //p2plein.ajout(o1);
        //p2plein.ajout(o1);
        mock1 = mock(Fruit.class);
        mock2 = mock(Fruit.class);

        when(mock1.getPrix()).thenReturn(1.0);
        when(mock2.getPrix()).thenReturn(0.5);
        when(mock1.getOrigine()).thenReturn("France");
        when(mock2.getOrigine()).thenReturn("Espagne");
    }

    @Test
    public void testGetPrixMock() throws PanierPleinException, PanierVideException {
        System.out.println("GetPrixMock");
        Panier panier = new Panier(3);
        //panier.ajout(mock1);
        //panier.ajout(mock2);
        double res = panier.getPrix();

        //test d'intersection
        verify(mock1, times(1)).getPrix();
        verify(mock2, times(1)).getPrix();
        assertEquals(1.5, res, 0);
        panier.retrait();
        res = panier.getPrix();
        verify(mock1, times(2)).getPrix();
        verify(mock2, times(1)).getPrix();
        assertEquals(1, res, 0);
    }

    @Test
    public void testBoycotteOrigineMock() throws PanierPleinException {
        Panier p = new Panier(3);
        //p.ajout(mock1);
        //p.ajout(mock2);

        assertEquals(2, p.getTaillePanier());
        p.boycotteOrigine("France");
        assertEquals(1, p.getTaillePanier());
    }

    @Test
    public void testGetPrixIntegration() throws PanierPleinException, PanierVideException {
        System.out.println("GetPrixIntegration");
        Panier panier = new Panier(3);
        //panier.ajout(o1);
        //panier.ajout(o2);
        double res = panier.getPrix();

        //test d'intersection
        assertEquals(1.0, res, 0);
        panier.retrait();
        res = panier.getPrix();
        assertEquals(0.5, res, 0);
    }

    @Test
    public void testBoycotteOrigineIntegration() throws PanierPleinException {
        Panier p = new Panier(3);
        //p.ajout(o1);
        //p.ajout(o2);
        //p.ajout(o3);

        assertEquals(3, p.getTaillePanier());
        p.boycotteOrigine("France");
        assertEquals(2, p.getTaillePanier());
    }
}