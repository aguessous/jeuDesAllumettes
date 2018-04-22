
import java.util.Scanner;

public class JeuAllumette {

	private static int nbAllumettes = 16;
	private static Scanner clavier = new Scanner (System.in);

	public static void main(String[] args) {
	
		JeuAllumette maPartie = new JeuAllumette();
		maPartie.run();	
	}
	
	public void run() {
		
		System.out.println("Jeu des allumettes");
		boolean finPartie = false;
		int numJoueur = 1;
		while(!finPartie) {
		jouer(numJoueur);
		numJoueur=changerJoueur(numJoueur);
		if(nbAllumettes<=0) finPartie=true;
		}
		afficherGagnant(numJoueur);
	}
	
	protected int choixMax () {
		int max = 0;
		if (nbAllumettes>=3) max = 3;
		else if (nbAllumettes==2) max = 2;
		else if (nbAllumettes==1) max = 1;
		return max;	
	}
	
	protected void jouer (int numJoueur) {
		System.out.println("Il reste "+nbAllumettes+" allumettes");
		System.out.println("Joueur #"+numJoueur+" : Combien d’allumettes prenez-vous?");
		int choix = 0;
		try {
		choix = clavier.nextInt();
		while(choix<1 || choix>choixMax()) {
		if(choixMax()==1) System.out.println("Erreur : Vous devez prendre 1 allumette"); 
		else System.out.println("Erreur : Vous devez prendre entre 1 et "+choixMax()+" allumettes");
		System.out.println("Joueur #"+numJoueur+" : Combien d’allumettes prenez-vous?");
		choix = clavier.nextInt();
		}
		nbAllumettes -=choix;
		}
		catch (Exception e) {
			System.out.println("Erreur : merci de saisir un nombre");
			clavier.next();
			jouer(numJoueur);}
		}

	
	protected int changerJoueur(int numJoueur) {
		if (numJoueur ==1) numJoueur = 2;
		else numJoueur =1;
		return numJoueur;
	}
	
	protected void afficherGagnant(int numJoueur) {
		System.out.println("Gagnant : Joueur #"+numJoueur);
	}
}
