
public class Emergency extends Vehicle {

	// Default Constructor
	public Emergency() {
		super(2, true);
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
		return "E";
	}

}
