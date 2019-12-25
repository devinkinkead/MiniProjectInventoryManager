package application;
// Devin Kinkead
import java.util.Scanner;
public class Utilities {
	
	private static Scanner scan = InventorySystem.scan;
	
	public static void pause() {
		System.out.print("\nPress enter to continue...");
		scan.nextLine();
	} //pause
	
	public static void invalidSelection() {
		System.out.println("\nInvalid Selection. Please try again.");
		Utilities.pause();
		
	} //invalidSelection
	
	public static boolean isNumeric(String s) {
		// Checks string to ensure that parseInt can be used on it
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	} //isNumberic
	



} // Utilities
