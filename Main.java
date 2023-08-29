import java.util.*;
import java.io.*;

class Main {

	public static Scanner sc = new Scanner(System.in);
	public static Console console = System.console();
	public static Random rn = new Random();
	public static String t[] = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
	public static boolean suddenDeath = false;
    public static void main(String[] args) throws Exception {
    	System.out.println();                                                                                                   
		Utility.clearScreen();

		int menu = 5;
		int statusMenu = 0;
		do { // while (statusMenu!=0);
			Utility.clearScreen();

			System.out.print("\n\n\n\n\n");
			System.out.println("                    ****PENALTY SHOOTOUT GAME****               ");

			System.out.println("\n\t          +---------+---+                          ");
			System.out.println("\t            | Start   | 1 |                          ");
			System.out.println("\t            +---------+---+                          ");
			System.out.println("\t            |   Help  | 2 |                          ");
			System.out.println("\t            +---------+---+             			  ");
			System.out.println("\t            |  Exit   | 0 |             			  ");
			System.out.println("\t            +---------+---+            			     ");

			menu = Utility.checkInput(menu);

			System.out.println();

			statusMenu = 0;
			switch (menu) {
				case 1:
					String team1, team2, statusInput="Wrong";
					String teamList[] = {"                   ","     BASHUNDHARA FC      ","    ABAHANI LTD    ","  MOHAMEDAN SC ","  AFC UTTARA   ","   ARAMBAGH KS   "};
					String poin1[] = {""," "," "," "," "," "," "," "," "," "," "," "}, poin2[] = {""," "," "," "," "," "," "," "," "," "," "," "};
					int level = 0, player = 0, turn = 0, swap = 0, score1 = 0, score2 = 0, keeper, shooter, idteam1 = 0, idteam2 = 0, Pointt=1;
					char [] hide;

					Utility.clearScreen();
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
					System.out.println("\t\t\t\t+--------------+---+");
					System.out.println("\t\t\t\t| Singleplayer | 1 |");
					System.out.println("\t\t\t\t+--------------+---+");
					System.out.println("\t\t\t\t| Multiplayer  | 2 |");
					System.out.println("\t\t\t\t+--------------+---+");
					do {
						System.out.print("\t\t\t\tEnter your choice: "); 
					    while (!sc.hasNextInt()) {
					        System.out.print("\t\t\t\t Select Again: ");
					        sc.next();
					    }
					    player = sc.nextInt();
					} while (player != 1 && player != 2);

					if (player == 1) {
						Utility.clearScreen();
						System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("\t\t\t\t+--------------+---+");
						System.out.println("\t\t\t\t|    Beginner  | 1 |");
						System.out.println("\t\t\t\t+--------------+---+");
						System.out.println("\t\t\t\t|    Pro Player| 2 |");
						System.out.println("\t\t\t\t+--------------+---+");						
						System.out.println("\t\t\t\t|  Top Player  | 3 |");
						System.out.println("\t\t\t\t+--------------+---+");										

						do {
							System.out.print("\t\t\t\tEnter your choice: "); 
						    while (!sc.hasNextInt()) {
						        System.out.print("\t\t\t\t Select Again: ");
						        sc.next(); 
						    }
						    level = sc.nextInt();
						} while (level < 1 || level > 3);
					}

					String daftarteam[] = {
						"BASHUNDHARA FC           ",
						"ABAHANI LTD              ",
						"MOHAMEDAN SC             ",
						"AFC UTTARA               ",
						"ARAMBAGH KS              "
					};

					Utility.clearScreen();
					System.out.print("\n\n\n");
					System.out.println("\t+----+--------------------- ");
					System.out.println("\t| NO |    Team name         |");
					System.out.println("\t+----+--------------------- ");
					for (int i=0; i<5; i++) {
						if (i<5)
							System.out.print("\t| " + (i+1) + " | ");
							System.out.print(daftarteam[i]  + " | ");
						System.out.println();
					}
					System.out.println("\t+----+---------------------+--");

					System.out.println("\n\t[Player 1] <-"); 
					System.out.println((player == 1) ? "\t[Computer]" : "\t[Player 2]");
					System.out.println("\t--------------------");
					do {
						idteam1 = Utility.checkInput(idteam1);
						if (idteam1>=1 && idteam1<=5)
							statusInput = "CORRECT";
						else {
							statusInput = "Wrong";
						}
					} while (statusInput=="Wrong");

					if (player == 1) {
						Utility.loader(idteam2, swap);
						idteam2 = rn.nextInt(4) + 1;
					}
					else {
						do {
							System.out.print("\n\t[Player 1]\n\t[Player 2] <-\n\t--------------------\n");
							idteam2 = Utility.checkInput(idteam2);
							if (idteam2>=1 && idteam2<=5)
								statusInput = "CORRECT";
							else {
								System.out.print("\n\tInput Wrong, Ulangi!");
								statusInput = "Wrong";
							}
						} while (statusInput=="Wrong");
					}

					sc.nextLine();
					Utility.clearScreen();
					System.out.print("\n\n\n");
					System.out.println("\t                                                    ");
					System.out.println("			+++++++START++++++    ");
					System.out.println("\t              [ENTER]");
					System.out.print("\t                                ");

					sc.nextLine();
					Utility.clearScreen();

					team1 = teamList[idteam1];
					team2 = teamList[idteam2];

					statusInput = "Wrong";
					do { //while (turn<10);						
						if (swap == 0) {
							do {
								shooter = Shooter.setShooter(idteam2, player, swap, score1, score2, team1, team2);
								statusInput = Point.setBall(shooter);
							} while (statusInput.equals("Wrong"));

							do { // while (statusInput.equals("Wrong"))
								keeper = Shooter.setKeeper(shooter, level, idteam2, player, swap, score1, score2, team1, team2);

								if (keeper >=1 && keeper <=9) {
									statusInput = "CORRECT";
									score1 = Utility.setscore(keeper, shooter, score1, score2, poin1, poin2, Pointt, swap);
									GoalDisplay(t, score1, score2, team1, team2, keeper);
								}
								else {
									statusInput = "Wrong";
								}
							} while (statusInput.equals("Wrong"));

							Goal.getGoalStatus(keeper, shooter, poin1, poin2, team1, team2);

							swap = 1;
							Point.pointReset();
							System.out.print("\n                       Press [ENTER] to continue"); 
							sc.nextLine();
							Utility.clearScreen();
						}

						else if (swap == 1) {
							do {
								shooter = Shooter.setShooter(idteam2, player, swap, score1, score2, team1, team2);
								statusInput = Point.setBall(shooter);

							} while (statusInput.equals("Wrong"));

							do {
								keeper = Shooter.setKeeper(shooter, level, idteam2, player, swap, score1, score2, team1, team2);

								if (keeper >=1 && keeper <=9) {
									statusInput = "CORRECT";
									score2 = Utility.setscore(keeper, shooter, score1, score2, poin1, poin2, Pointt, swap);
									GoalDisplay(t, score1, score2, team1, team2, keeper);
								}
								else {
									statusInput = "Wrong";
								}
							} while (statusInput.equals("Wrong"));

							Goal.getGoalStatus(keeper, shooter, poin1, poin2, team1, team2);

							swap = 0;
							Point.pointReset();
							System.out.print("\n                       Press [ENTER] to continue"); 
							sc.nextLine();
							Utility.clearScreen();
						}
						turn = turn + 1;
						Pointt = Pointt+1;

						if (turn==8 && (score1-score2)>=2) {
							break;
						}
						else if (turn==8 && (score2-score1)>=2) {
							break;
						}
					} while (turn<10);

					if (score1 > score2 || score1 < score2) {
						Winner.getWinner(score1, score2, team1, team2);
					}
					else {
						suddenDeath = true;
						int sd = 0; 
						do {
							System.out.print("\n\n\n\n\n");
							System.out.println("\t          DRAW RESULTS!");
							System.out.println("\t             score:");
							System.out.println("\t            +---+---+        ");
							System.out.println("\t     | "+score1+" | "+score2+" |");
							                                                    
							System.out.println("\t                         [ENTER]");

							sc.nextLine();
							Utility.clearScreen();

							for (int i=1; i<=10; i++) {
								poin1[i] = " ";
								poin2[i] = " ";
							}

							Pointt = 1;
							swap = 1;
							turn = 0;

							do {
								if (swap == 0) {
									do {
										shooter = Shooter.setShooter(idteam2, player, swap, score1, score2, team1, team2);
										statusInput = Point.setBall(shooter);

									} while (statusInput.equals("Wrong"));

									do {
										keeper = Shooter.setKeeper(shooter, level, idteam2, player, swap, score1, score2, team1, team2);

										if (keeper >=1 && keeper <=9) {
											statusInput = "CORRECT";
											score1 = Utility.setscore(keeper, shooter, score1, score2, poin1, poin2, Pointt, swap);
											GoalDisplay(t, score1, score2, team1, team2, keeper);
										}
										else {
											statusInput = "Wrong";
										}
									} while (statusInput.equals("Wrong"));

									Goal.getGoalStatus(keeper, shooter, poin1, poin2, team1, team2);

									swap = 1;
									Point.pointReset();
									System.out.print("\n                       Press [ENTER] to continue"); 
									sc.nextLine();
									Utility.clearScreen();
								}

								else if (swap == 1) {
									do {
										shooter = Shooter.setShooter(idteam2, player, swap, score1, score2, team1, team2);
										statusInput = Point.setBall(shooter);

									} while (statusInput.equals("Wrong"));

									do {
										keeper = Shooter.setKeeper(shooter, level, idteam2, player, swap, score1, score2, team1, team2);

										if (keeper >=1 && keeper <=9) {
											statusInput = "CORRECT";
											score2 = Utility.setscore(keeper, shooter, score1, score2, poin1, poin2, Pointt, swap);
											GoalDisplay(t, score1, score2, team1, team2, keeper);
										}
										else {
											statusInput = "Wrong";
										}
									} while (statusInput.equals("Wrong"));

									Goal.getGoalStatus(keeper, shooter, poin1, poin2, team1, team2);

									swap = 0;
									Point.pointReset();
									System.out.print("\n                       Press [ENTER] to continue"); 
									sc.nextLine();
									Utility.clearScreen();
								}
								
								Pointt = Pointt + 1;

								if ((turn%2)!=0 && (score1-score2)==1) {
									sd = 1;
									break;
								}
								else if ((turn%2)!=0 && (score2-score1)==1) {
									sd = 1;
									break;
								}
								turn = turn + 1;
							} while (turn<10);

						} while (sd==0);

						if (score1 > score2 || score1 < score2) {
							Winner.getWinner(score1, score2, team1, team2);
						}
					}
				break;
				case 2:
					Utility.clearScreen();
					System.out.print("\n\n\n");
					System.out.println("\t\t\t\t+---------+");
					System.out.println("\t\t\t\t| HELP! |");
					System.out.println("\t\t\t\t+---------+\n");
					System.out.println("\t\tThe minimum executor kicking is five people");
					System.out.println("\t\tand for minimum points is five, ");
					System.out.println("\t\tbut it could be less and could be more ");
					System.out.println("\t\tdepending on the score. ");
					System.out.println("\t\t");
					System.out.println("\t\t For example, if it comes to the fourth kicker ");
					System.out.println("\t\tthere is a difference of two points against the opposing team, ");
					System.out.println("\t\tthen the team with the highest score ");
					System.out.println("\t\twill automatically win the game. ");
					System.out.println("\t\tWhen it reaches the fifth singer stay on ");
					System.out.println("\t\tIf the position is equal then it will be done 'sudden death' ");
					System.out.println("\t\tmeaning every team that failed ");
					System.out.println("\t\twhile the other team managed to enter ");
					System.out.println("\t\tthen you can take the winner.\n");
					statusMenu = 1;
					System.out.print("\t\t[ENTER] ");
					sc.nextLine();
					sc.nextLine();
				break;
				case 0:
					Utility.clearScreen();
					System.exit(0);
					statusMenu = 0;
				break;
				default:
					System.out.print("\tWrong Input, press [ENTER] ");
					statusMenu = 1;
					sc.nextLine();
					sc.nextLine();
			}
		} while (statusMenu!=0); 
	}


	static void getLeaderboard(int score1, int score2, String team1, String team2) {
		System.out.print("\n");
		System.out.println("           +---------------------||-----------||---------------------+        ");
		System.out.println("           | " + team1 + " || [" + score1 + "] - [" + score2 + "] || " + team2 + " |");
	}

	
	static void GoalDisplay(String[] t, int score1, int score2, String team1, String team2, int keeper) {
		getLeaderboard(score1, score2, team1, team2);

		switch (keeper) {
			case 1:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"G                           "+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                       | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                       | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |     "+t[4]+"                             "+t[5]+"                            "+t[6]+"     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[7]+"                            "+t[8]+"                            "+t[9]+"     | |");
				System.out.println("   | |                                                                     | |");
				break;
			case 2:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                           G"+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[4]+"                            "+t[5]+"                            "+t[6]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[7]+"                            "+t[8]+"                             "+t[9]+"     | |");
				System.out.println("   | |                                                                     | |");
				break;
			case 3:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                            "+t[2]+"                           G"+t[3]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |     "+t[4]+"                            "+t[5]+"                            "+t[6]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[7]+"                            "+t[8]+"                            "+t[9]+"     | |");
				System.out.println("   | |                                                                     | |");
				break;
			case 4:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                            "+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[4]+"G                           "+t[5]+"                            "+t[6]+"     | |");
				System.out.println("   | |                                                                       | |");
				System.out.println("   | |                                                                       | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |     "+t[7]+"                             "+t[8]+"                             "+t[9]+"    | |");
				System.out.println("   | |                                                                      | |");
				break;
			case 5:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                            "+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[4]+"                          G("+t[5]+")                           "+t[6]+"     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |     "+t[7]+"                            "+t[8]+"                             "+t[9]+"     | |");
				System.out.println("   | |                                                                      | |");
				break;
			case 6:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                            "+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[4]+"                            "+t[5]+"                           G"+t[6]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |     "+t[7]+"                            "+t[8]+"                            "+t[9]+"     | |");
				System.out.println("   | |                                                                     | |");
				break;
			case 7:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                            "+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[4]+"                            "+t[5]+"                            "+t[6]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                       | |");
				System.out.println("   | |                                                                       | |");
				System.out.println("   | |     "+t[7]+"G                           "+t[8]+"                            "+t[9]+"     | |");
				System.out.println("   | |                                                                     | |");
				break;
			case 8:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                            "+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[4]+"                            "+t[5]+"                            "+t[6]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |     "+t[7]+"                          G("+t[8]+")                           "+t[9]+"     | |");
				System.out.println("   | |                                                                      | |");
				break;
			case 9:
				System.out.println("    _______|_____________________||___________||_____________________|_______ ");
				System.out.println("   |  _____________________________________________________________________  |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[1]+"                            "+t[2]+"                            "+t[3]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |     "+t[4]+"                            "+t[5]+"                            "+t[6]+"     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                     | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |                                                                      | |");
				System.out.println("   | |     "+t[7]+"                            "+t[8]+"                           G"+t[9]+"     | |");
				System.out.println("   | |                                                                     | |");
				break;
		}
	}
}