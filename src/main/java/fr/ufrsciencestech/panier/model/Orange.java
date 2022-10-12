package fr.ufrsciencestech.panier.model;

/**
 *
 * @author roudet
 */
public class Orange extends FruitSimple {
	
    public Orange() 
    {
        this.prix = 0.5;  //prix en euros
        this.Origine="Espagne";
    }
    
    public Orange(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.Origine = "Espagne";  //Espagne par défaut
	else
            this.Origine = origine;
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return Origine;
    }
 
    public void setOrigine(String origine){
	this.Origine=origine;
    }

    @Override
    public String toString(){
        return "Orange de " + Origine + " a " + prix + " euros";
    }

    public String getName() {
        return "Orange";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Orange or = (Orange) o;
            return (prix == or.prix && Origine.equals(or.Origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }

/**
 * Fonction main qui fait des choses
 * @param args les arguments
 */
    public static void main (String[] args){
        Orange or1 = new Orange(2.0,"France");
		System.out.println(or1.equals(new Orange(2.0,"France")));
		System.out.println(or1.getPrix()==2.0);
		System.out.println(or1.getOrigine()=="France");
		System.out.println("premier test Orange");
   }
}
