/**
 *
 * @author Tinsae, shady, hussain, loulia, shan 
 *
 */
public class Elevator implements Runnable {
	Scheduler seq;
	/**
	 * constructor 
	 */
	public Elevator(Scheduler seq) {
		this.seq = seq;
	}

	@Override
	public void run() {
		while(true) {
			FloorRequested reqInfo = seq.getElev();
			System.out.println(Thread.currentThread().getName() + ": Passenger Arrives at " + reqInfo.getTime() + " and requested on floor "+
			reqInfo.getFloorNum()+ " to go " + reqInfo.getDirection().toString());
			System.out.println(Thread.currentThread().getName()+": The passenger Goes to Floor: " + reqInfo.getDestinationFloor());
		}
		
	}
	
}
