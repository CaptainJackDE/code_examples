package ads.a4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
	BubbleSort sv;
	int[] feld1 = {4, 21, 47, 29, 3, 46, 37, 22, 23, 29};
	int[] feldso1 = {1,2,3,4,5,6,7,8,9,10};
	int[] feldso2 = {10,9,8,7,6,5,4,3,2,1};
	int[] feldsw0 = {5, 23, 8, 42, 35, 34, 4, 16};
	int[] feldsw1 = {4, 2, 1, 6, 3, 5};
	int[] feldsw2 = {64, 25, 12, 22, 11};
	int[] feldsw3 = {};
	

	@Before
	public void setUp() throws Exception {
		sv = new BubbleSort();
	}

	@Test
	public void testOptimal() {
		// testing the optimal number of swaps, comparison and passes
	  	sv.reset();
    	sv.sort(feld1);
    	System.out.println();
    	System.out.println("Versuch bei Feldl�nge: 10:  4, 21, 47, 29, 3, 46, 37, 22, 23, 29");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		for(int i=0; i<feld1.length; i++)
		   System.out.print(feld1[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=19 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=34 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=5 );
		
	  	sv.reset();
    	sv.sort(feldso1);
    	System.out.println();
    	System.out.println("Versuch bei Feldl�nge: 10: aufsteigend");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		for(int i=0; i<feldso1.length; i++)
		   System.out.print(feldso1[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=0 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=9 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=1 );
		
	  	sv.reset();
    	sv.sort(feldso2);
    	System.out.println();
    	System.out.println("Versuch bei Feldl�nge: 10:  absteigend");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		for(int i=0; i<feldso2.length; i++)
		   System.out.print(feldso2[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=45 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=45 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10);
		
	  	sv.reset();
    	sv.sort(feldsw0);
    	System.out.println();
    	System.out.println("Versuch bei Feldl�nge: 8: 5, 23, 8, 42, 35, 34, 4, 16");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		for(int i=0; i<feldsw0.length; i++)
		   System.out.print(feldsw0[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=14 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=26 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=7 );

		sv.reset();
    	sv.sort(feldsw1);
    	System.out.println();
    	System.out.println("Versuch bei Feldl�nge: 6:  4, 2, 1, 6, 3, 5");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		for(int i=0; i<feldsw0.length; i++)
		   System.out.print(feldsw0[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=6 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=11);
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=3 );
		
	  	sv.reset();
    	sv.sort(feldsw2);
    	System.out.println();
    	System.out.println("Versuch bei Feldl�nge: 5: 64, 25, 12, 22, 11");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		for(int i=0; i<feldsw2.length; i++)
		   System.out.print(feldsw2[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=9 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=10 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=5 );
		
	  	sv.reset();
    	sv.sort(feldsw3);
    	System.out.println();
    	System.out.println("Versuch bei Feldl�nge: 0:   ");
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		for(int i=0; i<feldsw3.length; i++)
		   System.out.print(feldsw3[i]+", ");
		System.out.println();
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=0 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=0 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=0 );
	}
	@Test
	public void testDurationRandom() {
		long testcomparisation, tc;
		long testswap, ts;
		double testduration, td;
		int feld[];
		int[] fl={10, 100, 1000, 10000, 20000};
		int anz = 10;
		tc=0;
		ts=0;
		td=0;
		for (int j=0; j<fl.length; j++) {
			testcomparisation=0;
			testswap=0;
			testduration=0;
		    for(int i=0; i <anz; i++){
		    	feld=InputGenerator.randomSequence(fl[j]);
		    	sv.reset();
		    	sv.sort(feld);
		    	testcomparisation += sv.getComparison();
				testswap += sv.getSwap();
				testduration += sv.getDuration();
		    }
		    tc = testcomparisation/anz;
			ts = testswap/anz;
			td = testduration/anz;
			System.out.println("Mittelwerte f�r "+anz+" Versuche bei Feldl�nge:"+fl[j]);
			System.out.println(" Vergleiche: "+ tc+" Vertauschungen: "+ts+" Zeit: "+ td);
		}
	}

	@Test
	public void testDurationFixed() {
		int feld[];
		int[] fl={10, 100, 1000, 10000, 20000};
		
		for (int j=0; j<fl.length; j++) {

		    feld=InputGenerator.increasingSequence(fl[j]);
		    sv.reset();
		    sv.sort(feld);
			System.out.println("Versuch bei Feldl�nge:"+fl[j]+" aufsteigend");
			System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
			
		    feld=InputGenerator.decreasingSequence(fl[j]);
		    sv.reset();
		    sv.sort(feld);
			System.out.println("Versuch bei Feldl�nge:"+fl[j]+" absteigend");
			System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
			
		    feld=InputGenerator.uniformSequence(fl[j], 4);
		    sv.reset();
		    sv.sort(feld);
			System.out.println("Versuch bei Feldl�nge:"+fl[j]+" gleiche Werte");
			System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
			
		    }

		
		}
	
}
