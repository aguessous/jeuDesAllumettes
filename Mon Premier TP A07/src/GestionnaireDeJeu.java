
public class GestionnaireDeJeu implements Iplayer{

	protected int nbAllumettes=16;
	//String winner = null;
	
	@Override
	public String GetNom() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public type GetType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetNbVictoires() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void AjouterVictoire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void JouerTour() {
		// TODO Auto-generated method stub
		
	}

		
	public String JouerPartie(Humain joueur1,IA joueur2) {	
		
		String winner = null;
		System.out.println("Jeu des allumettes");
		boolean finPartie = false;
		while(!finPartie) {
		System.out.println("Il reste "+nbAllumettes+" allumettes");
		System.out.println("Joueur #"+joueur1.GetNom()+" : Combien d’allumettes prenez-vous?");
		nbAllumettes -=joueur1.JouerTour(choixMax());
		if(nbAllumettes==0) {winner=joueur2.GetNom();}
		if(nbAllumettes>0) {
		System.out.println("Il reste "+nbAllumettes+" allumettes");
		System.out.println("Joueur #"+joueur2.GetNom()+" : Combien d’allumettes prenez-vous?");
		int nb = nbAllumettes;
		nbAllumettes -=joueur2.JouerTour(choixMax(),nbAllumettes);
		if(nbAllumettes==0) {winner=joueur1.GetNom();}
		System.out.println(nb-nbAllumettes);}
		if(nbAllumettes==0) {finPartie=true;}
		}
		return winner;
		
	}

	protected String changerJoueur(String joueur) {
		if (joueur =="joueur1") joueur = "joueur2";
		else joueur ="joueur1";
		return joueur;
	}
	protected int choixMax () {
		int max = 0;
		if (nbAllumettes>=3) max = 3;
		else if (nbAllumettes==2) max = 2;
		else if (nbAllumettes==1) max = 1;
		return max;	
	}

	protected void afficherGagnant(String winner) {
		System.out.println("Gagnant : Joueur #"+winner);
		
		
	}

	public void afficherScore(Humain joueur1, IA joueur2) {
		System.out.println("nombre de victoires pour le joueur "+joueur1.GetType()+" : "+joueur1.GetNom()+" est : "+joueur1.GetNbVictoires());
		System.out.println("nombre de victoires pour le joueur "+joueur2.GetType()+" : "+joueur2.GetNom()+" est : "+joueur2.GetNbVictoires());
		
	}

	public void ajouterVictoire(Humain joueur1, IA joueur2, String winner) {
		if (joueur1.GetNom() == winner) joueur1.AjouterVictoire(1);
		else joueur2.AjouterVictoire(1);
	}

	

	
	
}
