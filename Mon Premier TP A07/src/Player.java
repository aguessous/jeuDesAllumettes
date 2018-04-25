import java.io.Serializable;

public abstract class Player implements Iplayer, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7930502725586055244L;
	private String nom;
	private type type;
	private int nbVictoire;
	
	
	public Player(String nom) {
		super();
		this.nom = nom;
	}

	public String GetNom() {
		return nom;
		
	}
	public type GetType() {
		return type;
		
	}
	public int GetNbVictoires() {
		return nbVictoire;
		
	}
	public void AjouterVictoire(int add1) {
		this.nbVictoire += add1;
	}
	
	public abstract byte JouerTour(int max); // pour Humain

	public abstract byte JouerTour(int max,int nbAllumettes); // pour IA
	 
	
	
}
