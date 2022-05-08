package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertion2 {
    WebDriver driver;

    @Test
    public void VerifyCredentials2() {

        String expectedText = "Invalid credentials 123456";
        WebElement Username = driver.findElement(By.id("txtUsername"));
        Username.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();

//      1st assertion compare the two strings ---> since this fails
        Assert.assertEquals(text, expectedText);

//      assert if username text box is displayed
        boolean displayed = Username.isDisplayed();

//      2nd assertion if it is actually displayed ---> 2nd assertion doesnt occur
        System.out.println("Hello World");
        Assert.assertTrue(displayed);
    }

    @BeforeMethod
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();
    }
}