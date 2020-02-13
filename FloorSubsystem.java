
/*
 * @author Tinsae, shady, hussain, loulia, shan 
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class FloorSubsystem implements Runnable {
		

	Scheduler seq;
	
	public FloorSubsystem(Scheduler seq) {
		this.seq = seq;
	}
	/**
	 * This will assign the right direction based on the 
	 * @param seq
	 * @return
	 */

	private static MoveEnum getDirection(String seq) {
		switch (seq) {
		case "UP":
			return MoveEnum.UP;
		case "DOWN":
			return MoveEnum.DOWN;
		default:
			return null;
		}
	}
	/**
	 * This method reads the input files and send it to the floor requested class
	 * Reads each line of the text method and split it on space and add 
	 * @return
	 */
	
	public static List<FloorRequested> readInputFile() {
		FileReader input = null;
		List<FloorRequested> requests = new ArrayList<FloorRequested>();  
		
		try {
			input = new FileReader("src/inputData.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader bufferRead = new BufferedReader(input);
		String myLine = null;

		try {
			while ((myLine = bufferRead.readLine()) != null) {
				
				String[] ListOfInfo = myLine.split(" ");
				LocalTime time =  LocalTime.parse(ListOfInfo[0]);    // assinging each read word to corresponding variable 
				String floorNum = ListOfInfo[1];
				MoveEnum moveEnum = getDirection(ListOfInfo[2]);
				String destinationFloor = ListOfInfo[3];

				FloorRequested currRequest = new FloorRequested(time, floorNum, moveEnum, destinationFloor);
				requests.add(currRequest);
			}
		} catch (IOException e) {
			e.printStackTrace();
		};
		return requests;
	}
	
	@Override
	public void run() {
		ArrayList<FloorRequested> requests = (ArrayList<FloorRequested>) readInputFile(); // A list of requested floor
			
		for(int i = 0; i < requests.size(); i++)  // loops through the number of requested flood 
		{
			if (seq.getCompReq() >= requests.size()) break;
			seq.elevatorSch(requests.get(i));
		}
		try {
			Thread.sleep(500); 
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}


class FloorRequested {

	
	private LocalTime time; 
	private String floorNum;
	private MoveEnum MoveEnum;
	private String destinationFloorNum;
	/**
	 * a Constructor to construct each information passed by the floor class 
	 * @param time                 Time of request 
	 * @param floorNum             Number of floor 
	 * @param MoveEnum             Direction of the elevator 
	 * @param destinationFloorNum  Destination of the elevator 
	 */
	public FloorRequested(LocalTime time, String floorNum, MoveEnum MoveEnum, String destinationFloorNum){
		this.time = time;
		this.floorNum = floorNum;
		this.MoveEnum = MoveEnum;
		this.destinationFloorNum = destinationFloorNum;
	}

	public LocalTime getTime() {
		return time;
	}
	/**
	 * 
	 * @return to retrieve the floor number 
	 */
    public String getFloorNum() {
		return floorNum;
	}
    /**
     * 
     * @return indicated the direction of the elevator 
     */
    
    public MoveEnum getDirection() {
		return MoveEnum;
	}
    /**
     * 
     * @return number of destination floor 
     */
    public String getDestinationFloor() {
		return destinationFloorNum;
	}
    
    
    /**
     * Set the time of reqested
     * @param time 
     */
	public void setTime(LocalTime time) {
		this.time = time;
	}

	
	/**
	 * Assign the floor number
	 * @param floorNum
	 */
	public void setFloorName(String floorNum) {
		this.floorNum = floorNum;
	}
	/**
	 */

	

	public void setDirection(MoveEnum moveEnum) {
		MoveEnum = moveEnum;
	}

	public void setDestinationFloor(String destinationFloorNum) {
		this.destinationFloorNum = destinationFloorNum;
	}
   
}
/**
 * 
 * @author 
 * this class provide 
 */
enum MoveEnum {
	UP, DOWN
}
