package application;
// Devin Kinkead
import java.util.ArrayList;
import java.util.Scanner;
public class InventorySystem {
	private ArrayList<Device> deviceInventory;
	public static Scanner scan = new Scanner(System.in);
	
	
	public InventorySystem() {
		deviceInventory = new ArrayList<Device>();
		
		// Pre-Loaded Devices for Demo/Project Requirements. Won't hurt anything if you delete later on.  
		deviceInventory.add(new Device("SAMG2","Samsung Galaxy Tab 2"));
		deviceInventory.add(new Device("AMZK8","Amazon Kindle Fire HD 8"));
		deviceInventory.add(new Device("GoP4","Google Pixel 4"));
		deviceInventory.add(new Device("MSSURG","Microsoft Surface Go"));
		deviceInventory.add(new Device("LT480s","Lenovo Thinkpad T480s"));
	} //constructor
	
	public void addDevice() {
		System.out.println("\t\tLibrary Device Check Out System - Add Device\n\n");
		String sku;
		String name;
		
		sku = this.skuEditor();
	
		System.out.print("Enter Name: ");
		name = scan.nextLine();
		
		// Construct new device
		Device device = new Device(sku,name);
		
		// add new device into device inventory
		this.deviceInventory.add(device);
		System.out.println();
		System.out.printf("Added \"%s\" to Catalog", device.getName());
		
		Utilities.pause();
		
	} // addDevice	
	
	public void editDevice() {
		// Variables
		String sku = "";
		String name = "";
		int selection = 0;
		String input;
		
		System.out.println("\t\tLibrary Device Check Out System - Edit Device\n\n"); 
		
		// Print device list
		this.printDeviceList();
		
		System.out.println();
		System.out.print("Select Device number to edit: ");
		
		input = scan.nextLine();
		
		if(Utilities.isNumeric(input))
			selection = Integer.parseInt(input);
		
		// Verifies device is in inventory
		if (selection <= this.deviceInventory.size() && selection > 0) {
			// get specified device
			Device editD = this.deviceInventory.get(selection-1);
			
			sku = this.skuEditor(editD);
			
			System.out.print("Name: ");
			name = scan.nextLine();
			
			editD.setSku(sku);
			editD.setName(name);
			
			System.out.println("\nDevice information updated.");
			Utilities.pause();
		}
		else {
			Utilities.invalidSelection();
		}
		
		
	} // edit Device
	
	
	public void searchDevice() {
		String input = "";
		System.out.println("\t\tLibrary Device Check Out System - Search for Device\n\n");
		
		System.out.print("Enter device name to search for: ");
		input = scan.nextLine();
		
		System.out.printf("\nSearch Results for \"%s\"\n",input);
		this.searchDeviceList(input);
		Utilities.pause();
		
		
		
		
	} // searchDevice
	
	public void checkOut() {
		String input;
		int selection = 0;
		Device tmpDevice;
		
		System.out.println("\t\tLibrary Device Check Out System - Check Out\n\n");
		
		
		
		// Displays devices that are currently available to check out.
		
		this.printDeviceList("Available");
		
		System.out.println();
		
		System.out.print("Select device number to check out: ");
		
		input = scan.nextLine();
		 
		if(Utilities.isNumeric(input))
			selection = Integer.parseInt(input);
		
		// Verifies device is in inventory
		if (selection <= this.deviceInventory.size() && selection > 0) {
			
			tmpDevice = this.deviceInventory.get(selection-1);
			tmpDevice.checkOut();
			Utilities.pause();
			}
		else {
			Utilities.invalidSelection();
		}
	} // CheckOut
	
	public void checkIn(String device) {
		//Variables
		String input;
		int selection = 0;
		Device tmpDevice;
		
		System.out.println("\t\tLibrary Device Check Out System - Check In\n\n");
		
		// Displays Devices that are checked out
		
	
		
		this.printDeviceList("Checked Out");
		
		System.out.println();
		
		System.out.print("Select device number to check in: ");
		
		input = scan.nextLine();
		
		if(Utilities.isNumeric(input))
			selection = Integer.parseInt(input);
	
		
		// Verifies device is in inventory
		if (selection <= this.deviceInventory.size() && selection > 0) {
			
			tmpDevice = this.deviceInventory.get(selection-1);
			tmpDevice.checkIn();
			Utilities.pause();
			}
		else {
			Utilities.invalidSelection();
		}
		
		
	} // CheckIn
	
	public void printDeviceList() {
		int counter = 0;
		System.out.printf("%-7s%-10s%-30s%10s%-10s\n", "#","SKU","Name","","Status");
		for (Device d : deviceInventory) {
			counter = this.deviceInventory.indexOf(d)+1;
			System.out.printf("%-7s%-10s%-30s%10s%-10s\n",counter,d.getSku(),d.getName(),"",d.getStatus());
		}
		
	} //printDeviceList
	
	public void printDeviceList(String s) {
		int counter = 0;
		System.out.printf("%-7s%-10s%-30s%10s%-10s\n", "#","SKU","Name","","Status");
		for (Device d : deviceInventory) {
			// Prints only devices that return a status of String 's'
			if (d.getStatus().equalsIgnoreCase(s)) {
				counter = this.deviceInventory.indexOf(d)+1;
				System.out.printf("%-7s%-10s%-30s%10s%-10s\n",counter,d.getSku(),d.getName(),"",d.getStatus());
			}
		}
	} //printDeviceList
	
	public void searchDeviceList(String s) {
		int counter = 0;
		System.out.printf("%-7s%-10s%-30s%10s%-10s\n", "#","SKU","Name","","Status");
		for (Device d : deviceInventory) {
			// Prints only devices with names that contain the string 's'. Case does not matter.
			if (this.deviceInventory.get(this.deviceInventory.indexOf(d)).getName().toLowerCase().contains(s.toLowerCase())) {
				counter = this.deviceInventory.indexOf(d)+1;
				System.out.printf("%-7s%-10s%-30s%10s%-10s\n",counter,d.getSku(),d.getName(),"",d.getStatus());
				
				
			}
		}
	
	} // searchDeviceList
	
	public boolean duplicateSkuCheck(String s) {
			//This method checks that the sku is unique. 
			boolean duplicate = false;
			for (Device d : deviceInventory) {
				if (this.deviceInventory.get(this.deviceInventory.indexOf(d)).getSku().equalsIgnoreCase(s)) {
					duplicate = true;
				}
			
			}
			return duplicate;
	} //duplicateSkuCheck
	
	public String skuEditor(Device d) {
		boolean proceed = false;
		String sku = "";
		// Forces user to type new sku until it is valid. 
		do {
			System.out.print("Enter Sku: ");
			sku = scan.nextLine();
			
			// if the entered sku matches previous sku, return the entered sku
			if (d.getSku().equalsIgnoreCase(sku))
			{
				return sku;	
			}
			else {
			// If Device sku will not stay the same, this will check sku length and uniqueness
				if (sku.length() <= 6 && !this.duplicateSkuCheck(sku))			
					proceed = true;
				else if (sku.length() > 6)
					System.out.println("Sku is too long. Please try again.");
				else if (this.duplicateSkuCheck(sku))
					System.out.println("Sku matches another device. Please try again.");
		
			}
				
		} while (proceed == false);
		
		return sku;
	} // skuEditor

	public String skuEditor() {
		boolean proceed = false;
		String sku = "";
		// Forces user to type new sku until it is valid. Max length 6. Must be unique
		do {
			System.out.print("Enter Sku: ");
			sku = scan.nextLine();
			
				if (sku.length() <= 6 && !this.duplicateSkuCheck(sku))			
					proceed = true;
				else if (sku.length() > 6)
					System.out.println("Sku is too long. Please try again.");
				else if (this.duplicateSkuCheck(sku))
					System.out.println("Sku matches another device. Please try again.");
		
			} while (proceed == false);
		
		return sku;
	} //skuEditor
	
	public void showMenu() {
		// Variables
		String input;
		int selection=0;
		do
		{
			System.out.println("\n\n\n\n\n");
			System.out.println("\t\tLibrary Device Check Out System\n\n");
			System.out.println("1. List Devices by Title \n"
					+ "2. Add New Device \n"
					+ "3. Edit Device Information \n"
					+ "4. Search by Device Name \n"
					+ "5. Check Out Device \n"
					+ "6. Check In Device \n"
					+ "7. Exit");
			System.out.print("\nSelect a menu option (1-7): ");
			
			input = scan.nextLine();
			
			if(Utilities.isNumeric(input))
				selection = Integer.parseInt(input);
			
			
			switch(selection) {
			
			case 1: 
				System.out.println("\n\n");
				System.out.println("\t\tLibrary Device Check Out System - List\n\n");
				this.printDeviceList();
				
				Utilities.pause();
				break;
			case 2:
				this.addDevice();
				break;
			case 3:
				this.editDevice();
				break;
			case 4:
				this.searchDevice();
				break;
			case 5:
				this.checkOut();
				break;
			case 6:
				//this.checkIn();
				break;
			case 7:
				System.out.println("\nExiting Program...");
				
				InventorySystem.scan.close();
				
				System.exit(0);
				
				// break not necessary. But staying consistent
				break;
			default:
				Utilities.invalidSelection();
				
			}
		} while (selection != 7);
	} // showMenu 
	
	
	
} // Inventory 
