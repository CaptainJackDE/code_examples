package ads.a4;

public class Student implements Comparable<Student> {
	
	/**
	 * @param name
	 * @param vorname
	 * @param matrikelnummer
	 * @param fachsemester
	 */
	
	private String name;
	private String vorname;
	private long matrikelnummer;
	private int fachsemester;
	
	public Student(String name, String vorname, long matrikelnummer,
			int fachsemester) {
		this.name = name;
		this.vorname = vorname;
		this.matrikelnummer = matrikelnummer;
		this.fachsemester = fachsemester;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public long getMatrikelnummer() {
		return matrikelnummer;
	}


	public void setMatrikelnummer(long matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}


	public int getFachsemester() {
		return fachsemester;
	}


	public void setFachsemester(int fachsemester) {
		this.fachsemester = fachsemester;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student ( "+vorname+" "+name+" "+fachsemester+".tes Fachsemester Matriklenummer: "
			+matrikelnummer+")";
	}
	

	@Override
	public int compareTo(Student p) {
		// TODO Auto-generated method stub
		/////////////////////////////////////////////////////////////////
		// Vergleich von Studierenden
		return 0; // Daten sind gleich
		
	}
	

		
}
