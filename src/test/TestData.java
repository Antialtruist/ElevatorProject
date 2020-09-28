package test;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import model.Elevator;
import model.Passenger;

@Getter
@Setter
public class TestData {
	
	private List<Elevator> elevators;
	private Passenger passenger;
	private Integer expected;
}
