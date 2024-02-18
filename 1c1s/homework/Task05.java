public class Task05 {
	
	public static void main(String[] args) {
		
		final double EPS = 1e-9;
		double x = 0.3;
		double s = 0;
		double deg = x;
		int sign = 1;
		double a = EPS + 1;
		int k = 1;
		
		while (Math.abs(a) > EPS) {
			a = sign * (deg / k);
			s += a;
			sign = (-1)*sign;
			deg *= x;
			k += 1;
		}
		System.out.println("ln(1 + " + x + ") = " + s);
		System.out.println("Math.log(1 + " + x + ") = " + Math.log1p(x));
		System.out.println("dif = " + Math.abs(Math.log1p(x) - s));
	}
}