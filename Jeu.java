package Atelier4POO_Bilan;

import java.util.ArrayList;
import java.util.Random;
public class Jeu {
	
	private String titre;
	private final int NBJOUEURMAX= 6;
	private final int NBCASES = 50;
	private ArrayList<Joueur> listeJoueurs;
	
	private Case[] tab;
	private int nbEtapes;
	private int nbObstacles;
	private int scoreMax;
	
	public Jeu (String titre, int nbEtapes, int nbObstacles) {
		this.titre = titre;
		this.nbEtapes = nbEtapes;
		this.nbObstacles = nbObstacles;
		this.listeJoueurs = new ArrayList <Joueur>();
		tab = new Case [NBCASES];
		
	}
public void ajouterJoueur(Joueur j) {
	listeJoueurs.add(j);
	
}
public ArrayList <Personnage> tousLesPersos() 
{
	Joueur j = null;
	ArrayList <Personnage> pretour = new ArrayList <Personnage>();
	ArrayList <Personnage> per = null;
	//parcourir la liste des joueurs
	for (int i=0; i<listeJoueurs.size();i++) {
		
		j =listeJoueurs.get(i); // Recupere un joueur
		per = j.getlistePersos(); //recupere la liste des personnages du joueurs
		
		//parcourir la liste des personnage et ajoute a pretour
		 for(int a= 0; a <per.size();a++) {
			 
			 pretour.add(per.get(a));
		 }
	}
	return pretour;
}

private void initialiserCases() {
	Random rand = new Random();
	int nbr = 0;
	int compteurObstacle =0;
	//parcourir le nombre de case
	for(int i=0 ; i < NBCASES;i++ )
	{
		nbr = rand.nextInt(NBCASES)+1;
		// si multiple de 5 alors on cree un obstacle pour la case
		if(nbr % 5 == 0 && compteurObstacle < nbObstacles) 
		{
			Obstacle ob = new Obstacle(2*nbr);
			tab[i] = new Case (ob,ob.getPenalite()); //instancier case
			
		}else {
			tab[i] = new Case (nbr);//instancier case sans obstacles
		}
		
		
	}
}
public void lancerJeu() {
	initialiserCases();
	ArrayList <Personnage> list = tousLesPersos(); //appel de la fonction de tt les perso
	boolean flag = false;
	int compteurCase =0;
	for (int i=0; i<list.size(); i++) {
		flag = true;
		while (flag) {
			if(tab[compteurCase].sansObstacle()) {
				flag = false;
				tab[compteurCase].placerPersonnage(list.get(i));
			}
			
			compteurCase++;
			
		}
	}
	

for (int i = 0; i<nbEtapes; i++) {
	for (Personnage personnage : list) {
		int positionV = personnage.positionSouhaiter();
		if (positionV>50) {
			positionV =49;
			if(!tab[positionV].estLibre())
			{
				positionV--;
			}
			if(tab[positionV].estLibre())
			{
				personnage.deplacer(positionV, tab[positionV].getGain());
			}
			else if(!tab[positionV].sansObstacle()){
				personnage.penaliser(tab[positionV].getPenalite());
				
			}
			else {
				personnage.penaliser(tab[positionV].getGain());
			}
			
		}
		
	}
	
	afficherCases();
	}
}

public void afficherCases()
{
    for(int i =0;i<this.NBCASES;i++)
    {
        System.out.println(tab[i]);
    }
}
public void afficherParticipants() {
	System.out.println("LISTE DES JOUEURS");
	for (Joueur j : listeJoueurs) {
		System.out.println("------------------------");
		System.out.println(j);
		
	}
}

public void afficherResultats() {
this.afficherParticipants();
System.out.println("JEU "+this.titre);
System.out.println("--------");
Joueur j=null;
for(int i=0;i<listeJoueurs.size()-1;i++)
{
if((listeJoueurs.get(i)).getNbPoint()<(listeJoueurs.get(i+1)).getNbPoint())
j=listeJoueurs.get(i+1);
else
j=listeJoueurs.get(i);
}
System.out.println("Le gagnant est "+j.getNom()+" avec "+j.getNbPoint()+" points ");
if(j.getNbPoint()>scoreMax) 
{
System.out.println("Record battu : Ancien score maximum "+scoreMax);
scoreMax=j.getNbPoint();
}}}


