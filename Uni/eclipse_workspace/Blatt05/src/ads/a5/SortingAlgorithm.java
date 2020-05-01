package ads.a5;

public abstract class SortingAlgorithm {
	protected long comparison=0; // Anzahl der Vergleiche
	protected long swap=0;  // Anzahl der Vertauschungen
	protected long duration=0; // Messung der Laufzeit
	protected long count=0; // GGf. Rekursionstiefe oder Anzahl Durchlaeufe
	
	
	public long getComparison() {
		return comparison;
	}
	public long getSwap() {
		return swap;
	}
	public  long getDuration() {
		return duration;
	}
	public  long getCount() {
		return count;
	}
	
	public void reset(){
		// zuruecksetzen der Werte
		comparison=0; 
		swap=0;  
		duration=0;
		count=0; 
	}

	public abstract int[] sort(int f[]);
	
}
