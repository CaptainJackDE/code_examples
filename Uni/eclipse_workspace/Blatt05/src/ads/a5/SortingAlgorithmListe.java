package ads.a5;




public abstract class SortingAlgorithmListe {
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
	public static void printListe(Liste l){
		while(l!=null) {
			System.out.print( l.value+", ");
			l=l.next;
		}
		System.out.println();
	}
	public abstract Liste sort(Liste l);
	
}
