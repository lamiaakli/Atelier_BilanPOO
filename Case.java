package Atelier4POO_Bilan;



public class Case {
	private int gain;
	private Personnage personnage = null;
	private Obstacle obs = null;
	
	public Case(Obstacle obs, int gain) {
		this.gain = gain;
		this.obs = obs;
	}
	public Case(int gain) {
		this.gain=gain;
		
	}
	public int getPenalite() {
		int r=0;
		if(obs != null) {
			return obs.getPenalite();
		}
		return r;
		
		
	}
	  public int getGain() {
	        return gain;
	    }
	public void placerPersonnage(Personnage perso) 
	{
		personnage = perso;
	}
	
    public void placerObstacle(Obstacle obs)
    {
    	this.obs = obs;
    	
    }
    public void enleverPersonnage()
    {
    	personnage = null;
    }
    public boolean estLibre() {
    	return personnage == null && obs == null;
    	
    }
    public boolean sansObstacle() 
    {
    	return obs == null;
    }
    public boolean sansPerso() 
    {
    	return personnage == null;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String message = "Libre ("+ " gain =  "+ String.valueOf(gain) +")" ;
    	if (!sansObstacle())
    	{
    		message = "Obstacle" + "( penalite = "+String.valueOf(gain*-1)+") ";  
    	}
    	else if (!sansPerso())
    	{
    		
    		  message =personnage.toString() + "( penalite = "+String.valueOf(gain*-1)+" ) ";
    	        return message +"\n";
    	}
    	return message;
    }
}


