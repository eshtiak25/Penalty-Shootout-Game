import java.io.Console;
import java.util.Random;

public class Shooter {


    public static Console console = System.console();
	public static Random rn = new Random();


    static int setShooter(int idteam2, int player, int Swap, int score1, int score2, String team1, String team2) throws Exception {
		Utility.clearScreen();
		Point.getGoalPoint(score1, score2, team1, team2);
		if (Swap == 0) {
			if (player == 2) {
				System.out.println("\n\n   [Player 1] <-\n   [Player 2]");
			}
			else {
				System.out.println("\n\n   [Player 1] <-\n   [Computer]");
			}
		}
		else {
			if (player == 2) {
				System.out.println("\n\n   [Player 1]\n   [Player 2] <-");
			}
			else {
				System.out.println("\n\n   [Player 1]\n   [Computer] <-");
			}
		}

		if (Swap == 1 && player == 1) {
			Utility.loader(idteam2, Swap);
			Utility.clearScreen();
			int shooter = rn.nextInt(9) + 1;
			return shooter;
		}
		else {
			char[] hide = console.readPassword("\n   [SHOOTER] >> Enter the kick point: ");
			if (hide.length > 0) {
				Utility.clearScreen();
				int shooter = Character.getNumericValue(hide[hide.length - 1]);
				return shooter;
			}
			else
				return 0;
		}
	}

    static int setKeeperAi(int shooter, int level) {
		String chance = "";
		char point;

		if (level == 1)
			chance = "123456789";
		else if (level == 2) {
			if (shooter == 1)
				chance = "12345678";
			else if (shooter == 2)
				chance = "12345679";
			else if (shooter == 3)
				chance = "12345689";
			else if (shooter == 4)
				chance = "12345789";
			else if (shooter == 5 || shooter == 8)
				chance = "13456789";
			else if (shooter == 6)
				chance = "12356789";
			else if (shooter == 7)
				chance = "12456789";
			else if (shooter == 9)
				chance = "23456789";
		}
		else if (level == 3) {
			if (shooter == 1 || shooter == 4 || shooter == 7)
				chance = "124578";
			else if (shooter == 2)
				chance = "123456";
			else if (shooter == 3 || shooter == 6 || shooter == 9)
				chance = "235689";
			else if (shooter == 5 || shooter == 8)
				chance = "456789";
		}
		int index = rn.nextInt(chance.length());
	    point = chance.charAt(index);
	    
		return Character.getNumericValue(point);
	}

    static int setKeeper(int shooter, int level, int idteam2, int player, int swap, int score1, int score2, String team1, String team2) throws Exception {
		Utility.clearScreen();
		Point.getGoalPoint(score1, score2, team1, team2);
		if (swap == 0) {
			if (player == 2) {
				System.out.println("\n\n   [Player 1]\n   [Player 2] <-");
			}
			else {
				System.out.println("\n\n   [Player 1]\n   [Computer] <-");
			}
		}
		else {
			if (player == 2) {
				System.out.println("\n\n   [Player 1] <-\n   [Player 2]");
			}
			else {
				System.out.println("\n\n   [Player 1] <-\n   [Computer]");
			}
		}

		if (swap == 0 && player == 1) {
			Utility.loader(idteam2, swap);
			Utility.clearScreen();
			int keeper = setKeeperAi(shooter, level);
			return keeper;
		}
		else {
			char[] hide = console.readPassword("\n    [KEEPER] >> Enter the kick point: ");
			if (hide.length > 0) {
				Utility.clearScreen();
				int keeper = Character.getNumericValue(hide[hide.length - 1]);
				return keeper;
			}
			else
				return 0;
		}
	}
}
