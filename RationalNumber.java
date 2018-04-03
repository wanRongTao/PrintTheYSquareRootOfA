
package src;
import java.math.*;

public class RationalNumber
{
	public BigInteger numerator;
	public BigInteger denominator;
	public RationalNumber(BigInteger inputNumerator,BigInteger inputDenominator)throws NullPointerException
	{
		if(inputNumerator==null||inputDenominator==null)
		{
			throw new NullPointerException("Numerator or denominator are null!");
		}
		this.numerator = inputNumerator;
		this.denominator = inputDenominator;
	}
	
	public RationalNumber(long inputNumerator,long inputDenominator)throws NullPointerException
	{
		if(inputDenominator==0)
		{
			throw new NullPointerException("Denominator cannot be zero!");
		}
		this.numerator = BigInteger.valueOf(inputNumerator);
		this.denominator = BigInteger.valueOf(inputDenominator);
	}
	
	public RationalNumber(long inputNumerator)
	{
		this.numerator = BigInteger.valueOf(inputNumerator);
		this.denominator = BigInteger.ONE;
	}
	
	public RationalNumber add(RationalNumber input)
	{
		return new RationalNumber(this.numerator.multiply(input.denominator).add(input.numerator.multiply(this.denominator)),this.denominator.multiply(input.denominator));
	}
	
	public RationalNumber subtract(RationalNumber input)
	{
		return new RationalNumber(this.numerator.multiply(input.denominator).subtract(input.numerator.multiply(this.denominator)),this.denominator.multiply(input.denominator));
	}
	
	public RationalNumber multiply(RationalNumber input)
	{
		return new RationalNumber(this.numerator.multiply(input.numerator),this.denominator.multiply(input.denominator));
	}
	
	public RationalNumber divide(RationalNumber input)
	{
		return this.multiply(input.reciprocal());
	}
	
	public RationalNumber pow(BigInteger input)
	{
		RationalNumber ret = this;
		for(long i = 1;i<input.longValue();i++)
		{
			ret = ret.multiply(this);
		}
		return ret;
	}
	
	public RationalNumber reciprocal()
	{
		return new RationalNumber(this.denominator,this.numerator);
	}
	
	public RationalNumber reduction()
	{
		BigInteger bigIntegerNumerator = this.numerator;
		BigInteger bigIntegerDenpminator = this.denominator;
		BigInteger min = bigIntegerNumerator.gcd(bigIntegerDenpminator);
		return new RationalNumber(bigIntegerNumerator.divide(min),bigIntegerDenpminator.divide(min));
	}

	@Override
	public String toString()
	{
		return this.numerator.toString()+"/"+this.denominator.toString();
	}
	
}
