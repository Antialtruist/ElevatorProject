package test;

import com.google.gson.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonTest {
	static final String JSON = "src\\data\\data2.json";

	public static TestData[] getDataFromJson() {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(JSON));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		TestData[] testData = gson.fromJson(reader, TestData[].class);
		return testData;
	}
}