package blatt01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestComplex {
	
	Complex cn1 = new Complex(1,3);
	Complex cn2 = new Complex(4,4);

	@Test
	public void testAddComplex() {
		Complex cn = new Complex(5,7);
		assertTrue((cn) == (cn1.add(cn2)));
	}

	@Test
	public void testSubtractComplex() {
		Complex cn = new Complex(-3,1);
		assertTrue(cn == (cn1.subtract(cn2)));
	}

	@Test
	public void testMultiplyComplex() {
		Complex cn = new Complex(-8,16);
		assertTrue(cn == (cn1.multiply(cn2)));
	}

	@Test
	public void testDivideComplex() {
		Complex cn = new Complex(16/32,8/32);
		assertTrue(cn == (cn1.divide(cn2)));
	}


}
