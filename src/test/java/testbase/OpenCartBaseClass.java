package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class OpenCartBaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	@BeforeClass(groups={"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br) {
		rb=ResourceBundle.getBundle("config");//Load config.properties file
		logger=LogManager.getLogger(this.getClass());
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		if (br.equals("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if (br.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://demo.opencart.com/index.php");
		driver.get(rb.getString("URL"));
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass(groups={"Master","Sanity","Regression"})
	public void teardown() {
		driver.quit();
		
	}
	
	public String randomString() {
		
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
	}
	
	public String randomNumber() {
		String generatednum=RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
	
	public String randomAlphaNumeric() {
		String st=RandomStringUtils.randomAlphabetic(4);
		String nu=RandomStringUtils.randomNumeric(3);
		return st+"@"+nu;
	}
	public String captureScreen(String tname) throws IOException {
		

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}


}
