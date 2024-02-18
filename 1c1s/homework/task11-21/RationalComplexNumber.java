/*
Создать класс RationalComplexNumber - комплексное число, компонентами которого являются рациональные дроби. Атрибуты - RationalFraction). Методы:
•	RationalComplexNumber() - конструктор для нулевого комплексного числа;
•	RationalComplexNumber(RationalFraction, RationalFraction) - конструктор комплексного числа с заданными значениями вещественной и мнимой части; в конструкторах устраняйте дублирование кода;
•	RationalComplexNumber add(RationalComplexNumber)  сложение с другим таким числом;
•	RationalComplexNumber sub(RationalComplexNumber) - вычитание;
•	RationalComplexNumber mult(RationalComplexNumber) - умножение;
•	String toString() - строковое представление такого комплексного числа. Только без всяких "2/3 * i + -3/5". Проверяйте знаки, чтобы было красиво: 2/3 * i - 3/5.
*/

public class RationalComplexNumber {
	
	private RationalFraction real;
	private RationalFraction imaginary;
	
	public RationalComplexNumber() {
		this(new RationalFraction(), new RationalFraction());
	}
	
	public RationalComplexNumber(RationalFraction real, RationalFraction imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public String toString() {
		String sign;
		if (imaginary.getNumerator() == 0) {
			return real.toString();
		}
		if (imaginary.getNumerator() > 0) {
			sign = "+";
			return real.toString() + " " + sign + " " + imaginary.getNumerator() + "/" + imaginary.getDenumerator() + "*i";
		} else {
			sign = "-";
			return real.toString() + " " + sign + " " + (-1)*imaginary.getNumerator() + "/" + imaginary.getDenumerator() + "*i";
		}
	}
	
	public RationalComplexNumber add(RationalComplexNumber other) {
		return new RationalComplexNumber(real.add(other.real), imaginary.add(other.imaginary));
	}

	public RationalComplexNumber sub(RationalComplexNumber other) {
		return new RationalComplexNumber(real.sub(other.real), imaginary.sub(other.imaginary));
	}

	public RationalComplexNumber mult(RationalComplexNumber other) {
		RationalFraction a = real.mult(other.real).sub(imaginary.mult(other.imaginary));
		RationalFraction b = real.mult(other.imaginary).add(other.real.mult(imaginary));
		return new RationalComplexNumber(a, b);
	}

	public static void main(String [] args) {
		
		RationalComplexNumber a = new RationalComplexNumber(new RationalFraction(1, 5), new RationalFraction(7, 3));
		RationalComplexNumber b = new RationalComplexNumber(new RationalFraction(-7, 2), new RationalFraction(4, -7));
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.add(b));
		System.out.println(a.sub(b));
		System.out.println(a.mult(b));
		
	}
	
}