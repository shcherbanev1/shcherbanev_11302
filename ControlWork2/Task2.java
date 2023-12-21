// вариант 2

import java.util.Scanner;

public class Task2 {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//int m = 2;
		//int n = 3;
		//double [][] A = {{1, 2}, {3, 4}};
		
		System.out.println("ввод m");
		int m = sc.nextInt();
		System.out.println("ввод n");
		int n = sc.nextInt();
		System.out.println("ввод A");
		double [][] A = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				A[i][j] = sc.nextDouble();
			}
		}
		
		double [][] copyA = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				copyA[i][j] = A[i][j];
			}
		}
		
		double [][] answer = new double[m][m];
		double [][] I = createImatrix(m);
		
		
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				answer = sum(answer, I);
			} else if (i == 1) {
				answer = sum(answer, copyA);
			} else {
				A = multiplyMatrix(A, copyA);
				answer = sum(answer, A);
			}
		}
		
		for (int j = 0; j < m; j++) {
					for (int k = 0; k < m; k++) {
						System.out.print(answer[j][k] + " ");
					}
				System.out.println();
				}
	}
	
	public static double [][] createImatrix(int m) {
		double [][] I = new double[m][m];
		for (int i = 0; i < m; i++) {
			I[i][i] = 1;
		}
		return I;
	}
	
	public static double [][] sum(double [][] matrix1, double[][] matrix2) {
		int m = matrix1.length;
		double [][] result = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return result;
	}
	
	public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
		int m = matrix1.length;
		double[][] resultMatrix = new double[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				for (int y = 0; y < m; y++) {
					resultMatrix[i][j] += matrix1[i][y]*matrix2[y][j];
				}
			}
		}
		return resultMatrix;
	}
	
}