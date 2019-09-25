package testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
	
	public String reader(String key)
	{
		Properties prop = new Properties();

try {
	//C:\Users\skumar411\git\repository\DiscoveryTesting\Resource\config.properties
	
    prop.load(new FileInputStream("src//Resource//config.properties"));  
	} catch (IOException e) {
    e.printStackTrace();
	}
return prop.getProperty(key);
		    
	}
	

}
