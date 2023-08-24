import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Scanner;

public class TiktokLogin {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver =  new ChromeDriver(options);
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.tiktok.com");

        WebElement loginButton=driver.findElement(By.id("header-login-button"));
        loginButton.click();

        WebElement phoneemailTab = driver.findElement(By.xpath("//p[text()='Use phone / email / username']"));
        phoneemailTab.click();

        WebElement phoneNumberInput= driver.findElement(By.xpath("//input[@name='mobile']"));
        actions.moveToElement(phoneNumberInput).click().sendKeys("Phone Number").build().perform();

        WebElement sendCodeButton= driver.findElement(By.xpath("//button[text()='Send code']"));
        sendCodeButton.click();

        System.out.println("Enter the Code");
        Scanner scanner = new Scanner(System.in);
        String CODE = scanner.nextLine();

        loginButton = driver.findElement(By.xpath("//button[@data-e2e='login-button']"));
        loginButton.click();













    }
}