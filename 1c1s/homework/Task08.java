import java.util.Scanner;

public class Task08 {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int count = 0;
		char ch;
		boolean flag = true;
		
		for (int i = 0; i < s.length() && flag; i++) {
			ch = s.charAt(i);
			if (ch == '(') {
				count += 1;
			} else if (ch == ')') {
				count -= 1;
			}
			if (count < 0) {
				flag = false;
			}
		}
		if (count != 0) {
			flag = false;
		}
		
		System.out.print(flag);
	}
}