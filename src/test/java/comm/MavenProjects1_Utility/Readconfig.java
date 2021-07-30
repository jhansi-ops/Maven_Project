package comm.MavenProjects1_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig
{
	
Properties pro;
	
	public Readconfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String Applicationurl()
	{
		String URL=pro.getProperty("url");
		return URL;
		
	}
	
	public String Username()
	{
		String UserName=pro.getProperty("username");
		return UserName;
		
		
	}
	
	public String password()
	{
		String Password=pro.getProperty("password");
		return Password;
		
	}
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getinternetPath()
	{
	String internetpath=pro.getProperty("internetpath");
	return internetpath;
	}
	
	
	}


