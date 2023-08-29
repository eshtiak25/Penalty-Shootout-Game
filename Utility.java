import java.util.Scanner;

class Utility {
    static Scanner sc = new Scanner(System.in);

    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    static int checkInput(int input) {
		
		do {
			System.out.print("\tEnter your choice: "); 
		    while (!sc.hasNextInt()) {
		        System.out.print("\t Repeat selection: ");
		        sc.next(); // must
		    }
		    input = sc.nextInt();
		    return input;
		} while (input <= ((input == 1) ? 1 : 0) && input >= ((input == 1) ? 5 : 2));
	}

    static void loader(int idteam2, int change) throws Exception {
		int c=0;
		boolean s=false;
		System.out.println();
		for (int x = 0; x < 30; x++) {
			if (idteam2 == 0)
				System.out.print("     ");
			System.out.print("   [");
			if (c==0)
				s=false;
			else if (c==10)
				s=true;

			if (s==false)
				c++;
			else
				c--;

			for (int i=0; i<11; i++) {
				if (i==c)
					System.out.print("*");
				else
					System.out.print("-");
			}
			System.out.print("] >> ");
			if (idteam2 == 0) 
				System.out.print("computer selects Team");
			else if (change == 1)
				System.out.print("The computer kicks in");
			else if (change == 0)
				System.out.print("The computer predicts the catch");
			Thread.sleep(05); //85
			System.out.print("\r");
		}
	}


    static int setscore(int keeper, int shooter, int score1, int score2, String[] poin1, String[] poin2, int Pointt, int swap) {
		if (swap == 0) {
			if (keeper != shooter) {
				score1 = score1 + 1;
				poin1[Pointt] = "o";
			}
			else if (keeper == shooter) {
				poin1[Pointt] = "x";
			}
			return score1;
		}
		else {
			if (keeper != shooter) {
				score2 = score2 + 1;
				poin2[Pointt] = "o";
			}
			else if (keeper == shooter) {
				poin2[Pointt] = "x";
			}
			return score2;
		}
	}

}