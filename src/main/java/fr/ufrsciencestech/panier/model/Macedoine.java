
  import java.util.*;
public class Macedoine {
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

          public double getPrix(){
            double n=0;
            for (int i=0;i<=fruits.size()-1;i++){
              n= n+fruits.get(i).getPrix();
            }
            return n;
          }

          public static void main (String[] args) {

            Macedoine n = new Macedoine();
            FruitSimple t= new Banane(55,"gg");
            Fruit h= t;
            n.ajout(h);


        	    System.out.println(n.toString());
            }

}
