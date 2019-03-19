package pkgGame;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;

import pkgEnum.ePuzzleViolation;
import pkgHelper.LatinSquare;
import pkgHelper.PuzzleViolation;

public class Sudoku extends LatinSquare {
	
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku(int iSize) throws java.lang.Exception {
		this.iSize = iSize;
		if (Math.sqrt(iSize) % 1 == 0) {
			this.iSqrtSize = (int) Math.sqrt(iSize);
		}
	}
	
	public Sudoku(int[][] puzzle) throws java.lang.Exception {
		super.setLatinSquare(puzzle);
		this.iSize = puzzle.length;
		this.iSqrtSize = (int) Math.sqrt(puzzle.length);
	}
	
	protected int[][] getPuzzle() {
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int iRegionNbr) throws Exception {
		int[] newarray = new int[iSize];
		int count = 0;
		if((iRegionNbr+1) > iSize) {
			throw new Exception("Not a valid region.");
		}
		for(int iRow = (iRegionNbr/iSqrtSize)*iSqrtSize; iRow < ((iRegionNbr/iSqrtSize)*iSqrtSize) + iSqrtSize; iRow++) {
			for(int iCol = (iRegionNbr%iSqrtSize)*iSqrtSize; iCol < ((iRegionNbr%iSqrtSize)*iSqrtSize) + iSqrtSize; iCol++) {
				newarray[count++] = getPuzzle()[iRow][iCol]; 
			}
		}
		return newarray;
	}
	
	protected int[] getRegion(int Col, int Row) throws Exception {
		int i = (Col/iSqrtSize) + ((Row/iSqrtSize) * iSqrtSize);
		return getRegion(i);
	}
	
	@Override
	protected boolean hasDuplicates() throws Exception {
		
		super.hasDuplicates();
		
		for(int i = 0; i < iSize; i++) {
			if(hasDuplicates(getRegion(i)) == true) {
				AddPuzzleViolation​(new PuzzleViolation(ePuzzleViolation.DupRegion, 1));
			}
		}
		return (super.PuzzleViolationSize() > 0);
	}
	
	protected boolean isSudoku() throws Exception {
		super.setbIgnoreZero​(false);
		super.ClearPuzzleViolation();
		if(hasDuplicates() == true) {
			return false;
		} else {
			for(int i = 0; i < iSize - 1; i++) {
				if(super.hasAllValues(super.getRow(i), super.getRow(i + 1)) == false) {
					return false;
				}
			}
			return true;
		}
	}
	
	protected boolean isPartialSudoku() throws Exception {
		super.setbIgnoreZero​(true);
		super.ClearPuzzleViolation();
		if(hasDuplicates() == true) {
			return false;
		} else if(isSudoku() == true){
			return false;
		} else {
			return true;
		}
	}
	
	protected boolean isValueValid(int iValue, int Col, int Row) throws Exception {
		super.setbIgnoreZero​(true);
		int[][] puzzle = getPuzzle();
		if(puzzle[Row][Col] != 0) {
			return false;
		} else {
			if(ArrayUtils.contains(super.getRow(Row), iValue) == true) {
				return false;
			} else if (ArrayUtils.contains(super.getColumn(Col), iValue) == true) {
				return false;
			} else if (ArrayUtils.contains(getRegion(Col,Row), iValue) == true) {
				return false;
			} else if(iValue > iSize || iValue <= 0) {
				return false;
			}
		}
		return true;
	}
}