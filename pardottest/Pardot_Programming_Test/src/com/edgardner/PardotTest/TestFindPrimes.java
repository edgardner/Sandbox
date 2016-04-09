package com.edgardner.PardotTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class TestFindPrimes {

	@Test
	public void testForOne() throws Exception {
		FindPrimes fp = new FindPrimes(1);
		int arraySize = fp.getPrimes().size();
		assertEquals(0, arraySize);
	}

	@Test
	public void testOnePrime() throws Exception {
		FindPrimes fp = new FindPrimes(2);
		int arraySize = fp.getPrimes().size();
		assertEquals(1, arraySize);
	}

	@Test
	public void checkForDupes() throws Exception {
		int errors = 0;
		for (int i = 1; i < 28; i++) {
			int checkBound = (int) Math.pow(2, i);
			FindPrimes fp = new FindPrimes(checkBound);
			List<Integer> checkList = fp.getPrimes();
			HashSet<Integer> checkSet = new HashSet<>(checkList);
			if (checkSet.size() != checkList.size()) {
				errors += 1;
			}
		}
		assertEquals(0, errors);
	}

	@Test(expected = Exception.class)
	public void checkLessThanOne() throws Exception {
		@SuppressWarnings("unused")
		FindPrimes fp = new FindPrimes(0);
	}

	@Test
	public void validatePrimeArray() throws Exception {
		int[] pa = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
				89, 97 };
		List<Integer> pl = new ArrayList<>();
		for (int prime : pa) {
			pl.add(prime);
		}

		FindPrimes fp = new FindPrimes(100);

		// See if array's are the same length
		assertEquals(pa.length, fp.getPrimes().size());

		// Check if each valid prime is in the output array.
		ArrayList<Integer> outputArray = fp.getPrimes();
		assert (outputArray.containsAll(pl));
	}

}
