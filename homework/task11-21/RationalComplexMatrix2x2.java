/*
Создать класс RationalComplexMatrix2x2 - двумерная матрица из RationalComplexNumber. Аргументы - содержимое матрицы (лучше, разумеется, хранить двумерным массивом, а то замучаетесь). Методы:
•	RationalComplexMatrix2x2() - конструктор для нулевой матрицы;
•	RationalComplexMatrix2x2(RationalComplexNumber) - конструктор для матрицы, у которой каждый элемент равен поданному числу;
•	RationalComplexMatrix2x2(RationalComplexNumber, RationalComplexNumber, RationalComplexNumber, RationalComplexNumber) - конструктор на 4 дробях, в конструкторах устраняйте дублирование кода;
•	RationalComplexMatrix2x2 add(RationalComplexMatrix2x2) - сложение матрицы с другой;
•	RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2) - умножение матрицы на другую матрицу;
•	RationalComplexNumber det() - определитель матрицы;
•	RationalComplexVector2D multVector(RationalComplexVector2D) - умножить матрицу на двумерный комплекснозначный рациональный вектор (считая его столбцом) и возвратить получившийся столбец в виде вектора.
*/

public class RationalComplexMatrix2x2 {
	
	
	private RationalComplexNumber [][] matrix;
	
	public RationalComplexMatrix2x2() {
		this(new RationalComplexNumber());
	}
	
	public RationalComplexMatrix2x2(RationalComplexNumber n) {
		this(n, n, n, n);
	}
	
	public RationalComplexMatrix2x2(RationalComplexNumber n1, RationalComplexNumber n2, RationalComplexNumber n3, RationalComplexNumber n4) {
		this.matrix = new RationalComplexNumber [][] {{n1, n2}, {n3, n4}};
	}
	
	public String toString() {
		return "[" + matrix[0][0].toString() + ", " + matrix[0][1].toString() + "]\n" +
			"[" + matrix[1][0].toString() + ", " + matrix[1][1].toString() + "]";
	}
	
	public RationalComplexMatrix2x2 add(RationalComplexMatrix2x2 other) {
		return new RationalComplexMatrix2x2(matrix[0][0].add(other.matrix[0][0]),
											matrix[0][1].add(other.matrix[0][1]),
											matrix[1][0].add(other.matrix[1][0]),
											matrix[1][1].add(other.matrix[1][1]));
	}
	
	public RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 other) {
		RationalComplexNumber a11 = matrix[0][0].mult(other.matrix[0][0]).add(matrix[0][1].mult(other.matrix[1][0]));
		RationalComplexNumber a12 = matrix[0][0].mult(other.matrix[0][1]).add(matrix[0][1].mult(other.matrix[1][1]));
		RationalComplexNumber a21 = matrix[1][0].mult(other.matrix[0][0]).add(matrix[1][1].mult(other.matrix[1][0]));
		RationalComplexNumber a22 = matrix[1][0].mult(other.matrix[0][1]).add(matrix[1][1].mult(other.matrix[1][1]));
		return new RationalComplexMatrix2x2(a11, a12, a21, a22);
	}
	
	public RationalComplexNumber det() {
		RationalComplexNumber a = matrix[0][0].mult(matrix[1][1]);
		RationalComplexNumber b = matrix[0][1].mult(matrix[1][0]);
		return (a.sub(b));
	}
	
	public RationalComplexVector2D multVector(RationalComplexVector2D vector) {
		RationalComplexNumber a = matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY()));
		RationalComplexNumber b = matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY()));
		return new RationalComplexVector2D(a, b);
	}
	
	public static void main(String [] args) {
		RationalComplexMatrix2x2 a = new RationalComplexMatrix2x2(new RationalComplexNumber(new RationalFraction(2, 2), new RationalFraction(3, -6)),
																	new RationalComplexNumber(new RationalFraction(1, -7), new RationalFraction(2, 4)),
																	new RationalComplexNumber(new RationalFraction(3, -2), new RationalFraction(1, 5)),
																	new RationalComplexNumber(new RationalFraction(2, 6), new RationalFraction(1, 8)));
		RationalComplexMatrix2x2 b = new RationalComplexMatrix2x2(new RationalComplexNumber(new RationalFraction(1, 3), new RationalFraction(2, 9)),
																	new RationalComplexNumber(new RationalFraction(7, 3), new RationalFraction(1, 9)),
																	new RationalComplexNumber(new RationalFraction(3, 5), new RationalFraction(-7, 5)),
																	new RationalComplexNumber(new RationalFraction(1, 2), new RationalFraction(-9, 8)));
		RationalComplexVector2D c = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(2, 2), new RationalFraction(3, -6)), 
																new RationalComplexNumber(new RationalFraction(1, -7), new RationalFraction(2, 4)));
		System.out.println(a);
		System.out.println(b);
		RationalComplexMatrix2x2 res1 = a.add(b);
		System.out.println(res1);
		RationalComplexMatrix2x2 res2 = a.mult(b);
		System.out.println(res2);
		RationalComplexNumber res3 = a.det();
		System.out.println(res3);
		RationalComplexVector2D res4 = a.multVector(c);
		System.out.println(res4);
	}
	
}