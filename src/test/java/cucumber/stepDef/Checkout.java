package cucumber.stepDef;

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

public class Checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    public void login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Given("add chart")
    public void addChart() {
        login();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")));
        ele1.click();
    }

    @Then("click cart")
    public void clickCart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Then("click checkout")
    public void clickCheckout() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @Then("fill the input")
    public void fillTheInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first-name']")));
        ele1.sendKeys("dummy");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("dummy");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("13320");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @Then("finish")
    public void finish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='finish']")));
        ele1.click();
    }

    @Then("back home")
    public void backHome() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='back-to-products']")));
        ele1.click();
        driver.close();
    }
}
