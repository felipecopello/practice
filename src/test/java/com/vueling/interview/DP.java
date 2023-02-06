package com.vueling.interview;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

public class DP {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
	JSONParser jsonParser = new JSONParser();

	try {
	    Object obj = jsonParser.parse(new FileReader("src/test/resources/testData.json"));
	    JSONObject jsonObject = (JSONObject) obj;
	    String fareOption = (String) jsonObject.get("fareOption");
	    return new Object[][] { { fareOption } };

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return new Object[][] { {} };
    }
}
