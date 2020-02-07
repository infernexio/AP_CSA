import java.util.Scanner;
/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSGameOfLife
 */
public class SSGameOfLife {
	private String[][] arr;
	private String[][] nums;

	public static final String DEAD_CELL = "0";
	public static final String ALIVE_CELL = "X";

	/**
	 * sets the inizital state for the class
	 */
	public SSGameOfLife(int demention, int demenition2) {
		this.arr = new String[demention][demenition2];
		this.nums = new String[demention][demenition2];

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = DEAD_CELL;
				nums[i][j] = DEAD_CELL;
			}
		}
	}

	/**
	 * set the cell alive
	 * @param row - the given row
	 * @param col - the given col
	 */
	public void initilaize(int row, int col) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i == row && j == col) {
					arr[i][j] = ALIVE_CELL;
					nums[i][j] = ALIVE_CELL;
				}
			}
		}
	}

	/**
	 * initializes it when doing the game loop
	 */
	public void initilaize() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == ALIVE_CELL) {
					nums[i][j] = ALIVE_CELL;
				}else {
					nums[i][j] = DEAD_CELL;
				}
			}
		}
	}

	/**
	 * get the amount of live cells
	 * @return - get the total amount of live cells
	 */
	public int getAmountAlive(){
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == ALIVE_CELL) {
					count++;
				}
			}
		}
		return count;
	}


	/**
	 * get the neighbors for the given space
	 * @param row - the given row
	 * @param col - the given col
	 * @return - the amount of neighbors 0 if none exist
	 */
	public int getNeighbors(int row, int col, String[][] a) {
		int count = 0;
		//checks down
		if(isValid(row+1, col, a)&& ALIVE_CELL == nums[row+1][col]) {
			count++;
		}
		//checks to the down and right
		if(isValid(row+1, col+1, a) &&  ALIVE_CELL == nums[row+1][col+1]) {
			count++;
		}
		//checks to the down and left
		if(isValid(row+1, col-1,a) && ALIVE_CELL == nums[row+1][col-1]) {
			count++;
		}
		//checks to the up 
		if(isValid(row-1, col,a) &&  ALIVE_CELL == nums[row-1][col]) {
			count++;
		}
		//checks to the up and right
		if(isValid(row-1, col+1,a) &&  ALIVE_CELL == nums[row-1][col+1]) {
			count++;
		}
		//checks to the up and left
		if(isValid(row-1, col-1,a) &&  ALIVE_CELL == nums[row-1][col-1]) {
			count++;
		}
		//checks to the right
		if(isValid(row, col+1,a)&&  ALIVE_CELL == nums[row][col+1]) {
			count++;
		}
		//checks to the left
		if(isValid(row,col-1,a) && ALIVE_CELL == nums[row][col-1]) {
			count++;
		}
		return count;
	}

	/**
	 * return if the cell is alive or not
	 * @param row - the given row
	 * @param col - the given col
	 * @return - true if the cell is alive false otherwise
	 */
	public boolean isAlive(int row, int col, String[][] a) {
		if(a[row][col].equalsIgnoreCase(ALIVE_CELL)) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * gets the the point and checks if its valid
	 * @param row -  the given row
	 * @param col - the given col
	 * @return - true if the locatoin is valid, false otherwise
	 */
	public boolean isValid(int row, int col, String[][] a) {
		if((row < a.length && row >= 0) && (col < a[0].length && col >= 0)) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * plays the game main method uses this in its loop
	 */
	public void playGame() {
		if(SSDriver.day != 1) {
			initilaize();	
		}
		for(int row = 0; row < nums.length; row++) {
			for(int col = 0; col  < nums[row].length; col++) {
				if(isAlive(row, col, nums)) {
					if(getNeighbors(row, col, nums) == 2 || getNeighbors(row, col, nums) == 3) {
						arr[row][col] = SSGameOfLife.ALIVE_CELL;
					}else {
						arr[row][col] = SSGameOfLife.DEAD_CELL;
					}
				}else if(!isAlive(row, col, nums)) {
					if(getNeighbors(row, col, nums) == 3) {
						arr[row][col] = SSGameOfLife.ALIVE_CELL;
					}else {
						arr[row][col] = SSGameOfLife.DEAD_CELL;
					}
				}
			}
		}
	}

	/**
	 * returns the arr
	 * @return - the arr
	 */
	public String[][] getArr() {
		return arr;
	}
}
