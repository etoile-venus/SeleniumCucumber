# SauceDemo Cucumber

*GitHub* - [etoile-venus/SeleniumCucumber](https://github.com/etoile-venus/SeleniumCucumber)

An **automated UI testing project** for the [SauceDemo](https://www.saucedemo.com/) e-commerce website, showcasing **Behavior-Driven Development (BDD)** principles using **Cucumber**. This project serves as a practical exercise in integrating Selenium WebDriver with Cucumber to create readable and maintainable test scenarios.

---

## Built With

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-%2343B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-207E2E?style=for-the-badge&logo=cucumber&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-B22222?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Page-Object-Model](https://img.shields.io/badge/Page--Object--Model-68655F?style=for-the-badge)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)

## Project Setup

This project uses **Maven** for dependency management and build automation.

1.  **Prerequisites:**
    * **Java Development Kit (JDK):** Version 17 or newer.
    * **Apache Maven:** Latest stable version.
    * **Git:** For cloning the repository.
    * An IDE like **IntelliJ IDEA** (recommended).
    * **Google Chrome browser:** Required as the default browser for testing. WebDriverManager handles the automatic download and setup of the Chrome WebDriver.

2.  **Clone the Repository:**

    ```bash
    git clone [https://github.com/etoile-venus/SeleniumCucumber.git](https://github.com/etoile-venus/SeleniumCucumber.git)
    cd SeleniumCucumber
    ```

3.  **Build the Project:**
    Navigate to the project's root directory and run the following command to download dependencies and build the project:

    ```bash
    mvn clean install
    ```

---

## Project Structure

```bash
SauceDemoItemPurchase/
├── src/
│   ├── main/
│   │   ├── java/            # Main application code (if any)
│   │   └── resources/       # Main application resources
│   └── test/
│       ├── java/
│       │   ├── Pages/         # Page Object Model (POM) classes representing UI pages (e.g., LoginPage, HomePage)
│       │   │   ├── CartPage.java
│       │   │   ├── CheckoutCompletePage.java
│       │   │   ├── CheckoutPage.java
│       │   │   ├── ConfirmPurchasePage.java
│       │   │   ├── HomePage.java
│       │   │   └── LoginPage.java
│       │   ├── Runner/        # Test Runner class to execute Cucumber features
│       │   │   └── TestRunner.java
│       │   └── Steps/         # Step Definition classes that link Gherkin steps to Java code
│       │       └── StepDefinition.java
│       └── resources/
│           └── ItemPurchase.feature # Cucumber feature files describing test scenarios in Gherkin
├── pom.xml                  # Maven Project Object Model file
└── README.md                # This file
```
## How to Run Tests
### From IntelliJ IDEA
Open the project in IntelliJ IDEA.

Navigate to the TestRunner.java file located in src/test/java/Runner/.

Right-click on TestRunner.java and select "Run 'TestRunner'" to execute all defined Cucumber scenarios.

### From Command Line
Make sure Maven is installed and added to your system PATH.

Navigate to the project's root directory.

Run the following command to execute all Cucumber tests via the TestRunner:

```bash
mvn test
```

## License

This project is open-source and freely available for use, modification, and distribution without restrictions.

## Author
**Danica Bijeljanin**

Feel free to connect with me:
- **LinkedIn:** [linkedin.com/in/danicabijeljanin/](https://linkedin.com/in/danicabijeljanin/)  
- **GitHub:** [github.com/etoile-venus](https://github.com/etoile-venus)
