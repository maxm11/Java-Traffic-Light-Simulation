
public class NoVehicle extends Vehicle {

	// Default Constructor
		public NoVehicle() {
			super(0, false);
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
			return " ";
		}

}
