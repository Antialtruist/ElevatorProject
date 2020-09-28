package test;

import java.util.List;

import model.Elevator;
import model.Passenger;

public class TestData {
	
	private List<Elevator> elevators;
	private Passenger passenger;
	private Integer expected;
	
	public List<Elevator> getElevators() {
		return elevators;
	}
	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Integer getExpected() {
		return expected;
	}
	public void setExpected(Integer expected) {
		this.expected = expected;
	}
	
}
