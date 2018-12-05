
public class Truck extends Vehicle {
	
	// Default Constructor
	public Truck() {
		super(2, false);
	}
	
	// Getters
	public int getTime() {
		return time;
	}

	public boolean getIsEmergency() {
		return isEmergency;
	}
	
	// To String
	public String toString() {
		return "T";
	}

}
