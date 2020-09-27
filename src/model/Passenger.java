package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {
	
	private Integer currentFloor;
	private Integer destinationFloor;
	private Direction direction;
	
	public Passenger() {
		currentFloor = 0;
		destinationFloor = 0;
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
		direction = currentFloor < destinationFloor ? Direction.UP : Direction.DOWN;
	}
	
	@Override
	public String toString() {
		return "Passenger from " + currentFloor + " to " + destinationFloor;
	}
	
	public static class Builder {
		private Passenger passenger;
		
		public Builder() {
			passenger = new Passenger();
		}
		
		public Builder setCurrentFloor(Integer floor) {
			passenger.currentFloor = floor;
			return this;
		}
		
		public Builder setDestinationFloor(Integer floor) {
			passenger.destinationFloor = floor;
			return this;
		}
		
		public Passenger build() {
			return passenger;
		}
	}
}
