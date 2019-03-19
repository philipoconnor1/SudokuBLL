package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import pkgHelper.LatinSquare;

public class SudokuTest {

	@Test
	public void getRegion_test1() throws Exception {
		int[][] sud = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,3,4,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,4,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9}};
		Sudoku SD = new Sudoku(sud);
		LatinSquare LS = new LatinSquare(sud);
		int [] ExpectedRegion = {6,7,8,1,9,5,3,4,2};
		int [] Row = SD.getRegion(1);

		assertTrue(Arrays.equals(ExpectedRegion, Row));
	}
	
	@Test
	public void getRegion_test2() throws Exception {
		int[][] MySquare = { { 1, 2, 3, 4}, { 4, 3, 1, 2 }, { 2, 1, 4, 3 }, {3, 4, 2, 1} };
		Sudoku SD = new Sudoku(MySquare);
		int [] ExpectedRegion = {4,3,2,1};
		int [] Row = SD.getRegion(3, 3);
		
		assertTrue(Arrays.equals(ExpectedRegion, Row));
		System.out.print(Row);
	}
	
	@Test(expected = Exception.class)
	public void getRegion_test3() throws Exception {
		int[][] arr = {{ 1, 2, 3, 4}, { 4, 3, 1, 2 }, { 2, 1, 4, 3 }, {3, 4, 2, 1}};
		Sudoku SD = new Sudoku(arr);
		int[] regions = null;
		regions = SD.getRegion(5);
		System.out.println(Arrays.toString(regions));
	}
	
	@Test(expected = Exception.class)
	public void constructor_test1() throws Exception {

		Sudoku SD = new Sudoku(5);
	}
	
	@Test
	public void constructor_test2() throws Exception {

		Sudoku SD = new Sudoku(4);	
	}
	
	@Test
	public void isSudoku_test1() throws Exception {
		int[][] sud = {{1,5,2,4,8,9,3,7,6},{7,3,9,2,5,6,8,4,1},{4,6,8,3,7,1,2,9,5},{3,8,7,1,2,4,6,5,9},
				{5,9,1,7,6,3,4,2,8},{2,4,6,8,9,5,7,1,3},{9,1,4,6,3,7,5,8,2},{6,2,5,9,4,8,1,3,7},
				{8,7,3,5,1,2,9,6,4}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isSudoku();
		
		assertTrue(sdActual);
	}
	
	@Test
	public void isSudoku_test2() throws Exception {
		int[][] sud = {{1,5,5,4,8,9,3,7,6},{7,3,9,2,5,6,8,4,1},{4,6,8,3,7,1,2,9,5},{3,8,7,1,2,4,6,5,9},
				{5,9,1,7,6,3,4,2,8},{2,4,6,8,9,5,7,1,3},{9,1,4,6,3,7,5,8,2},{6,2,5,9,4,8,1,3,7},
				{8,7,3,5,1,2,9,6,4}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isSudoku();
		
		assertFalse(sdActual);
	}
	
	@Test
	public void isSudoku_test3() throws Exception {
		int[][] sud = {{1,5,0,4,8,9,3,7,6},{7,3,9,2,5,6,8,4,1},{4,6,8,3,7,1,2,9,5},{3,8,7,1,2,4,6,5,9},
				{5,9,1,7,6,3,4,2,8},{2,4,6,8,9,5,7,1,3},{9,1,4,6,3,7,5,8,2},{6,2,5,9,4,8,1,3,7},
				{8,7,3,5,1,2,9,6,4}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isSudoku();
		
		assertFalse(sdActual);
	}
	
	@Test
	public void isPartialSudoku_test1() throws Exception {
		int[][] sud = {{1,5,0,4,8,9,3,7,6},{7,3,9,2,5,6,8,4,1},{4,6,8,3,7,1,2,9,5},{3,8,7,1,2,4,6,5,9},
				{5,9,1,7,6,3,4,2,8},{2,4,6,8,9,5,7,1,3},{9,1,4,6,3,7,5,8,2},{6,2,5,9,4,8,1,3,7},
				{8,7,3,5,1,2,9,6,4}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isPartialSudoku();
		
		assertTrue(sdActual);
	}
	
	@Test
	public void isPartialSudoku_test2() throws Exception {
		int[][] sud = {{1,5,2,4,8,9,3,7,6},{7,3,9,2,5,6,8,4,1},{4,6,8,3,7,1,2,9,5},{3,8,7,1,2,4,6,5,9},
				{5,9,1,7,6,3,4,2,8},{2,4,6,8,9,5,7,1,3},{9,1,4,6,3,7,5,8,2},{6,2,5,9,4,8,1,3,7},
				{8,7,3,5,1,2,9,6,4}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isPartialSudoku();
		
		assertFalse(sdActual);
	}
	
	@Test
	public void isPartialSudoku_test3() throws Exception {
		int[][] sud = {{1,5,0,4,8,3,3,7,6},{7,3,9,2,5,6,8,4,1},{4,6,8,3,7,1,2,9,5},{3,8,7,1,2,4,6,5,9},
				{5,9,1,7,6,3,4,2,8},{2,4,6,8,9,5,7,1,3},{9,1,4,6,3,7,5,8,2},{6,2,5,9,4,8,1,3,7},
				{8,7,3,5,1,2,9,6,4}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isPartialSudoku();
		
		assertFalse(sdActual);
	}
	
	@Test
	public void isValueValid_test1() throws Exception {
		int[][] sud = {{1,5,0,4,8,9,3,7,6},{7,3,9,2,5,6,8,4,1},{4,6,8,3,7,1,2,9,5},{3,8,7,1,2,4,6,5,9},
				{5,9,1,7,6,3,4,2,8},{2,4,6,8,9,5,7,1,3},{9,1,4,6,3,7,5,8,2},{6,2,5,9,4,8,1,3,7},
				{8,7,3,5,1,2,9,6,4}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isValueValid(2,2,0);
		
		assertTrue(sdActual);
	}
	
	@Test
	public void isValueValid_test2() throws Exception {
		int[][] sud = {{ 1, 2, 0, 0}, { 4, 3, 1, 2 }, { 2, 1, 4, 3 }, {3, 4, 2, 1}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isValueValid(2,1,1);
		
		assertFalse(sdActual);
	}
	
	@Test
	public void isValueValid_test3() throws Exception {
		int[][] sud = {{ 1, 2, 0, 0}, { 0, 3, 1, 2 }, { 2, 1, 4, 3 }, {3, 4, 2, 1}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isValueValid(2,0,1);
		
		assertFalse(sdActual);
	}
	
	@Test
	public void isValueValid_test4() throws Exception {
		int[][] sud = {{ 1, 2, 0, 4}, { 4, 3, 1, 2 }, { 2, 1, 4, 3 }, {3, 4, 2, 1}};
		Sudoku SD = new Sudoku(sud);
		boolean sdActual = SD.isValueValid(8,2,0);
		
		assertFalse(sdActual);
	}

	
}
