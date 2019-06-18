import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class CountingSortTester {

    /**
     * Array that will be properly sorted with CountingSort.naiveCountingSort
     **/
    public static int[] nonNegative = {9, 5, 2, 1, 5, 3, 0, 3, 1, 1};

    /**
     * Array that will cause CountingSort.naiveCountingSort to fail, but CountingSort.betterCountingSort can handle
     **/
    public static int[] someNegative = {9, 5, -4, 2, 1, -2, 5, 3, 0, -2, 3, 1, 1};
    
    public static void assertIsSorted(int[] a) {
    	int previous = Integer.MIN_VALUE;
    	for (int x : a) {
    		assertTrue(x >= previous);
    		previous = x;
    	}
    }

	@Test
	public void testNaiveWithNonNegative() {
		int[] sortedNonNegative = CountingSort.naiveCountingSort(nonNegative);
		assertIsSorted(sortedNonNegative);
	}

	@Test
	public void testNaiveWithSomeNegative() {
		try {
			int[] sortedSomeNegative = CountingSort.naiveCountingSort(someNegative);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Great! Exception happened as we expected, since this sort is broken for negative numbers.");
		}
	}

	@Test
	public void testBetterWithNonNegative() {
//		System.out.println("Unsorted: " + Arrays.toString(nonNegative));
		int[] sortedNonNegative = CountingSort.betterCountingSort(nonNegative);
//		System.out.println("Sorted: " + Arrays.toString(sortedNonNegative));
		assertIsSorted(sortedNonNegative);
	}

	@Test
	public void testBetterWithSomeNegative() {
//		System.out.println("UnsortedSomeNegative: " + Arrays.toString(someNegative));
		int[] sortedSomeNegative = CountingSort.betterCountingSort(someNegative);
//		System.out.println("SortedSomeNegative: " + Arrays.toString(sortedSomeNegative));
		assertIsSorted(sortedSomeNegative);
	}


    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", CountingSortTester.class);
    }	
} 
