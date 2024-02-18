/*
Создать класс ComplexMatrix2x2 - двумерная матрица из ComplexNumber. Аргументы - содержимое матрицы (лучше разумеется хранить двумерным массивом, а то замучаетесь). Методы:
•	ComplexMatrix2x2() - конструктор для нулевой матрицы;
•	ComplexMatrix2x2(ComplexNumber) - конструктор для матрицы, у которой каждый элемент равен поданному числу;
•	ComplexMatrix2x2(ComplexNumber, ComplexNumber,  ComplexNumber, ComplexNumber) - конструктор на 4 дробях, в конструкторах устраняйте дублирование кода;
•	ComplexMatrix2x2 add(ComplexMatrix2x2) - сложение матрицы с другой;
•	ComplexMatrix2x2 mult(ComplexMatrix2x2) - умножение матрицы на другую матрицу;
•	ComplexNumber det() - определитель матрицы;
•	ComplexVector2D multVector(ComplexVector2D) - умножить матрицу на двумерный комплекснозначный вектор (считая его столбцом) и возвратить получившийся столбец в виде вектора.
*/

public class ComplexMatrix2x2 {
	
	private ComplexNumber [][] matrix;
	
	public ComplexMatrix2x2() {
		this(new ComplexNumber());
	}
	
	public ComplexMatrix2x2(ComplexNumber num) {
		this(num, num, num, num);
	}
	
	public ComplexMatrix2x2(ComplexNumber n1, ComplexNumber n2, ComplexNumber n3, ComplexNumber n4) {
		this.matrix = new ComplexNumber [][] {{n1, n2}, {n3, n4}};
	}
	
	public String toString() {
		return "[" + matrix[0][0].toString() + ", " + matrix[0][1].toString() + "]\n" +
			"[" + matrix[1][0].toString() + ", " + matrix[1][1].toString() + "]";
	}
	
	public ComplexMatrix2x2 add(ComplexMatrix2x2 other) {
		return new ComplexMatrix2x2(matrix[0][0].add(other.matrix[0][0]), 
									matrix[0][1].add(other.matrix[0][1]), 
									matrix[1][0].add(other.matrix[1][0]), 
									matrix[1][1].add(other.matrix[1][1]));
	}
	
	public ComplexMatrix2x2 mult(ComplexMatrix2x2 other) {
		ComplexNumber a11 = matrix[0][0].mult(other.matrix[0][0]).add(matrix[0][1].mult(other.matrix[1][0]));
		ComplexNumber a12 = matrix[0][0].mult(other.matrix[0][1]).add(matrix[0][1].mult(other.matrix[1][1]));
		ComplexNumber a21 = matrix[1][0].mult(other.matrix[0][0]).add(matrix[1][1].mult(other.matrix[1][0]));
		ComplexNumber a22 = matrix[1][0].mult(other.matrix[0][1]).add(matrix[1][1].mult(other.matrix[1][1]));
		return new ComplexMatrix2x2(a11, a12, a21, a22);
	}
	
	public ComplexNumber det() {
		ComplexNumber a = matrix[0][0].mult(matrix[1][1]);
		ComplexNumber b = matrix[0][1].mult(matrix[1][0]);		
		return (a.sub(b));
	}
	
	public ComplexVector2D multVector(ComplexVector2D vector) {
		ComplexNumber a = matrix[0][0].mult(vector.getX()).add(matrix[0][1].mult(vector.getY()));
		ComplexNumber b = matrix[1][0].mult(vector.getX()).add(matrix[1][1].mult(vector.getY()));
		return new ComplexVector2D(a, b);
	}
	
	public static void main(String [] args) {
		ComplexMatrix2x2 a = new ComplexMatrix2x2(new ComplexNumber(1, 5), new ComplexNumber(3, 7),
													new ComplexNumber(-9, 5), new ComplexNumber(1, 4));
		ComplexMatrix2x2 b = new ComplexMatrix2x2(new ComplexNumber(3, -3), new ComplexNumber(1, 2),
													new ComplexNumber(-9, -5), new ComplexNumber(-1, 4));
		ComplexVector2D c = new ComplexVector2D(new ComplexNumber(-9, -5), new ComplexNumber(-1, 4));
		
		
		System.out.println(a.add(b));
		System.out.println(a.mult(b));
		System.out.println(a.add(b).det());
		System.out.println(a.multVector(c));
		
	}
	
}