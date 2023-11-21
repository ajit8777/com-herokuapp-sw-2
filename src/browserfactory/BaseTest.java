package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 */
public class BaseTest {

    // Declaring global variable
    public static WebDriver driver;

    static String browser = "Chrome";

    //Browser open method
    public void openBrowser(String baseUrl) {
        //Declaring multiple browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        driver.get(baseUrl);  // Launch baseUrl
        driver.manage().window().maximize();  // Maximise Url
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Declaring timeout manage
    }

    //Closing browser method
    public void closeBrowser() {
        driver.quit();
    }
}
