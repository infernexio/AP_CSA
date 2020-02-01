/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSGame
 */
public class SSGame {
	private int[][] arr;
	int numThrow;

	/**
	 * sets the inizital state for the class
	 * 
	 */
	public SSGame(int[][] arr, int numThrow) {
		this.arr = arr;
		this.numThrow = numThrow;
	}

	/**
	 * gets the total of the arr
	 * @return - the total of the arr
	 */
	public int getTotal() {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++){
				sum += arr[i][j];
			}
		}
		return sum;
	}
	
	/**
	 * resets the array to a given array
	 * @param arr - the given array that the player wants to reset the array to 
	 */
	public void reset(int[][] arr) {
		this.arr = arr;
	}

	/**
	 * set the a three random places as zero
	 */
	public void throwPennies() {
		for(int i = numThrow; i > 0; i--) {
			int row = (int) (Math.random() * arr[0].length);
			int col = (int) (Math.random() * arr.length);
			do {
			row = (int) (Math.random() * arr[0].length);
			col = (int) (Math.random() * arr.length);	
			arr[row][col] = 0;
			}while(arr[row][col] != 0);
		}	
	}	

	/**
	 * returns the arr
	 * @return - the arr
	 */
	public int[][] getArr() {
		return arr;
	}

}
