package com.panson.tdd.tdddemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: panxing@qbb6.com
 * @date: 2019年07月25日 16:31
 */
public class PrimeUtilTest {

	@Test
	public void testGetPrimesForEmptyResult() {
		int[] expected = {};

		Assert.assertArrayEquals(expected, PrimeUtil.getPrimes(2));
		Assert.assertArrayEquals(expected, PrimeUtil.getPrimes(0));
		Assert.assertArrayEquals(expected, PrimeUtil.getPrimes(1));

	}

	@Test
	public void testGetPrimes() {

		Assert.assertArrayEquals(new int[]{2, 3, 5, 7}, PrimeUtil.getPrimes(9));
		Assert.assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13}, PrimeUtil.getPrimes(17));
		Assert.assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, PrimeUtil.getPrimes(30));

	}
}
