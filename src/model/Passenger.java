package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {
	
	private int currentFloor;
	private int destinationFloor;
	
	@Override
	public String toString() {
		return "Passenger [currentFloor = " + currentFloor + ", destinationFloor = " + destinationFloor + "]";
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
