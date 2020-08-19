package WebObjects.Pages;

import UiElements.Dropdown;
import UiElements.FileUpload;
import UiElements.InputText;
import UiElements.UiElement;
import WebObjects.Fragments.Header;
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


    public ContactUsPage typeEmail(String text)
    {
        emailField.type(text);
        return this;
    }
    public ContactUsPage typeOrderReference(String text)
    {
        idOrderField.type(text);
        return this;
    }
    public ContactUsPage typeMessage(String text)
    {
        messageField.type(text);
        return this;
    }
    public ContactUsPage uploadFile(String text)
    {
        fileUpload.type(text);
        return this;
    }
    public ContactUsPage selectSubjectHeading(String option)
    {
        dropdown.selectByText(option);
        return this;
    }
    public ContactUsPage submitForm()
    {
        submitMessage.click();
        return this;
    }
    public String getResultMessage()
    {
        return resultMessage.getText();
    }








}
