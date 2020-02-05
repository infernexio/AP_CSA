import java.util.Scanner;

/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSDriver
 */
public class SSDriver {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = { { 1, 1, 1, 1, 1 }, { 1, 2, 2, 2, 1 }, { 1, 2, 3, 2, 1 }, { 1, 2, 2, 2, 1 }, { 1, 1, 1, 1, 1 } };
		SSGame game = new SSGame(errorCheck("Please enter the grid size", sc), errorCheck("Please enter the grid size", sc));
		int money = 10;
		int total = game.getTotal();
		
		
		

		do {
			int num = 3;

			while (num > 0) {
				game.throwPennies();
				money--;
				for (int i = 0; i < game.getArr().length; i++) {
					for (int j = 0; j < game.getArr()[0].length; j++) {
						if (game.getArr()[i][j] == -1) {
							System.out.print("P");
						} else {
							System.out.print(game.getArr()[i][j]);
						}
					}
					System.out.println();
				}
				money += game.sum();
				System.out.println("Scores: " + (game.sum()));
				System.out.println("you have : " + money + "C" );
				num--;
			}

			System.out.print("Do you want to play again: ");
			int[][] nums = { { 1, 1, 1, 1, 1 }, { 1, 2, 2, 2, 1 }, { 1, 2, 3, 2, 1 }, { 1, 2, 2, 2, 1 },
					{ 1, 1, 1, 1, 1 } };
			game.reset(nums);
		} while (money > 0 && sc.nextLine().equalsIgnoreCase("Yes"));

		System.out.println("Thanks for Playing!");
		sc.close();
	}
	
	/**
	 * checks for wrong input to a promt
	 * @param promt - the promt the program wants to ask the user
	 * @param in - a scanner object that is used to check the user input
	 * @return - an int that is checked for the wrong input to a promt
	 */
	public static int errorCheck(String promt, Scanner in) {
		int userNum;
		do {
			System.out.println(promt);
			while (!in.hasNextInt()){
				System.out.println("That was not an int! Try again.");
				in.next();
			}
			userNum = in.nextInt();
			if(userNum  < 0) {
				System.out.println("You can't enter an negative!");
			}
		}while(userNum < 0);
		return userNum;
	}

}