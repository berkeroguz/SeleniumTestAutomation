package day04_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) throws InterruptedException {
        //1-gerekli ayarlari yapin
//2- https://www.amazon.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4- Sayfayi "refresh" yapin
//5- Sayfa basliginin "Spend less" ifadesi icerdigini test edin
//6- Gift Cards sekmesine basin
//7Birthday butonuna basin
//8- Best Seller bolumunden ilk urunu tiklayin
//9- Gift card details'den 25 $'i secin
//10-Urun ucretinin 25$ oldugunu test edin
//11-Sayfayi kapatin

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        Thread.sleep(1000);
        String expectedText ="Spend less";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedText)){
            System.out.println("Title is contain spend less, TEST PASSED");
        }
        else System.out.println("Title is not contain spend less, Test FAILED");

        driver.findElement(By.linkText("Gift Cards")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/a[@aria-label='Birthday']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//li[@class='a-carousel-card acswidget-carousel__card'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"gc-mini-picker-amount-1\" and @value='25']")).click();

        String expectedWord="$25";
        String actualWord=driver.findElement(By.xpath("//*[@id=\"gc-buy-box-text\"]/span")).getText();
        System.out.println(actualWord);
        if(expectedWord.equals(actualWord))
        {
            System.out.println("Ürün 25 dolar olmuştur. Test PASSED");
        }
        else System.out.println("Ürün 25 dolar olmamış Test FAILED");

        Thread.sleep(3000);
        driver.close();
    }
}
