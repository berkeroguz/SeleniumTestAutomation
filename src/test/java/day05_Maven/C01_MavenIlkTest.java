package day05_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2- arama kutusunu Locate edelim
        WebElement searchBox =driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));

        //3- "Samsung headphones" ile arama yapalim
        searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);


        //4- Bulunan sonuc sayisini yazdiralim
        System.out.println("Urun Sayısı = " + driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']/span)[1]")).getText());
        //5- Ilk urunu tiklayalim
        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img"));
        firstProduct.click();
        Thread.sleep(2000);
        driver.navigate().back();
        //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement> basliklar = driver.findElements(By.xpath("//div/span[@class='a-size-base a-color-base puis-bold-weight-text']"));

        for (WebElement each : basliklar)
        {
            System.out.println(each.getText());
        }
        driver.close();
    }
}
