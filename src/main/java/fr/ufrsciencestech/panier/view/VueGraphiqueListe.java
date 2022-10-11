/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Fruit;

import java.awt.BorderLayout;
import java.util.Observable;
import javax.swing.*;

/**
 *
 * @author as855970
 */
public class VueGraphiqueListe extends JFrame implements VueG {
    private JButton inc;
    private JButton dec;
    private JTextArea affiche;
    private JComboBox<Fruit> listeFruits;
    
    public VueGraphiqueListe(){
        super ("CompteurSwing");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JTextArea(1, JLabel.CENTER);
        add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addControleur(Controleur c){
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
    @Override
    public void update(Observable m, Object compte){     //This method is called whenever the observed object is changed
        getAffiche().setText(((Integer) compte).toString());
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public JTextArea getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JTextArea affiche) {
        this.affiche = affiche;
    }

    public JComboBox<Fruit> getListeFruits() {
        return listeFruits;
    }

    public void setListeFruits(JComboBox<Fruit> listeFruits) {
        this.listeFruits = listeFruits;
    }

    public void ajouteFruit(Fruit f) {
        listeFruits.addItem(f);
    }
}
