package day05_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

//3. Login alanine "username" yazdirin
        driver.findElement(By.xpath("//div/input[@id='user_login']")).sendKeys("username");

//4. Password alanine "password" yazdirin
        driver.findElement(By.xpath("//div/input[@id='user_password']")).sendKeys("password");

//5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit")).click();
//6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();


//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//div/input[@id='sp_amount']")).sendKeys("10000");

//8. tarh kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//div/input[@id='sp_date']")).sendKeys("2020-09-10");
//9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//div/input[@id='pay_saved_payees']")).click();
//10. "The payment was successfully submitted." mesajinin ciktigini test edin

        if(driver.findElement(By.xpath("//div/span")).isDisplayed())
        {
            System.out.println("Test PASSED");
        }
        else System.out.println("Test FAILED");

        /*       String expectedText="The payment was successfully submitted.";
       String actualText =driver.findElement(By.xpath("//div/span")).getText();

/*
       if(actualText.equals(expectedText)){

       }
       else
*/

       driver.close();

    }
}
