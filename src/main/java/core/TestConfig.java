package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
	
	private static InputStream reader;
	private static Properties envProps;
	private static File confFileDir = new File("src/test/resources/");
	
	public static void loadProps(String env) throws Exception {
		reader = new FileInputStream(confFileDir+"/test." + env + ".properties");
		envProps = new Properties();
		envProps.load(reader);
		
	}
	
	public static String getProperty(String key) {
		if(envProps.containsKey(key)) {
			return envProps.getProperty(key);
		}
		return null;
	}

}
