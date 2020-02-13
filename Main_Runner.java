/*
 * @author Tinsae, shady, hussain, loulia, shan 
 */
public class Main_Runner {

	public static void main(String[] args) {
		
		Thread Floor, Elevator;                                 // declearing the 
		Scheduler seq = new Scheduler();                       // create an class of Schedular which extends of thread which makes it a thread 
		Floor = new Thread(new FloorSubsystem(seq), "Floor");  // create a thread of floor subsystem
		Elevator = new Thread(new Elevator(seq),"Elevator");   // create a thread of Elevator 
		Floor.start();
		Elevator.start();
	}

}
