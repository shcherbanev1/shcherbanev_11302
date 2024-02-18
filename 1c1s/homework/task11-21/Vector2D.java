/*
Класс Vector2D - двумерный вектор. Атрибуты - два вещественных числа (координаты). Далее (здесь и в последующих подобных задачах) указываю методы с типом возвращамых значений, а в скобках пишу только типы параметров. get- и set- методы создавать по необходимости (тоже здесь и далее). 
•	Vector2D() - конструктор для нулевого вектора;
•	Vector2D(double, double) - конструктор вектора с координатами; в конструкторах устраняйте дублирование кода;
•	Vector2D add(Vector2D) - сложение вектора с другим вектором, результат возвращается как новый объект.
•	void add2(Vector2D) - сложение вектора с другим вектором, результат сохраняется в том, у кого был вызван этот метод;
•	Vector2D sub(Vector2D) - вычитание из вектора другого вектора, результат возвращается как новый объект;
•	void sub2(Vector2D) - вычитание из вектора другого вектора, результат сохраняется в том векторе, у кого был вызван этот метод;
•	Vector2D mult(double) - умножение вектора на вещественное число, результат возвращается как новый объект;
•	void mult2(double) - умножение вектора на вещественное число, результат сохраняется в векторе;

•	String toString() - строковое представление вектора;
•	double length() - длина вектора;
•	double scalarProduct(Vector2D) - скалярное произведение вектора на другой вектор;
•	double cos(Vector2D) - косинус угла между этим и другим вектором;
•	boolean equals(Vector2D) - сравнить вектор с другим вектором;
*/

public class Vector2D {
	
	private double x;
	private double y;
	
	public Vector2D() {
		this(0, 0);
	}
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D add(Vector2D vector) {
		return new Vector2D(x + vector.x, y + vector.y);
	}
	
	public void add2(Vector2D vector) {
		x += vector.x;
		y += vector.y;
	}
	
	public Vector2D sub(Vector2D vector) {
		return new Vector2D(x - vector.x, y - vector.y);
	}
	
	public void sub2(Vector2D vector) {
		x -= vector.x;
		y -= vector.y;
	}
	
	public Vector2D mult(double number) {
		return new Vector2D(x * number, y * number);
	}
	
	public void mult2(double number) {
		this.x *= number;
		this.y *= number;
	}
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}	
	
	public double length() {
		return Math.sqrt(x*x + y*y);
	}

	public double scalarProduct(Vector2D vector) {
		return (x*vector.x + y*vector.y);
	}
	
	public double cos(Vector2D vector) {
		return this.scalarProduct(vector) / (this.length() * vector.length());
	}
	
	public boolean equals(Vector2D vector) {
		return (Math.abs(x - vector.x) < 0.01 && Math.abs(y - vector.y) < 0.01);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public static void main(String [] args) {
		
		Vector2D vector1 = new Vector2D(3.5, 5);
		Vector2D vector2 = new Vector2D(3.5, 5.00001);
//		vector1.add2(vector2);
		Vector2D result = vector1.add(vector2);
		System.out.println(result.toString());
		System.out.println(vector1.scalarProduct(vector2));
		System.out.println(vector1.cos(vector2));
		System.out.println(vector1.equals(vector2));
		
	}
	
}