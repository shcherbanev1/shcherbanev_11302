public class Task04 {
	
	public static void main(String[] args) {
		
		final double EPS = 1e-6;
		double s = 0;
		double x = Math.PI / 6;
		int fact = 1;
		double deg = 1;
		int sign = 1;
		int k = 0;
		double a = EPS + 1;
		
		while (Math.abs(a) > EPS) {
			a = sign * (deg / fact);
			s += a;
			sign = (-1) * sign;
			fact *= (k + 1)*(k + 2);
			deg *= x*x;
			k += 2;
			//System.out.println("a = " + a);
			//System.out.println("deg = " + deg);
			//System.out.println("fact = " + fact);
		}
		System.out.println("answer " + s);
		System.out.println(Math.cos(x));
		System.out.println("dif " + Math.abs(Math.cos(x) - s));
	}
}