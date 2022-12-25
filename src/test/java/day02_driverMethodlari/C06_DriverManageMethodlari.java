package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverManageMethodlari {
    public static void main(String[] args) {
     System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //implicityl wait gittiğimiz sayfa acılıncaya veya aradığımız webelement bulununcaya kadar
        //driver'in bekleyebileceği max sureyi belirler.

        // Bu dörtlü kod her test method'unun basına yazılacak.


    }
}
