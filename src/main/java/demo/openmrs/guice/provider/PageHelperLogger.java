package demo.openmrs.guice.provider;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageHelperLogger {

	
	public static void sendKey(WebDriver driver, WebElement element, String keyValue) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(keyValue);
	}

	
	public static void sendKey(WebDriver driver, By by, String keyValue, String TextBox) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(by));
//		scrollToMiddle(driver, by);
		driver.findElement(by).clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(by).sendKeys(keyValue);
	}

	
	public static void sendKeyJs(WebDriver driver, By by, String keyValue, String input) {
		System.out.println("Enter " + keyValue + " in " + input + "Textbox");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value = " + keyValue + ";", driver.findElement(by));
	}

	
//	public static void sendKey(WebDriver driver, WebElement element, String keyValue, String input) {
//		System.out.println("Enter " + keyValue + " in " + input + " Textbox.");
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		element.click();
//		element.clear();
//		element.sendKeys(keyValue);
//	}

	
	public static void sendKeyNoClear(WebDriver driver, By element, String keyValue, String input) {
		System.out.println("Enter " + keyValue + " in " + input + "Textbox");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).sendKeys(keyValue);
	}

	public static String getText(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		System.out.println("Get text from element: " + driver.findElement(by).getText());
		return driver.findElement(by).getText();
	}

	public static void lineBreak() {
		System.out.println(" ");
		System.out.println("***************************************************************************");
		System.out.println("***************************************************************************");
		System.out.println(" ");
	}

	public static void emptyLine() {
		System.out.println(" ");
		System.out.println(" ");
	}

	public static void takeScreenShot(String methodName, WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Anubha.Gupta\\eclipse-workspace\\xperigo\\src\\main\\java\\practice"
							+ methodName + ".png"));
			System.out.println("***Placed screen shot in " + "" + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void switchWindow(WebDriver driver) {
		// Store the current window handle
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
			}
		}

		driver.manage().window().maximize();
	}

	public static void scrollToElement(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement element = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public static void scrollToTop(WebDriver driver) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public static void scrollToLength(WebDriver driver, int length) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("scroll(0," + length + ");");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void selectDropdown( WebDriver driver, By dropdown, String option, String dropdownName) {
		System.out.println("Select " + option);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		
		scrollToMiddle(driver, dropdown);
		
		Select selectDropdown = new Select(driver.findElement(dropdown));

		// selectByVisibleText
		selectDropdown.selectByVisibleText(option);
	}

	
	public static void selectDropdownJs(WebDriver driver, By dropdown, String option, String dropdownName) {
		System.out.println("Select " + option + " from " + dropdownName + "Drop down");
		try {
			Thread.sleep(1000);

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.elementToBeClickable(dropdown));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value = '" + option + "'", driver.findElement(dropdown));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void click(WebDriver driver, WebElement element, String elementName, int staticWait) {
		// System.out.println( "Click on " + elementName);
		try {
			Thread.sleep(staticWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}

	
	public static void click(WebDriver driver, By by, String elementName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
Thread.sleep(500);
		scrollToMiddle(driver, by);
		driver.findElement(by).click();
	}

	
	public static void clickOption(WebDriver driver, By by, String elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();

		} catch (org.openqa.selenium.WebDriverException e) {
			System.out.println(elementName + "is not Displayed");
		}
	}

	
	public static void clickJs(WebDriver driver, By by, String elementName, int staticWait) {
		// System.out.println( "Click on " + elementName);

		try {
			Thread.sleep(staticWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(by));
	}

	
	public static void click(WebDriver driver, WebElement element, String elementName) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}



	public static void switchFrameWait(WebDriver driver, WebElement frame) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
	}

	public static void switchFrameWait(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.switchTo().defaultContent();
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(by)));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	}

	public static void switchFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	
	public static void verifyInput(WebDriver driver, WebElement element, String inputValue) {
		String value = element.getAttribute("value");
		System.out.println("Verify value is" + inputValue);
		Assert.assertTrue(value.contains(inputValue));
		System.out.println("Verify value is " + inputValue);
	}
	
	public static boolean isDisplayed(WebDriver driver, By by, String elementName) {

		boolean flag;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			if (driver.findElement(by).isDisplayed()) {
				flag = true;
				
			} else {
				flag = false;
				
			}
		} catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.NoSuchElementException
				| org.openqa.selenium.InvalidElementStateException | org.openqa.selenium.TimeoutException e) {
			flag = false;
			return flag;
		}

		return flag;

	}

	
	public static void scrollToMiddle(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement element = driver.findElement(by);

		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";

		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
	}

}
