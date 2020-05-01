package ads.a4;

public class SelectionSort extends SortingAlgorithm {
	
	 
	@Override
	public int[] sort(int[] f) {
		duration = System.currentTimeMillis();
		int min = 0;
		int end = 0;
		int temp;
		
		for(int i = 0; i < f.length; i++) {
			count++;
			for(int j = i; j < f.length; j++) {
				if(f[j] > min) {
					min = j;
					end++;
				}
				comparison++;
			}
			if(end == f.length) break;
			swap++;
			temp = f[i];
			f[i] = f[min];
			f[min] = temp;
			
		}
		duration = System.currentTimeMillis() - duration;
		return f;
	}
}
