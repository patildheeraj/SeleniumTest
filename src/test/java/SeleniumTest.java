import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static ChromeOptions  options;
    public static  WebDriver driver;
    @BeforeTest
    public void Setup(){

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

    }

    @Test
    void testStep(){
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("problem_user");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));

        String expectedText = "Sauce Labs Backpack";

        Assert.assertEquals(expectedText, webElement.getText());

        driver.close();
    }

}
