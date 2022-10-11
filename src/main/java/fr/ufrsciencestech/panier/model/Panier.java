package fr.ufrsciencestech.panier.model;

import java.util.Observable;
import java.util.*;

/**
 *
 * @author roudet
 */
public class Panier extends Observable {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier

    public void update(int incr) {
        if (incr >= 0) {
            //add
            for (int i = 0; i < incr; i++) {
                try {
                    ajout(new Orange());
                } catch (PanierPleinException e) {
                    break;
                }
            }
        }
        else {
            //remove
            for (int i = 0; i > incr; i--) {
                try {
                    retrait();
                } catch (PanierVideException e) {
                    break;
                }
            }
        }

        setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
        notifyObservers(getTaillePanier());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }

    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        this.fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String resultat = "";
        for (int i = 0; i < this.getFruits().size(); i++)
        {
            Fruit f = this.getFruit(i);
            if(f != null)
            {
                resultat += f.toString() + "/n";
            }
        }
        return resultat;
    }

    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
        return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier(){  //accesseur retournant la taille allouee pour l'attibut fruits
        return this.getFruits().size();
    }

    public int getContenanceMax(){  //accesseur du second attribut
        return this.contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
	   return this.getFruits().get(i);
    }

    public void setFruit(int i, Fruit f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        this.getFruits().set(i, f);
    }
    
    public boolean estVide(){  //predicat indiquant que le panier est vide
    	if(this.getFruits().isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean estPlein(){  //predicat indiquant que le panier est plein
    	if(this.getTaillePanier() >= this.getContenanceMax()){
            return true;
        }
        else {
            return false;
        }
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException{  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        if(!this.estPlein()){
            this.getFruits().add(o);
        }
        else {
            throw new PanierPleinException();
        }
    }

    //groupe 5
    public void retrait() throws PanierVideException{ //retire le dernier fruit du panier si celui-ci n'est pas vide
        if(!this.estVide()){
            this.getFruits().remove(this.getTaillePanier() - 1);
        }
        else {
            throw new PanierVideException();
        }
    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
        double prixTotal = 0.0;
        for (int i = 0; i < this.getTaillePanier(); i++)
        {
            Fruit f = this.getFruit(i);
            if(f != null)
            {
                prixTotal += f.getPrix();
            }
        }
        return prixTotal;
    }

    //groupe 7
    public void boycotteOrigine(String origine){  //supprime du panier tous les fruits provenant du pays origine
		ArrayList<Fruit> newFruits = getFruits();
		newFruits.removeIf(f -> (f.getOrigine() == origine));
		setFruits(newFruits);
    }

    //groupe 8
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        return getFruits().equals(((Panier) o).getFruits());
    }

    //tests
    public static void main (String[] args){
    	//Ecrire ici vos tests
	    System.out.println("premier test Panier");
    }
}
