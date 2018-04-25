
public interface Iplayer {
	
	public enum type {Humain, IA}
	
	public String GetNom();
	public type GetType(); 
	public int GetNbVictoires();
	public void AjouterVictoire();
	public void JouerTour();

}
