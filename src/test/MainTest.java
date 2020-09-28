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
		TestData[] testData = JsonTest.getDataFromJson();
		Object[][] objects = new Object[testData.length][];
		for (int i = 0; i < testData.length; i++) {
			objects[i] = new Object[] { testData[i].getElevators(), testData[i].getPassenger(),	testData[i].getExpected() };
		}
		return objects;
	}

	@Test
	@UseDataProvider("testElevator")
	public void inputTest(List<Elevator> elevators, Passenger passenger, Integer resultElevatorID) {
		assertEquals(Main.validElevator(elevators, passenger), resultElevatorID);
	}
}
