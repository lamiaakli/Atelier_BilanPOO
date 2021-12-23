package Atelier4POO_Bilan;

public class Humain extends Personnage{
	private int nbDeplacements =0;
	private int niveau;
	
	public Humain(String nom, int age) {
		super(nom,age);
		this.niveau =1;
		
	}
	public void deplacer(int destination, int gain) {
		super.deplacer(gain, destination);
		nbDeplacements++;
		if(nbDeplacements == 4 || nbDeplacements == 6)
			niveau++;
		
		
	}
	
	public int positionSouhaiter() {
		position += niveau*nbDeplacements;
		return position;
		
	}
	public String toString() {
		String message = "Humain Jean";
		return message;
	}
}
