/*Создать класс ComplexNumber - комплексное число. Атрибуты - действительная и мнимая части (два числа). Методы:
•	ComplexNumber() - конструктор для нулевого комплексного числа;
•	ComplexNumber(double, double) - конструктор комплексного числа с заданными значениями вещественной и мнимой части; в конструкторах устраняйте дублирование кода;
•	ComplexNumber add(ComplexNumber) - сложение комплексного числа с другим комплексным числом;
•	void add2(ComplexNumber) - сложение комплексного числа с другим комплексным числом;
•	CompexNumber sub(ComplexNumber) - вычитание из комплексного числа  другого комплексного числа;
•	void sub2(ComplexNumber) - вычитание из комплексного числа другого комплексного числа;
•	ComplexNumber multNumber(double) - умножение комплексного числа на вещественное число;
•	void multNumber2(double) - умножение комплексного числа на вещественное число;
•	ComplexNumber mult(ComplexNumber) - умножение комплексного числа на другое комплексное число;
•	void mult2(ComplexNumber) - умножение комплексного числа на другое комплексное число;
•	ComplexNumber div(ComplexNumber) - деление на другое комплексное число;
•	void div2(ComplexNumber) - деление на другое комплексное число;
•	double length() - модуль комплексного числа; 
•	String toString() - строковое представление комплексного числа.  Только без всяких "2 * i + - 3". Проверяйте знаки, чтобы было красиво: 2 * i - 3.
•	double arg() - аргумент комплексного числа (может понадобиться тригонометрическое представление (читайте ссылку) и арктангенс Math.atan);


•	ComplexNumber pow(double) - возвести в степень по Формуле Муавра (иные способы запрещены). Внимание - разрешено использование Math.pow для возведения аргумента в степень (т.к. оба аргумента double), также вам понадобятся Math.cos, Math.sin.
•	boolean equals(ComplexNumber) - сравнить комплексное число с другим комплексным числом;
*/

public class ComplexNumber {
	
	private double real;
	private double imaginary;
	
	ComplexNumber() {
		this(0, 0);
	}
	
	ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public ComplexNumber add(ComplexNumber num) {
		return new ComplexNumber(real + num.real, imaginary + num.imaginary);
	}
	
	public void add2(ComplexNumber num) {
		real += num.real;
		imaginary += num.imaginary;
	}
	
	public ComplexNumber sub(ComplexNumber num) {
		return new ComplexNumber(real - num.real, imaginary - num.imaginary);
	}
	
	public void sub2(ComplexNumber num) {
		real -= num.real;
		imaginary -= num.imaginary;
	}
	
	public ComplexNumber multNumber(double num) {
		return new ComplexNumber(real*num, imaginary*num);
	}
	
	public void multNumber2(double num) {
		real *= num;
		imaginary *= num;
	}
	
	public ComplexNumber mult(ComplexNumber num) {
		return  new ComplexNumber(real * num.real - imaginary * num.imaginary, imaginary * num.real + real * num.imaginary);
	}
	
	public void mult2(ComplexNumber num) {
		real = real * num.real - imaginary * num.imaginary;
		imaginary = imaginary * num.real + real * num.imaginary;
	}
	
	public ComplexNumber div(ComplexNumber num) {
		double a = (real * num.real + imaginary * num.imaginary) / (num.real * num.real + num.imaginary*num.imaginary);
		double b = (imaginary * num.real - real * num.imaginary) / (num.real * num.real + num.imaginary*num.imaginary);
		return new ComplexNumber(a, b);
	}
	
	public void div2(ComplexNumber num) {
		double a = (real * num.real + imaginary * num.imaginary) / (num.real * num.real + num.imaginary*num.imaginary);
		double b = (imaginary * num.real - real * num.imaginary) / (num.real * num.real + num.imaginary*num.imaginary);
		real = a;
		imaginary = b;
	}
	
	public double length() {
		return Math.sqrt(real*real + imaginary*imaginary);
	}
	
	public String toString() {
		if (imaginary > 0) {
			return (real + " + " + imaginary + "i");
		} else if (imaginary < 0) {
			return (real + " - " + ((-1)*imaginary) + "i");
		} else {
			return (real + "");
		}
	}
	
	public double arg() {
		return Math.atan(imaginary / real);
	}
	
	public ComplexNumber pow(double n) {
		double r = Math.pow(this.length(), n);
		double angle = this.arg() * n;
		return new ComplexNumber(r * Math.cos(angle), r * Math.sin(angle));
	}
	
	public boolean equals(ComplexNumber num) {
		return (Math.abs(real - num.real) < 0.01 && Math.abs(imaginary - num.imaginary) < 0.01);
	}
	
	public static void main(String [] args) {
		ComplexNumber a = new ComplexNumber(3, 2);
		ComplexNumber b = new ComplexNumber(2, 3);
		a.div2(b);
		System.out.println(a);
		System.out.println(a.length());
	}
	
}