package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import model.Elevator;
import model.Passenger;
import service.Main;

@RunWith(DataProviderRunner.class)
public class MainTest {
	
	@DataProvider
	public static Object[][] testElevator() {
		return new Object[][] {
			{new Passenger.Builder()
				.setCurrentFloor(5)
				.setDestinationFloor(10)
				.build(),
			List.of(new Elevator.Builder()
					.setElevatorID(1)
					.setCurrentFloor(2)
					.setDestinationFloor(4)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(2)
					.setCurrentFloor(1)
					.setDestinationFloor(6)
					.build(),
			
					new Elevator.Builder()
					.setElevatorID(3)
					.setCurrentFloor(5)
					.setDestinationFloor(8)
					.build()
					),
			3
			},
			
			{new Passenger.Builder()
				.setCurrentFloor(5)
				.setDestinationFloor(10)
				.build(),
			List.of(new Elevator.Builder()
					.setElevatorID(1)
					.setCurrentFloor(2)
					.setDestinationFloor(4)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(2)
					.setCurrentFloor(1)
					.setDestinationFloor(6)
					.build()
					),
			2
			},
			
			{new Passenger.Builder()
				.setCurrentFloor(8)
				.setDestinationFloor(1)
				.build(),
			List.of(new Elevator.Builder()
					.setElevatorID(1)
					.setCurrentFloor(12)
					.setDestinationFloor(6)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(2)
					.setCurrentFloor(6)
					.setDestinationFloor(1)
					.build(),
			
					new Elevator.Builder()
					.setElevatorID(3)
					.setCurrentFloor(12)
					.setDestinationFloor(7)
					.build()
					),
			1
			},
			
			{new Passenger.Builder()
				.setCurrentFloor(2)
				.setDestinationFloor(10)
				.build(),
			List.of(new Elevator.Builder()
					.setElevatorID(1)
					.setCurrentFloor(4)
					.setDestinationFloor(1)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(2)
					.setCurrentFloor(3)
					.setDestinationFloor(4)
					.build()
					),
			2
			},
			
			{new Passenger.Builder()
				.setCurrentFloor(7)
				.setDestinationFloor(15)
				.build(),
			List.of(new Elevator.Builder()
					.setElevatorID(1)
					.setCurrentFloor(12)
					.setDestinationFloor(6)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(2)
					.setCurrentFloor(8)
					.setDestinationFloor(7)
					.build(),
			
					new Elevator.Builder()
					.setElevatorID(3)
					.setCurrentFloor(6)
					.setDestinationFloor(8)
					.build()
					),
			1
			},
			
			{new Passenger.Builder()
				.setCurrentFloor(7)
				.setDestinationFloor(1)
				.build(),
			List.of(new Elevator.Builder()
					.setElevatorID(1)
					.setCurrentFloor(1)
					.setDestinationFloor(8)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(2)
					.setCurrentFloor(2)
					.setDestinationFloor(7)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(3)
					.setCurrentFloor(15)
					.setDestinationFloor(18)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(4)
					.setCurrentFloor(6)
					.setDestinationFloor(8)
					.build(),
					
					new Elevator.Builder()
					.setElevatorID(5)
					.setCurrentFloor(20)
					.setDestinationFloor(1)
					.build(),
			
					new Elevator.Builder()
					.setElevatorID(6)
					.setCurrentFloor(19)
					.setDestinationFloor(6)
					.build()
					),
			6
			},
		};
	}
	
	@Test
	@UseDataProvider("testElevator")
	public void getElevator(Passenger p, List<Elevator> elevators, Integer resultElevatorID) {
		assertEquals(resultElevatorID, Main.validElevator(elevators, p).getElevatorID());
	}
}
