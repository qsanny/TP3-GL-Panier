/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.tp2.panier.vue;

import fr.tp2.panier.controleur.ControleurPanier;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author as855970
 */
public interface VueG extends Observer {
   public void update(Observable o,  Object arg);
   public void addControleur(ControleurPanier c);
}
