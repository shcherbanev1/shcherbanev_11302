public class Task29 {
	
	public static void main(String [] args) {
		
		int [][] arr = {{34, 356, 893, 224}, 
						{86, 46, 666, 8284}, 
						{26, 87, 242, 628}};
	
		boolean flag = true;
		for (int i = 0; i < arr.length && flag; i++) {
			boolean flag2 = false;
			for (int j = 0; j < arr[0].length && !flag2; j++) {
				flag2 = onlyEven(arr[i][j]);
			}
			flag = flag2;
		}
		
		System.out.println(flag);
		
	}
	
	public static boolean onlyEven(int number) {
		while (number > 0) {
			if ((number % 10) % 2 == 1) {
				return false;
			}
			number /= 10;
		}
		return true;
	}
	
}