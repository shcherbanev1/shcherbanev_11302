public class Task27 {
	
	public static void main(String [] args) {
		
		int [][] arr = {{1, 7 ,9, 24},
						{24, 39, 3, 6},
						{3, 12, 11, 4}};
		
		boolean flag = false;
		for (int i = 0; i < arr.length && !flag; i++) {
			boolean flag3 = true;
			for (int j = 0; j < arr[i].length && flag3; j++) {
				if (arr[i][j] % 3 != 0) {
					flag3 = false;
				}
				System.out.println(arr[i][j]);
			}
			flag = flag3;
		}
		System.out.println(flag);
	}
	
}