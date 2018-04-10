
package src;

import java.util.*;
import src.RationalNumber;
import java.math.*;

public class Main
{
	public static void main(String[] args)
	{
		//System.out.println(new RationalNumber(63,13).multiply(new RationalNumber(5,1)).subtract(new RationalNumber(24,1)).reduction());
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the radicand to calculate: ");
	    BigInteger a = input.nextBigInteger();
		System.out.print("Please enter the root index to calculate： ");
		BigInteger y = input.nextBigInteger();
		RationalNumber x1 = new RationalNumber(BigInteger.valueOf((long)Math.pow(a.doubleValue(),1/y.longValue())),BigInteger.ONE);
		System.out.println((long)Math.pow(a.doubleValue(),1/y.longValue()));
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
		RationalNumber y1 = new RationalNumber(y.longValue());
		RationalNumber temp1 = x1.multiply(y1);
		RationalNumber temp2 = a.divide(y1.pow(x1.getNumerator().subtract(BigInteger.ONE)));
		temp1= temp1.subtract(y1);
		return temp1.add(temp2).divide(y1);
	}
}
