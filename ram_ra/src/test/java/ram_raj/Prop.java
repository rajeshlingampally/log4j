package ram_raj;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prop { 
	 
	 static String s=System.getProperty("user.dir");
		 static WebDriver driver;
	 Properties p=new Properties();
	
	   
	@Test
	public static void getprop( WebDriver driver) {
		 Properties p=new Properties();
		try {
			InputStream ip=new FileInputStream(s+"/src/test/java/com/util/rst.properties");
			p.load(ip);
		} catch (Exception e) {
		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		  System.out.println("url");
		String s=p.getProperty("url");

		String b=p.getProperty("browser");
	  if(b.equalsIgnoreCase("chrom")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			driver.get(s);
	
		}else {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	    	driver.get(s);
		}
		
		
	
	 }}