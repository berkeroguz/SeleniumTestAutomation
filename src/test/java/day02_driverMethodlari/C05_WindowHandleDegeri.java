package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleDegeri {
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getWindowHandle()); //CDwindow-C64E9977FD6B7C505AFD1D5879F78A55
        driver.get("https://www.amazon.com");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getWindowHandle()); //CDwindow-64730D7974755FFEE6077BE7CE9DD6E1

        Thread.sleep(3000);
        driver.close();


    }
}
