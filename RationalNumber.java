
package src;
import java.math.*;
/**此处使用的英语单词- 中文翻译
 *RationalNumber  - 有理数
 *numerator       - 分子
 *denominator     - 分母
*/
public class RationalNumber
{
	//静态变量-0&1&10
	public static RationalNumber ZERO = new RationalNumber(0,1);
	public static RationalNumber ONE = new RationalNumber(1,1);
	public static RationalNumber TEN = new RationalNumber(10,1);
	//成员变量-分子&分母
	protected BigInteger numerator;
	protected BigInteger denominator;
	//双BigInteger构造方法-直接设置分子分母
	public RationalNumber(BigInteger inputNumerator,BigInteger inputDenominator)throws NullPointerException
	{
		if(inputNumerator==null||inputDenominator==null)
		{
			throw new NullPointerException("Numerator or denominator are null!");
		}
		this.numerator = inputNumerator;
		this.denominator = inputDenominator;
	}
	//双long构造方法-long转BigInteger再调用双BigInteger构造方法
	public RationalNumber(long inputNumerator,long inputDenominator)throws NullPointerException
	{
		this(BigInteger.valueOf(inputNumerator),BigInteger.valueOf(inputDenominator));
	}
	//单long构造方法-以输入的分子作为分子，以1为分母，调用双long构造方法
	public RationalNumber(long inputNumerator)
	{
		this(inputNumerator,1);
	}
	//加法运算，返回this与输入有理数的和
	public RationalNumber add(RationalNumber input)
	{
		return new RationalNumber(this.numerator.multiply(input.denominator).add(input.numerator.multiply(this.denominator)),this.denominator.multiply(input.denominator)).reduction();
	}
	//减法运算，返回this与输入有理数的差
	public RationalNumber subtract(RationalNumber input)
	{
		return new RationalNumber(this.numerator.multiply(input.denominator).subtract(input.numerator.multiply(this.denominator)),this.denominator.multiply(input.denominator)).reduction();
	}
	//乘法运算，返回this与输入有理数的积
	public RationalNumber multiply(RationalNumber input)
	{
		return new RationalNumber(this.numerator.multiply(input.numerator),this.denominator.multiply(input.denominator)).reduction();
	}
	//除法运算，返回this与输入有理数的商
	public RationalNumber divide(RationalNumber input)
	{
		return this.multiply(input.reciprocal()).reduction();
	}
	//幂运算，返回this的输入有理数次方
	public RationalNumber pow(BigInteger input)
	{
		RationalNumber ret = this;
		for(long i = 1;i<input.longValue();i++)
		{
			ret = ret.multiply(this);
		}
		return ret.reduction();
	}
	//倒数运算，返回this的倒数
	public RationalNumber reciprocal()
	{
		return new RationalNumber(this.denominator,this.numerator).reduction();
	}
	//约分运算，返回this的约分结果
	public RationalNumber reduction()
	{
		if(this.numerator.equals(BigInteger.ZERO))
		{
			return this.ZERO;
		}
		BigInteger bigIntegerNumerator = this.numerator;
		BigInteger bigIntegerDenpminator = this.denominator;
		BigInteger min = bigIntegerNumerator.gcd(bigIntegerDenpminator);
		return new RationalNumber(bigIntegerNumerator.divide(min),bigIntegerDenpminator.divide(min));
	}
	//返回字符串格式-整数或分数
	@Override
	public String toString()
	{
		if(this.denominator.equals(BigInteger.ONE))
		{
			return this.numerator.toString();
		}
		return this.numerator.toString()+"/"+this.denominator.toString();
	}
	//判断是否相等-先比较是否同类，分子分母再分别相较
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof RationalNumber)
		{
			RationalNumber r = ((RationalNumber)o).reduction().;
			return r.numerator.equals(this.numerator)&r.denominator.equals(this.denominator);
		}
		return false;
	}
	public BigInteger getNumerator()
	{
		return this.numerator;
	}
}
