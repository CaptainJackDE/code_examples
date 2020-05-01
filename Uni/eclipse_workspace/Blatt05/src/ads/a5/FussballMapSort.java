package ads.a5;



public class FussballMapSort {
	public static int swap=0;
	
	
	public static int code(String s, int m){
	// Ersten Buchstaben in Intervall 0 bis m-1 abbbilden unabhaegig von Gross- und Kleinschreibung -Aufgabe a
		return 0;
	}
	
	public static void mapSort(String[] f, int start, int end, int vmin, int vmax, double alpha) {
		//Anpassung von Mapsort an Liste von Strings - aufgabe b
		}

	
	
	

	public static void main(String[] args) {
		// Testrahmen in main nicht Begleiterklasse
		String[] teilnehmer = {"Deutschland", "England", "Frankreich","Italien", "Niederlande","Norwegen","Schottland","Schweden","Spanien",
				"Argentinien","Brasilien","Chile",
				"USA","Kanada","Jamaika",
				"Kamerun", "Nigeria","Südafrika",
				"Australien","China","Japan","Südkorea","Thailand",
						"Neuseeland"};
		String[] t= new String[24];
		
		for (int i=0; i<teilnehmer.length;i++){
			System.out.println(teilnehmer[i]+" -code(23): "+code(teilnehmer[i],23));
			t[i]= teilnehmer[i];
		}
		FussballMapSort fm =new FussballMapSort();
		
		fm.mapSort(teilnehmer, 0, 23, 0, 25, 0.8);
		for (int i=0; i<teilnehmer.length;i++){
			System.out.print(teilnehmer[i]+", ");
		}
		System.out.println();
		System.out.println("Swaps: "+swap);
		
		// Weitere Tests für alpha Aufgabe c

	}

}
