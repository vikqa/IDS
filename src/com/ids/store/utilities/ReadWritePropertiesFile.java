package  com.ids.store.utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;


public class ReadWritePropertiesFile {

	public static void setProperty(String key, String value) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(".\\properties\\userSettings.properties", true);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public static String getUserSettingsProperty(String key) {
		String value = "";
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".\\properties\\userSettings.properties");
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;

	}


	

	

}
