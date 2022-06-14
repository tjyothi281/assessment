package com.build.qa.build.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuildTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);

		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}

	/**
	 * Search for the Quoizel MY1613 from the search bar
	 * @throws InterruptedException 
	 * @assert: That the product page we land on is what is expected by checking the product title
	 * @difficulty Easy
	 */
	WebDriver driver;
	
	  /*@BeforeMethod
	  public void setUp() {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();	
	   }*/
	   @BeforeMethod
	   public void setUp() {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();	
		}
	   

		@Test
		public void searchForProductLandsOnCorrectProduct() throws InterruptedException {
			// TODO: Implement this test	
			
			//driver.get("https://www.build.com");
			driver.get("https://www.ferguson.com/");
			driver.findElement(By.cssSelector("a.fg-icon-search")).click();
			driver.findElement(By.name("search")).sendKeys("Quoizel MY1613");
			driver.findElement(By.cssSelector("a.fg-icon-search")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");//scroll down
			//Thread.sleep(1000);
		   //driver.findElement(By.xpath("//p[contains(text(),'Quoizel Nicholas 22 in. A19 100 W 3-Bulb Medium Ba')]")).click();
		    Thread.sleep(1000);
			driver.findElement(By.cssSelector("div.plp:nth-child(1) div.container div.row.first-row div.col-lg-9.col-md-9 div.right-cont.js-handle-loading.animation-opacity div.fg-search-results-box ul.fg-search-results li.fg-search-results-li.js-compare-search-item:nth-child(3) div.js-grid-colorItem.sku-item:nth-child(2) div.sr-content-box:nth-child(4) a.link-gray:nth-child(1) > p.sr-fg-content-name.js-compare-search-item-name")).click();	
			String exp_title ="Quoizel Nicholas 22 in. A19 100 W 3-Bulb Medium Bath Light in Polished Chrome - NL8603C - Ferguson";
			
			String act_title =driver.getTitle();
			if (exp_title.equals(act_title)==true)
			{
			System.out.println("test is passed");	
			}
			else
			{System.out.println("test is failed");	
			
			}
			
			
		}
			
					
	/**
	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @throws InterruptedException 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
			
		
	@Test
	public void addProductToCartFromCategoryDrop() throws InterruptedException {
		// TODO: Implement this test
		
		driver.get("https://www.ferguson.com/");
		//driver.get("https://www.build.com/");
		
	//  driver.get("(https://www.build.com/bathroom-sinks/c108504)");
		
		
		driver.findElement(By.xpath("//a[contains(text(),'All Products')]")).click();
		
		driver.findElement(By.xpath("//p[contains(text(),'Bathroom Plumbing')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'Bathroom Sinks')]")).click();
		Thread.sleep(1000);
		driver.findElement( By.linkText("Drop-in")).click();//drop category
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//body/div[@id='hide-main-mine']/div[@id='wrapper']/main[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[1]/li[2]/div[2]/div[4]/a[1]/p[1]")).click();//2nd product of the serch resuly
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/input[9]")).click();//add to cart
		
		}
		
	
		
	
	

	/**
	 * Add a product to the cart and email the cart to yourself, also to my email address: test.automation+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 
	 *
	 */
		
	
	       @Test
								 
			public void addProductToCartAndEmailIt() throws InterruptedException {
			// TODO: Implement this test
					
			driver.get("https://www.ferguson.com/");
			driver.findElement(By.cssSelector("a.fg-icon-search")).click();
			driver.findElement(By.name("search")).sendKeys("Fans");
			driver.findElement(By.cssSelector("a.fg-icon-search")).click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//p[contains(text(),'Honeywell Home 5 in. Auto Dampers Galvanized Steel')]")).click();
			driver.findElement(By.xpath("//body/div[@id='hide-main-mine']/div[@id='wrapper']/main[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/input[9]")).click();
					
				}

					
	
	
	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
				
	  
			
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() throws InterruptedException {
		// TODO: Implement this test
		
		driver.get("https://www.ferguson.com/");
		driver.navigate().refresh();  
		driver.findElement(By.xpath("//a[contains(text(),'All Products')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'Bathroom Plumbing')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'Bathroom Faucets')]")).click();
     	//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='hide-main-mine']/div[@id='wrapper']/main[1]/div[1]/div[1]/div[2]/div[1]/div[4]/ul[1]/li[1]/div[1]/a[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='hide-main-mine']/div[@id='wrapper']/main[1]/div[1]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/a[1]")).click();
		Thread.sleep(1000);
			
	    int links= driver.findElements(By.tagName("a")).size();
		
		System.out.println(links);
		
		}
		
	@AfterMethod
	public void teardown() {

	driver.close();
	}	



	}



			
				
				
	

