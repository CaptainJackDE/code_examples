package ads.a5;

import java.util.Arrays;
import java.util.Random;

/**
 * Klasse bietet einige statische Methoden zur Generierung von Eingabedaten
 * für Sortieralgorithmen.
 * 
 * @author jeremic, parzy
 */
public class InputGenerator {

	private static Random rng = new Random();
	
	/**
	 * Generiert eine Folge von Pseudozufallszahlen.
	 * @param length Laenge der Folge.
	 * @return Folge von Pseudozufallszahlen in beliebiegr Reihenfolge.
	 */
	public static int[] randomSequence(int length) {
		int[] array = new int[length];
		for (int i=0; i < array.length; i++) { array[i] = rng.nextInt(5*length); }
		return array;
	}
	
	/**
	 * Generiert eine Zahlenfolge, die length-mal die Zahl number enthaelt.
	 * 
	 * @param length Laenge der Folge
	 * @param number Zahl
	 * @return Zahlenfolge, die length-mal die Zahl number enthaelt.
	 */
	public static int[] uniformSequence(int length, int number) {
		int[] array = new int[length];
		Arrays.fill(array,number);
		return array;
	}
	
	/**
	 * Generiert eine aufsteigend sortierte Folge von Pseudozufallszahlen.
	 * @param length Laenge der Folge.
	 * @return Aufsteigend sortierte Folge von Pseudozufallszahlen.
	 */
	public static int[] increasingSequence(int length) {
		int[] array = randomSequence(length);
		Arrays.sort(array);
		return array;
	}
	
	/**
	 * Generiert eine absteigend sortierte Folge von Pseudozufallszahlen.
	 * @param length Laenge der Folge.
	 * @return Absteigend sortierte Folge von Pseudozufallszahlen.
	 */
	public static int[] decreasingSequence(int length) {
		int[] array = increasingSequence(length);
		for (int i=length/2-1, j=(length+1)/2; i>=0; i--,j++) {
			array[i]^=array[j]; array[j]^=array[i]; array[i]^=array[j];
		}
		return array;
	}
	
	/**
	 * Generiert eine Liste aus Array
	 */
	public static Liste arrayToListe(int[] f) {
		Liste n= new Liste(f[0], null);
		Liste neu=n;
		for (int i=1; i < f.length; i++) { 
			n.next=new Liste(f[i], null);
			n=n.next;
		}
		return neu;
	}
	
	
	/**
	 * Einige Testfaelle zur Demonstration der Nutzung.
	 */
	public static void main(String[] args) {
		int a[] = randomSequence(10);
		int b[] = uniformSequence(10,8);
		int c[] = increasingSequence(10);
		int d[] = decreasingSequence(10);
		System.out.println("a[] = " + Arrays.toString(a));
		System.out.println("b[] = " + Arrays.toString(b));
		System.out.println("c[] = " + Arrays.toString(c));
		System.out.println("d[] = " + Arrays.toString(d));	
	}
}
