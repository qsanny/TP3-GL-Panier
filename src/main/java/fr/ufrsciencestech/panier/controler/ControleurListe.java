/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Panier;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author celine
 */
public class ControleurListe extends Controleur {
    private Panier p;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        switch(((Component)e.getSource()).getName()) {
            // Incrémenter un fruit en particulier ?
            case "Plus" :
                p.update(1);
                break;
            case "Moins" :
                p.update(-1);
                break;
        }
    }
    public void setPanier(Panier p){
        this.p = p;
    }
}
