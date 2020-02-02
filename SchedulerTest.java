


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class SchedulerTest {

	@Test

	void test() {
	
		
		Scheduler test = new Scheduler();
		FloorSubsystem test2 = new FloorSubsystem(test);
		assertEquals(test2.readInputFile(),test.getElev());
		
	}

}
