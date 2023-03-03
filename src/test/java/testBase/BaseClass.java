package testBase;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;



public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
		
		//loading config file
		rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());
		//WebDriverManager.chromedriver().setup();    NO need to setup this above selenium 4.6
	if (br.equals("chrome"))
			{	
			driver=new ChromeDriver();
			}
	else if(br.equals("edge")) {
		driver=new EdgeDriver();
	}
	else {
		driver=new FirefoxDriver();
	}
	      driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get("https://demo.opencart.com/");
		 driver.get(rb.getString("URL"));
		 
	
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	//random strinf
	//for alphabatic
	public String randomString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
		
	}
	//numeric random num 
	public String randomNumber () {
		String generatedSting2=RandomStringUtils.randomNumeric(10);
		return (generatedSting2);
		
	}
	//alphanumeric combo of string and num
	public String randomAlphaNumeric () {
		String st=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(10);
		return (st+num);
		//ifu want num+string+specialchar then return(st+"@"+num);
		}
	//numb+string+special char
	public String randomAlpaNumericsp() {
		String s=RandomStringUtils.randomAlphabetic(5);
		String n=RandomStringUtils.randomNumeric(10);
	
		return (s+"@"+n);
		
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
