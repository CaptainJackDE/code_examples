package ads.a4;

public class MergeSort extends SortingAlgorithm {
	
	public void mergeSort(int[] f, int start, int end, int depth) {
		int mid;
		if(end > start) {
			comparison++;
			mid = (start + end) / 2;
//	        mergeSort(f, start, mid, depth++);
//	        mergeSort(f, (mid + 1), end, depth++);
		
	        int[] tmp = new int[f.length];
	        int end_f1, pos;
	        pos = start;
	        end_f1 = mid-1;
		
	        while((start <= end_f1) && (mid <= end)) {
	        	if(f[start] <= f[mid]) tmp[pos++] = f[start++];
	        	else tmp[pos++] = f[mid++];
	        	swap++;
			}

	        while(start <= end_f1) {
	        	tmp[pos++] = f[start++];
	        	swap++;
	        }

	        while(mid <= end) {
	        	tmp[pos++] = f[mid++];
	        	swap++;
	        }

	        for(int i = 0; i < end-start+1; i++) {
	        	f[end] = tmp[end];
	        	end--;
	        }
		}
	}
	
	@Override
	public int[] sort(int[] f) {
		duration = System.currentTimeMillis();
		int end = f.length-1;
		int start = 0;
		
		mergeSort(f, start, end, 0);
		duration = System.currentTimeMillis() - duration;
        return f;
	}
	
}
