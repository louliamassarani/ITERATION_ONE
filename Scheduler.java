
/**
 * @author Tinsae, shady, hussain, loulia, shan 
 * 
 */

import java.util.ArrayList;




public class Scheduler extends Thread {
	
	ArrayList<FloorRequested> ListOfRequested = null;      // list  of floor requested 
	private int numReqComp = 0;                            //count number of elevators
	/**
	 * 
	 * @return  list of floor requested 
	 */
	public ArrayList<FloorRequested> getListReq()   
	
	{
		return ListOfRequested;
	}
	/**
	 * method 
	 * @return  numReqComp : number of floor requested complited
	 */
	
	public int getCompReq() {
		return numReqComp;
		
	}

	/**
	 * Put an elevator on the scheduler when a user from a floor requests it.
	 * This method is used for assigning an elevator on the sechdedular when a user from a floor requests it
	 * @param elevator
	 */
	
	
	public synchronized void elevatorSch(FloorRequested floor)
	{
        while (!(ListOfRequested == null)) { //wait if there is already a user (floor) being serviced. they should be serviced first
            try {
                wait();
            } catch (InterruptedException e) {
            	System.out.println(e.getStackTrace());
                return;
            }
        }
        
        ListOfRequested = new ArrayList<FloorRequested>();   // assigne
        ListOfRequested.add(floor);							 // add the floor requested in the list of floors requested
        
	    try {
	    	
	    	Thread.sleep(500);     // slow it down 
	    } catch (InterruptedException e) {
	    	return;
	    }  
	   
        notifyAll();
	}
	
	/**
	 * this method is used when the floor needes to used the elevtor any time.
	 * @return 
	 */
	public synchronized FloorRequested getElev()
	{
		while(ListOfRequested == null) //if there are no users (floors) waiting to be serviced, wait
		{
			try {
				wait();
			} catch (InterruptedException e) {
    	   		return null;
			}
		}
		
		FloorRequested item = ListOfRequested.get(0);
	    ListOfRequested = null;
	    numReqComp++;
	    notifyAll();
	    return item;
	     
	}
	  
}
