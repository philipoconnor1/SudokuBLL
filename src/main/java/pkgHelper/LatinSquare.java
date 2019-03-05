package pkgHelper;
import java.util.Arrays;
public class LatinSquare {

	private int[][] LatinSquare;

	public LatinSquare() {
		super();
	}

	public LatinSquare(int[][] puzzle) {
		super();
		LatinSquare = puzzle;
	}
	
	public int[][] getLatinSquare() {
		return LatinSquare;
	}

	public void setLatinSquare(int[][] latinSquare) {
		LatinSquare = latinSquare;
	}

	public boolean ContainsZero() {
		for (int i = 0; i < LatinSquare.length; i++) {
			for (int j = 0; j < LatinSquare.length; j++) {
				if (LatinSquare[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean doesElementExist​(int[] arr, int iValue) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == iValue) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasAllValues​(int[] arr1, int[] arr2) {
		boolean hasAllValues_ = true;
		for (int i = 0; i < arr2.length; i++) {
			boolean bFound = false;
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j] == arr2[i]) {
					bFound = true;
					break;
				}
			}
			if (bFound == false) {
				hasAllValues_ = false; 
				break;
			}
		}
	return hasAllValues_;
	}
	
	public int[] getRow​(int iRow) {
		int[] returnrow = new int[(LatinSquare.length)];
		for(int i = 0; i < LatinSquare.length; i++) {
			returnrow[i] = LatinSquare[iRow][i];
		}
		return returnrow;
	}

	public int[] getColumn​(int iCol) {
		int[] returncolumn = new int[LatinSquare.length];
		for(int i = 0; i < LatinSquare.length; i++) {
			returncolumn[i] = LatinSquare[i][iCol];
		}
		return returncolumn;
	}
	
	
	public static boolean hasDuplicates​(int[] arr) {
		int[] arrCopy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arrCopy);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arrCopy[i] == arrCopy[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public boolean isLatinSquare() {
		for (int i = 0; i < LatinSquare.length; i++) {
			if (hasDuplicates​(getRow​(i)) == true || hasDuplicates​(getColumn​(i)) == true) {
				return false; 
			}
		}
		for (int i = 0; i < LatinSquare.length; i++) {
			if (hasAllValues​(getRow​(i), getRow​(0)) == false || hasAllValues​(getColumn​(i), getColumn​(0)) == false) {
				return false;
			}
		}
		return true; 
	}
}
