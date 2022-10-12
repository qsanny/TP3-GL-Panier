package fr.ufrsciencestech.panier.model;

/**
 *
 * @author roudet
 */
public class Cerise extends FruitSimple{
  public Cerise()
  {
    super();

  }

  public Cerise(double prix, String origine)
  {
  if(prix < 0)
    super.prix = -prix;  //une solution possible pour interdire les prix negatifs
  else
    super.prix = prix;

  if(origine.equals(""))
          super.Origine = "Espagne";  //Espagne par défaut
  else
          super.Origine = origine;
  }



  public void setPrix(double prix){
    super.prix= prix;
  }


  public void setOrigine(String origine){
  super.Origine=origine;
  }
  public String toString(){
      return "Cérise " + Origine + " a " + prix + " euros";
  }
  public String getName() {
    return "Cerise";
  }

  public static void main (String[] args){
      //Ecrire ici vos tests
  Cerise  o= new Cerise();
  o.setPrix(22);
  o.setOrigine("CONGO");
  Cerise  P= new Cerise(22,"CONGO");

  System.out.println(o.toString());
  System.out.println(P.toString());
    System.out.println(P.equals(o));
  }
}
