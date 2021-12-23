package Atelier4POO_Bilan;

import java.util.ArrayList;

public class Joueur {
   
	private String nom;
	private String code;
	private int numero;
	private static int nbJoueurs;
	private int nbPoints = 0;
	private ArrayList<Personnage> listePersos;
	
	public Joueur(String nom) {
		nbJoueurs++;
	 
		this.nom = nom;
		this.code = "J" + nbJoueurs;
		listePersos = new ArrayList <Personnage>();
		
	}
	
	public ArrayList <Personnage> getlistePersos(){
		return listePersos;
	}
	public void ajouterPersonnage(Personnage p) {
		
		listePersos.add(p);
		p.setProprietaire(this);
	
	}
	public void modifierPoints(int nb) {
		nbPoints += nb;
	}
	public boolean peutJouer() {
		boolean result = false;
		if(listePersos.isEmpty()) result = false; {
			return result;
				}
	}
	public static int getNbJoueur() {
		return nbJoueurs;
	}
	 public int getNbPoint() {
	        return nbPoints;
	    }
	   public String getNom() {
	        return nom;
	    }
	public String toString() {
		String message = code +" " +nom + "("+nbPoints+"Points) aucun personnage";
		if(peutJouer())
			message = code +"" +nom+ "("+nbPoints+" Points) "+" avec"+String.valueOf(listePersos.size())+"personnage(s)";
		return message;

			
	}
}
