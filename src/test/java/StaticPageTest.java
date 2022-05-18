import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StaticPageTest {
    protected WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void staticPageTest() {
        MainPage mainPage = new MainPage(this.driver);
        assertEquals("GeeksforGeeks | A computer science portal for geeks", this.driver.getTitle());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
