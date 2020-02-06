import java.util.Scanner;

/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSDriver
 */
public class SSDriver {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		SSGameOfLife game = new SSGameOfLife(errorCheck("Enter a integer for the number of rows: ", sc), errorCheck("Enter a integer for the number of cols: ", sc));
		
		do {
			game.initilaize(errorCheck("Enter row of live cell: ", sc), errorCheck("Enter col for live cell: ", sc));
			for(int row = 0; row < game.getArr().length; row++) {
				for(int col = 0; col  <game.getArr()[row].length; col++) {
					System.out.print(game.getArr()[row][col]);
				}
				System.out.println();
			}
		}while(errorCheckString("Do you want to see the next day (y/n)", sc).equalsIgnoreCase("y"));
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

}