/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.tp2.panier.controleur;

import fr.tp2.panier.model.Orange;
import fr.tp2.panier.model.Panier;
import fr.tp2.panier.vue.VueG;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author as855970
 */
public class ControleurPanier  implements ActionListener{
    
    private Panier p;
    private VueG vg;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((Component)e.getSource()).getName().equals("Ajouter")) {
            Orange o = new Orange();
            this.p.ajout(o);
        } else if(((Component)e.getSource()).getName().equals("Retirer")) {
            this.p.retrait();
        }
                System.out.println("fr.tp2.panier.model.Panier.update()");

    }
    
    public void setPanier(Panier p){
        this.p = p;
    }
    
    public void setVue(VueG vg){
        this.vg = vg;
    }
    
}
