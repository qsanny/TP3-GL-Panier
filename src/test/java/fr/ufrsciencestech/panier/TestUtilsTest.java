package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.view.VueGSwing;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestUtilsTest {  //Classe JUnit 4
    private static VueGSwing vueg;
    private Controleur c;  //Contrôleur associé à la vue
    private Panier p;

    @Before
    public void setUp() {
        vueg = new VueGSwing();
        p = new Panier(2);
        c = new Controleur();
        c.setPanier(p);
        p.addObserver(vueg);  //La vue observe le modèle (panier)
        vueg.addControleur(c);  //On associe le contrôleur à la vue
    }

    @Test
    public void testStoryAjouteRetire() {  //test d'acceptation
        assertNotNull(vueg);  //Instantiated?
        JLabel res = (JLabel) TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res);  //Component found?
        final JButton plus = (JButton) TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton moins = (JButton) TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(moins);
        plus.doClick();
        assertEquals(res.getText(), "1");
        moins.doClick();
        assertEquals(res.getText(), "0");
    }
}
