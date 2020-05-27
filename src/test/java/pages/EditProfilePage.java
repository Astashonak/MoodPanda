package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EditProfilePage extends BasePage {

    By message_locator = By.xpath("//strong[contains(text(),'Success!')]");
    By name_locator = By.id("ContentPlaceHolderContent_TextBoxFirstname");
    By update_details_button = By.id("ContentPlaceHolderContent_ButtonSave");

    public BasePage openPage() {
        open("https://moodpanda.com/Account/");
        isPageOpen();
        return this;
    }

    public BasePage isPageOpen() {
        $(By.xpath("//legend[contains(text(),'Personal Info')]")).waitUntil(Condition.visible, 30000);
        return this;
    }

    public EditProfilePage changeName(String name){
        $(name_locator).click();
        $(name_locator).clear();
        $(name_locator).sendKeys(name);
        $(update_details_button).click();
        return this;
    }

    public EditProfilePage verifyMessage(String expectedMessage){
        $(message_locator).waitUntil(Condition.visible, 30000);
        String actualMessage = $(message_locator).getText();
        System.out.println("Actual message: " + actualMessage);
        System.out.println("Expected message: " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Новое имя не сохранился");
        return this;
    }
}
