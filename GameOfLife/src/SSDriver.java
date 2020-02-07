import java.util.Scanner;

/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSDriver
 */
public class SSDriver {

	public static int day;

	public static void main(String args[]) {
		Scanner Stringsc = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		SSGameOfLife game = new SSGameOfLife(errorCheck("Enter a integer for the number of rows: ", sc), errorCheck("Enter a integer for the number of cols: ", sc));
		String userInput = "";
		day = 0;

		do {
			game.initilaize(errorCheck("Enter row of live cell: ", sc, game.getArr().length), errorCheck("Enter col for live cell: ", sc, game.getArr()[0].length));
		}while(errorCheckString("Do you want to add more live cells", Stringsc).equalsIgnoreCase("y"));

		do {
			System.out.println("Day: " + day);

			if(day > 0){
				game.playGame();
				for(int i = 0; i < game.getArr().length; i++) {
					for(int j = 0; j  < game.getArr()[i].length; j++) {
						System.out.print(game.getArr()[i][j]);
					}
					System.out.println();
				}
			}else {
				for(int row = 0; row < game.getArr().length; row++) {
					for(int col = 0; col  <game.getArr()[row].length; col++) {
						System.out.print(game.getArr()[row][col]);
					}
					System.out.println();
				}
			}
			day++;
		}while(game.getAmountAlive() > 0 && (errorCheckString("Do you want to see the next day (y/n)", Stringsc)).equalsIgnoreCase("y"));
		System.out.println("Everyone Died!");
	}

	/**
	 * checks for wrong input to a promt
	 * @param promt - the promt the program wants to ask the user
	 * @param in - a scanner object that is used to check the user input
	 * @return - an int that is checked for the wrong input to a promt
	 */
	public static String errorCheckString(String promt, Scanner in) {
		String str;
		do {
			System.out.println(promt);
			while (!in.hasNextLine()){
				System.out.println("That was not an String! Try again.");
				in.next();
			}
			str = in.nextLine();
			if(!(str.equalsIgnoreCase("y")) && !(str.equalsIgnoreCase("n"))) {
				System.out.println("Please enter y or n");
			}
		}while(!(str.equalsIgnoreCase("y")) && !(str.equalsIgnoreCase("n")));
		return str;
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

	/**
	 * checks for wrong input to a promt
	 * @param promt - the promt the program wants to ask the user
	 * @param in - a scanner object that is used to check the user input
	 * @return - an string that is checked for the wrong input to a promt
	 */
	public static int errorCheck(String promt, Scanner in, int max) {
		int userNum;
		do {
			System.out.println(promt);
			while (!in.hasNextInt()){
				System.out.println("That was not an int! Try again.");
				in.next();
			}
			userNum = in.nextInt();
			if(userNum  >= max) {
				System.out.println("that is out of the range!");
			}
			if(userNum  < 0) {
				System.out.println("You can't enter an negative!");
			}
		}while(userNum < 0 || userNum >= max);
		return userNum;
	}

}
