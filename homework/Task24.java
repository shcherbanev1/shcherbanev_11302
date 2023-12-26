public class Task24 {
	
	public static void main(String [] args) {
		
		int [] arr = {1, 6, 4, -8, 5, 3, 55, 234, 5};
		int count = 0;
		for (int i = 0; i < arr.length && count < 2; i++) {
			if (arr[i] < 0) {
				count += 1;
			}
		}
		System.out.println(count >= 2);
	}
	
}