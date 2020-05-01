package blatt01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComplexTestMaurice2 {
	
	Complex cn1 = new Complex(1,3);
	Complex cn2 = new Complex(4,4);
	
	public void testadd() {
		try {
			assertEquals(new Complex(5,7), cn1.add(cn2));
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testsubtract() {
		try {
			assertEquals(new Complex(-3,-1), cn1.subtract(cn2));
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testmultiply() {
		try {
			assertEquals(new Complex(-8,16), cn1.multiply(cn2));
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testdivide() {
		try {
			assertEquals(new Complex(16/32,8/32), cn1.divide(cn2));
		}catch (Exception e) {
			fail();
		}
	}

}
