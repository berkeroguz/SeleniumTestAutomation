package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        // amazon'a gidip nutella icin arama yapın
        // ilk sayfada çıkan ürünlerin içerisinde
        // en yüksek fiyati bulun
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        List<WebElement> items = driver.findElements(By.className("a-price-whole"));

        int biggest = 0;

        for (WebElement item: items)
        {
            int value = Integer.parseInt(item.getText());
            if(value>biggest){
                biggest= Integer.parseInt(item.getText());
            }
        }
        System.out.println("En büyük sayı = " + biggest);

        Thread.sleep(2000);
        driver.close();




    }
}
