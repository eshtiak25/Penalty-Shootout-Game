public class Goal { 
        public static boolean suddenDeath = false;
    static void getBoardGoal(String[] poin1, String[] poin2, String team1, String team2) {
		System.out.println();
		if (suddenDeath == true) {
			System.out.println("              +---------------------+-----+-----+-----+-----+-----+");
			System.out.println("              | " + team1 + " |  "+poin1[2]+"  |  "+poin1[4]+"  |  "+poin1[6]+"  |  "+poin1[8]+"  |  "+poin1[10]+"  |");
			System.out.println("              +---------------------+-----+-----+-----+-----+-----+");
			System.out.println("              | " + team2 + " |  "+poin2[1]+"  |  "+poin2[3]+"  |  "+poin2[5]+"  |  "+poin2[7]+"  |  "+poin2[9]+"   |");
			System.out.println("              +---------------------+-----+-----+-----+-----+-----+");
		}
		else {
			System.out.println("              +---------------------+-----+-----+-----+-----+-----+");
			System.out.println("              | " + team1 + " |  "+poin1[1]+"  |  "+poin1[3]+"  |  "+poin1[5]+"  |  "+poin1[7]+"  |  "+poin1[9]+"   |");
			System.out.println("              +---------------------+-----+-----+-----+-----+-----+");
			System.out.println("              | " + team2 + " |  "+poin2[2]+"  |  "+poin2[4]+"  |  "+poin2[6]+"  |  "+poin2[8]+"  |  "+poin2[10]+"  |");
			System.out.println("              +---------------------+-----+-----+-----+-----+-----+");
		}
	}

    static void getGoalStatus(int keeper, int shooter, String[] poin1, String[] poin2, String team1, String team2) {
		if (keeper != shooter) {
			System.out.println("			***GOAL***				");
	 
			Goal.getBoardGoal(poin1, poin2, team1, team2);
		}
		else {
			System.out.println("			***SAVE***				");
			
			Goal.getBoardGoal(poin1, poin2, team1, team2);
		}
	}
}
