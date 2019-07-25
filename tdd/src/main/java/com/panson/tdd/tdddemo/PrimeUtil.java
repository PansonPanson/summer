package com.panson.tdd.tdddemo;

import java.util.Arrays;


public class PrimeUtil {

	public static int[] getPrimes(int max) {
		if (max <= 2) {
			return new int[] {};
		}
		int[] primes = new int[max];
		int count = 0;
		for (int num = 2; num < max; num++) {
			if (isPrime(num)) {
				primes[count++] = num;
			}
		}
		primes = Arrays.copyOf(primes, count);
		return primes;

	}

	/**
	 * 判断一个数是否是素数
	 * @param num
	 * @return boolean
	 */
	private static boolean isPrime(int num) {

		for (int i = 2; i < num / 2 + 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
