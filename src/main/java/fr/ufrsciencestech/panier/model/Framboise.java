package fr.ufrsciencestech.panier.model;

/**
 *
 * @author roudet
 */
public class Framboise implements Fruit {
    private double prix;
    private String origine;
	
    public Framboise() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Framboise(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Framboise de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 framboises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Framboise or = (Framboise) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une framboise a des pepins
        return false;
    }


    /**
     * Fonction main qui fait des trucs
     * @author Loïs
     * @param args les arguments
     */
    public static void main (String[] args){
        Framboise or1 = new Framboise(2.0,"France");
		System.out.println(or1.equals(new Framboise(2.0,"France")));
		System.out.println(or1.getPrix()==2.0);
		System.out.println(or1.getOrigine()=="France");
		System.out.println("premier test Framboise");
   }
}
