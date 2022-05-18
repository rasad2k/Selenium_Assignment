import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginPageTest {
    protected WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        MainPage mainPage = new MainPage(this.driver);
        String result = mainPage.login("fobejo5078@abincol.com", "t3mps3cur3");
        Assert.assertEquals("GeeksforGeeks | A computer science portal for geeks", result);
    }

    @Test
    public void logoutTest() {
        MainPage mainPage = new MainPage(this.driver);
        String result = mainPage.logout();
        assertEquals("GeeksforGeeks | A computer science portal for geeks", result);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
