/*
Класс RationalComplexVector2D - двумерный вектор, компоненты которого являются объектами класса RationalComplexNumber. Это и есть атрибуты класса. Уже не буду писать, что надо в операциях опираться на методы класса RationalComplexNumber. Методы:
•	RationalComplexVector2D() - конструктор для нулевого вектора (компоненты должны быть равны нулевым рациональным дробям);
•	RationalComplexVector2D(RationalComplexNumber, RationalComplexNumber) -конструктор вектора с координатами; в конструкторах устраняйте дублирование кода;
•	RationalComplexVector2D add(RationalComplexVector2D) - сложение вектора с другим вектором;
•	String toString() - строковое представление такого вектора.
•	RationalComplexNumber scalarProduct(RationalComplexVector2D) - скалярное произведение вектора на другой вектор;
*/

public class RationalComplexVector2D {
	
	private RationalComplexNumber x;
	private RationalComplexNumber y;
	
	public RationalComplexVector2D() {
		this(new RationalComplexNumber(), new RationalComplexNumber());
	}
	
	public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + x.toString() + "], [" + y.toString() + "]";
	}
	
	public RationalComplexVector2D add(RationalComplexVector2D vector) {
		return new RationalComplexVector2D(x.add(vector.x), y.add(vector.y));
	}
	
	public RationalComplexNumber scalarProduct(RationalComplexVector2D vector) {
		RationalComplexNumber num1 = x.mult(vector.x);
		RationalComplexNumber num2 = y.mult(vector.y);
		
		return num1.add(num2);
	}
	
	public RationalComplexNumber getX() {
		return x;
	}
	
	public RationalComplexNumber getY() {
		return y;
	}
	
	public static void main(String [] args) {
		RationalComplexVector2D a = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(2, 2), new RationalFraction(3, -6)), new RationalComplexNumber(new RationalFraction(1, -7), new RationalFraction(2, 4)));
		RationalComplexVector2D b = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(5, 3), new RationalFraction(2, 1)), new RationalComplexNumber(new RationalFraction(1, -3), new RationalFraction(-2, 1)));
		System.out.println(a);
		System.out.println(b);
		RationalComplexVector2D res1 = a.add(b);
		System.out.println(res1);		
		RationalComplexNumber res2 = a.scalarProduct(b);
		System.out.println(res2);
	}
	
}