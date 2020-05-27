package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvatarPage extends BasePage {

    By message_locator = By.xpath("//strong[contains(text(),'Success!')]");
    By image_locator = By.id("ContentPlaceHolderContent_RepeaterImage_ImageButton1_8");

    public BasePage openPage() {
        open("https://moodpanda.com/Account/Avatar/");
        isPageOpen();
        return this;
    }

    public BasePage isPageOpen() {
        $(By.xpath("//legend[contains(text(),'Avatar')]")).waitUntil(Condition.visible, 30000);
        return this;
    }

    public AvatarPage chooseAvatarImage(){
        $(image_locator).click();
        return this;
    }

    public AvatarPage verifyMessage(String expectedMessage){
        $(message_locator).waitUntil(Condition.visible, 30000);
        String actualMessage = $(message_locator).getText();
        System.out.println("Actual message: " + actualMessage);
        System.out.println("Expected message: " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Avatar не сохранился");
        return this;
    }
}
