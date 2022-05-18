import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;

class MainPage extends PageBase {

    public WebDriver driver;
    public By signInItem = By.id("userProfileId");
    public By usernameInputItem = By.id("luser");
    public By passwordInputItem = By.id("password");


    public By iconItem = By.xpath("//div[contains(@class,'header-main__container')]/ul[2]/li[4]");
    public By editProfileItem = By.xpath("//li[contains(@id,'userProfileId')]/ul[1]/li[5]/a[1]");
    public By logoutImage = By.xpath("//div[@class='header-main__profile']/img[1]");
    public By logoutLink = By.xpath("//a[@href='https://auth.geeksforgeeks.org/logout.php/?to=https://www.geeksforgeeks.org/']");
    private final By hoverItem = By.xpath("//ul[@class='header-main__list']/li[1]");
    public final By allCourses = By.xpath("//ul[@class='header-main__list']/li[1]/span[1]");


    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.driver.get("https://www.geeksforgeeks.org");
    }

    public EditProfilePage openEditProfilePage() {
        login("fobejo5078@abincol.com", "t3mps3cur3");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement iconItemElement = this.waitAndReturnElement(iconItem);
        iconItemElement.click();
        WebElement editProfileItemElement = this.waitAndReturnElement(editProfileItem);
        editProfileItemElement.click();
        return new EditProfilePage(this.driver);

    }

    public String login(String username, String password) {
        WebElement signInItemElement = this.waitAndReturnElement(signInItem);
        signInItemElement.click();
        WebElement userNameItem = this.waitAndReturnElement(usernameInputItem);
        WebElement passwordItem = this.waitAndReturnElement(passwordInputItem);
        userNameItem.sendKeys(username);
        passwordItem.sendKeys(password + "\n");
        return this.driver.getTitle();
    }

    public String logout() {
        login("fobejo5078@abincol.com", "t3mps3cur3");
        WebElement logOutImageElement = this.waitAndReturnElement(logoutImage);
        logOutImageElement.click();
        WebElement logOutElement = this.waitAndReturnElement(logoutLink);
        logOutElement.click();
        return this.driver.getTitle();
    }

    public String hover() {
        WebElement hoverItemElement = this.waitAndReturnElement(hoverItem);
        Actions action = new Actions(this.driver);
        action.moveToElement(hoverItemElement).perform();
        WebElement allCourserElement = this.waitAndReturnElement(allCourses);
        return allCourserElement.getText();
    }


}
