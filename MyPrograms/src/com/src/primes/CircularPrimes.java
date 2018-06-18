package com.src.primes;

import java.util.ArrayList;

/**
 * Program to list and total the circular prime numbers between 1 and 1,000,000
 * añadir linea sksksks
 * @author Carlos Steven Ramírez
 * @version 1.0
 */

public class CircularPrimes {	
	
	ArrayList <Integer> numbers = new ArrayList<Integer>();
	
	/**
	 * Print the elements of the ArrayList.	
	 * @param numbers: This is a ArrayList with the list of circular primes.
	 */
	private void printArray (ArrayList <Integer> numbers) {
		for(int j=0;j<numbers.size();j++) {
			System.out.println(numbers.get(j));			
		}
	}
	
	/**
	 * Evaluate if a number is prime or not
	 * @param num: this is the number to evaluate
	 * @return isPrime: Boolean value that indicate if the number is prime
	 */
	private boolean isPrime(int num) {
		
		boolean isprime = true;
		for (int i=2;i<=num;i++) {
			if(i!=num) {				
				int b = num %i;
				if(b==0) {					
					isprime = false;
					break;
				}					
			}			
		}		
		return isprime;
	}	
	
	/**
	 * Evaluate if a number is circular prime.
	 * The program moves the last digit to the first position (for each digit of the number).
	 * then evaluates whether the number is prime or not.
	 * If the number is not prime, the cycle breaks and returns false.
	 * Only true returns when all combinations are prime numbers.
	 * @param num: It is the number to evaluate.
	 * @return circularPrime: Boolean value that indicate if the number is circular prime.
	 */
	public boolean isCircularPrime (int num) {
		
		boolean circularPrime = true;		
		String s = String.valueOf(num);	
		
		for (int i=0; i<s.length();i++) {
			int d = num%10;			
			int result = (int) (d * Math.pow(10, s.length()-1));
			num/=10;
			num +=result;			
			if(isPrime(num) == false) {
				circularPrime = false;
				break;
			}
		}		
		return circularPrime;
		}
	

	/**
	 * First solution to list and total the circular prime.
	 * This solution runs one by one all the numbers to the limit.
	 * Evaluating whether the number is a circular prime or not.
	 * If the number is circular prime, it is print and counted.
	 * @param limit: The range of numbers to evaluate.
	 * @circular: Boolean value that is true if the number is circular prime.
	 * @return count: The total of circular prime numbers.
	 */
	public int listPrimesSol1(int limit) {
		int count = 0;			
		boolean circular=false; 
		for(int i=2;i<=limit;i++) {			 			  
					circular = isCircularPrime(i);
					if(circular==true) {
						System.out.println(i);
						count +=1;
					}				
		   }
		
	    return count;
	}
	
	/**
	 * Second solution to list and total the circular prime
	 * This solution runs one by one all the numbers to the limit.
	 * First if the number is 2 or 5 it is added to the ArrayList
	 * else it is verified that the number does not contain 0,2,4,5,6,8 
	 * only if the number does not contain the characters is it evaluated
	 * If the number is circular prime then it is added to the ArrayList
	 * @param limit: The range of numbers to evaluate.
	 * @return count: Return the total elements of the ArrayList (total of circular primes)
	 */
	
	public int listPrimesSol2(int limit) {
		
		int count = 0;
	
	 for(int i=2;i<=limit;i++) {
			  String s = String.valueOf(i);
				if (i==2 || i==5)				
					
					numbers.add(i);				
				else if (!(s.contains("0")  || s.contains("2") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("8")) )
				{
				 if (isCircularPrime(i)==true)
				 numbers.add(i);
				}				
			} 			
			printArray(numbers);
			count = numbers.size();
			return count;	
	}
	
	/**
	 * Third solution to list and total the circular prime
	 * This solution runs one by one all the numbers to the limit.
	 * First verify if the number does not contain 0.2,4,5,6,8 or its length is equal to 1   
	 * Only if the number meets the condition is it evaluated.
	 * If the number is circular prime then it is added to the ArrayList
	 * @param limit: The range of numbers to evaluate.
	 * @return count: Return the total elements of the ArrayList (total of circular primes)
	 */
	
	public int listPrimesSol3(int limit) {	
	
		int i=2;		
		int count = 0;
		do {
			String s = String.valueOf(i);			  
				if (!(s.contains("0")  || s.contains("2") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("8"))
					|| s.length()== 1){
				 if (isCircularPrime(i)==true)
				 numbers.add(i);
				}		
				i++;
		} while (i<=limit);		
		
		printArray(numbers);
		count = numbers.size();
		return count;
	}
	
	public int circularPrimes(int sol, int limit) {
	   
		int totalNumbers=0;
		long startTime = System.nanoTime();	
		
	    switch(sol) {
	    case 1:
	    	totalNumbers = listPrimesSol1(limit);
	    	break;
	    case 2:
	    	totalNumbers = listPrimesSol2(limit);
	    	break;
	    case 3:
	    	totalNumbers = listPrimesSol3(limit);	    		
	    }
	    System.out.println("Total of circular primes in " + limit+ " numbers with solution number " + sol + " is equal to " +totalNumbers);
	    long endTime = System.nanoTime();		
		System.out.println("The total execution time is equal to: " + (endTime - startTime));
		return totalNumbers;
	}
}
