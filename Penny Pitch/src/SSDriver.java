import java.util.Scanner;

/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSDriver
 */
public class SSDriver {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = {{1,1,1,1,1}, {1,2,2,2,1}, {1,2,3,2,1}, {1,2,2,2,1}, {1,1,1,1,1}};
		SSGame game = new SSGame(arr);
		int total  = game.getTotal();
		
		do {
			int[][] nums = {{1,1,1,1,1}, {1,2,2,2,1}, {1,2,3,2,1}, {1,2,2,2,1}, {1,1,1,1,1}};
			game.reset(nums);
			int num = 3;
			
			while(num > 0) {
			game.throwPennies();
			for(int i = 0; i < game.getArr().length; i++) {
				for(int j = 0; j < game.getArr()[0].length;j++) {
					if(game.getArr()[i][j] == 0) {
						System.out.print("P");
					}else {
					System.out.print(game.getArr()[i][j]);
					}
				}
				System.out.println();
			} 
			System.out.println("Scores: " + (total - game.getTotal()));
			num--;
			}
			
			System.out.print("Do you want to play again: ");
		}while(sc.nextLine().equalsIgnoreCase("Yes"));
		
		System.out.println("Thanks for Playing!");
		sc.close();
	}

}
