import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner clavier = new Scanner(System.in);
		int x = 0;
		boolean saisieCorrecte = false;
		while (!saisieCorrecte) {
		try {
		System.out.println("entrer un nombre");
		x = clavier.nextInt();
		saisieCorrecte=true;
		}
		catch(Exception e) {System.out.println("erreur");
		clavier.next();}
		}
		
		System.out.println("nombre :"+x);	
	}
}
