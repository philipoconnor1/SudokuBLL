package pkgHelper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LatinSquareTest {
	
	@Test
	public void ContainsZero_Test1() {
		int[][] puzzle = {{1,2,3}, {2,0,1}, {3,1,2}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = true;
		boolean bActual = ls.ContainsZero();

		assertEquals(bExpected, bActual);
	}
	@Test
	public void ContainsZero_Test2() {
		int[][] puzzle = {{1,2,3}, {2,3,1}, {3,1,2}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = false;
		boolean bActual = ls.ContainsZero();

		assertEquals(bExpected, bActual);
	}
	@Test
	public void doesElementExist_Test1() {

		int[] arr = { 1, 2, 3, 4, 5 };
		int iValue = 5;
		boolean bExpected = true;
		boolean bActual = LatinSquare.doesElementExist​(arr, iValue);

		assertEquals(bExpected, bActual);
	}
	@Test
	public void doesElementExist_Test2() {

		int[] arr = { 1, 2, 3, 4, 5 };
		int iValue = 8;
		boolean bExpected = false;
		boolean bActual = LatinSquare.doesElementExist​(arr, iValue);

		assertEquals(bExpected, bActual);
	}
	@Test
	public void hasAllValues_Test1() {

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 3, 5 };
		boolean bExpected = true;
		boolean bActual = LatinSquare.hasAllValues​(arr1, arr2);

		assertEquals(bExpected, bActual);
	}
	@Test
	public void hasAllValues_Test2() {

		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 3, 6 };
		boolean bExpected = false;
		boolean bActual = LatinSquare.hasAllValues​(arr1, arr2);

		assertEquals(bExpected, bActual);
	}
	@Test
	public void getRow_Test() {

		int iRow = 1;
		int[][] puzzle = {{5,6,7}, {2,3,1}, {4,8,1}};
		LatinSquare ls = new LatinSquare(puzzle);
		int[] bExpected = {2,3,1};
		int[] bActual = ls.getRow​(iRow);

		assertEquals(true, Arrays.equals(bExpected, bActual));
	}
	@Test
	public void getColumn_Test() {

		int iCol = 1;
		int[][] puzzle = {{7,2,1}, {9,6,4}, {2,8,5}};
		LatinSquare ls = new LatinSquare(puzzle);
		int[] bExpected = {2,6,8};
		int[] bActual = ls.getColumn​(iCol);

		assertEquals(true, Arrays.equals(bExpected, bActual));
	}
	@Test
	public void hasDuplicates_Test1() {

		int[] arr = { 6, 2, 5, 9, 5 };
		boolean bExpected = true;
		boolean bActual = LatinSquare.hasDuplicates​(arr);

		assertEquals(bExpected, bActual);
	}
	@Test
	public void hasDuplicates_Test2() {

		int[] arr = { 6, 2, 4, 9, 5 };
		boolean bExpected = false;
		boolean bActual = LatinSquare.hasDuplicates​(arr);

		assertEquals(bExpected, bActual);
	}
	@Test
	public void isLatinSquare_Test1() {
		
		int[][] puzzle = {{1,2,3}, {2,3,1}, {3,1,2}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = true;
		boolean bActual = ls.isLatinSquare();

		assertEquals(bExpected, bActual);
	}
	@Test
	public void isLatinSquare_Test2() {

		int[][] puzzle = {{7,1,7}, {9,6,4}, {2,8,5}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = false;
		boolean bActual = ls.isLatinSquare();

		assertEquals(bExpected, bActual);
	}
	@Test
	public void isLatinSquare_Test3() {

		int[][] puzzle = {{7,1,3}, {9,6,4}, {7,8,5}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = false;
		boolean bActual = ls.isLatinSquare();

		assertEquals(bExpected, bActual);
	}
	@Test
	public void isLatinSquare_Test4() {

		int[][] puzzle = {{7,1,3}, {9,6,4}, {2,8,5}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = false;
		boolean bActual = ls.isLatinSquare();

		assertEquals(bExpected, bActual);
	}
	@Test
	public void isLatinSquare_Test5() {

		int[][] puzzle = {{7,1,3}, {3,7,1}, {2,8,5}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = false;
		boolean bActual = ls.isLatinSquare();

		assertEquals(bExpected, bActual);
	}
}
