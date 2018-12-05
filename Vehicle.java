
public abstract class Vehicle {
	// Define Instance Variables
	int time;
	boolean isEmergency;
	int timeleft;
	
	// Constructors
	
	// Default Constructor
	public Vehicle() {
		time = 0;
		isEmergency = false;
	}
	
	// User-Defined Constructor
	public Vehicle(int time, boolean isEmergency) {
		this.time = time;
		this.isEmergency = isEmergency;
		this.timeleft = time;
	}
	
	public void cycleTime() {
		timeleft = timeleft - 1;
	}
	
	public int getTimeLeft() {
		return timeleft;
	}
	
	public abstract int getTime();
	public abstract String toString();
	public abstract boolean getIsEmergency();
}
