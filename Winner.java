import java.util.Scanner;

public class Winner {
    
    static void getWinner(int score1, int score2, String team1, String team2) {
		System.out.print("\n\n\n");
		System.out.println("\t                           Full Team:");
		System.out.println("\t                           +---+---+        ");
		System.out.println("\t                           | "+score1+" | "+score2+" |");
		System.out.println("\t                           +---+---+        ");
		System.out.println("\t");
		System.out.println("\t 					********WINNER******* 						");
		
		if (score1 > score2) 
			System.out.println("                              "+team1);
		else
			System.out.println("                              "+team2);
	}
}
