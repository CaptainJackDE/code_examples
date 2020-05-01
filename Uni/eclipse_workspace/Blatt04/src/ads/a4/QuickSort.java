package ads.a4;

public class QuickSort extends SortingAlgorithm {
	int currentdepth=0;
	
	@Override
	public int[] sort(int[] f) {
		int start = 0;
		int end = f.length-1;
		quickSort(f, start, end);
        return f;
	}
	
	public void quickSort(int[] f, int start, int end) {
		duration = System.currentTimeMillis();
		count++;
		while (start < end) {
			comparison++;
			int part = partition(f, start, end);
			if (part - start < end - part) {
				quickSort(f, start, part - 1);
				start = part + 1;
			} else{
				quickSort(f, part + 1, end);
				end = part - 1;
			}
		}
		duration = System.currentTimeMillis() - duration;
	}
	
	public int partition(int[] f, int start, int end) {
		int part = start;
		int pivot = f[end];
		for (int i = start; i <= end; i++) if (f[i] <= pivot) swap(f, i , part++);
		return part - 1;
	}
	
	public void swap(int[] f, int a, int b) {
		int tmp = f[a];
		f[a] = f[b];
		f[b] = tmp;
		swap++;
	}
}
