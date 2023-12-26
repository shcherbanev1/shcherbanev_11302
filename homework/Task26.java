public class Task26 {
	
	public static void main(String [] args) {
		
		int [] arr = {12, 978, 4, 8, 54, 38, -515, 234};
		boolean flag = true;
		for (int i = 0; i < arr.length && flag; i++) {
			if (arr[i] > 0) {
				flag = hasEven(arr[i]);
			}
		}
		System.out.println(flag);
	}
	
	public static boolean hasEven(int number) {
		while (number > 0) {
			if ((number % 10) % 2 == 0) {
				return true;
			}
			number /= 10;
		}
		return false;
	}
	
}