package day04_Xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {
        /*
        1- https://the-internet.herokuapp.com/add remove elements/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu'nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin
         */

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement button = driver.findElement(By.xpath("//div/button[@onclick='addElement()']"));
        button.click();

        Thread.sleep(1000);

        WebElement deleteButton = driver.findElement(By.xpath("//div/button[@class='added-manually']"));

        if(deleteButton.isDisplayed())
        {
            System.out.println("Delete tuşu görüntülendi. Test PASSED");
        }
        else System.out.println("Delete tuşu yok . Test FAILED");

        deleteButton.click();

        WebElement text = driver.findElement(By.xpath("//div/h3"));

        if (text.isDisplayed())
        {
            System.out.println("Add/Remove Elements yazısı gözükyüor TEST PASSED");
        }else System.out.println("Add/Remove Elements yazısı gözükmüyor test FAILED");

        driver.close();


    }
}
