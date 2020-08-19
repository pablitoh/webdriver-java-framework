# webdriver-java-framework
Framework to make automation using WebDriver easier.

To run the tests run the mvn clean test command in the root folder of your project from your CLI. This will run all the specified classes inside testng.xml


Automation Framework created to make the use of web driver and pageObject pattern easier. Some of the features are:

- Parallel test execution via TestNG and MavenSurefire Plugin. Driver is independent of each instance and it is managed by a Singleton.

- Allure Reporting

- Clean PageObjects with no calls to the webdriver

- Custom WebElements to simplify solve usual webdrivers issues.

- API testing with RestAssure

- Harmcrest Matchers

Description:

This framework is forged around the UIElements, when creating your page objects, instantiate your elements like this:

private InputText submitMessage = new InputText(By.xpath("//*[@id='submitMessage']"));
private UiElement resultMessage = new UiElement(By.cssSelector(".alert.alert-success"));

The UiElements contains the click,type,etc ( All behavior methods ). There are different kinds of elements, such as InputText, FileUpload, each one with different behaviors.

To start creating UI tests, just create a new class and extend BaseTest.java , this will manage the setUp and TearDown methods, and the creation of the browser.
There you can create your page objects and perform your asserts.



