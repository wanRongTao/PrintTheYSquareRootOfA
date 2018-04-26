
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
		System.out.print("请输入被开方数: ");
	    RationalNumber a = new RationalNumber(input.nextLong());
		System.out.print("请输入开方次数： ");
		RationalNumber y = new RationalNumber(input.nextBigInteger().longValue());
		System.out.println("请输入递归计算次数(大于0，越大越精确，超过15会导致计算奇慢无比):");
		long l = input.nextLong();
		//RationalNumber a = new RationalNumber(2);
		//RationalNumber y = new RationalNumber(2);
		RationalNumber x1 = new RationalNumber(BigInteger.valueOf((long)Math.pow(a.numerator.longValue(),1/y.numerator.longValue())),BigInteger.ONE);
		RationalNumber x2 = calculate(x1,y,a);
		//System.out.println(x2);
		System.out.println("完成1％");
		for(long i = 0;i<l;i++)
		{
			x2 = calculate(x2,y,a).reduction();
			System.out.println("完成"+(i+1)*100/l+"％");
		}
		System.out.println("完成100％");
		System.out.print("计算完成!得到一个分数值。请输入其输出时精度(以小数点后位数记,大于50000将奇慢无比):");
		System.out.println("\n"+x2.BigDecimalValue(input.nextInt()));
		System.out.println("输出完毕.");
	}
	public static RationalNumber calculate(RationalNumber x1,RationalNumber y,RationalNumber a)
	{
		RationalNumber t1 = x1.multiply(y).subtract(x1);
		RationalNumber t2 = a.divide(x1.pow(y.subtract(RationalNumber.ONE).numerator));
		return t1.add(t2).divide(y);
	}
}
