## Cucumber BDD Automation Framework

### 📌 Overview
This project is a **Cucumber BDD-based automation framework** designed for robust and scalable **UI test automation**. It follows a **multi-module architecture**, ensuring modularity, reusability, and maintainability of test components. The framework is designed to support:

- **Cross-browser testing** with WebDriver management
- **Parallel execution** using TestNG with testng.xml
- **Page Object Model (POM)** for structured test design
- **Data-driven testing** with YAML data files
- **Selenium Grid support** for distributed execution
- **Detailed reporting and logging**, integrating Cucumber Reports and Log4j2
- **CI/CD integration** with Jenkins for seamless automation

With **reusable components and structured test execution**, this framework simplifies UI automation while maintaining efficiency and flexibility.

### 📂 Project Structure
```
project-root/
│-- module1-coreframework/  # Reusable Components
│   ├── config/             # Configuration files (LogConfig and ReportConfig)
│   ├── commonhooks/        # Hooks (before/after scenario)
│   ├── drivers/            # DriverFactory class for WebDriver management and context class
│   ├── utilities/          # Common utilities (Selenium common utilities, File utilities, Yaml Reader)
│   ├── pageobject/         # Base page object
│   ├── resources/          # log4j2 settings (log4j2.xml)
│
│-- module2-warriors/       # Feature Module 1
│   ├── features/           # Cucumber feature files
│---- src/main/java
│   ├── pageobject/         # Page Object Model
│   ├── utilities/          # DynamicLocators
│---- src/test/java
│   ├── stepdefs/           # Step Definitions
│   ├── testrunner/         # TestNG / JUnit Runner
│   ├── resources/          # Test Data in Yaml files
│
│-- module3-sixers/         # Feature Module 2
│   ├── features/           # Cucumber feature files
│---- src/main/java
│   ├── pageobject/         # Page Object Model
│---- src/test/java
│   ├── stepdefs/           # Step Definitions
│   ├── testrunner/         # TestNG / JUnit Runner
│   ├── resources/          # Test Data in Yaml files
│
│-- module4-bulls/          # Feature Module 3
│   ├── features/           # Cucumber feature files
│---- src/main/java
│   ├── pageobject/         # Page Object Model
│   ├── utilities/          # Constants
│---- src/test/java
│   ├── stepdefs/           # Step Definitions
│   ├── testrunner/         # TestNG / JUnit Runner
│   ├── resources/          # Test Data in Yaml files
│
│-- reports/                # Test reports (Extent, Cucumber MasterThought)
│-- pom.xml                 # Maven dependencies
```

### ⚙️ Setup Instructions
#### Prerequisites:
- Java 11+
- Maven
- TestNG
- Selenium WebDriver
- Cucumber-JVM

#### Installation Steps:
1. Clone the repository
   ```sh
   git clone https://github.com/sanjaycode-gh/com.veeva.assignment.git
   ```
2. Run tests using Maven and Install dependencies
   ```sh
   mvn clean install -fae
   ```

### 🚀 Test Execution
#### Running via TestNG Runner
- Located in `src/test/java/glucode/`
- Execute using IDE or command line

#### Running via TestNG XML
- Located in the root folder (`testing.xml`)
- Execute using IDE or command line

### 📊 Reports & Logging
- **Cucumber Reports** (JSON, HTML)
- **Log4j2-based Logging**
- **Cucumber MasterThought for detailed insights** 
- ** Respective modules Cucumber reports are available at "target/cucumber-reports" folder"
- ** if any reports are generated in tests are attached to the after scenario hooks"

### 🔄 CI/CD Integration
- **Jenkins integration** for automated test execution
- **Bitbucket/GitHub integration** for version control

### ❓ Support
For issues or contributions, raise a ticket in the repository.

📧 **Contact:** sanjay.yerrolla@gmail.com

