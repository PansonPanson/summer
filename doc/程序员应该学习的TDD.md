TDD ( Test-Driven Development ) ，也就是测试驱动开发。当我们在讨论程序员的基本技能的时候，会聊到两点：

+ 单元测试
+ 重构

开发者是程序的第一道防火墙，程序正确性应该由开发者保证，而不应该寄希望于测试人员。学会测试驱动，有助于养成良好的编程习惯。

那如何去实施TDD呢？

流程大致如下：

+ 思考：写一个测试用例
+ 写 just enough 的代码，让测试通过
+ 重构代码保持测试通过

我们来看一个TDD demo ：

```java
/**
* 编写一个函数，返回小于给定值 Max 的所有素数组成的数组
*/
public static int[] getPrimes(int max);
```

那我们如何去做呢？

首先做一个简单的任务分解：

+ 边界条件
    + getPrimes(0), getPrimes(-1), getPrimes(2) 应该返回什么？
+ 正常输入
    + getPrimes(9), getPrimes(17), getPrimes(30)

接下来是编码阶段, 在编码时，记住上文中讲的实施TDD的 “三步走” 战略

+ 边界条件: 

```java
/**
* 创建一个测试类，使用断言
*/
public class PrimeUtilTest {

	@Test
	public void testGetPrimesForEmptyResult() {
		int[] expected = {};

		Assert.assertArrayEquals(expected, PrimUtil.getPrimes(2));
		Assert.assertArrayEquals(expected, PrimUtil.getPrimes(0));
		Assert.assertArrayEquals(expected, PrimUtil.getPrimes(1));

	}
}
```

```java
/**
* 被测试的类
*/
public class PrimUtil {

	public static int[] getPrimes(int max) {
		if (max <= 2) {
			return new int[]{};
		}
		return null;
	}
}
```

让我们进阶一下，测试一下正常输入的情况下的测试用例以及代码实现：

```java
@Test
public void testGetPrimes() {

		Assert.assertArrayEquals(new int[]{2, 3, 5, 7}, PrimeUtil.getPrimes(9));
		Assert.assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13}, PrimeUtil.getPrimes(17));
		Assert.assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, PrimeUtil.getPrimes(9));

}
```

```java
/**
* 被测试的类
*/
public class PrimeUtil {

	public static int[] getPrimes(int max) {
		if (max <= 2) {
			return new int[]{};
		} else {
			int[] newArray = new int[max];
			int size = 0, j = 0;
			for (int i = 2; i < max; i++) {
				for (j = 2; j < i / 2 + 1; j++) {
					if (i % j == 0) {
						break;
					}
				}
				if (j == i / 2 + 1) {
					newArray[size++] = i;
				}
			}
			newArray = Arrays.copyOf(newArray, size);
			return newArray;
		}
	}
}
```

看看上面的代码，作为一个不那么差的程序员一定凌乱了，好难受啊，别急，我们是故意这么做的，为了展示一下TDD "三步走"战略的最后一步：

+ 重构代码保持测试通过

接下来我们对上面的代码进行重构，拒绝 bad taste。

```java
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
```

经过以上步骤，我们尝试了一次简单的TDD，还是蛮有意思的。