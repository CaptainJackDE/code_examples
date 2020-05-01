package ads.a5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class HeapSortTest {
	HeapSort sv;
	int[] feld1 = {4, 21, 47, 29, 3, 46, 37, 22, 23, 29};
	int[] feldso1 = {1,2,3,4,5,6,7,8,9,10};
	int[] feldso2 = {10,9,8,7,6,5,4,3,2,1};
	int[] feldsw0 = {5, 23, 8, 42, 35, 34, 4, 16};
	int[] feldsw1 = {4, 2, 1, 6, 3, 5};
	int[] feldsw2 = {64, 25, 12, 22, 11};
	int[] feldsw3 = {};
	

	@Before
	public void setUp() throws Exception {
		sv = new HeapSort();
	}

	public static  boolean isSorted(int[] f){
		for(int i=0; i<f.length-1; i++)
			if(f[i]>f[i+1]) return false;
		return true;
	}
	
	@Test
	public void testOptimal() {
		// testing the optimal number of swaps, comparison and passes
	  	sv.reset();
    	sv.sort(feld1);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 10:  4, 21, 47, 29, 3, 46, 37, 22, 23, 29");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feld1.length; i++)
		   System.out.print(feld1[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=35);
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=80 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		assertTrue("isSorted", isSorted(feld1));
		
	  	sv.reset();
    	sv.sort(feldso1);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 10: aufsteigend");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldso1.length; i++)
		   System.out.print(feldso1[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=35 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=80);
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		assertTrue("isSorted", isSorted(feldso1));
		
	  	sv.reset();
    	sv.sort(feldso2);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 10:  absteigend");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldso2.length; i++)
		   System.out.print(feldso2[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=35 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=80);
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10);
		assertTrue("isSorted", isSorted(feldso2));
	}
	@Test
	public void testDurationRandom() {
	
	}

	@Test
	public void testDurationFixed() {

	}
}
