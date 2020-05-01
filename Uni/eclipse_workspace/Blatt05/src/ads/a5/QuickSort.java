package ads.a5;

import java.util.Random;

public class QuickSort extends SortingAlgorithm {
	
	QuickSortStrategie s= QuickSortStrategie.Last;
	private static final Random rng = new Random();
	int currentdepth=0;
	
	public static void swap (int[] f, int a, int b){
		int h=f[a];
		f[a]=f[b];
		f[b]=h;
	}
	public void quickSort(int[] f, int start, int end) {
	
	}
	
	public int getPivot(QuickSortStrategie qs,int[] f, int start, int end) {
		int pivot=f[end];
		return pivot;
	}
	
	public int partition(int[] f, int start, int end) {
		// pivot= getPivot(s, f, start, end); - Beispiel 
		return start; 
		}
	@Override
	public int[] sort(int[] f) {
		// TODO Auto-generated method stub
		currentdepth = 0;
		duration=System.currentTimeMillis();
        quickSort(f, 0, f.length-1);
        duration= System.currentTimeMillis()-duration;
        return f;
	}

}
