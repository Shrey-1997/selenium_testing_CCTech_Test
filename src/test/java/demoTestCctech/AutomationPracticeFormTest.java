package demoTestCctech;

import demoTest_PageObjects.AutomationPracticeFormPage;
import demoTest.BaseTest.BaseTest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AutomationPracticeFormTest extends BaseTest {

    JavascriptExecutor js;

    @Test(priority = 1)
    public void testValidFormSubmission() {
        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        driver.get("https://demoqa.com/automation-practice-form");
        js = (JavascriptExecutor) driver;

        formPage.enterFirstName("Shreya");
        formPage.enterLastName("Joahi");
        formPage.enterEmail("joshishreya1997@gmail.com");
        formPage.selectGender();
        formPage.enterPhoneNumber("1234567890");

        // Scroll and click submit via JS
        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        js.executeScript("arguments[0].click();", submitButton);

        // Wait for confirmation modal
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(modalTitle.getText(), "Thanks for submitting the form", "Modal title did not match!");
    }

    @AfterMethod
    public void captureScreenshot(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot("Failure_" + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            takeScreenshot("Success_" + result.getName());
        }
    }

    @Test(priority = 2)
    public void testInvalidEmailFormat() {
        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        driver.get("https://demoqa.com/automation-practice-form");
        js = (JavascriptExecutor) driver;

        formPage.enterFirstName("Shreya");
        formPage.enterLastName("Joshi");
        formPage.enterEmail("xyz@cct"); // Invalid
        formPage.selectGender();
        formPage.enterPhoneNumber("1234567890");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", emailInput);
        Assert.assertFalse(isValid, "Email should be invalid but was marked valid.");
    }

    @Test(priority = 3)
    public void testPhoneNumberWithIncorrectLength() {
        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        driver.get("https://demoqa.com/automation-practice-form");
        js = (JavascriptExecutor) driver;

        formPage.enterFirstName("Shreya");
        formPage.enterLastName("Joshi");
        formPage.enterEmail("joshishreya1997@gmail.com");
        formPage.selectGender();
        formPage.enterPhoneNumber("12345"); // Too short

        WebElement phoneInput = driver.findElement(By.id("userNumber"));
        boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", phoneInput);
        Assert.assertFalse(isValid, "Phone number should be invalid due to short length.");
    }

    @Test(priority = 4)
    public void testBlankFirstName() {
        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        driver.get("https://demoqa.com/automation-practice-form");
        js = (JavascriptExecutor) driver;

        formPage.enterFirstName(""); // Blank
        formPage.enterLastName("Joshi");
        formPage.enterEmail("joshishreya1997@gmail.com");
        formPage.selectGender();
        formPage.enterPhoneNumber("1234567890");

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", firstNameInput);
        Assert.assertFalse(isValid, "First name should be invalid when left blank.");
    }

    @Test(priority = 5)
    public void testFutureDateOfBirth() {
        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        driver.get("https://demoqa.com/automation-practice-form");

        // The form allows future DOB — this test is just an example
        formPage.enterFirstName("Shreya");
        formPage.enterLastName("Joshi");
        formPage.enterEmail("joshishreya1997@gmail.com");
        formPage.selectGender();
        formPage.enterPhoneNumber("1234567890");

        // This would be enhanced if DOB is handled via custom logic
        WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
        dobInput.clear();
        dobInput.sendKeys("30 Sep 2030"); // Future date

        // Validate the DOB input was accepted (as page has no restriction)
        Assert.assertTrue(dobInput.getAttribute("value").contains("2030"), "DOB field did not accept future date");
    }
}
