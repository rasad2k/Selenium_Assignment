import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertEquals;


public class EditProfilePageTest {
    protected WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void editProfilePageTest() {
        MainPage mainPage = new MainPage(this.driver);
        EditProfilePage editProfilePage = mainPage.openEditProfilePage();
        String result = editProfilePage.editProfile();
        assertEquals(result, "GfG Profile");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
