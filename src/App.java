import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class App {
    WebDriver driver;

    public App(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\koderx\\Desktop\\automationExercises\\driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

         
         ChromeOptions options = new ChromeOptions();
       
         options.addArguments("--disable-notifications");
        
         this.driver = new ChromeDriver(options);

         driver.get("http://automationexercise.com");
    }

    @Test
    public void HomeVisiblity(){
        WebElement header = this.driver.findElement(By.id("header"));
        junit.framework.Assert.assertTrue(header.isDisplayed());
    }
    
    public void clicksiginup(){
        HomeVisiblity();
        WebElement sigin = driver.findElement(By.xpath("//i[contains(@class, 'fa fa-lock')]"));
        sigin.click();


    }


    public static void main(String[] args) throws Exception {
        new App().VerifyInformation();
    

    }

    @Test
    public void Newverifiuser(){

        clicksiginup();

        WebElement div = this.driver.findElement(By.xpath("//div[contains(@class, 'signup-form')]"));
        junit.framework.Assert.assertTrue(div.isDisplayed());


        WebElement txtname = this.driver.findElement(By.name("name"));
        txtname.sendKeys("Koder");

        List<WebElement> txtemail = this.driver.findElements(By.name("email"));
        txtemail.get(1).sendKeys("Koderselagano@gmail.com");

        List<WebElement> btnsiginup = driver.findElements(By.xpath("//button[contains(@class,'btn-default')]"));
        btnsiginup.get(1).click();


        WebElement Checkbox1 = this.driver.findElement(By.id("id_gender1"));
        Checkbox1.click();

        this.driver.findElement((By.id("password"))).sendKeys("1234");


        WebElement days = this.driver.findElement(By.id("days"));
        days.click();
        Select selectday = new Select(days);
        selectday.selectByValue("3");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement months = this.driver.findElement(By.id("months"));
        months.click();
        Select selectmt = new Select(months);
        selectmt.selectByValue("10");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement year = this.driver.findElement(By.id("years"));
        year.click();
        Select selectyr = new Select(year);
        selectyr.selectByValue("2007");
    }

    @Test
    public void VerifyInformation(){
        Newverifiuser();
        WebElement div = this.driver.findElement(By.xpath("//h2[contains(@class, 'title text-center')]"));
        junit.framework.Assert.assertTrue(div.isDisplayed());

    }

    


}
