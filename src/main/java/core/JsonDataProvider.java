package core;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.*;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonDataProvider implements ITestData {
	
	private Reader reader = null;
	private Gson gson = null;
	
	public JsonDataProvider (String testFile) throws Exception {
	    reader = new FileReader(testFile);
		gson = new Gson();
	}

	@Override
	public List<HashMap<String, String>> getAllTestData(String testName) {
		
		Type type = new TypeToken<HashMap<String, ArrayList<HashMap>>>(){}.getType();
		
		HashMap<String, ArrayList<HashMap>> test = gson.fromJson(reader, type);
		ArrayList testData = test.get("testdata");
		
		for(Object i : testData) {
			if(((Map) i).get("testname").equals(testName)){
				return (List<HashMap<String, String>>) ((Map) i).get("iteration");
			}
			
		}
		return null;
	     
	}

	@Override
	public String getCounty(String testName) {
		String county ="";
		Type type = new TypeToken<HashMap<String, ArrayList<HashMap>>>(){}.getType();
		HashMap<String, ArrayList<HashMap>>test = gson.fromJson(reader, type);
		ArrayList testList = test.get("testdata");
		for(Object i : testList) {
			if(((Map) i).get("name").equals(testName)) {
			    county = ((Map) i).get("county").toString();
			    
			    return county;
			}
		}
		return null;
	}

}
