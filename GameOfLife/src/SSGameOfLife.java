import java.util.Scanner;
/**
 * @author - Sohail Shaik
 * @Date - Jan 31,2019
 * @Assignment - SSGameOfLife
 */
public class SSGameOfLife {
	private boolean isAlive;
	private String[][] arr;
	
	public static final String DEAD_CELL = "0";
	public static final String ALIVE_CELL = "X";
	
	/**
	 * sets the inizital state for the class
	 */
	public SSGameOfLife(int demention, int demenition2) {
		this.arr = new String[demention][demenition2];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = DEAD_CELL;
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
				}
			}
		}
	}
	

	/**
	 * get the neighbors for the given space
	 * @param row - the given row
	 * @param col - the given col
	 * @return - the amount of neighbors 0 if none exist
	 */
	public int getNeighbors(int row, int col) {
		int count = 0;
		int i = row;
		int j = col;
				if(!(i++ > arr.length) &&  arr[i][j] == arr[i+1][j]) {
					count++;
				}
				if((!(i++ > arr.length) && !(j++ > arr[i].length)) &&  arr[i][j] == arr[i+1][j+1]) {
					count++;
				}
				if((!(i++ > arr.length) && !(j-- > arr[i].length)) &&  arr[i][j] == arr[i+1][j-1]) {
					count++;
				}
				if(!(i-- > arr.length) &&  arr[i][j] == arr[i-1][j]) {
					count++;
				}
				if((!(i-- > arr.length) && !(j++ > arr[i].length)) &&  arr[i][j] == arr[i-1][j+1]) {
					count++;
				}
				if((!(i-- > arr.length) && !(j-- > arr[i].length)) &&  arr[i][j] == arr[i-1][j-1]) {
					count++;
				}
				if(!(j++ > arr[i].length) &&  arr[i][j] == arr[i][j+1]) {
					count++;
				}
				if(!(j-- > arr[i].length) &&  arr[i][j] == arr[i][j-1]) {
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
	public boolean isAlive(int row, int col) {
		if(arr[row][col].equalsIgnoreCase(ALIVE_CELL)) {
			return true;
		}else {
			return false;
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
