/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.tp2.panier.model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author as855970
 */
public class Panier extends Observable{
    
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier
	
    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.contenanceMax = contenanceMax;
	    this.fruits = new ArrayList<Fruit>(this.contenanceMax);
    }
    
    public void update(){
        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(this.fruits.size());
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String s = "Votre panier contient: ";
        for(int i = 0; i < this.fruits.size(); i++)
        {
            s += this.fruits.get(i) + " ";
        }
        return s;
    }
    
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
       return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut

    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }
    
    public int getContenanceMax(){  //accesseur du second attribut
	return this.contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
	return this.fruits.get(i);
    }
    
    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
    }



    public boolean estVide(){  //predicat indiquant que le panier est vide
	    return !this.estPlein();
    }
    
    public boolean estPlein(){  //predicat indiquant que le panier est plein
	    return this.fruits.size() == this.contenanceMax;
    }

    public void ajout(Fruit o){  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        this.fruits.add(o);
        this.update();
    }

    public void retrait() { //retire le dernier fruit du panier si celui-ci n'est pas vide
        this.fruits.remove(this.fruits.size()-1);
        this.update();     
    }

    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
	return 0;
    }
    
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine
	
    }  
        
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        return false;
    }
    
    
}
