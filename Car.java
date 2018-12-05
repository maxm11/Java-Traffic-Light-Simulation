
public class Car extends Vehicle {
	
	// Default Constructor
	public Car() {
		super(1, false);
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
		return "C";
	}

}
