
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dropboxDownload {

    @Test
    public void startWebDriver(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Slavik\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20, 500);

        driver.navigate().to("https://www.dropbox.com/");

        //Login page
        driver.findElement(By.id("sign-in")).click();

        driver.findElement(By.className("text-input-input")).sendKeys("stankova-87@mail.ru");
        driver.findElement(By.className("password-input")).sendKeys("password");
        driver.findElement(By.className("login-button")).submit();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("is-sharedwith-column-visible")));

        driver.findElement(By.className("primary-action-menu__button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dbmodal-button")));

        driver.findElement(By.className("basic-uploader-link")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dbmodal-button")));

        driver.findElement(By.cssSelector("[aria-label=\"Upload files\"]")).sendKeys("C:\\Users\\Slavik\\Downloads\\geckodriver-v0.15.0-win64\\geckodriver.exe");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-filename=\"geckodriver.zip\"]")));


       // Files page
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("is-sharedwith-column-visible")));

        driver.findElement(By.cssSelector("[data-filename=\"chromedriver_win32.zip\"]")).click();

        //Download file page
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("button-secondary")));

            /* When page loading, button already clickable, but it doesn`t have an event for "file download".
             "Dropbox" uses two different classes with different text insight the button.
             One used if desktop app is disabled, one when enabled.
             That why I use "while"*/
        String buttonText = driver.findElement(By.className("button-secondary")).getText();
        while (buttonText.length() < 1 ) {
             buttonText = driver.findElement(By.className("button-secondary")).getText();
        };

        driver.findElement(By.className("button-secondary")).click();

//        driver.close();
////        driver.quit();
    }
}

