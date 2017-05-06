
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class DropboxTest {

     public String baseUrl = "https://www.dropbox.com/";
     String driverPath = "C:\\Users\\Slavik\\Downloads\\chromedriver_win32\\chromedriver.exe";
     WebDriver driver;
     WebDriverWait wait;

        @BeforeTest
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", driverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--incognito");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 20, 500);
            driver.get(baseUrl);
        }

        @Test(priority = 0)
        public void logInToAccount() {
            driver.findElement(By.cssSelector("#sign-in")).click();
            driver.findElement(By.cssSelector(".text-input-input")).sendKeys("stankova-87@mail.ru");
            driver.findElement(By.cssSelector(".password-input")).sendKeys("password");
            driver.findElement(By.cssSelector(".login-button")).submit();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".primary-action-menu__button")));
            Assert.assertTrue(driver.findElement(By.cssSelector(".primary-action-menu__button")).isDisplayed());
        }

        @Test(priority = 1,
              dependsOnMethods = { "logInToAccount"})
        public void uploadFile() {
            String fileName = new String("chromedriver_win32.zip");
            driver.findElement(By.cssSelector(".primary-action-menu__button")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dbmodal-button")));
            driver.findElement(By.cssSelector(".basic-uploader-link")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dbmodal-button")));
            driver.findElement(By.cssSelector("[aria-label=\"Upload files\"]")).sendKeys("C:\\Users\\Slavik\\Downloads\\" + fileName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-filename=\"" + fileName + "\"]")));
            driver.findElement(By.cssSelector("[data-filename=\"" + fileName + "\"] button[role=\"checkbox\"]")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("[data-filename=\"" + fileName + "\"]")).isDisplayed());
        }

        @Test(priority = 2,
              dependsOnMethods = {"logInToAccount", "uploadFile"})
        public void downloadFile() {
            String fileName = new String("chromedriver_win32.zip");
            driver.findElement(By.cssSelector("[data-filename=\"" + fileName + "\"]")).click();
            //Download file page
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".button-secondary")));
            String buttonText = driver.findElement(By.cssSelector(".button-secondary")).getText();
            while (buttonText.length() < 1 ) {
                 buttonText = driver.findElement(By.cssSelector(".button-secondary")).getText();
            };
            driver.findElement(By.cssSelector(".button-secondary")).click();
            driver.findElement(By.cssSelector(".react-title-bar__close")).click();
        }

        @Test(priority = 3,
              dependsOnMethods = {"logInToAccount", "uploadFile"})
        public void deleteFile() {
            String fileName = new String("chromedriver_win32.zip");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-filename=\"" + fileName + "\"]")));
            driver.findElement(By.cssSelector("[data-filename=\"" + fileName + "\"] button[role=\"checkbox\"]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ue-effect-container")));
            driver.findElement(By.xpath("//div[contains(text(), 'Delete')]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".db-modal-buttons")));
            driver.findElement(By.cssSelector(".button-primary")).click();
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("[data-filename=\"" + fileName + "\"]"))));
            Assert.assertTrue(driver.findElements(By.cssSelector("[data-filename=\"" + fileName + "\"]")).size()==0);
        }

        @Test(priority = 4,
              dependsOnMethods = {"logInToAccount"})
        public void logOut() {
<<<<<<< HEAD
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bubbleDropdownTarget-1")));
            driver.findElement(By.cssSelector("#bubbleDropdownTarget-1")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.link-item")));
            driver.findElement(By.cssSelector("[href=\"https://www.dropbox.com/logout\"]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".login-button")));
=======
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".c-avatar--circle")));
            driver.findElement(By.cssSelector("#bubbleDropdownTarget-1")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.link-item")));
            driver.findElement(By.cssSelector("[href=\"https://www.dropbox.com/logout\"]")).click();
>>>>>>> 284b3a2f5c59f5bf5764080e3137fc675fe5df6e
            Assert.assertTrue(driver.findElement(By.cssSelector(".login-button")).isDisplayed());
        }

     @AfterTest
        public void finish() {
            driver.close();
        }
    }

