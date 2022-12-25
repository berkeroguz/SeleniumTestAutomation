package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {
    public static void main(String[] args) {
        // https://www.automationexercise.com/ adresine gidin
        // Sayfada 147 adet link bulunduğunu test edin.
        // Products linkine tıklayın
        // Special offer yazısının göründüğünü test edin.
        // sayfayı kapatın.

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Syafaya gittik.
        driver.get("https://www.automationexercise.com/");

        //Linkleri alalım
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //List uzunluğunu yazdırdık
        System.out.println(links.size());
        //Link sayısını kontrol ediyoruz.
        if (links.size()==147) {
            System.out.println("Test PaSSED");
        }
        else System.out.println("There are not 147 links");

        WebElement productLink = driver.findElement(By.partialLinkText("Products"));
        productLink.click();
        WebElement specialOffer = driver.findElement(By.id("sale_image"));

        //NoSuchElementException driver findelement bulunamadığında ortaya çıkar.

        if(specialOffer.isDisplayed())
        {
            System.out.println("Special offer testi PASSED");
        }
        else System.out.println("Special offer testi FAILED");




        driver.close();

    }
}
