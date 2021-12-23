package Atelier4POO_Bilan;

public abstract class Personnage {
	private String nom;
	private int age;
	protected int position;
	private Joueur proprietaire;
	
	public Personnage (String nom, int age) {
		this.age =age;
		this.nom = nom;
		
	}
	
	public void deplacer(int gain, int destination) {
		position = destination ;
		proprietaire.modifierPoints(gain);
		
	}
	 public void setProprietaire(Joueur proprietaire) {
	        this.proprietaire = proprietaire;
	    }
	public void penaliser (int penalite) {
		penalite = penalite*-1;
		proprietaire.modifierPoints(penalite);
	}
	public int getPosition() {
		return position;
	}
	public String toString() {
		String message =" Nom du personnage :" +nom;
		return message;
	}
public abstract int positionSouhaiter();
}
