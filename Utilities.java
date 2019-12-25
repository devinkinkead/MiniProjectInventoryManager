package application;
// Devin Kinkead
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
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
	public static void paneSet(GridPane g) {
		g.setAlignment(Pos.CENTER);
        g.setHgap(10);
        g.setVgap(10);
        g.setPadding(new Insets(25,25,25,25));
	}



} // Utilities
