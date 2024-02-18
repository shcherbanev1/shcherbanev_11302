/*
Создать класс Matrix2x2 - двумерная матрица из вещественных чисел. Аргументы - содержимое матрицы (лучше, разумеется, хранить двумерным массивом, а то замучаетесь). Методы:
•	Matrix2x2() - конструктор для нулевой матрицы;
•	Matrix2x2(double) - конструктор для матрицы, у которой каждый элемент равен поданному числу;
•	Matrix2x2(double [][]) - конструктор для матрицы, содержимое подается на вход в виде массива;
•	Matrix2x2(double, double, double, double) - глупый конструктор, но пусть он будет. Сами знаете, что он делает. В конструкторах устраняйте дублирование кода;
•	Matrix2x2 add(Matrix2x2) - сложение матрицы с другой;
•	void add2(Matrix2x2) - сложение матрицы с другой;
•	Matrix2x2 sub(Matrix2x2) - вычитание из матрицы другой матрицы;
•	void sub2(Matrix2x2) - вычитание из матрицы другой матрицы;
•	Matrix2x2 multNumber(double) - умножение матрицы на вещественное число;
•	void multNumber2(double) - умножение матрицы на вещественное число;


•	

•	double det() - определитель матрицы;
•	void transpon() - транспонировать матрицу;
•	Matrix2x2 inverseMatrix() - возвратить обратную матрицу для заданной. Если это невозможно, вывести сообщение об ошибке и вернуть нулевую матрицу (кто вдруг знает исключения, может их использовать).
•	Matrix2x2 equivalentDiagonal() - возвратить эквивалентную диагональную матрицу;
•	Vector2D multVector(Vector2D) - умножить матрицу на двумерный вектор (считая его столбцом) и возвратить получившийся столбец в виде вектора.
*/

public class Matrix2x2 {
	
	private double [][] matrix;
	
	public Matrix2x2(double [][] matrix) {
		this.matrix = matrix;
	}
	
	public Matrix2x2(double n1, double n2, double n3, double n4) {
		this(new double[][] {{n1, n2}, {n3, n4}});
	}
	
	public Matrix2x2(double n) {
		this(n, n, n, n);
	}
	
	public Matrix2x2() {
		this(0);
	}
	
	public String toString() {
		return "[" + matrix[0][0] + ", " + matrix[0][1] + "]\n" +
			"[" + matrix[1][0] + ", " + matrix[1][1] + "]";
	}
	
	public Matrix2x2 add(Matrix2x2 m) {
		Matrix2x2 res = new Matrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				res.matrix[i][j] = matrix[i][j] + m.matrix[i][j];
			}
		}
		
		return res;
	}
	
	public void add2(Matrix2x2 m) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] += m.matrix[i][j];
			}
		}
	}
	
	public Matrix2x2 sub(Matrix2x2 m) {
		Matrix2x2 res = new Matrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				res.matrix[i][j] = matrix[i][j] - m.matrix[i][j];
			}
		}
		
		return res;
	}
	
	public void sub2(Matrix2x2 m) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] -= m.matrix[i][j];
			}
		}
	}
	
	public Matrix2x2 multNumber(double num) {
		Matrix2x2 res = new Matrix2x2();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				res.matrix[i][j] = num * matrix[i][j];
			}
		}
		
		return res;
	}
	
	public void multNumber2(double num) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] *= num;
			}
		}
	}
	
//	Matrix2x2 mult(Matrix2x2) - умножение матрицы на другую матрицу;
//	void mult2(Matrix2x2) - умножение матрицы на другую матрицу;
	
	public Matrix2x2 mult(Matrix2x2 m) {
		double n1 = matrix[0][0] * m.matrix[0][0] + matrix[0][1] * m.matrix[1][0];
		double n2 = matrix[0][0] * m.matrix[0][1] + matrix[0][1] * m.matrix[1][1];
		double n3 = matrix[1][0] * m.matrix[0][0] + matrix[1][1] * m.matrix[1][0];
		double n4 = matrix[1][0] * m.matrix[0][1] + matrix[1][1] * m.matrix[1][1];
		return new Matrix2x2(n1, n2, n3, n4);
	}
	
	public void mult2(Matrix2x2 m) {
		Matrix2x2 res = this.mult(m);
		matrix = res.matrix;
	}
	
	public double det() {
		return (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
	}
	
	public void transpon() {
		double temp = matrix[0][1];
		matrix[0][1] = matrix[1][0];
		matrix[1][0] = temp;
	}
	
	public Matrix2x2 inverseMatrix() {
		if (this.det() != 0) {
			return new Matrix2x2(matrix[1][1] / this.det(), (-1)*matrix[0][1] / this.det(),
								(-1)*matrix[1][0] / this.det(), matrix[0][0] / this.det());
		} else {
			return new Matrix2x2();
		}
	}
	
	public Matrix2x2 equivalentDiagonal() {
		
		if (matrix[0][0] != 0){
			return new Matrix2x2(matrix[0][0], 0, 0, (-1)*matrix[0][1] * matrix[1][0] / matrix[0][0] + matrix[1][1]);
		} else if (matrix[1][0] != 0) {
			double [] temp = matrix[0];
			matrix[0] = matrix[1];
			matrix[1] = temp;
			return new Matrix2x2(matrix[0][0], 0, 0, (-1)*matrix[0][1] * matrix[1][0] / matrix[0][0] + matrix[1][1]);
		} else {
			return new Matrix2x2(0, 0, 0, matrix[1][1]);
		}
	}
	
	public Vector2D multVector(Vector2D vector) {
		return new Vector2D(matrix[0][0] * vector.getX() + matrix[0][1] * vector.getY(), 
							matrix[1][0] * vector.getX() + matrix[1][1] * vector.getY());
	}
	
	public static void main(String [] args) {
		
		Matrix2x2 a = new Matrix2x2(new double[][] {{4, 12}, {6, 5.7}});
		Matrix2x2 b = new Matrix2x2(new double[][] {{2, 9}, {4, 1}});
		Vector2D res = a.multVector(new Vector2D(3, 8.1));
		//Matrix2x2 res = a.inverseMatrix();
		//Matrix2x2 res = a.equivalentDiagonal();
		System.out.println(res);
		//a.mult2(b);
		//a.transpon();
		//System.out.println(a);
		//System.out.println(a.det());
		/*
		a.add2(b);
		System.out.println(res);
		System.out.println(a);
		Matrix2x2 res2 = a.multNumber(3);
		a.multNumber2(3);
		System.out.println(a);
		System.out.println(res2);
		*/
	}
	
}