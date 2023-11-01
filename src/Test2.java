import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;



public class Test2 extends App{
   @Override
   public void Newverifiuser(){
      this.clicksiginup();
      List<WebElement> txtemail = this.driver.findElements(By.name("email"));
        txtemail.get(0).sendKeys("elkoderselagano@gmail.com");

        this.driver.findElement(By.name("password")).sendKeys("1234");

        List<WebElement> btnsiginup = driver.findElements(By.xpath("//button[contains(@class,'btn-default')]"));
        btnsiginup.get(0).click();
   }

   @Test
   @Override
   public void VerifyLogin(){
      this.clicksiginup();
      junit.framework.Assert.assertTrue(this.driver.findElement(By.className("login-form")).isDisplayed());
   }
}
