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
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    WebDriver driver;

    @Test
    public void VerifyCredentials3() {

        SoftAssert soft = new SoftAssert();

        String expectedText = "Invalid credentials 101";
        WebElement Username = driver.findElement(By.id("txtUsername"));
        Username.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();

//      assertion to make sure that the message is correct
        soft.assertEquals(text, expectedText);

//      validate the display is true or not
        WebElement username2 = driver.findElement(By.id("txtUsername"));
        boolean displayed = username2.isDisplayed();
        soft.assertTrue(displayed);
        System.out.println("2nd assertion passes");

//      check all assertions to compile the results
        soft.assertAll();

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
