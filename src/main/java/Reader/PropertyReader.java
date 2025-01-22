package Reader;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyReader
{
		public static String getProperty(String keyName) throws Exception 
		{
			Properties prop =new Properties();
			String path= System.getProperty("user.dir")+"//src//main/resources//config.properties/";
			FileInputStream fis =new FileInputStream(path);
			prop.load(fis);

			return prop.getProperty(keyName);
		}

}