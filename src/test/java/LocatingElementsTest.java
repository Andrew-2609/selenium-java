import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatingElementsTest {

    @Test
    public void firstElementsQuiz() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));

        Assert.assertTrue(element.isDisplayed());

        driver.quit();
    }

    @Test
    public void typesOfLocatorsTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement swagLabsLogo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]")));
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        WebElement botImage = driver.findElement(By.className("bot_column"));

        Assert.assertTrue(swagLabsLogo.isDisplayed());
        Assert.assertTrue(userNameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(botImage.isDisplayed());

        driver.quit();
    }

}
