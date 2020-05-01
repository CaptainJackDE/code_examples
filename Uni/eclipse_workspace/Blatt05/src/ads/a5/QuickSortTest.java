package ads.a5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class QuickSortTest {
	QuickSort sv;
	int[] feld;
	int[] feld1 = {4, 21, 47, 29, 3, 46, 37, 22, 23, 29};
	int[] feldso1 = {1,2,3,4,5,6,7,8,9,10};
	int[] feldso2 = {10,9,8,7,6,5,4,3,2,1};
	

	@Before
	public void setUp() throws Exception {
		sv = new QuickSort();
	}

	public static  boolean isSorted(int[] f){
		for(int i=0; i<f.length-1; i++)
			if(f[i]>f[i+1]) return false;
		return true;
	}
	
	public static int[] copyArray(int[] f){
		int[] r= new int[f.length];
		for(int i=0; i<f.length; i++)
			r[i]= f[i];
		return r;
	}
	
	@Test
	public void testOptimal() {
		// testing the optimal number of swaps, comparison and passes
		for(QuickSortStrategie qss: QuickSortStrategie.values()) {
			System.out.println(qss);
			sv.reset();
			sv.s=qss;
			feld=copyArray(feld1);
			sv.sort(feld);	
			System.out.println("Versuch bei Feldlänge:  10:  4, 21, 47, 29, 3, 46, 37, 22, 23, 29");
			System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
			/* for(int i=0; i<feld.length; i++)
				System.out.print(feld[i]+", ");
			System.out.println(); */
			assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=30);
			assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=50 );
			assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=8 );
			assertTrue("isSorted", isSorted(feld));
			System.out.println();
		};
		
		for(QuickSortStrategie qss: QuickSortStrategie.values()) {
			System.out.println(qss);
			sv.reset();
			sv.s=qss;
			feld=copyArray(feldso1);
			sv.sort(feld);
			System.out.println("Versuch bei Feldlänge: 10: aufsteigend");
			System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
			for(int i=0; i<feld.length; i++)
				System.out.print(feld[i]+", ");
			System.out.println();
			assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=60 );
			assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=60 );
			assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
			assertTrue("isSorted", isSorted(feld));
			System.out.println();
		};
		for(QuickSortStrategie qss: QuickSortStrategie.values()) {
			System.out.println(qss);
			sv.reset();
			sv.s=qss;
			feld=copyArray(feldso2);
			sv.sort(feld);
			System.out.println("Versuch bei Feldlänge: 10:  absteigend");
			System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Rekursionstiefe:"+sv.getCount());
			for(int i=0; i<feld.length; i++)
				System.out.print(feld[i]+", ");
			System.out.println();
			assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=60 );
			assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=60);
			assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10);
			assertTrue("isSorted", isSorted(feld));
			System.out.println();
		};

	}
	@Test
	public void testDurationRandom() {
	}

	@Test
	public void testDurationFixed() {
	}
}
