
public class Semi extends Vehicle {

	// Default Constructor
	public Semi() {
		super(3, false);
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
		return "S";
	}

}
