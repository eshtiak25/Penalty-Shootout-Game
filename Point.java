import java.util.Scanner;


public class Point {

    public static String t[] = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};

    static void pointReset() {
		for (int i=1; i <= 9; i++) {
			t[i] = " ";
		}
	}

    static String setBall(int shooter) {
		if (shooter <=9 && shooter >=1) {
			for (int i = 1; i <= 9; i++) {
				if (shooter == i)
					t[i] = "*";
			}
		}
		if (shooter >= 1 && shooter <= 9) {
			return "Correct";
		}
		else {
			return "Out of Goal post";
		}
	}
    
    static void getLeaderboard(int score1, int score2, String team1, String team2) {
		System.out.print("\n");
		System.out.println("           +---------------------||-----------||---------------------+        ");
		System.out.println("           | " + team1 + " || [" + score1 + "] - [" + score2 + "] || " + team2 + " |");
	}

    
    static void getGoalPoint(int score1, int score2, String team1, String team2) {
		getLeaderboard(score1, score2, team1, team2);
		String[] numbers = {"[1]", "[2]", "[3]", "[4]", "[5]", "[6]", "[7]", "[8]", "[9]"};
	
		System.out.println("    _______|_____________________||___________||_____________________|_______ ");
		System.out.println("   |  _____________________________________________________________________  |");
	
		for (int i = 0; i < 3; i++) {
			System.out.print("   | |");
			for (int j = 0; j < 3; j++) {
				int index = i * 3 + j;
				System.out.print("    " + numbers[index] + "                          ");
			}
			System.out.print("  |\n");
			System.out.println("   | |                                                                     | |");
		}
	}

    
}
