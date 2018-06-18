package com.test.primes;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.src.primes.CircularPrimes;


@RunWith(Parameterized.class)
public class CircularPrimesTest {
	
	@Parameters(name="{index}: {0} {1} {2}")
	public static Collection<Object[]> valuesToTest() {
		return Arrays.asList(new Object[][] { {13,1, 100},{25,1, 1000},{33,1, 10000} ,{43,1, 100000},
			{13,2, 100},{25,2, 1000},{33,2, 10000} ,{43,2, 100000},{55,2, 1000000},
			{13,3, 100},{25,3, 1000},{33,3, 10000} ,{43,3, 100000},{55,3, 1000000}});
	}

	private int sol;
	private int range;	
	private int expected;
	private CircularPrimes cp;
	
	public CircularPrimesTest(int expected, int sol, int range) {
		this.expected = expected;
		this.sol = sol;
		this.range = range;
	}
	
	@Before
	public void setup() {
		this.cp = new CircularPrimes();
	}	
	
	@Test
	public void listCircularPrimesSol() {		
		Assert.assertEquals(this.expected,cp.circularPrimes(this.sol,this.range));				
	}
}
