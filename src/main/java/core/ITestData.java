package core;

import java.util.HashMap;
import java.util.List;

public interface ITestData {
     public String getCounty (String personName);
     public List<HashMap<String, String>> getAllTestData(String testname);
}
