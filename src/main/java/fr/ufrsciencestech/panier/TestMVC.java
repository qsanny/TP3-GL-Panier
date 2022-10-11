/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.view.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//utilise pour springIoC :

/**
 *
 * @author celine
 */
public class TestMVC {
    private VueG vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    
    /**
     * @return the vueg
     */
    public VueG getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueG vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
    
    
    public TestMVC(){
        //sans utiliser SpringIoC :
        /*
        vueg = new VueGSwing();
        controleur = new Controleur();
        Panier panier = new Panier(10);
        VueConsole vuec = new VueConsole();

        controleur.setPanier(panier);
        panier.addObserver(vueg);
        panier.addObserver(vuec);
        vueg.addControleur(controleur);
        */
    }
    
    public static void main(String[] args){
        //TestMVC test = new TestMVC();    //sans utiliser SpringIoC
        
        //La meme chose mais avec SpringIoC :
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestMVC test = (TestMVC)context.getBean("MVC");  //SpringIoC
        test.setControleur( (Controleur)context.getBean("Controleur") );  //SpringIoC
        test.setVueg( (VueG)context.getBean("Vue") );   //SpringIoC
         
        Panier p = new Panier(10);
        test.getControleur().setPanier(p);
        
        p.addObserver(test.getVueg());
        test.getVueg().addControleur(test.getControleur());
        
        VueConsole vuec = new VueConsole();
        p.addObserver(vuec);
    }
}
