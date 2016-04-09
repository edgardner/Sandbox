package com.edgardner.PardotTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Enter a upper bound to test secret funtion: ");
		Scanner s = new Scanner(System.in);
		int upperBound = s.nextInt();
		s.close();

		FindPrimes fp = new FindPrimes(upperBound);
		System.out.println("Primes less than " + upperBound + ": " + fp.getPrimes().toString());

		if (checkDistributiveTransform(fp.getPrimes())) {
			System.out.println("Success - Secret function is Distributive");
		} else {
			System.out.println("Failed - Secret function isn't Distributive");
		}

	}

	// Secret function to check.
	static int secret(int inputValue) {
		int output = 0;
		// TODO: Add secret transform
		return output;

	}

	/**
	 * The prompt is to check if secret(x+y) = secret(x) + secret(y) for all
	 * primes less than some upper bound. Effectively, the check is to see if
	 * secret() is distributive over the primes. /p
	 * 
	 * Since addition is commutative over the integers we can avoid checking if
	 * secret(x) + secret(y) is equal to secret(y) + secret(x) likewise with
	 * secret(x+y) and secret(y+x). /p
	 * 
	 * The idea here is to use nested loops where the inner loop gets smaller as
	 * we move through the prime array until we are left with just checking if
	 * the secret(prime + prime) = secret(prime) + secret(prime) which means the
	 * algorithm will run in O(n!) time where n is the length of the prime array
	 * in the worst case.
	 * 
	 * @param primes:
	 *            List of primes to use for validation
	 * @return boolean: value based on if secret() is distributive on the primes
	 */
	static boolean checkDistributiveTransform(ArrayList<Integer> primes) {

		boolean checkFailed = false;
		for (int i = 0; i < primes.size(); i++) {
			if (!checkFailed) {

				for (int j = i; j < primes.size(); j++) {
					if (!checkFailed) {
						int compositeSecret = secret(primes.get(i)) + secret(primes.get(j));
						int primeSum = primes.get(i) + primes.get(j);
						if (compositeSecret != secret(primeSum)) {
							checkFailed = true;
							break;
						}

					} else {
						break;
					}
				}
			}
		}
		return (!checkFailed);
	}

}
