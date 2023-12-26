/*
Создать класс RationalMatrix2x2 - двумерная матрица из RationalFraction. Аргументы - содержимое матрицы (лучше разумеется хранить двумерным массивом, а то замучаетесь). Методы:
•	RationalMatrix2x2() - конструктор для нулевой матрицы;
•	RationalMatrix2x2(RationalFraction) - конструктор для матрицы, у которой каждый элемент равен поданному числу;
•	RationalMatrix2x2(RationalFraсtion, RationalFraсtion, RationalFraсtion, RationalFraсtion) - конструктор на 4 дробях. В конструкторах устраняйте дублирование кода;
•	RationalMatrix2x2 add(RationalMatrix2x2) - сложение матрицы с другой;
•	RationalMatrix2x2 mult(RationalMatrix2x2) - умножение матрицы на другую матрицу;
•	RationalFraсtion det() - определитель матрицы;
•	RationalVector2D multVector(RationalVector2D) - умножить матрицу на двумерный вектор (считая его столбцом) и возвратить получившийся столбец в виде вектора.
*/

public class RationalMatrix2x2 {
	
	private RationalFraction [][] matrix;
	
	public RationalMatrix2x2() {
		this(new RationalFraction());
	}
	
	public RationalMatrix2x2(RationalFraction f) {
		this(f, f, f, f);
	}
	
	public RationalMatrix2x2(RationalFraction f1, RationalFraction f2, RationalFraction f3, RationalFraction f4) {
		this.matrix = new RationalFraction[][] {{f1, f2}, {f3, f4}};
	}
	
	public String toString() {
		return "[" + matrix[0][0].toString() + ", " + matrix[0][1].toString() + "]\n" +
			"[" + matrix[1][0].toString() + ", " + matrix[1][1].toString() + "]";
	}
	
	public RationalMatrix2x2 add(RationalMatrix2x2 other) {
		return new RationalMatrix2x2(matrix[0][0].add(other.matrix[0][0]), 
									matrix[0][1].add(other.matrix[0][1]), 
									matrix[1][0].add(other.matrix[1][0]), 
									matrix[1][1].add(other.matrix[1][1]));
	}
	
	public RationalMatrix2x2 mult(RationalMatrix2x2 other) {
		RationalFraction a11 = matrix[0][0].mult(other.matrix[0][0]).add(matrix[0][1].mult(other.matrix[1][0]));
		RationalFraction a12 = matrix[0][0].mult(other.matrix[0][1]).add(matrix[0][1].mult(other.matrix[1][1]));
		RationalFraction a21 = matrix[1][0].mult(other.matrix[0][0]).add(matrix[1][1].mult(other.matrix[1][0]));
		RationalFraction a22 = matrix[1][0].mult(other.matrix[0][1]).add(matrix[1][1].mult(other.matrix[1][1]));
		return new RationalMatrix2x2(a11, a12, a21, a22);
	}
	
	public RationalFraction det() {
		RationalFraction a = matrix[0][0].mult(matrix[1][1]);
		RationalFraction b = matrix[0][1].mult(matrix[1][0]);		
		return (a.sub(b));
	}
	
	public RationalVector2D multVector(RationalVector2D vector) {
		RationalFraction a = matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY()));
		RationalFraction b = matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY()));
		return new RationalVector2D(a, b);
	}
	
	public static void main(String [] args) {
		
		RationalMatrix2x2 a = new RationalMatrix2x2(new RationalFraction(5, 7), new RationalFraction(3, 4), 
													new RationalFraction(5, 3), new RationalFraction(8, 16));
		RationalMatrix2x2 b = new RationalMatrix2x2(new RationalFraction(1, 7), new RationalFraction(3, 6), 
													new RationalFraction(7, 2), new RationalFraction(5, 3));
		RationalVector2D c = new RationalVector2D(new RationalFraction(1, 7), new RationalFraction(3, 6));
		System.out.println(a.add(b));
		System.out.println(a.mult(b));
		System.out.println(a.mult(b).det());
		System.out.println(a.multVector(c));
	}
	
}