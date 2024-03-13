package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tendable.com");
		String[] menuItems = { "Home", "Our Story", "Our Solution", "Why  Tendable" };
		for (String menuItem : menuItems)
		{
			WebElement menu = driver.findElement(By.xpath("//nav[@id='main-navigation-new']"));
			if (menu != null && menu.isDisplayed()) 
			{
				System.out.println(menuItem + " menu is accessible");
			} else 
			{
				System.out.println(menuItem + "menu is Not accessible");
			}
		}
		for (String menuItem : menuItems)
		{
			driver.findElement(By.xpath("//div[@class='button-links-panel']//a[3]")).click();
			WebElement demoButton = driver.findElement(By.xpath("//div[@class='button-links-panel']//a[3]"));
			if (demoButton != null && demoButton.isDisplayed() && demoButton.isEnabled()) 
			{
				System.out.println("Request a Demo button is present and active on " + menuItem + "page.");
			} else 
			{
				System.out.println("Request a Demo button is not  present and active on " + menuItem + "page.");

			}
		}
		driver.navigate().back();

		driver.findElement(By.xpath("//div[@class='button-links-panel']//a[1]")).click();
		driver.findElement(By.xpath("//button[@class='body-button bg-plain-600 toggle-control'][1]")).click();

		driver.findElement(By.id("form-input-fullName")).sendKeys("meeravali");

		driver.findElement(By.id("form-input-organisationName")).sendKeys("abc");

		driver.findElement(By.id("form-input-cellPhone")).sendKeys("1234567890");
		driver.findElement(By.id("form-input-email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("form-input-message")).sendKeys("Good work");

		driver.findElement(By.tagName("form")).submit();
		WebElement errorMassage = driver.findElement(By.xpath("//div[@class='page-text-inner']//h3"));
		if (errorMassage != null && errorMassage.isDisplayed()) {
			System.out.println("Error massage is Desplayed upon form submission. Test Passed ");

		} else {
			System.out.println("Error massage is Not Desplayed upon form submission. Test Failed");
		}
	}

}
