/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSGame
 */
public class SSGame {
	private int[][] arr;
	private int sum;

	/**
	 * sets the inizital state for the class
	 * 
	 */
	public SSGame(int[][] arr) {
		this.arr = arr;
		this.sum = 0;

		int sum = 0;
		int row = (int) (Math.random() * arr.length);
		int col = (int) (Math.random() * arr[0].length);

		do {
			while (arr[row][col] == 0) {
				row = (int) (Math.random() * arr[0].length);
				col = (int) (Math.random() * arr.length);
			}
			arr[row][col] = 0;
			sum++;
		} while (sum < 12);
	}
	
	/**
	 * sets the inizital state for the class
	 * 
	 */
	public SSGame(int errorCheck, int errorCheck2) {
		arr = new int[errorCheck][errorCheck2];
		
		this.createBoard();
	}
	
	
	/**
	 * helps set thie board to the user num
	 */
	private void createBoard() {
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				arr[row][col] += 1;
			}
		}
	}

	/**
	 * gets the total of the arr
	 * 
	 * @return - the total of the arr
	 */
	public int getTotal() {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	/**
	 * resets the array to a given array
	 * 
	 * @param arr - the given array that the player wants to reset the array to
	 */
	public void reset(int[][] arr) {
		this.arr = arr;
		
		int row = (int) (Math.random() * arr.length);
		int col = (int) (Math.random() * arr[0].length);

		do {
			while (arr[row][col] == 0) {
				row = (int) (Math.random() * arr[0].length);
				col = (int) (Math.random() * arr.length);
			}
			arr[row][col] = 0;
			sum++;
		} while (sum < 12);
	}
	
	/**
	 * the sum of the number removed for the grid
	 * @return - the sum of the number removed for the grid
	 */
	public int sum() {
		return this.sum;
	}

	/**
	 * set the a three random places as zero
	 */
	public void throwPennies() {
		int row = (int) (Math.random() * arr.length);
		int col = (int) (Math.random() * arr[0].length);
		do {
			while (arr[row][col] == -1) {
				row = (int) (Math.random() * arr[0].length);
				col = (int) (Math.random() * arr.length);
			}
			this.sum = arr[row][col];
			arr[row][col] = -1;
		} while (arr[row][col] != -1);
	}

	/**
	 * returns the arr
	 * 
	 * @return - the arr
	 */
	public int[][] getArr() {
		return arr;
	}

}