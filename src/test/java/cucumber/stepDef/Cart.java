package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user login")
    public void user_login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Then("input username")
    public void input_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @And("input password")
    public void input_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @And("login")
    public void login(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Then("add cart a T-shirt")
    public void add_tshirt(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")));
        ele1.click();
    }
    @Then("remove a T-shirt")
    public void remove_tshirt(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='remove-sauce-labs-backpack']")));
        ele1.click();
    }

}
