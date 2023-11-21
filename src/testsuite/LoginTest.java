package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    // Launching baseUrl
    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // Verify the text “Secure Area”
        String expectedText = "Secure Area";
        WebElement actualTextExpected = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualText = actualTextExpected.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // Verify the error message “Your username is invalid!”
        String expectedText = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = actualTextElement.getText().substring(0, 25);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // Verify the error message “Your password is invalid!”
        String expectedText = "Your password is invalid!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = actualTextElement.getText().substring(0, 25);
    }

    @After
    public void closingBrowser() {
        closeBrowser();
    }
}
