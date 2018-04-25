import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		char reponse;
		
		
		Humain joueur1 = deSerialiserJoueur1();
		
		
		//Humain joueur1 = deSerialiserJoueur1();

		//Humain joueur1 = new Humain("luke");
		
		//IA joueur2 = new IA("C3POO");
		
		IA joueur2 = deSerialiserJoueur2();
		
		boolean finPartie = false;
		do{
		GestionnaireDeJeu maPartie = new GestionnaireDeJeu();
		String winner = maPartie.JouerPartie(joueur1,joueur2);
		maPartie.afficherGagnant(winner);
		maPartie.ajouterVictoire(joueur1,joueur2,winner);
		maPartie.afficherScore(joueur1,joueur2);
		
		
		do {
		System.out.println("Voulez vous rejouer O/N");
		reponse = clavier.next().charAt(0);;
		}while(reponse != 'o' && reponse != 'O' && reponse !='n' && reponse != 'N');
		if(reponse == 'N' || reponse == 'n') {finPartie=true;}
		}while(!finPartie); 
		clavier.close();
		
		serialiserJoueur1(joueur1);
		serialiserJoueur2(joueur2);
		
	}

	public static Humain deSerialiserJoueur1() {

	    Humain retour = null;  
		try {
	         FileInputStream fileIn = new FileInputStream("luke.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Humain joueur1 = (Humain) in.readObject();
	         System.out.println("mon objet ressucite est : "+joueur1.GetNom());
	         retour = joueur1;
	         in.close();
//	         fileIn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	        
	      }
			
			return retour;	
	}
	
	
	public static IA deSerialiserJoueur2() {

	    IA retour = null;  
		try {
	         FileInputStream fileIn = new FileInputStream("C3P00.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         IA joueur2 = (IA) in.readObject();
	         System.out.println("mon objet ressucite est : "+joueur2.GetNom());
	         retour = joueur2;
	         in.close();
//	         fileIn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return retour;	
	}
	
	public static void serialiserJoueur1(Humain joueur1) {
		try {
	         FileOutputStream fileOut = new FileOutputStream("luke.txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(joueur1);
	         out.close();
	         //fileOut.close();
	         System.out.println("Serialized data is saved in luke.txt");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

	public static void serialiserJoueur2(IA joueur2) {
		try {
	         FileOutputStream fileOut = new FileOutputStream("C3P00.txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(joueur2);
	         out.close();
	         //fileOut.close();
	         System.out.println("Serialized data is saved in C3P00.txt");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

}
