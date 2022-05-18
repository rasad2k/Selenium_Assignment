import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage extends PageBase {
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    public By institutionElem = By.name("institution");
    public By yearsOfPassing = By.id("graduation_year");
    public By details = By.name("hq_details");
    public By cgpaRadio = By.name("percent_0");
    public By cgpaInput = By.id("percentage_cgpa");
    public By scale = By.id("cgpa_scale");
    public By firstNext = By.id("nextBtn");

    public String editProfile() {

        // Initiating web elements to edit the profile
        WebElement institutionWebElement = this.waitAndReturnElement(institutionElem);
        WebElement yearsOfPassingElement = this.waitAndReturnElement(yearsOfPassing);
        WebElement detailsElement = this.waitAndReturnElement(details);
        WebElement cgpaRadioElement = this.waitAndReturnElement(cgpaRadio);
        WebElement cgpaInputElement = this.waitAndReturnElement(cgpaInput);

        // Clearing and filling the input fields
        institutionWebElement.clear();
        institutionWebElement.sendKeys("ELTE");
        yearsOfPassingElement.clear();
        yearsOfPassingElement.sendKeys("2022");

        Select selectElem = new Select(detailsElement);
        selectElem.selectByVisibleText("M.Sc");
        if (!cgpaRadioElement.isSelected()) {
            cgpaRadioElement.click();
        }
        cgpaInputElement.clear();
        cgpaInputElement.sendKeys("90");

        WebElement nextElement = this.waitAndReturnElement(firstNext);
        nextElement.click();

        // Scrolling so that 'next' will be visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextElement);
        nextElement.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextElement);
        nextElement.click();

        return this.driver.getTitle();
    }
}
