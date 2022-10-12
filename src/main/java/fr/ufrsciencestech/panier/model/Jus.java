package fr.ufrsciencestech.panier.model;

/**
 *
 * @author roudet
 */
public class Jus implements Fruit{
    private Fruit f;
    public double prix;
    public String Origine;

    public Jus(Fruit f) {
        this.setF(f);
        this.setPrix(f.getPrix());
    }

    public boolean isSeedless(){
      return false;
    }  //predicat indiquant si le fruit a ou non des pepins
    public void setPrix(double prix){
      this.prix=prix;
    }
    public double getPrix(){
return this.prix;

    };      //prix unitaire du fruit (en euros)
    public String getOrigine(){
      return this.Origine;
    };   //pays d'origine du fruit
    //@Override
    public boolean equals(Object o){
      if(o != null && getClass() == o.getClass()){
          Jus or = (Jus) o;
          return (prix == or.prix && Origine.equals(or.Origine));
      }
      return false;
    }  //predicat pour tester si 2 fruits sont equivalents
  //  @Override
    public String toString(){
        return "Jus" + Origine + " a " + prix + " euros";
    }    //affichage d'un fruit

    public String getName() {
        return "Jus";
    }

    public Fruit getF() {
        return f;
    }

    public void setF(Fruit f) {
        this.f = f;
    }
}
