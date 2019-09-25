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
	public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver", "src\\driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		 
		
		driver.get("http://go.discovery.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.xpath("//span[contains(text(), 'Shows')]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement SeeAllShows=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id='show-drop-desktop']//a[@class= 'dscShowsDropContent__seeAllShows']")));
		SeeAllShows.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[@class= 'showGridTile__container']/*[contains(@href, 'apollo')]")));
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class= 'showGridTile__container']/*[contains(@href, 'apollo')]"));
		System.out.println(elements.get(0).getAttribute("href"));
		System.out.println(elements.get(1).getAttribute("href"));
		
		List<String> Fav_Title = new ArrayList<String>();
		List<String> Unfav_Title = new ArrayList<String>();
		for (int i=1; i<=elements.size();i++){
		     // System.out.println(elements.get(i).getAttribute("value"));
			//System.out.println(elements.get(i-1).getAttribute("href"));
			//elements.get(i).click();
			driver.findElement(By.xpath("(//div[@class= 'showGridTile__container']/*[contains(@href, 'apollo')])["+i+"]")).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class= 'flipIconCore__icon icon-plus ' or @class= 'flipIconCore__icon icon-minus ']")));
			//img[@alt= 'Confessions From Space: Apollo']/parent::div//*[@class= 'flipIconCore__icon icon-plus ' or @class= 'flipIconCore__icon icon-minus '] 
			if( driver.findElement(By.xpath("//i[@class= 'flipIconCore__icon icon-plus ']")).isDisplayed())
			{
				System.out.println("Add to my favorit(+) displaying");
				driver.findElement(By.xpath("//*[@class= 'flipIconCore__icon icon-plus ']")).click();
				
				Fav_Title.add(driver.findElement(By.xpath("//img[@class='showHero__showLogo']")).getAttribute("alt"));
				Fav_Title.get(0);
				driver.navigate().back();
				
			}
			
			else if( driver.findElement(By.xpath("//*[@class= 'flipIconCore__icon icon-minus ']")).isDisplayed())
			{
				System.out.println("Remove from my favorit(-) Displaying");
				driver.findElement(By.xpath("//*[@class= 'flipIconCore__icon icon-minus ']")).click();
				Unfav_Title.add(driver.findElement(By.xpath("//img[@class='showHero__showLogo']")).getAttribute("alt"));
				driver.navigate().back();
			
			}
			
											}
		
				driver.findElement(By.xpath("//*[@class= 'dscHeaderMain__iconMenu']")).click();
				driver.findElement(By.xpath("//span[contains(text(), 'My Videos')]")).click();
				System.out.println("valu="+driver.findElement(By.xpath("(//h2[contains(text(), 'Favorite Shows')]/parent::div//h3/div)[1]")).getText());
				
				driver.findElement(By.xpath("(//h2[contains(text(), 'Favorite Shows')]/parent::div//h3/div)[1]")).getText();
				List<WebElement> MyVideo_Fav_Title = driver.findElements(By.xpath("//h2[contains(text(), 'Favorite Shows')]/parent::div//h3/div"));
			
				
				int count =0;
				String s1= null;
				s1=  MyVideo_Fav_Title.get(0).getText();
				
				for(int i=0;i<Fav_Title.size();i++)
				{
					for (int j=0; j<MyVideo_Fav_Title.size();j++)
					
					  {
				     // System.out.println(elements.get(i).getAttribute("value"));
					s1=  MyVideo_Fav_Title.get(j).getText();
					
					  if(Fav_Title.get(i).equals(MyVideo_Fav_Title.get(j).getText()))
					   {
						count=count+1;
						s1=  MyVideo_Fav_Title.get(j).getText();
									break;
					   }
					 }
					if(count!=0)
					{
						System.out.println(i+"th video added to my favorit shows ");
					}
					else 
					{
						System.out.println(i+"th vth video not added to my favorit shows");
					}
				}
				
				for (int i=0; i<Unfav_Title.size();i++)
				{
					for(int j=0;j<MyVideo_Fav_Title.size();j++)
					  {
				     // System.out.println(elements.get(i).getAttribute("value"));
					  ;
					
					  if(Unfav_Title.get(i).equals(MyVideo_Fav_Title.get(j).getText()))
					   {
						count=count+1;
						break;
					   }
					 }
					if(count!=0)
					{
						System.out.println(i+"th video not removed from my favorit shows ");
					}
					else 
					{
						System.out.println(i+"th vth video  removed from my favorit shows");
					}
				}
	
		 
		}

}



 
