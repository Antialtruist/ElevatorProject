package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Elevator {

	private Integer elevatorID;
	private Integer currentFloor;
	private Integer destinationFloor;
	private Direction direction;
	
	public Elevator() {
		elevatorID = 0;
		currentFloor = 0;
		destinationFloor = 0;
		direction = Direction.STOP;
	}
	
	public void setCurrentFloor(Integer currentFloor) {
		this.currentFloor = currentFloor;
		if (currentFloor != null && destinationFloor != null) {
			defineDirection();
		}
	}
	
	public void setDestinationFloor(Integer destinationFloor) {
		this.destinationFloor = destinationFloor;
		if (currentFloor != null && destinationFloor != null) {
			defineDirection();
		}
	}

	private void defineDirection() {
		if (currentFloor > destinationFloor) direction = Direction.DOWN;
		else direction = currentFloor < destinationFloor ? Direction.UP : Direction.STOP;
	}
	
	@Override
	public String toString() {
		return "ElevatorID = " + elevatorID + ", currentFloor = " + currentFloor + ", destinationFloor = "
				+ destinationFloor + ", direction = " + direction;
	}
	
	public static class Builder {
		private Elevator elevator;
		
		public Builder() {
			elevator = new Elevator();
		}
		
		public Builder setElevatorID(Integer elevatorID) {
			elevator.setElevatorID(elevatorID);
			return this;
		}
		
		public Builder setCurrentFloor(Integer floor) {
			elevator.setCurrentFloor(floor);
			return this;
		}
		
		public Builder setDestinationFloor(Integer floor) {
			elevator.setDestinationFloor(floor);
			return this;
		}
		
		public Elevator build() {
			return elevator;
		}
	}
}
