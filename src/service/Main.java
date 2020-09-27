package service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Direction;
import model.Elevator;
import model.Passenger;

public class Main {

	public static Elevator validElevator(List<Elevator> elevators, Passenger psngr) {
		Map<Elevator, Integer> minDistances = new HashMap<>();
		List<Map.Entry<Elevator, Integer>> elevatorSortedByMinDistance;
		Elevator result = null;

		if (psngr.getDestinationFloor() > psngr.getCurrentFloor()) {
			for (Elevator e : elevators) {
				minDistances.put(e, minDistance(e, psngr, true));
			}
		} else if (psngr.getDestinationFloor() < psngr.getCurrentFloor()) {
			for (Elevator e : elevators) {
				minDistances.put(e, minDistance(e, psngr, false));
			}
		}

		if (!minDistances.isEmpty()) {
			elevatorSortedByMinDistance = new LinkedList<>(minDistances.entrySet());
			elevatorSortedByMinDistance.sort(((o1, o2) -> {
				int comparison = o1.getValue().compareTo(o2.getValue());
				return comparison == 0 ? o1.getKey().getElevatorID().compareTo(o2.getKey().getElevatorID())	: comparison;
			}));

			if (!elevatorSortedByMinDistance.isEmpty())
				result = elevatorSortedByMinDistance.get(0).getKey();
		}
		return result;
	}

//	private static Integer minDistance(Elevator elevator, Passenger passenger, boolean isUp) {
//		Integer result;
//		if (isUp ? elevator.getCurrentFloor() >= passenger.getCurrentFloor() : elevator.getCurrentFloor() <= passenger.getCurrentFloor()) {
////			result = Math.abs(elevator.getCurrentFloor() - passenger.getDestinationFloor());
////			result = Math.abs(elevator.getDestinationFloor() - elevator.getCurrentFloor()) +
////                    Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor()) +
////                    Math.abs(passenger.getCurrentFloor() - elevator.getDestinationFloor());
//			result = Math.abs(passenger.getCurrentFloor() - elevator.getCurrentFloor()) 
//					+ Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor());
//		} else {
////			result = Math.abs(passenger.getCurrentFloor() - elevator.getCurrentFloor()) 
////					+ Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor());
//			result = Math.abs(elevator.getDestinationFloor() - elevator.getCurrentFloor()) +
//                    Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor()) +
//                    Math.abs(passenger.getCurrentFloor() - elevator.getDestinationFloor());
//		}
//		return result;
//	}
	
	private static Integer minDistance(Elevator elevator, Passenger passenger, boolean isUp) {
		Integer result;
		if (isUp && elevator.getCurrentFloor() <= passenger.getCurrentFloor()) {
			result = Math.abs(passenger.getCurrentFloor() - elevator.getCurrentFloor());
//			result = Math.abs(elevator.getDestinationFloor() - elevator.getCurrentFloor()) +
//                    Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor()) +
//                    Math.abs(passenger.getCurrentFloor() - elevator.getDestinationFloor());
//			result = Math.abs(passenger.getCurrentFloor() - elevator.getCurrentFloor()) 
//					+ Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor());
		} else {
//			result = Math.abs(passenger.getCurrentFloor() - elevator.getCurrentFloor()) 
//					+ Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor());
			result = Math.abs(elevator.getDestinationFloor() - elevator.getCurrentFloor()) +
                    Math.abs(passenger.getCurrentFloor() - passenger.getDestinationFloor()) +
                    Math.abs(passenger.getCurrentFloor() - elevator.getDestinationFloor());
		}
		return result;
	}
	
}
