

/**
 *
 * @author roudet
 */
public  class  FruitSimple implements Fruit{
    public double prix;
    public String Origine;
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
          FruitSimple or = (FruitSimple) o;
          return (prix == or.prix && Origine.equals(or.Origine));
      }
      return false;
    }  //predicat pour tester si 2 fruits sont equivalents
  //  @Override
    public String toString(){
        return "Fruit Simple d'origine " + Origine + " a " + prix + " euros";
    }    //affichage d'un fruit
}
