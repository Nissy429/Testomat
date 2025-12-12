package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;

    @Given("I open the browser and navigate to login page")
    public void i_open_the_browser_and_navigate_to_login_page() {
        driver = new ChromeDriver();  // ✅ No Hooks used
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should land on the home page")
    public void i_should_land_on_the_home_page() {
        boolean logo = driver.findElements(By.className("app_logo")).size() > 0;
        assertTrue("Home page not displayed", logo);

        driver.quit();  // ✅ Close browser here
    }
}
