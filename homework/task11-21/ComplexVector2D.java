public class ComplexVector2D {
	
	private ComplexNumber x;
	private ComplexNumber y;
	
	ComplexVector2D() {
		this(new ComplexNumber(), new ComplexNumber());
		
	}
	
	ComplexVector2D(ComplexNumber x, ComplexNumber y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + x.toString() + ", " + y.toString() + "]";
	}	
	
	public ComplexVector2D add(ComplexVector2D vector) {
		return new ComplexVector2D(x.add(vector.x), y.add(vector.y));
	}
	
	public ComplexNumber scalarProduct(ComplexVector2D vector) {
		return (x.mult(vector.x).add(y.mult(vector.y)));
	}
	
	public boolean equals(ComplexVector2D vector) {
		return x.equals(vector.x) && y.equals(vector.y);
	}
	
	public ComplexNumber getX() {
		return x;
	}

	public ComplexNumber getY() {
		return y;
	}	
	
	public static void main(String [] args) {
		ComplexVector2D a = new ComplexVector2D(new ComplexNumber(1, 3), new ComplexNumber(5, 7));
		ComplexVector2D b = new ComplexVector2D(new ComplexNumber(1, 33), new ComplexNumber(-25, 17));
		ComplexNumber res = a.scalarProduct(b);
		System.out.println(res);
		System.out.println(a.equals(b));
	}
	
}