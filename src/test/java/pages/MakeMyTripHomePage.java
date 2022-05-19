package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakeMyTripHomePage {
    WebDriver driver;

    @FindBy(xpath = "//li[text()='Round Trip]'")
    WebElement roundTrip;

    @FindBy(xpath = "//input[@id='departure']")
    WebElement departure;

    MakeMyTripHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void selectTrip()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(roundTrip));
        roundTrip.click();
    }
}
