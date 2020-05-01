package ads.a4;

public class InsertionSort extends SortingAlgorithm {

	@Override
	public int[] sort(int[] f) {
		duration = System.currentTimeMillis();
	
		for (int i = 0; i < f.length; i++) {
	        for (int j = i; j > 0 && f[j] < f[j-1]; j--) {
	            int tmp = f[j];
	            f[j] = f[j-1];
	            f[j-1] = tmp;
	        }
	    }
        duration = System.currentTimeMillis() - duration;
		return f;
	}
}
            
         
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		if(f == null || f.length == 0) {
//			return f;
//		} else {
//			for(int m = f.length; m > 0; m--) {
//				for(int i = 1; i < m; i++) {
//					if(f[i-1] < f[i]) {swap(f, i-1, i); swap++;}
//					comparison++;
//					}
//				}
//			count++;
//			duration = System.currentTimeMillis() - start;
//			}
//		return f;
//		}
//
//}