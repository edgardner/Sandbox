package com.edgardner.PardotTest;

import java.util.ArrayList;

/**
 * @author Ed Gardner
 *
 */

public class FindPrimes {

	private ArrayList<Integer> primes = new ArrayList<>();

	/**
	 * Initializes an ArrayList containing all primes less than the input value
	 * 
	 * @param upperBound
	 *            what is the upper bound (inclusive)for primes to find?
	 * @throws Exception
	 *             if upper bound is 0 or less or not an integer
	 */
	public FindPrimes(Integer upperBound) throws Exception {

		if (upperBound < 1) {
			throw new Exception("Bound must be at least 1");
		} else {
			boolean[] isNonPrime = new boolean[upperBound + 1];
			primeSieve(isNonPrime, upperBound, primes);
		}
	}

	/**
	 * Simple implementation of Prime Sieve. Per convention 1 is not considered
	 * a Prime and as such will not be in the output Array.
	 * 
	 * @param isNonPrime
	 *            Boolean Array to hold classification of Integers
	 * @param topVal
	 *            Upper bound of Prime List
	 * @param primes
	 *            Array to populate with Prime numbers.
	 */
	private static void primeSieve(boolean[] isNonPrime, int topVal, ArrayList<Integer> primes) {
		double sieveBound = Math.sqrt(topVal);
		for (int i = 2; i < sieveBound + 1; i++) {
			if (!isNonPrime[i]) {
				primes.add(i);
				int j = i;
				while ((j + i) <= topVal) {
					isNonPrime[(j + i)] = true;
					j += i;
				}
			}
		}
		for (int i = (int) Math.ceil(sieveBound) + 1; i <= topVal; i++) {
			if (!isNonPrime[i]) {
				primes.add(i);
			}
		}
	}

	/**
	 * @return Outputs an ArrayList containing all primes less than or equal to
	 *         Initialization bound.
	 */
	public ArrayList<Integer> getPrimes() {
		return primes;
	}

}
