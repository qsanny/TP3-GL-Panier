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

    public void update(int incr, String choix) {
        if (incr >= 0) {
            //add
            for (int i = 0; i < incr; i++) {
                switch (choix) {
                    //TODO : décommenter
                    case "Orange":
                        ajout(new Orange());
                        break;
                    case "Cerise":
                        ajout(new Cerise());
                        break;
                    case "Banane":
                        ajout(new Banane());
                        break;
                case "Macedoine" :
                    ajout(new Macedoine());
                    break;
                /*
                case "Jus" :
                    ajout(new Jus());
                    break;
                */
                }
            }
        }
        else{
                //remove
                for (int i = 0; i > incr; i--) {
                    retrait();
                }
            }

            setChanged();                //marks this Observable object as having been changed; the hasChanged method will now return true
            notifyObservers(this.toString());   //if this object has changed, as indicated by the hasChanged method, then notify all of its observers and then call the clearChanged method to indicate that this object has no longer changed
    }

    //groupe 1
    public Panier(int contenanceMax){  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)

        this.contenanceMax = contenanceMax;
        this.fruits = new ArrayList<Fruit>();
    }

    @Override
    public String toString(){  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        String resultat ="";
        resultat = "Panier de " + getTaillePanier() + " fruits ";
        double prixTotal = 0;
        for (Fruit f : getFruits()) {
            prixTotal += f.getPrix();
        }
        resultat += ": "+ prixTotal + " euros\n";
        //Orange + Cerise + Banane
        FruitSimple[] typesFruitDisponible = {new Orange(), new Cerise(), new Banane()};// TODO: Ajouter Macedoine et Jus
        for (FruitSimple typeFruit : typesFruitDisponible) {
            int nbFruits = 0;
            for (Fruit f : getFruits()) {
                if (f.getName() == typeFruit.getName()) {
                    nbFruits++;
                }
            }
            resultat += nbFruits + " " + typeFruit.getName() + " à " + typeFruit.getPrix() + " euros \n";
        }
        //Macedoine
        int nbMacedoine = 0;
        double prixMacedoine = 0;
        for (Fruit f : getFruits()) {
            if (f.getName() == "Macedoine") {
                nbMacedoine++;
                prixMacedoine += f.getPrix();
            }
        }
        resultat += nbMacedoine + " Macedoine : " + prixMacedoine + " euros au total\n";
        //Orange o  = new Orange();
        //resultat += getTaillePanier() + " Orange a " + o.getPrix() + " euros\n";
        // for (int i = 0; i < this.getFruits().size(); i++)
        // {
        //     Fruit f = this.getFruit(i);
        //     if(f != null)
        //     {
        //         resultat += f.toString() + "\n";
        //     }
        // }
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
        return fruits.size();
    }

    public int getContenanceMax(){  //accesseur du second attribut
	return this.contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i){  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
	    if(i<0 || i>=fruits.size())
        {
            return null;
        }
        else{
            return fruits.get(i);
        }
    }

    public void setFruit(int i, FruitSimple f){  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if(i>=0 && i<fruits.size())
        {
            fruits.add(i,f);
        }
    }

    public boolean estVide(){  //predicat indiquant que le panier est vide
	    return fruits.isEmpty();
    }

    public boolean estPlein(){  //predicat indiquant que le panier est plein

        return fruits.size()==contenanceMax;
    }

    //groupe 4
    public void ajout(Fruit o) {  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein

      if(!estPlein())
       fruits.add(o);
    }



    //groupe 5
    public void retrait(){ //retire le dernier fruit du panier si celui-ci n'est pas vide
        if(!estVide()){
            int index = fruits.size()-1;
            fruits.remove(index);
        }





    }

    //groupe 6
    public double getPrix(){  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans
      int tmp=0;

      for(int i=0;i<fruits.size();i++){
        tmp +=fruits.get(i).getPrix();
      }
  return tmp;
    }

    //groupe 7
    public void boycotteOrigine(String origine) {  //supprime du panier tous les fruits provenant du pays origine

        for (int i = 0; i <= fruits.size() - 1; i++) {
            if (fruits.get(i).getOrigine().equals(origine)) {
                fruits.remove(i);
            }

        }
    }

    //groupe 8
    @Override
    public boolean equals(Object o){  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        return false;
    }

    //tests
    public static void main (String[] args) {
    	//Ecrire ici vos tests
        Panier p = new Panier(5);
        System.out.println(p.estVide());
        FruitSimple b = new Banane(3,"Espagne");
  p.ajout(b);

        FruitSimple g = new Banane(55,"Congo");
          p.ajout(g);
          FruitSimple e = new Cerise(55,"Congo");
            p.ajout(e);
            FruitSimple f = new Cerise(55,"Congo");
              p.ajout(e);
    System.out.println(p.toString());
    p.boycotteOrigine("Congo");
    System.out.println(p.toString());
    }
}
