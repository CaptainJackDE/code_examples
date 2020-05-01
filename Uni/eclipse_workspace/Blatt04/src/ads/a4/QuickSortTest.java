package ads.a4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import ads.a4.InputGenerator;

public class QuickSortTest {
	QuickSort sv;
	int[] feld1 = {4, 21, 47, 29, 3, 46, 37, 22, 23, 29};
	int[] feldso1 = {1,2,3,4,5,6,7,8,9,10};
	int[] feldso2 = {10,9,8,7,6,5,4,3,2,1};
	int[] feldsw0 = {5, 23, 8, 42, 35, 34, 4, 16};
	int[] feldsw1 = {4, 2, 1, 6, 3, 5};
	int[] feldsw2 = {64, 25, 12, 22, 11};
	int[] feldsw3 = {};
	

	@Before
	public void setUp() throws Exception {
		sv = new QuickSort();
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
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=21);
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=30 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=6 );
		
	  	sv.reset();
    	sv.sort(feldso1);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 10: aufsteigend");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldso1.length; i++)
		   System.out.print(feldso1[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=54 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=54 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		
	  	sv.reset();
    	sv.sort(feldso2);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 10:  absteigend");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldso2.length; i++)
		   System.out.print(feldso2[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=29 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=54);
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10);
		
	  	sv.reset();
    	sv.sort(feldsw0);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 8: 5, 23, 8, 42, 35, 34, 4, 16");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldsw0.length; i++)
		   System.out.print(feldsw0[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=13 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=22 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=5 );

		sv.reset();
    	sv.sort(feldsw1);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 6:  4, 2, 1, 6, 3, 5");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldsw0.length; i++)
		   System.out.print(feldsw0[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=9);
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=12);
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=4 );
		
	  	sv.reset();
    	sv.sort(feldsw2);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 5: 64, 25, 12, 22, 11");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldsw2.length; i++)
		   System.out.print(feldsw2[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=7 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=12 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=4 );
		
	  	sv.reset();
    	sv.sort(feldsw3);
    	System.out.println();
    	System.out.println("Versuch bei Feldlänge: 0:   ");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
		for(int i=0; i<feldsw3.length; i++)
		   System.out.print(feldsw3[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()==0 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getSwap()==0 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=1 );
	}
	@Test
	public void testDurationRandom() {
		fail("Not yet implemented");
	}

	@Test
	public void testDurationFixed() {
		fail("Not yet implemented");
	}
	
}
