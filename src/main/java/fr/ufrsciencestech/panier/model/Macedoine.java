package fr.ufrsciencestech.panier.model;

import java.util.*;
public class Macedoine implements Fruit {
        private ArrayList<Fruit> fruits;
          public boolean Seedless;

          public Macedoine(){
            this.fruits= new ArrayList<Fruit>();
          }


          public void ajout ( Fruit f){
            fruits.add(f);
          }

          public String toString(){
             String n="list des fuits de la Macedoine";
            for (int i=0;i<=fruits.size()-1;i++){
              n=n+"\n"+fruits.get(i).toString();
            }
          return n;


          }

  @Override
  public String getName() {
    return "Macedoine";
  }

  @Override
  public boolean isSeedless() {
    return this.Seedless;
  }

  public double getPrix(){
            double n=0;
            for (int i=0;i<=fruits.size()-1;i++){
              n= n+fruits.get(i).getPrix();
            }
            return n;
          }

  @Override
  public String getOrigine() {
    return null;
  }

  public static void main (String[] args) {

            Macedoine n = new Macedoine();
            FruitSimple t= new Banane(55,"gg");
            Fruit h= t;
            n.ajout(h);


        	    System.out.println(n.toString());
            }

}
