package ads.a5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class SelectionSortTest {
	SelectionSort sv;
	int[] feld1 = {4, 21, 47, 29, 3, 46, 37, 22, 23, 29};
	int[] feld2 = {3, 4, 47, 29, 21, 46, 37, 22, 23, 29};
	int[] feld3 = {4, 21, 23, 29, 3, 18, 37, 22, 46, 47};
	int[] feld4 = {3, 4, 7, 8, 12, 18, 22, 32, 46, 47};
	int[] feld5 = {47, 46, 32, 22, 18, 12, 8, 7, 4, 3};
	int[] feld6 = {4};
	int[] feld7 = {4, 21};

	Liste l1, l2, l3, lr;

	@Before
	public void setUp() throws Exception {
		sv = new SelectionSort();
		
	}

	public static  boolean isSorted(Liste f){
		while(f!=null){
			if(f.next!=null)
				if(f.value> f.next.value)
					return false;
			f=f.next;
		}
		return true;
	}
	
	@Test
	public void testOptimal() {
		// testing the optimal number of swaps, comparison and passes
		System.out.println("testOptimal");
	  	sv.reset();
	  	l1 =InputGenerator.arrayToListe(feld1);
	  	SortingAlgorithmListe.printListe(l1);
    	lr= sv.sort(l1);
    	System.out.println("Versuch bei Feldlänge: "+feld1.length);
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		SortingAlgorithmListe.printListe(lr);
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=10 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=55 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		assertTrue("isSorted",isSorted(lr));
		System.out.println();
		
		sv.reset();
	  	l2 =InputGenerator.arrayToListe(feld2);
	  	SortingAlgorithmListe.printListe(l2);
    	lr= sv.sort(l2);
    
    	System.out.println("Versuch bei Feldlänge: "+feld2.length);
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		SortingAlgorithmListe.printListe(lr);
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=10 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=55 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		assertTrue("isSorted",isSorted(lr));
		System.out.println();
		
		sv.reset();
	  	l3 =InputGenerator.arrayToListe(feld3);
	  	SortingAlgorithmListe.printListe(l3);
    	lr= sv.sort(l3);
    	System.out.println("Versuch bei Feldlänge: "+feld3.length);
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		SortingAlgorithmListe.printListe(lr);
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=10 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=55 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		assertTrue("isSorted",isSorted(lr));
    	System.out.println();
		
		sv.reset();
	  	l3 =InputGenerator.arrayToListe(feld4);
	  	SortingAlgorithmListe.printListe(l3);
    	lr= sv.sort(l3);
    	System.out.println("Versuch bei Feldlänge: "+feld4.length);
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		SortingAlgorithmListe.printListe(lr);
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=10 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=55 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		assertTrue("isSorted",isSorted(lr));
    	System.out.println();
    	
		sv.reset();
	  	l3 =InputGenerator.arrayToListe(feld5);
	  	SortingAlgorithmListe.printListe(l3);
    	lr= sv.sort(l3);
    	System.out.println("Versuch bei Feldlänge: "+feld5.length);
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		SortingAlgorithmListe.printListe(lr);
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=10 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=55 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=10 );
		assertTrue("isSorted",isSorted(lr));
    	System.out.println();
    	
		sv.reset();
	  	l3 =InputGenerator.arrayToListe(feld6);
	  	SortingAlgorithmListe.printListe(l3);
    	lr= sv.sort(l3);
    	System.out.println("Versuch bei Feldlänge: "+feld6.length);
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		SortingAlgorithmListe.printListe(lr);
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=1 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=1 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=1 );
		assertTrue("isSorted",isSorted(lr));
    	System.out.println();
    	
		
		sv.reset();
	  	l3 =InputGenerator.arrayToListe(feld7);
	  	SortingAlgorithmListe.printListe(l3);
    	lr= sv.sort(l3);
    	System.out.println("Versuch bei Feldlänge: "+feld7.length);
		System.out.println(" Vergleiche: "+ sv.getComparison()+" Vertauschungen: "+sv.getSwap()+" Zeit: "+ sv.getDuration()+" Durchlaeufe:"+sv.getCount());
		SortingAlgorithmListe.printListe(lr);
		assertTrue("Compare the number of swaps "+sv.getSwap(), sv.getSwap()<=2 );
		assertTrue("Compare the number of comparision "+sv.getComparison(), sv.getComparison()<=3 );
		assertTrue("Compare the number of pass"+sv.getCount(), sv.getCount()<=2 );
		assertTrue("isSorted",isSorted(lr));
    	System.out.println();
    	
	}
	@Test
	public void testDurationRandom() {
	
	}

	@Test
	public void testDurationFixed() {

	}
	
}
