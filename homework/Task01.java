public class Task01 {
	
	public static void main(String [] args) {
	
		int n = 10;
		
		System.out.println("1)");
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}	
			System.out.println();
		}

		System.out.println();
		System.out.println("2)");
		System.out.println();
		
		for (int i = n; i >= 1; i--) {
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("3)");
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			for (int j = (n-i); j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}	
}	