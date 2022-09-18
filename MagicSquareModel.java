import java.util.Arrays;
import java.util.HashSet;

public class MagicSquareModel extends SquareModel{

	int size=0;
	
	Integer[][] squareMod;
	public MagicSquareModel(int size) {
		setSize(size);
		this.size=size;
	}
	
	public boolean isMagic() {
		//tests if the list is valid before traversing it
		try {
		if(!(squareMod.length>0&&squareMod.length==squareMod[0].length)) {
			System.out.println("Square size error");
			return false;
		}
		}catch (Exception e){
			System.out.println("Square error");
			return false;
		}
		//integers to keep track of the values to compare to as it traverses
		Integer[] rowVal=new Integer[squareMod.length]; 
		Arrays.fill(rowVal,0);
		Integer diagRVal=0, diagLVal=0; 
		Integer[] colVal=new Integer[squareMod.length];
		Arrays.fill(colVal,0);
		
		//function goes through the entire 2D array and updates the values 
		for(int i=0;i<squareMod.length;i++) {
			for(int j=0;j<squareMod.length;j++) {
				//updates the array of counters in each spot
				if(squareMod[i][j]!=null) {
					rowVal[i]+=squareMod[i][j];
					colVal[j]+=squareMod[i][j];
					}
			}
			//updates the diagonal value counters
			if(squareMod[i][i]!=null) {
				diagRVal+=squareMod[i][i];
				}
				if(squareMod[i][squareMod.length-1-i]!=null) {
				diagLVal+=squareMod[i][squareMod.length-1-i];
				}
		}

		//returns true if all values in the array are the same
		HashSet<Integer> arrayTest= new HashSet<>(Arrays.asList(rowVal));
		if(arrayTest.size()>1) {
			return false;
		}
		//if colVal has any different values or the diagonals are different it returns false
		return Arrays.equals(rowVal,colVal)&&diagRVal==diagLVal&&rowVal[0]==diagRVal;
	}
	
	public boolean isNormalMagic() {
		//tests if the list is valid before traversing it
				try {
				if(!(squareMod.length>0&&squareMod.length==squareMod[0].length)) {
					System.out.println("Square size error");
					return false;
				}
				}catch (Exception e){
					System.out.println("Square error");
					return false;
				}
				//integers to keep track of the values to compare to as it traverses
				Integer[] rowVal=new Integer[squareMod.length]; 
				Arrays.fill(rowVal,0);
				Integer diagRVal=0, diagLVal=0; 
				Integer[] colVal=new Integer[squareMod.length];
				Arrays.fill(colVal,0);
				
				//array that keeps track of the numbers used
				int[] valCount= new int[squareMod.length*squareMod.length];
				
				//function goes through the entire 2D array and updates the values 
				for(int i=0;i<squareMod.length;i++) {
					for(int j=0;j<squareMod.length;j++) {
						//updates the array of counters in each spot
						if(squareMod[i][j]!=null) {
						rowVal[i]+=squareMod[i][j];
						colVal[j]+=squareMod[i][j];
						}
						//returns false if the number isn't between 1 and size^2, if not updates counter
						try {
							valCount[squareMod[i][j]-1]++;
						}catch (Exception e) {
							return false;
						}
					}
					//updates the diagonal value counters
					if(squareMod[i][i]!=null) {
					diagRVal+=squareMod[i][i];
					}
					if(squareMod[i][squareMod.length-1-i]!=null) {
					diagLVal+=squareMod[i][squareMod.length-1-i];
					}
					
				}
				
				//returns false if any number appears more or less than one time
				for(int x:valCount) {
					if (x!=1) {
						return false;
					}
				}
				
				//returns true if all values in the array are the same
				HashSet<Integer> arrayTest= new HashSet<>(Arrays.asList(rowVal));
				if(arrayTest.size()>1) {
					return false;
				}
				//if colVal has any different values or the diagonals are different it returns false
				return Arrays.equals(rowVal,colVal)&&diagRVal==diagLVal&&rowVal[0]==diagRVal;
	}
	
	@Override
	public String getFeedback() {
		if (isNormalMagic()) {
			return "Normal Magic";
		}else if (isMagic()) {
			return "Magic";
		}else {
			return "Mundane";
		}
	}

	@Override
	public void setSize(int size) {
		squareMod= new Integer[size][size];
	}

	@Override
	public int getSize() {
		return squareMod.length;
	}

	@Override
	public String getTitle() {
		return "Magic Squares";
	}

	@Override
	public void clear() {
		squareMod=new Integer[squareMod.length][squareMod.length];
	}

	@Override
	public String getValueAt(int row, int col) {
		//checks for out of bounds errors and returns a message if so, if not displays value 
		if(row>=squareMod.length||col>=squareMod.length) {
			return "Out of bounds";
		}else {
			return ""+squareMod[row][col];
		}
	}

	@Override
	public void setValueAt(String data, int row, int col) {
		//if the input is not an integer in the form of a string it catches the error and does not change the value, or if it is out of bounds
		try {
		if(row>=squareMod.length||col>=squareMod.length) {
			return;
		}else {
			if(data=="") {
				squareMod[row][col]=null;
			}else {
			squareMod[row][col]=Integer.parseInt(data);
			}
		}
		}catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

}
