public class main {
	public static void main(String[] args) {
		TrafficLight tl = new TrafficLight();
		tl.printState();
		while(tl.running) {
			tl.run();
			tl.printState();
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

		}
	}



}