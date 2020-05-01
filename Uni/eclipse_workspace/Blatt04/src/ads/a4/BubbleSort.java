package ads.a4;

public class BubbleSort extends SortingAlgorithm {

	
	@Override
	public int[] sort(int[] f) {
		duration = System.currentTimeMillis();
		int last = f.length-1;
		  for(int i = 1; i < f.length; i++) {
			  boolean is_sorted = true;
			  int current = -1;

			  for(int j = 0; j < last; j++) {
				  comparison++;
				  if(f[j] > f[j+1]) {
					  swap++;
					  int temp = f[j];
					  f[j] = f[j+1];
					  f[j+1] = temp;
					  is_sorted = false;
					  current = j;
				  }
				  if(is_sorted) return f;
				  last = current;
		    }   
		}
		duration = System.currentTimeMillis() - duration;
		return f;
	}
}
