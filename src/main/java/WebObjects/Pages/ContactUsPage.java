package WebObjects.Pages;

import UiElements.Dropdown;
import UiElements.FileUpload;
import UiElements.InputText;
import UiElements.UiElement;
import WebObjects.Fragments.Header;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

/***
 * Page Object for the  Contact Us Page : http://automationpractice.com/index.php?controller=contact
 */
public class ContactUsPage extends BasePage {

    private Header header = new Header();
    private InputText emailField    = new InputText(By.xpath("//*[@id='email']"));
    private InputText idOrderField  = new InputText(By.xpath("//*[@id='id_order']"));
    private Dropdown  dropdown      = new Dropdown(By.xpath("//*[@id='id_contact']"));
    private InputText messageField  = new InputText(By.xpath("//*[@id='message']"));
    private FileUpload fileUpload   = new FileUpload(By.xpath("//*[@id='fileUpload']"));
    private InputText submitMessage = new InputText(By.xpath("//*[@id='submitMessage']"));
    private UiElement resultMessage = new UiElement(By.cssSelector(".alert.alert-success"));


    /***
     * Types the current email in the email field
     * @param email
     * @return {@link ContactUsPage}
     */
    @Step("Typing email: {0}")
    public ContactUsPage typeEmail(String email)
    {
        emailField.type(email);
        return this;
    }
    @Step("Typing Order Reference: {0}")
    public ContactUsPage typeOrderReference(String text)
    {
        idOrderField.type(text);
        return this;
    }
    @Step("Typing Message: {0}")
    public ContactUsPage typeMessage(String text)
    {
        messageField.type(text);
        return this;
    }
    @Step("Uploading file: {0}")
    public ContactUsPage uploadFile(String text)
    {
        fileUpload.type(text);
        return this;
    }
    @Step("Select Subject Heading: {0}")
    public ContactUsPage selectSubjectHeading(String option)
    {
        dropdown.selectByText(option);
        return this;
    }
    @Step("Submitting form")
    public ContactUsPage submitForm()
    {
        submitMessage.click();
        return this;
    }
    @Step("Getting Result Message")
    public String getResultMessage()
    {
        return resultMessage.getText();
    }








}
