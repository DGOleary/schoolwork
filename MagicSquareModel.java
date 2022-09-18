import java.util.Arrays;
import java.util.HashSet;

/**
 * The MagicSquareModel class allows an NxN square to be created, and to test if
 * that square is magic, normal magic, or neither. In addition, it has methods
 * that allow for modification of the square.
 * 
 * @author Darby Oleary
 * @date 9/18/2022
 * @version 1.0
 */

public class MagicSquareModel extends SquareModel {

	// data to store the size of the square
	int size = 0;

	// the array of integers that represents the square
	Integer[][] squareMod;

	public MagicSquareModel(int size) {
		setSize(size);
		this.size = size;
	}

	/**
	 * Tests if a square is a magic square, which is a square that sums to the same
	 * value in every row, column, and main diagonal
	 * 
	 * @return boolean a boolean value with true corresponding to a magic square and
	 *         false not being magic
	 */
	public boolean isMagic() {
		// tests if the list is valid before traversing it
		try {
			if (!(size > 0 && squareMod.length == squareMod[0].length)) {
				System.out.println("Square size error");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Square error");
			return false;
		}
		// integers to keep track of the values to compare to as it traverses
		Integer[] rowVal = new Integer[size];
		Arrays.fill(rowVal, 0);
		Integer diagRVal = 0, diagLVal = 0;
		Integer[] colVal = new Integer[size];
		Arrays.fill(colVal, 0);

		// function goes through the entire 2D array and updates the values
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// updates the array of counters in each spot
				if (squareMod[i][j] != null) {
					rowVal[i] += squareMod[i][j];
					colVal[j] += squareMod[i][j];
				}
			}
			// updates the diagonal value counters
			if (squareMod[i][i] != null) {
				diagRVal += squareMod[i][i];
			}
			if (squareMod[i][size - 1 - i] != null) {
				diagLVal += squareMod[i][size - 1 - i];
			}
		}

		// returns true if all values in the array are the same
		HashSet<Integer> arrayTest = new HashSet<>(Arrays.asList(rowVal));
		if (arrayTest.size() > 1) {
			return false;
		}
		// if colVal has any different values or the diagonals are different it returns
		// false
		return Arrays.equals(rowVal, colVal) && diagRVal == diagLVal && rowVal[0] == diagRVal;
	}

	/**
	 * Performs the same tests as isMagic, but in addition it must also use every
	 * number from 1 to n^2 once
	 * 
	 * @return boolean boolean a boolean value with true corresponding to a normal
	 *         magic square and false not being normal magic
	 */
	public boolean isNormalMagic() {
		// tests if the list is valid before traversing it
		try {
			if (!(size > 0 && squareMod.length == squareMod[0].length)) {
				System.out.println("Square size error");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Square error");
			return false;
		}
		// integers to keep track of the values to compare to as it traverses
		Integer[] rowVal = new Integer[size];
		Arrays.fill(rowVal, 0);
		Integer diagRVal = 0, diagLVal = 0;
		Integer[] colVal = new Integer[size];
		Arrays.fill(colVal, 0);

		// array that keeps track of the numbers used
		int[] valCount = new int[size * size];

		// function goes through the entire 2D array and updates the values
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// updates the array of counters in each spot
				if (squareMod[i][j] != null) {
					rowVal[i] += squareMod[i][j];
					colVal[j] += squareMod[i][j];
				}
				// returns false if the number isn't between 1 and size^2, if not updates
				// counter
				try {
					valCount[squareMod[i][j] - 1]++;
				} catch (Exception e) {
					return false;
				}
			}
			// updates the diagonal value counters
			if (squareMod[i][i] != null) {
				diagRVal += squareMod[i][i];
			}
			if (squareMod[i][size - 1 - i] != null) {
				diagLVal += squareMod[i][size - 1 - i];
			}

		}

		// returns false if any number appears more or less than one time
		for (int x : valCount) {
			if (x != 1) {
				return false;
			}
		}

		// returns true if all values in the array are the same
		HashSet<Integer> arrayTest = new HashSet<>(Arrays.asList(rowVal));
		if (arrayTest.size() > 1) {
			return false;
		}
		// if colVal has any different values or the diagonals are different it returns
		// false
		return Arrays.equals(rowVal, colVal) && diagRVal == diagLVal && rowVal[0] == diagRVal;
	}

	/**
	 * Returns a string giving the current magical state of the square
	 * 
	 * @return String The state of the array
	 */
	@Override
	public String getFeedback() {
		if (isNormalMagic()) {
			return "Normal Magic";
		} else if (isMagic()) {
			return "Magic";
		} else {
			return "Mundane";
		}
	}

	/**
	 * A function used to resize the square
	 * 
	 * @param size An int value that is to be the new NxN size of the square
	 */
	@Override
	public void setSize(int size) {
		squareMod = new Integer[size][size];
		this.size = size;
	}

	/**
	 * Returns the size of each row or column of the square
	 * 
	 * @return int An int value giving the size of the square
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Returns the title of the program
	 * 
	 * @return String The title of the program
	 */
	@Override
	public String getTitle() {
		return "Magic Squares";
	}

	/**
	 * Clears the square's values to null
	 */
	@Override
	public void clear() {
		squareMod = new Integer[size][size];
	}

	/**
	 * A method that returns the value at a specific point in the square, and if
	 * given and invalid value returns the phrase "Out of bounds"
	 * 
	 * @param row An int value of the row of the value being searched for
	 * @param col An int value of the column of the value being searched for
	 * @return String The value at the given spot or an error message if the spot is
	 *         out of bounds
	 */
	@Override
	public String getValueAt(int row, int col) {
		// checks for out of bounds errors and returns a message if so, if not displays
		// value
		if (row >= size || col >= size) {
			return "Out of bounds";
		} else {
			return "" + squareMod[row][col];
		}
	}

	/**
	 * A method that sets the value at the spot given to the supplied value, if out
	 * of bounds or an invalid String it changes nothing, and if given an empty
	 * String the value is set to null
	 * 
	 * @param data The integer to change the value to, or an empty string if it is
	 *             to be set to null
	 * @param row  An int value of the row of the value being searched for
	 * @param col  An int value of the column of the value being searched for
	 */
	@Override
	public void setValueAt(String data, int row, int col) {
		// if the input is not an integer in the form of a string it catches the error
		// and does not change the value, or if it is out of bounds
		try {
			if (row >= size || col >= size) {
				return;
			} else {
				if (data == "") {
					squareMod[row][col] = null;
				} else {
					squareMod[row][col] = Integer.parseInt(data);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	/**
	 * 
	 * This toString method returns the array as a square, starting from the top
	 * with the array at index 0
	 * 
	 * @return String The array as an NxN square
	 */
	public String toString() {
		// temporary string to store the values
		String temp = "";
		// loops through every value and adds it to the string to be returned, and
		// formats it with a line break to look like a square
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp += squareMod[i][j];
			}
			temp += "\n";
		}
		return temp;
	}

}