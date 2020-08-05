package commonUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig()  {
		File src = new File("./resources/Configuration/config.properties");
		try {
			FileInputStream input= new FileInputStream(src);
			prop = new Properties();
			prop.load(input);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	public  String getURL()
	{

		String url=	prop.getProperty("Url");
		return url;

	}

	public  String getUsername()
	{

		String username=prop.getProperty("username");
		return username;

	}

	public  String getPassword()
	{

		String passWord=prop.getProperty("password");
		return passWord;

	}

	public  String getBrowser()
	{

		String browser=prop.getProperty("browserName");
		return browser;

	}
//	public  String getIe()
//	{
//
//		String ie=prop.getProperty("iepath");
//		return ie;
//
//	}
//
//	public  String getFirefox()
//	{
//
//		String firefox=prop.getProperty("firefoxpath");
//		return firefox;
//
//	}


}
