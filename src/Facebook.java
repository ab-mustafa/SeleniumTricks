import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Scanner;

public class Facebook {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver =  new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.facebook.com");
        String email="xyZ@gmail.com";
        String password= "cccccc";

        WebElement emailInput= driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordInput= driver.findElement(By.xpath("//input[@name='pass']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        WebElement searchButton = driver.findElement(By.xpath("//input[@aria-label='Search Facebook']"));
        actions.moveToElement(searchButton).click().sendKeys("Person name").sendKeys(Keys.ENTER).build().perform();

        WebElement MessageButton =driver.findElement(By.xpath("//span[text()='Message']"));
        actions.moveToElement(MessageButton).click().build().perform();


        WebElement textBar = driver.findElement(By.xpath("//div[text()='Aa']"));
        actions.moveToElement(textBar).sendKeys("Test 123").sendKeys(Keys.ENTER).build().perform();

    }
}