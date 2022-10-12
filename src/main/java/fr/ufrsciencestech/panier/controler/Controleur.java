/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.model.Panier;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author celine
 */
public class Controleur implements ActionListener {
    private Panier p;

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void setPanier(Panier p){
        this.p = p;
    }
}
