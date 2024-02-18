// вариант 2

public class Task3 {
	
	public static void main(String [] args) {
		
		int n = 5;
		
		int [][] data = {{7, 8, 9}, {7, 12}, {7, 8, 11}, {11, 15, 21}, {20}};
		int [] time = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int [] count = new int[time.length];
		
		for (int t = 0; t < time.length; t++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < data[i].length; j++) {
					if (time[t] == data[i][j]) {
						count[time[t] - 7] += 1;
					}
				}
			}
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println((7 + i) + ":00 " + count[i] + " workers");
		}
		
	}
	
}