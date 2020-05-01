package blatt01;

public class Complex {
	double re;
	double im;

	public Complex() {
	    this(0);
	}	
	
	public Complex(double real) {
	    this(real, 0);
	}
	
	public Complex(double real, double img) {
	    this.re = real;
	    this.im = img;
	}
	
	public Complex(Complex cn) {
	    this.re = cn.re;
	    this.im = cn.im;
	}
	
	public Complex add(Complex cn) {
	    return new Complex(this.re + cn.re, this.im + cn.im);
	}
	 
	public Complex subtract(Complex cn) {
	    return new Complex(this.re - cn.re, this.im - cn.im);
	}
	 
	public Complex multiply(Complex cn) {
	    double re = this.re * cn.re - this.im * cn.im;
	    double im = this.im * cn.re + this.re * cn.im;
	    return new Complex(re, im);
	}
	 
	public Complex divide(Complex cn) {
	    double cAndDSquared = (cn.re * cn.re + cn.im * cn.im);
	    double re = (this.re * cn.re + this.im * cn.im) / cAndDSquared;
	    double im = (this.im * cn.re - this.re * cn.im) / cAndDSquared;
	    return new Complex(re, im);
	}
	
	public Complex add(double number) {
	    return this.add(new Complex(number));
	}
	 
	public Complex subtract(double number) {
	    return this.subtract(new Complex(number));
	}
	 
	public Complex multiply(double number) {
	    return this.multiply(new Complex(number));
	}
	 
	public Complex divide(double number) {
	    return this.divide(new Complex(number));
	}
	
	public void setRealPart(double real) {
	    this.re = real;
	}
	 
	public double getRealPart() {
	    return this.re;
	}
	 
	public void setImaginaryPart(double imaginary) {
	    this.im = imaginary;
	}
	 
	public double getImaginaryPart() {
	    return this.im;
	}
}
