import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class App {
    WebDriver driver;

    public App(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usser\\Desktop\\caso de prueba\\Prueba1\\driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
         
         ChromeOptions options = new ChromeOptions();
       
         options.addArguments("--disable-infobars"); // Desactiva la barra de información
        options.addArguments("--disable-extensions"); // Desactiva las extensiones
        options.addArguments("--disable-popup-blocking"); // Desactiva el bloqueo de ventanas emergentes
        options.addArguments("--disable-save-password-bubble"); // Desactiva la burbuja de guardar contraseñas
        options.addArguments("--disable-translate");
        
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

        String [] charcs = new String[] {"A", "B", "C", "D", "F", "G", "H", "I", "W", "Q", "V", "B", "Z", "T", "U", "P", "@", "3", "4", "5", "7"};
        Random rn = new Random();
        String name = "", email ="";

        for(int i = 0; i < charcs.length; i++){
            int index = rn.nextInt(charcs.length);
            name += charcs[index];
        }

        WebElement txtname = this.driver.findElement(By.name("name"));
        txtname.sendKeys(name);

        int index = rn.nextInt(5, charcs.length-1);
        for(int i = 0; i < index; i++){
            if(charcs[i] != "@"){
              email += charcs[i];  
            }
        }

        email += "@gmail.com";
        List<WebElement> txtemail = this.driver.findElements(By.name("email"));
        txtemail.get(1).sendKeys(email);
        

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
        selectyr.selectByValue("2005");
    }

    @Test
    public void VerifyInformation(){
        Newverifiuser();
        WebElement div = this.driver.findElement(By.xpath("//h2[contains(@class, 'title text-center')]"));
        junit.framework.Assert.assertTrue(div.isDisplayed());

    }

    @Test
    public void verifyusercreate(){
        VerifyInformation();
        WebElement div = this.driver.findElement(By.xpath("//h2[contains(@class, 'title text-center')]"));
        junit.framework.Assert.assertTrue(div.isDisplayed());

    }






    


}
