/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.panierdefruit;

import fr.tp2.panier.controleur.ControleurPanier;
import fr.tp2.panier.model.Panier;
import fr.tp2.panier.vue.VueGSwing;
import fr.tp2.panier.vue.VueG;

/**
 *
 * @author as855970
 */
public class PanierDeFruit {

    public static void main(String[] args) {
        
        Panier p = new Panier(10);
        ControleurPanier c = new ControleurPanier();
        VueG v = new VueGSwing();
        
        c.setPanier(p);
        c.setVue(v);
        
        p.addObserver(v);
        v.addControleur(c);
        
        

    }
}
