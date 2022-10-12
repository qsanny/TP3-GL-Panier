/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Panier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author celine
 */
public class ControleurListe extends Controleur {
    private Panier p;
    private String choix = "Orange";
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        switch(((Component)e.getSource()).getName()) {
            case "Plus" :
                p.update(1, choix);
                break;
            case "Moins" :
                p.update(-1, choix);
                break;
            case "Choix" :
                choix = ((JComboBox)e.getSource()).getSelectedItem().toString();
                break;
        }
    }
    public void setPanier(Panier p){
        this.p = p;
    }
}
