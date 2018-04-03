
package src;

import java.util.*;
import src.RationalNumber;
import java.math.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the radicand to calculate: ");
	    BigInteger a = input.nextBigInteger();
		System.out.print("Please enter the root index to calculate： ");
		BigInteger y = input.nextBigInteger();
		RationalNumber x1 = new RationalNumber(BigInteger.valueOf((long)Math.pow(a.doubleValue(),1/y.longValue())),BigInteger.ONE);
		RationalNumber x2 = calculate(x1,y,new RationalNumber(a,BigInteger.ONE));
		for(int i = 0;i<50;i++)
		{
			System.out.println("doing");
			x2 = calculate(x2,y,new RationalNumber(a,BigInteger.ONE)).reduction();
		}
		System.out.println(x2);
	}
	public static RationalNumber calculate(RationalNumber x1,BigInteger y,RationalNumber a)
	{
		return x1.multiply(new RationalNumber(y,BigInteger.valueOf(1)).subtract(new RationalNumber(y,BigInteger.valueOf(1))).add(a.divide(x1.pow(y.subtract(BigInteger.ONE))))).divide(new RationalNumber(y,BigInteger.ONE));
	}
}
