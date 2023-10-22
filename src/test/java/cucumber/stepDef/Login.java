package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user the login page")
    public void user_the_login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Then("user write (.*) as username$")
    public void user_write_username_credential(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @And("user write (.*) as password$")
    public void user_write_password_credential(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("click login button")
    public void click_login_button(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Then("user verify (.*) login result$")
    public void user_verify_login_result(String status){
        if (status.equals("success")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Products')]")));
            String dashboard = ele1.getText();
            driver.close();

            Assert.assertEquals(dashboard, "Products");
        }
        if (status.equals("failed")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement ele2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button")));

            String errorLogin = ele2.getText();
            driver.close();

            Assert.assertEquals(errorLogin, "ini salah");
        }

    }
}
