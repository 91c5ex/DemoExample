import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Books;
import pages.HomePage;

import java.time.Duration;

public class Example {

    WebDriver driver;
    String URL = "https://demoqa.com/";

    HomePage homePage;
    Books books;

    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage(driver);
        homePage.clickBooks();

        books = new Books(driver);
        books.clickAuthor();

       driver.close();
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.launchBrowser();

      /*  String s = "atomorrow";
        char[] charArray = s.toCharArray();
        int index=0;
        for(int j=0;j<charArray.length;j++)
        {
            if(charArray[j]=='o'){
                index ++;
//                charArray[j]='#';
                if(  (index==2))
                {
                    charArray[j]='#';
                    break;
                }
            }
//            else {
//                index++;
//            }
        }
        System.out.println(String.copyValueOf(charArray));
    }*/
    }
}
