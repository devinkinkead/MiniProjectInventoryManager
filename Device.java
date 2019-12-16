// Devin Kinkead
public class Device {
	// Variables
	private String sku;
	private String name;
	private boolean status;
	
	// Constructor
	public Device(String sku, String name) {
		this.setName(name);
		this.setSku(sku);
		this.setStatus(true);
		
		
	} //constructor
	
	public String getSku() {
		
		return this.sku;
	} //getSku
	
	public void setSku(String s) {
			if (s.length() <= 6) {
				this.sku = s.toUpperCase();
			}
			else 
				System.out.println("Sku is too long. Please try again.");
		
	} //setSku
	
	public String getName() {
		
		return this.name;
	} //getName
	
	public void setName(String s) {
		
		this.name = s;
	} //setName
	
	public String getStatus() {
		String tmpString; 
		
		// item is available if status is set to true
		if (this.status)
			tmpString = "Available";
		else
			tmpString = "Checked Out";
		
		return tmpString; 
	} //getStatus
	
	public void setStatus(boolean b) {
		
		this.status=b;
		
	} //setStatus
	
	public void checkOut() {
		// If item is available
		if (this.status) {
			// check it out
			this.setStatus(false);
			System.out.printf("Device \"%s\" is now checked out\n",this.getName());
		}
		else 
			System.out.println("Device is already checked out");
	} //checkOut
	
	public void checkIn() {
		// if item is Checked out
		if (this.status == false) {
			//check it in
			this.setStatus(true);
			System.out.printf("Device \"%s\" is now checked in\n",this.getName());
		}
		else 
			System.out.println("Device is already checked in");
	} //checkIn
	
	
} // Device Class
