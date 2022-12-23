package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com");
        // get ile aynı işlevi yapar
        Thread.sleep(3000);

        driver.get("https://www.wisequarter.com");

        // yeniden amazon'a dönelim
        driver.navigate().back();

        //tekrar wisequarter.com'a gidelim

        driver.navigate().forward();

        driver.close();

    }
}
