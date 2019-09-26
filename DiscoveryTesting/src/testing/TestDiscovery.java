package testing;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDiscovery {
	WebDriver driver;
	WebDriverWait wait;
	
 public  void test ()
	{
		 
		System.setProperty("webdriver.chrome.driver", "src\\driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, 30);
		FileReader r =new FileReader();	
		
		driver.get(r.reader("Discovery_url"));
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath(r.reader("shows"))).click();
		WebElement SeeAllShows=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( r.reader("seeAllShows"))));
		SeeAllShows.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(r.reader("ApolloShows"))));
		List<WebElement> elements = driver.findElements(By.xpath(r.reader("ApolloShows")));
		List<String> Fav_Title = new ArrayList<String>();
		List<String> Unfav_Title = new ArrayList<String>();
		for (int i=1; i<=elements.size();i++){
			driver.findElement(By.xpath(r.reader("clickApolloShows")+i+"]")).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(r.reader("iCon_Plus_OR_Minus"))));
			
			if( driver.findElement(By.xpath(r.reader("iCon_Plus"))).isDisplayed())
			{
				System.out.println("Add to my favorit(+) displaying");
				driver.findElement(By.xpath(r.reader("iCon_Plus"))).click();
				
				Fav_Title.add(driver.findElement(By.xpath(r.reader("FavShow_Title"))).getAttribute("alt"));
				Fav_Title.get(0);
				driver.navigate().back();
				
			}
			
			else if( driver.findElement(By.xpath(r.reader("iCon_Minus"))).isDisplayed())
			{
				System.out.println("Remove from my favorit(-) Displaying");
				driver.findElement(By.xpath(r.reader("iCon_Minus"))).click();
				Unfav_Title.add(driver.findElement(By.xpath(r.reader("FavShow_Title"))).getAttribute("alt"));
				driver.navigate().back();
				
			}
			
		}
				driver.findElement(By.xpath(r.reader("MenuBar"))).click();
				driver.findElement(By.xpath(r.reader("MyVideos"))).click();
				js.executeScript("window.scrollBy(0,350)");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(r.reader("FavShowsHeader"))));
				List<WebElement> MyVideo_Fav_Title = driver.findElements(By.xpath(r.reader("FavShowsAvailable")));
			
				int count =0;
				for(int i=0;i<Fav_Title.size();i++)
				{
					for (int j=0; j<MyVideo_Fav_Title.size();j++)
					
					  {
					
					  if(Fav_Title.get(i).equals(MyVideo_Fav_Title.get(j).getAttribute("textContent")))
					   {
						  System.out.println("Title of show added to my favorite   "+Fav_Title.get(i));
						  count=count+1;
					   }
					 }
						
					 if (count==0)
					{
						System.out.println(Fav_Title.get(i) +"   show not able to add in my favorite shows");
					}
				}
				
				for (int i=0; i<Unfav_Title.size();i++)
				{
					for(int j=0;j<MyVideo_Fav_Title.size();j++)
					  {
					  if(Unfav_Title.get(i).equals(MyVideo_Fav_Title.get(j).getAttribute("textContent")))
					   {
						  System.out.println(Unfav_Title.get(i) + "video not able to make as un-favorite shows ");
						count=count+1;
					
					   }
					 }
					
					if(count==0)
					{
						System.out.println(Unfav_Title.get(i) + "video successfully done as un-favorite shows");
					}
				}
		}
	

		 
		}





 
