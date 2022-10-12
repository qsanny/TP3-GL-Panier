package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.Orange;
import fr.ufrsciencestech.panier.view.VueGraphiqueListe;

import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
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
        JTextArea test = new JTextArea("Test");
        view.setAffiche(test);
        assertTrue(view.getAffiche().equals(test));
    }

    @Test
    public void testGetInc() {
        assertTrue(view.getInc().getText().equals("+"));
    }

    @Test // Il faudrait vérifier que 'modifiedLabel' est incrémenté plutôt que différant
    public void testClickInc(){
        view.getInc().doClick();
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
    public void testClickDec(){
        view.getDec().doClick();
        String label = view.getAffiche().getText();
        view.getDec().doClick();
        String modifiedLabel = view.getAffiche().getText();
        System.out.println("Label = " + label);
        System.out.println("Modified = "+modifiedLabel);
        assertNotEquals(label, modifiedLabel);
    }

    @Test
    public void testGetListeFruits(){
        assertTrue(view.getListeFruits().getItemAt(0).getName(), "Orange");
    }

    @Test
    public void testSetListeFruit() {
        String[] fruit = {"Orange"};
        JComboBox<Fruit> listeFruits = new JComboBox(fruit);
        view.setListeFruits(listeFruits);
        assertTrue(view.getListeFruits().equals(listeFruits));
    }

    @Test
    public void ajouteFruit() {
        Orange o = new Orange();
        view.ajouteFruit(o);
        assertEquals(view.getListeFruits().getItemAt(5), o);
    }
}
