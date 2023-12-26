public class Task02 {
	
	public static void main(String [] args) {
		
		int n = 4;
		int spaces = 2*n - 1;
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= spaces; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= 2*i - 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			spaces--	;
		}
		spaces = 2*n - 1;
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= 2*i - 1; j++) {
				System.out.print("*");
			}
			
			for (int j = 1; j <= spaces; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= 2*i - 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			spaces -= 2;
		}
		
	}
}
