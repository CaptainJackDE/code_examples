package ads.a5;

public class HeapSort extends SortingAlgorithm {
	
	public void heapSort(int[] f, int start, int end) {
		int h;
		// Erzeugen des Heaps - buildheap
		for(int i=end/2; i>=0; i--)
			heapify(f, end, i);
			
		for(int i = end; i >= start; i--){
			// Tausche an korrekte Position und verkleinere Heap
			h=f[start];
			f[start]=f[i];
			f[i]=h;
			// Versickern des Rootelementes
			heapify(f, i, 0);		
		}

	}
	public void heapify(int[] f, int n, int i) {
		while(i <= (n / 2) - 1) {
			comparison++;
			//count++;
			int k = i*2+1;
			if(k + 1 <= n -1) {
				comparison++;
				if(f[k] < f[k+1]) {
					comparison++;
					k++; 
				}
			}
			if(f[i] < f[k]) {
				comparison++;
				swap++;
				int h = f[i];
				f[i] = f[k];
				f[k] = h;
				i = k; 
			} else break;
		}
	} 
	@Override
	public int[] sort(int[] f) {
		// TODO Auto-generated method stub
		duration=System.currentTimeMillis();
        heapSort(f, 0, f.length-1);
        duration= System.currentTimeMillis()-duration;
        return f;
	}

		

}
