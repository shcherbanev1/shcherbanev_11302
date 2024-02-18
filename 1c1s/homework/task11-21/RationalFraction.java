/*
Класс RationalFraction - рациональная дробь. Атрибуты - два целых числа (числитель и знаменатель). Методы:
•	+RationalFraction() - конструктор для дроби, равной нулю;
•	+RationalFraction(int, int) - конструктор дроби со значениями числителя и знаменателя; в конструкторах устраняйте дублирование кода;
•	+void reduce() - сокращение дроби;
•	+RationalFraction add(RationalFraction) - сложение дроби с другой дробью, результат возвращается как новый объект (не забудьте сократить)
•	+void add2(RationalFraction) - сложение дроби с другой дробью, результат сохраняется в том, у кого был вызван этот метод (не забудьте сократить);
•	+RationalFraction sub(RationalFraction) - вычитание из дроби другой дроби, результат возвращается как новый объект (не забудьте сократить);
•	+void sub2(RationalFraction) - вычитание из дроби другой дроби, результат сохраняется в том, у кого был вызван этот метод (не забудьте сократить);
•	+RationalFraction mult(RationalFraction) - умножение дроби на другую дробь, результат возвращается как новый объект (сократить)
•	+void mult2(RationalFraction) - умножение дроби на другую дробь, результат сохраняется;
•	+RationalFraction div(RationalFraction) - деление дроби на другую дробь, результат возвращается как новый объект (сократить)
•	+void div2(RationalFraction) - деление дроби на другую дробь, результат сохраняется; больше не буду писать "возвращается" или "сохраняется", думаю, уже и так понятно.
•	+String toString() - строковое представление дроби (например, -2/3);
•	+double value() - десятичное значение дроби;
•	+boolean equals(RationalFraction) - сравнить дробь с другой дробью 
•	(не забывайте, что 2/4 и 1/2 - одна и та же дробь)
•	+int numberPart() - целая часть дроби;
*/

public class RationalFraction {
	
	private int numerator;
	private int denominator;
	
	public RationalFraction() {
		this(0, 1);
	}
	
	public RationalFraction(int numerator, int denominator) {
		// числитель - целое число
		// знаменатель - натуральное число
		if (denominator < 0) {
			this.numerator = (-1)*numerator;
			this.denominator = (-1)* denominator;
		} else {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}
	
	public void reduce() {
		int a = Math.abs(numerator);
		int b = Math.abs(denominator);
		while (a != 0 && b != 0) {
			if (a > b) {
				a = a % b;
			} else {
				b = b % a;
			}
		}
		numerator /= (a + b);
		denominator /= (a + b);
		
	}
	
	public String toString() {
		if (denominator != 1) {
			return (numerator + "/" + denominator);
		}
		return numerator + "";
	}
	
	public RationalFraction add(RationalFraction fraction) {
		int num = numerator * fraction.denominator + fraction.numerator * denominator;
		int den = denominator*fraction.denominator;
		RationalFraction result = new RationalFraction(num, den);
		result.reduce();
		return result;
	}
	
	public void add2(RationalFraction fraction) {
		numerator = numerator * fraction.denominator + fraction.numerator * denominator;
		denominator = denominator * fraction.denominator;
		this.reduce();
	}
	
	public RationalFraction sub(RationalFraction fraction) {
		int num = numerator * fraction.denominator - fraction.numerator * denominator;
		int den = denominator*fraction.denominator;
		RationalFraction result = new RationalFraction(num, den);
		result.reduce();
		return result;
	}
	
	public void sub2(RationalFraction fraction) {
		numerator = numerator * fraction.denominator - fraction.numerator * denominator;
		denominator = denominator * fraction.denominator;
		this.reduce();
	}
	
	public RationalFraction mult(RationalFraction fraction) {
		int num = numerator * fraction.numerator;
		int den = denominator * fraction.denominator;
		RationalFraction result = new RationalFraction(num, den);
		result.reduce();
		return result;
	}
	

	public void mult2(RationalFraction fraction) {
		numerator *= fraction.numerator;
		denominator *= fraction.denominator;
		this.reduce();
	}
	
	public RationalFraction div(RationalFraction fraction) {
		RationalFraction reversedFraction = new RationalFraction(fraction.denominator, fraction.numerator);
		return mult(reversedFraction);
	}
	

	public void div2(RationalFraction fraction) {
		RationalFraction reversedFraction = new RationalFraction(fraction.denominator, fraction.numerator);
		numerator *= reversedFraction.numerator;
		denominator *= reversedFraction.denominator;
		this.reduce();
	}
	
	public double value() {
		return (double)numerator / denominator;
	}
	
	public boolean equals(RationalFraction fraction) {
		this.reduce();
		fraction.reduce();
		return (numerator == fraction.numerator && denominator == fraction.denominator);
	}
	
	public int numberPart() {
		return numerator / denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenumerator() {
		return denominator;
	}
	
	public static void main(String [] args) {
		
		RationalFraction a = new RationalFraction(42, 11);
		RationalFraction b = new RationalFraction(84, 22);
		RationalFraction res = a.div(b);
		System.out.println(res);
		//a.div2(b);
		System.out.println(a);
		System.out.println(a.equals(b));
		System.out.println(a.numberPart());
	}
	
}