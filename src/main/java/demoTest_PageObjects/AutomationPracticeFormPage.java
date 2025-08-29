package demoTest_PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@SuppressWarnings("unused")
public class AutomationPracticeFormPage {
    WebDriver driver;

    // Locators
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderRadioButton = By.xpath("//label[text()='Female']");
    private By phoneNumberField = By.id("userNumber");
    private By submitButton = By.id("submit");

    // Constructor
    public AutomationPracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void selectGender() {
        driver.findElement(genderRadioButton).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    // Validation
    public String getPageTitle() {
        return driver.getTitle();
    }
}
