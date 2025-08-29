# Selenium TestNG Automation Framework - CCTech

This project is an automation testing framework built using **Selenium WebDriver**, **TestNG**, and **Java**. It is designed to test the automation practice form on [demoqa.com](https://demoqa.com/automation-practice-form) as part of the CCTech assignment.

---

## 🔧 Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven (for dependency management)
- Jenkins (for CI/CD)
- Git & GitHub (for version control)
- Extent Reports or TestNG reports (for reporting)

---

## 📂 Project Structure

├── src
│ ├── main
│ │ └── java
│ └── test
│ ├── java
│ │ ├── demoTestCctech
│ │ │ └── AutomationPracticeFormTest.java
│ │ └── demoTest_PageObjects
│ │ └── AutomationPracticeFormPage.java
├── testng.xml
├── pom.xml
└── README.md


---

## 🚀 How to Run the Tests

### Prerequisites:
- Java (JDK 11+)
- Maven
- TestNG
- Chrome browser
- Git (optional for cloning)

### Run from command line:
```bash
mvn clean test

Run with TestNG:

Right-click on testng.xml and select Run As → TestNG Suite in Eclipse or IntelliJ.

🧪 Test Coverage

Tests included:

✅ Valid form submission

❌ Invalid email format 

❌ Incorrect phone number length

❌ Blank first name

❌ Future date of birth

🛠 Jenkins Integration

This project is configured for Jenkins:

You can clone it using SSH or HTTPS

Run test jobs manually or automatically

Generate and email TestNG HTML reports

📬 Reporting

Default: test-output/index.html (TestNG report)

Configurable in Jenkins using post-build actions

📎 Repository URL

https://github.com/Shrey-1997/selenium_testing_CCTech_Test

---

