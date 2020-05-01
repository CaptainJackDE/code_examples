package quicksort;

public class QuickSort2Pivot {

	public void main(String[] args) {
		int[] f = {5,13,37,2,19,4,22,12,20,30,33,31,15,9};
		int[] k = QuickSort(f, f[0], f[f.length-1];);
		

	}
	
	public int[] QuickSort(int[] f, int P1, int P2) {
		int l = f[1];
		int g =f[2];
		int i = f[f.length-2];
		
		while(i <= g) {
			if(i < P1) {
				swap(f, l, i);
				i = f[i+1];
				l = f[l+1];
			} else if (i > P2) {
				swap(f, i, g);
				g = f[g-1];
			} else {
				i = f[i+1];
			}
		}
		swap(f, P1, f[l-1]);
		swap(f, P2, f[g+1]);
		QuickSort(f, f[0],f[f.length-1]);
		
		
	
		return f;
	}
	
	public void swap(int[] f, int a, int b) {
		int tmp =f[a];
		f[b] = f[a];
		f[a] = tmp;
	}
	
}
