package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.view.VueGraphiqueListe;

import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.mockito.Mockito.*;

import javax.swing.*;

public class TestIHM {
    VueGraphiqueListe view;

    @Before
    public void setup(){
        view = new VueGraphiqueListe();
    }

    @Test
    public void testGetAndSetAffiche() {
        //JLabel test = new JLabel("Test");
        //view.setAffiche(test);
        //assertTrue(view.getAffiche().equals(test));
    }

    @Test
    public void testGetInc() {
        assertTrue(view.getInc().getText().equals("+"));
    }

    @Test // Il faudrait vérifier que 'modifiedLabel' est incrémenté plutôt que différant
    public void testClickInc(){
        String label = view.getAffiche().getText();
        view.getInc().doClick();
        String modifiedLabel = view.getAffiche().getText();
        assertNotEquals(label, modifiedLabel);
    }

    @Test
    public void testGetDec() {
        assertTrue(view.getDec().getText().equals("-"));
    }

    @Test // Il faudrait vérifier que 'modifiedLabel' est incrémenté plutôt que différant
    public void testClickDex(){
        String label = view.getAffiche().getText();
        view.getDec().doClick();
        String modifiedLabel = view.getAffiche().getText();
        assertNotEquals(label, modifiedLabel);
    }

    @Ignore
    @Test
    public void testGetListeFruit(){
    }

    @Ignore
    @Test
    public void testSetListeFruit() {

    }

    @Ignore
    @Test
    public void ajouteFruit() {
        
    }
}
