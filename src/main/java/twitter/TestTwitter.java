package twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestTwitter {
    public static WebDriver driver;

    public void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void setup() {
        // we need to direct the class to the path of the chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        /* the reason why we are using webdriver and
           not chromedriver is because webdriver is
           the interface and this allows us to use multiply
           drivers for different internet browsers
        driver = new FirefoxDriver(); */
        driver.get("https://twitter.com");
    }

    public void close() {
        sleepFor(3);
        driver.close();
        driver.quit();
    }

    @Test
    public void clickOnSignUp() {
        setup();
        driver.findElement(By.xpath("//*[@id='doc']/div/div[1]/div[1]/div[2]/div[2]/div/a[1]")).click();
        close();
    }

    @Test
    public void signIn() {
        driver.get("https://twitter.com/login");
        driver.findElement(By.xpath("//input[@type='text' and @autocomplete='on']")).sendKeys("hello@hello.com");
        close();
    }

    @Test
    public void clickOnLogIn() {
        setup();
        close();
    }
}

