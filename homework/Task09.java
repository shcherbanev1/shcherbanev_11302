import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Task9 {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Pattern p = Pattern.compile("[a-zA-Z$_][a-zA-Z0-9$_]* = ([1-9][0-9]*|[a-zA-Z$_][a-zA-Z0-9$_]*) [+\\-\\*/] ([1-9][0-9]*|[a-zA-Z$_][a-zA-Z0-9$_]*);");
		Matcher m = p.matcher(s);
		System.out.println(m.matches());
		
	}
}