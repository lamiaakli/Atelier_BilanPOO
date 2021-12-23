package Atelier4POO_Bilan;

public class Obstacle {
	private int penalite; 
	
	
	public Obstacle(int penalite) 
	{
		this.penalite = penalite;
		
	}
	public int getPenalite() 
	{
		return penalite;
	}
    public String toString()
    {
    	String message ="Nombre de point :" +penalite;
    	return message;
    }
}
