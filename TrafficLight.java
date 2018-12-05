import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class TrafficLight {
	// Arrays for Each Direction of Traffic
	// Accepts the Type Vehicle and has an initial size of 5
	ArrayList<Vehicle> north = new ArrayList<Vehicle>(11);
	ArrayList<Vehicle> east = new ArrayList<Vehicle>(11);
	ArrayList<Vehicle> south = new ArrayList<Vehicle>(11);
	ArrayList<Vehicle> west = new ArrayList<Vehicle>(11);
	
	// Boolean indicating whether or not the simulation is running
	boolean running = true;
	
	// Light Direction
	// False = Red
	// True = Green/Yellow or Traffic is Flowing
	boolean ns_flow = true;
	boolean ew_flow = false;
	
	// Light Length
	int time = 6;
	
	// Get Vehicle
	public Vehicle getVehicleFromInt(int vtype) {
		Vehicle tempVehicle = null;
		switch (vtype){
		case 1:
			tempVehicle = new Car();
			break;
		case 2:
			tempVehicle = new Truck();
			break;
		case 3:
			tempVehicle = new Semi();
			break;
		case 4:
			tempVehicle = new NoVehicle();
			break;
		case 0:
			tempVehicle = new Emergency();
			break;
		}
		return tempVehicle;
	}
	
	// Print Intersection State
	public void printState() {
		// Get a printable direction
		String flowString = "";
		if(ns_flow == true)
		{
			flowString = "North-South";
		}
		
		else if(ew_flow == true)
		{
			flowString = "East-West";
		}
		// Print direction
		System.out.println("Direction : " + flowString);
		System.out.println("Time : " + time);
		
		// Print State
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(0).toString(), north.get(9).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(1).toString(), north.get(8).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(2).toString(), north.get(7).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(3).toString(), north.get(6).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(4).toString(), north.get(5).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "=========", "#", "#", "=========");
		System.out.printf("%1s %1s %1s %1s %1s %1s %1s %2s %1s %1s %1s %1s %1s %1s %1s %n", west.get(9).toString(), west.get(8).toString(), west.get(7).toString(), west.get(6).toString(), west.get(5).toString(),"#", south.get(10).toString(), "", west.get(10).toString(), "#", west.get(4).toString(), west.get(3).toString(), west.get(2).toString(), west.get(1).toString(), west.get(0).toString());
		System.out.printf("%8s %9s %8s %n", "-- -- --", "", "-- -- --");
		System.out.printf("%1s %1s %1s %1s %1s %1s %1s %2s %1s %1s %1s %1s %1s %1s %1s %n", east.get(0).toString(), east.get(1).toString(), east.get(2).toString(), east.get(3).toString(), east.get(4).toString(), "#", east.get(10).toString(), "", north.get(10).toString(), "#", east.get(5).toString(), east.get(6).toString(), east.get(7).toString(), east.get(8).toString(), east.get(9).toString());
		System.out.printf("%9s | %1s : %1s | %9s %n", "=========", "#", "#", "=========");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(5).toString(), north.get(4).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(6).toString(), north.get(3).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(7).toString(), north.get(2).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(8).toString(), north.get(1).toString(), "");
		System.out.printf("%9s | %1s : %1s | %9s %n", "", south.get(9).toString(), north.get(0).toString(), "");
	}
	
	public void addVehicle(String direction, boolean allowEmergency) {
		Random rand = new Random();
		
		int vtype;
		boolean alreadyEmergency = anyEmergency();
		if(allowEmergency && !alreadyEmergency) {
			vtype = rand.nextInt(4);
		}
		else {
			vtype = rand.nextInt(3) + 1;
		}
		
		
		switch (direction) {
		case "n":
			north.set(0, getVehicleFromInt(vtype));
			break;
		
		case "s":
			south.set(0, getVehicleFromInt(vtype));
			break;
		
		case "e":
			east.set(0, getVehicleFromInt(vtype));
			break;
		
		case "w":
			west.set(0, getVehicleFromInt(vtype));
			break;
		}
	}
	
	public boolean noVehiclesLeft() {
		for(int i = 0; i < 5; i++) {
			if(north.get(i).time > 0) {
				return false;
			}
			if(south.get(i).time > 0) {
				return false;
			}
			if(east.get(i).time > 0) {
				return false;
			}
			if(west.get(i).time > 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean anyEmergency() {
		if(anyEmergency("n") || anyEmergency("s") || anyEmergency("w") || anyEmergency("e")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean anyEmergency(String direction) {
		switch(direction) {
			case "n":
				for(int i = 0; i < 5; i++) {
					if(north.get(i).isEmergency) {
						return true;
					}
				
				}
				return false;
			case "s":
				for(int i = 0; i < 5; i++) {
					if(south.get(i).isEmergency) {
						return true;
					}
				}
				return false;
			case "e":
				for(int i = 0; i < 5; i++) {
					if(east.get(i).isEmergency) {
						return true;
					}
				}
				return false;
			case "w":
				for(int i = 0; i < 5; i++) {
					if(west.get(i).isEmergency) {
						return true;
					}
				}
				return false;
			default:
				return false;
		}
	}
	
	public int indexOfEmergency(ArrayList<Vehicle> list) {
		for(int i = 0; i < 5; i++) {
			if(list.get(i).isEmergency) {
				return i;
			}
		}
		return -1;
	}
	
	public void checkEmergency() {
		if (this.anyEmergency()) {
			System.out.println("EMERGENCY VEHICLE");
			if(this.anyEmergency("n")) {
				int e_index = indexOfEmergency(north);
				System.out.println("EMERGENCY INDEX : " + e_index);
				if (e_index < 5) {
					north.set(0, north.get(1));
					north.set(1, north.get(2));
					north.set(2, north.get(3));
					north.set(3, north.get(4));
					north.set(4, getVehicleFromInt(0));
					north.set(5, north.get(10));
					north.set(10, getVehicleFromInt(4));
					ns_flow = true;
					ew_flow = false;
					time = 3;
				}
			}
			if(this.anyEmergency("s")) {
				int e_index = indexOfEmergency(south);
				System.out.println("EMERGENCY INDEX : " + e_index);
				if (e_index < 5) {
					south.set(0, south.get(1));
					south.set(1, south.get(2));
					south.set(2, south.get(3));
					south.set(3, south.get(4));
					south.set(4, getVehicleFromInt(0));
					south.set(5, north.get(10));
					south.set(10, getVehicleFromInt(4));
					ns_flow = true;
					ew_flow = false;
					time = 3;
				}
			}
			if(this.anyEmergency("e")) {
				int e_index = indexOfEmergency(east);
				System.out.println("EMERGENCY INDEX : " + e_index);
				if (e_index < 5) {
					east.set(0, east.get(1));
					east.set(1, east.get(2));
					east.set(2, east.get(3));
					east.set(3, east.get(4));
					east.set(4, getVehicleFromInt(0));
					east.set(5, north.get(10));
					east.set(10, getVehicleFromInt(4));
					ns_flow = false;
					ew_flow = true;
					time = 3;
				}
			}
			if(this.anyEmergency("w")) {
				int e_index = indexOfEmergency(west);
				System.out.println("EMERGENCY INDEX : " + e_index);
				if (e_index < 5) {
					west.set(0, west.get(1));
					west.set(1, west.get(2));
					west.set(2, west.get(3));
					west.set(3, west.get(4));
					west.set(4, getVehicleFromInt(0));
					west.set(5, north.get(10));
					west.set(10, getVehicleFromInt(4));
					ns_flow = false;
					ew_flow = true;
					time = 3;
				}
			}
		}
	}
	
	public void run() {
		
			checkEmergency();
			// Transition Post-Intersection Cars Up
			north.set(9, north.get(8));
			north.set(8, north.get(7));
			north.set(7, north.get(6));
			north.set(6, north.get(5));

			south.set(9, south.get(8));
			south.set(8, south.get(7));
			south.set(7, south.get(6));
			south.set(6, south.get(5));
			
			east.set(9, east.get(8));
			east.set(8, east.get(7));
			east.set(7, east.get(6));
			east.set(6, east.get(5));
			
			west.set(9, west.get(8));
			west.set(8, west.get(7));
			west.set(7, west.get(6));
			west.set(6, west.get(5));
			if(ns_flow) {
				
				// If car in intersections time is 0 then cycle
				if (north.get(10).getTimeLeft() == 0) {
					north.set(5, north.get(10));
					// If time allows cycle car into intersection
					if ((time-north.get(4).getTime()) > 0) {
						north.set(10, north.get(4));
						north.set(4, north.get(3));
						north.set(3, north.get(2));
						north.set(2, north.get(1));
						north.set(1, north.get(0));
					}
					else {
						north.set(4, north.get(3));
						north.set(3, north.get(2));
						north.set(2, north.get(1));
						north.set(1, north.get(0));
						north.set(10, getVehicleFromInt(4));
					}
				}
				else {
					north.set(5, getVehicleFromInt(4));
				}
				
				// If car in intersections time is 0 then cycle
				if (south.get(10).getTimeLeft() == 0) {
					south.set(5, south.get(10));
					// If time allows cycle car into intersection
					if ((time-south.get(4).getTime()) > 0) {
						south.set(10, south.get(4));
						south.set(4, south.get(3));
						south.set(3, south.get(2));
						south.set(2, south.get(1));
						south.set(1, south.get(0));
					}
					else {
						south.set(4, south.get(3));
						south.set(3, south.get(2));
						south.set(2, south.get(1));
						south.set(1, south.get(0));
						south.set(10, getVehicleFromInt(4));
					}
				}
				else {
					south.set(5, getVehicleFromInt(4));
				}
				
				west.set(5, getVehicleFromInt(4));
				east.set(5, getVehicleFromInt(4));
			}
			else if (ew_flow) {
				// If car in intersections time is 0 then cycle
				if (east.get(10).getTimeLeft() == 0) {
					east.set(5, east.get(10));
					// If time allows cycle car into intersection
					if ((time-east.get(4).getTime()) > 0) {
						east.set(10, east.get(4));
						east.set(4, east.get(3));
						east.set(3, east.get(2));
						east.set(2, east.get(1));
						east.set(1, east.get(0));
					}
					else {
						east.set(4, east.get(3));
						east.set(3, east.get(2));
						east.set(2, east.get(1));
						east.set(1, east.get(0));
						east.set(10, getVehicleFromInt(4));
					}
				}
				else {
					east.set(5, getVehicleFromInt(4));
				}
				
				// If car in intersections time is 0 then cycle
				if (west.get(10).getTimeLeft() == 0) {
					west.set(5, west.get(10));
					// If time allows cycle car into intersection
					if ((time - west.get(4).getTime()) > 0) {
						west.set(10, west.get(4));
						west.set(4, west.get(3));
						west.set(3, west.get(2));
						west.set(2, west.get(1));
						west.set(1, west.get(0));
					}
					else {
						west.set(4, west.get(3));
						west.set(3, west.get(2));
						west.set(2, west.get(1));
						west.set(1, west.get(0));
						west.set(10, getVehicleFromInt(4));
					}
				}
				else {
					west.set(5, getVehicleFromInt(4));
				}
				
				north.set(5, getVehicleFromInt(4));
				south.set(5, getVehicleFromInt(4));
			}
			
			time = time - 1;
			if (north.get(10).getTimeLeft() > 0) {
				north.get(10).cycleTime();
			}
			if (south.get(10).getTimeLeft() > 0) {
				south.get(10).cycleTime();
			}
			if (east.get(10).getTimeLeft() > 0) {
				east.get(10).cycleTime();
			}
			if (west.get(10).getTimeLeft() > 0) {
				west.get(10).cycleTime();
			}
			
			if(ns_flow) {
				boolean noNorth = true;
				boolean noSouth = true;
				for(int i = 0; i < 5; i++) {
					if(north.get(i).getTime() != 0) {
						noNorth = false;
						break;
					}
				}
				for(int i = 0; i < 5; i++) {
					if(south.get(i).getTime() != 0) {
						noSouth = false;
						break;
					}
				}
				
				if (north.get(10).getTime() != 0) {
					noNorth = false;
				}
				if (south.get(10).getTime() != 0) {
					noSouth = false;
				}
				
				if ((noNorth && noSouth) || time == 0) {
					ns_flow = false;
					ew_flow = true;
					time = 6;
				}
				if(north.get(0).getTime() == 0) {
				addVehicle("n", true);
				}
				if(south.get(0).getTime() == 0) {
				addVehicle("s", true);
				}
			}
			
			if(ew_flow) {
				boolean noEast = true;
				boolean noWest = true;
				for(int i = 0; i < 5; i++) {
					if(east.get(i).getTime() != 0) {
						noEast = false;
					}
				}
				for(int i = 0; i < 5; i++) {
					if(west.get(i).getTime() != 0) {
						noWest = false;;
					}
				}
				if (east.get(10).getTime() != 0) {
					noEast = false;
				}
				if (west.get(10).getTime() != 0) {
						noEast = false;
				}
				
				if ((noEast && noWest) || time == 0) {
					ns_flow = true;
					ew_flow = false;
					time = 6;
				}
				if(east.get(0).getTime() == 0) {
				addVehicle("e", true);
				}
				if(west.get(0).getTime() == 0) {
				addVehicle("w", true);
				}
			}
			
			if(noVehiclesLeft()) {
				running = false;
			}
		}
	
	// Default Constructor
	public TrafficLight() {
		// Create an instance of the random class
		Random rand = new Random();
		
		// Random int for number of cars in each direction
		int[] numCars = {rand.nextInt(9), rand.nextInt(9), rand.nextInt(9), rand.nextInt(9)};
		
		for (int i = 0; i < numCars.length; i++) {
			int len = numCars[i];
			
			for(int j = 0; j < len; j++) {
				int vtype = rand.nextInt(2) + 1;
				
				// Figure out what direction
				switch(i) {
				// North
				case 0:
					north.add(getVehicleFromInt(vtype));
					break;
				// East
				case 1:
					east.add(getVehicleFromInt(vtype));
					break;
				// South
				case 2:
					south.add(getVehicleFromInt(vtype));
					break;
				// West
				case 3:
					west.add(getVehicleFromInt(vtype));
					break;
				}
			}
			for(int antij = 10-len; antij > 0; antij--) {
				switch(i) {
				// North
				case 0:
					north.add(getVehicleFromInt(4));
					break;
				// East
				case 1:
					east.add(getVehicleFromInt(4));
					break;
				// South
				case 2:
					south.add(getVehicleFromInt(4));
					break;
				// West
				case 3:
					west.add(getVehicleFromInt(4));
					break;
					
				}
			}
		}
		// Intersection Cars
		north.add(getVehicleFromInt(4));
		south.add(getVehicleFromInt(4));
		east.add(getVehicleFromInt(4));
		west.add(getVehicleFromInt(4));
	}
	
}
