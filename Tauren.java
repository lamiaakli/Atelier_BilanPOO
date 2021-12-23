package Atelier4POO_Bilan;


public class Tauren extends Personnage {
	
	private int taille;
	
	
   public Tauren(String nom, int age, int taille) {
	   super(nom, age);
	   this.taille = taille;
	   
   }


@Override
public int positionSouhaiter() {
	// TODO Auto-generated method stub
	
		   position = super.getPosition();
		   int min = 1;
		   int range = taille - min + 1;
		   int rand = (int)(Math.random() * range) + min;
		   return position + rand;
	   

}
public String toString() {
	String message ="Tauren Hector";
	return message;
}

}
