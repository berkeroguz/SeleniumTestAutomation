package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        //amazon anasayfaya gidin ,
        // Gift Cards linkini tıklayın
        // Gift cards sayfasınaa gittiğini test edin.

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement button = driver.findElement(By.className("a-button-input"));
        button.click(); // Butonu bulduk o açılan küçük penceredeki onu kapattık.

        Thread.sleep(2000);

        WebElement giftCardLinki = driver.findElement(By.linkText("Gift Cards"));
        giftCardLinki.click();

        String expectedWord="Gift Cards";
        String actualTitle=driver.getTitle();

        if(actualTitle.contains(expectedWord))
        {
            System.out.println("Test Passed");
        }
        else System.out.println("Test FAILED");

        Thread.sleep(2000);
        driver.close();


    }
}
