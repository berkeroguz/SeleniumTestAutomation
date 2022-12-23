package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.getProperty("webdriver.chrome.driver","src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("Maximize windows boyutlari " + driver.manage().window().getSize());
        System.out.println("Maximize windows konum " + driver.manage().window().getPosition());

        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        System.out.println("fullscreen window");



    }
}
