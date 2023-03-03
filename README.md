# AppiumCucumberFramework
Android mobile app automation using Appium, Java, and Cucumber framework

Packages :
1. pages : 
    - BasePage : contains basic operations such as field decorator, wait, clear, click, send keys, get text, launch app, and close app
    - Pages : contains elements and operations on that specific page
2. runners : to run the JUnit Test, also defining @BeforeClass and @AfterClass
3. stepdef : 
    - Hooks : defining @Before (execute method before each scenario) and @After (execute method after each scenario)
    - StepDef classes : code implementations from features files
4. utils :
    - CapabilitiesManager : to set capabilities
    - DriverManager : to initialize driver
    - GlobalParams : setting parameter (platform name, UDID, system port)
    - PropertyManager : loading properties from config.properties
    - ServerManager : starting Appium server programmatically
    - TestUtils : logging
    
feature files are stored in src/test/resources

Apk Name : Android-MyDemoAppRN.1.3.0.build-244

How to run the test :
1. Right click on MyRunnerTest
2. Run As > JUnit Test
