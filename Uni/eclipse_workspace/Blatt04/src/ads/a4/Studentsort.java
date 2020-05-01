package ads.a4;

import java.util.Arrays;

public class Studentsort {


	
	public Student[] countSortFachsemester(Student[] liste) {
		// Hier Countsort für Fachsemester implementieren 
	
		return liste;
	}
	
	public void quickSort(Student[] f, int start, int end) {
		// Hier Quicksort für Student unter Nutzung comareTo implementieren 
		
	}
	

		
	public static void main(String[] args) {
		
		Studentsort so= new Studentsort(); 
		Student[] liste= new Student[12];
		Student s;
		int i;
		/* Beispieldatensatz, kann erweitert werden */
		liste[0]= new Student("Mustermann", "Max", 212004, 6);
		liste[1]= new Student("Musterfrau", "Martina", 2140003, 2);
		liste[2]= new Student("Mustermann", "Martin", 2140002, 2);
		liste[3]= new Student("Mustermann", "Max", 2130001, 4);
		liste[4]= new Student("Musterfrau", "Martina", 2120005, 6);
		liste[5]= new Student("Mustermann", "Max", 2130006, 4);
		liste[6]= new Student("Klammer", "Karl", 2130008, 4);
		liste[7]= new Student("Gleich", "Gerda", 2130009, 4);
		liste[8]= new Student("Ungleich", "Udo", 2130011, 4);
		liste[9]= new Student("Schleife", "Susi", 2130010, 4);
		liste[10]= new Student("Modulo", "Martin", 2130014, 4);
		liste[11]= new Student("Modulo", "Martina", 2130013, 4);
		
		System.out.println(" Liste unsortiert:");
		for(i=0; i<liste.length; i++)
			System.out.println(liste[i]);

		//Hier ggf Aufruf Sort-Algorithmus von Klasse Arrays
		
		// Ende Ersatz
		
		// Aufruf von Quicksort
		so.quickSort(liste, 0, liste.length-1);
		
		System.out.println(" Sortiert mit XXXsort:");
		for(i=0; i<liste.length; i++)
			System.out.println(liste[i]);
		
		liste= so.countSortFachsemester(liste);
		
		System.out.println(" Mit Contsort nach Fachsemster:");
		for(i=0; i<liste.length; i++)
			System.out.println(liste[i]);
		
		
	}


}
