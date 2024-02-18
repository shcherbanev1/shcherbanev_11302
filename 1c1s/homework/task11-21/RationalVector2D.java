/*
Класс RationalVector2D - двумерный вектор, компоненты которого являются рациональными дробями (т.е. объектами класса RationalFraction). Это и есть атрибуты класса. Методы:
•	RationalVector2D() - конструктор для нулевого вектора (компоненты должны быть равны нулевым рациональным дробям);
•	RationalVector2D(RationalFraction, RationalFraction) - конструктор вектора с координатами; в конструкторах устраняйте дублирование кода;
•	RationalVector2D add(RationalVector2D) - сложение вектора с другим вектором;
•	String toString() - строковое представление вектора (использует строковое представление RationalFraсtion);
•	double length() - длина вектора;
•	RationalFraction scalarProduct(RationalVector2D) – скалярное произведение вектора на другой вектор;
•	boolean equals(RationalVector2D) - сравнить вектор с другим вектором (опираться на equals у RationalFraction);

*/

public class RationalVector2D {
	
	private RationalFraction x;
	private RationalFraction y;
	
	public RationalVector2D() {
		this(new RationalFraction(0, 1), new RationalFraction(0, 1));
	}
	
	public RationalVector2D(RationalFraction x, RationalFraction y) {
		this.x = x;
		this.y = y;
	}
	
	public RationalVector2D add(RationalVector2D vector) {
		return new RationalVector2D(x.add(vector.x), y.add(vector.y));
	}
	
	public String toString() {
		return "[" + x.toString() + ", " + y.toString() + "]";
	}
	
	public double length() {
		
		return Math.sqrt((x.mult(x).add(y.mult(y))).value());
	}
	
	public boolean equals(RationalVector2D vector) {
		return (x.equals(vector.x) && y.equals(vector.y));
	}
	
	public RationalFraction getX() {
		return x;
	}

	public RationalFraction getY() {
		return y;
	}	

	public static void main(String [] args) {
		RationalVector2D a = new RationalVector2D(new RationalFraction(2, 8), new RationalFraction(7, 12));
		RationalVector2D b = new RationalVector2D(new RationalFraction(3, 12), new RationalFraction(14, 24));
		double s = a.length();
		System.out.println(s);
		System.out.println(a.equals(b));
	}
	
}