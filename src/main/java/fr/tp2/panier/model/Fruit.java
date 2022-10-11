/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.tp2.panier.model;

/**
 *
 * @author as855970
 */
interface Fruit {
    public boolean isSeedless();  //predicat indiquant si le fruit a ou non des pepins
    public double getPrix();      //prix unitaire du fruit (en euros)
    public String getOrigine();   //pays d'origine du fruit
    public boolean equals(Object o);  //predicat pour tester si 2 fruits sont equivalents
    public String toString();    //affichage d'un fruit

}
