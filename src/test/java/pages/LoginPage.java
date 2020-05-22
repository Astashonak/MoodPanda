package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    public LoginPage openPage() {
        open("https://moodpanda.com/Login/");
        return this;
    }

    public LoginPage isPageOpen() {
        $("[alt='MoodPanda Android App on Google Play'").waitUntil(Condition.visible, 30000);
        return this;
    }

    public FeedPage login(String email, String password) {
        $(By.id("ContentPlaceHolderContent_TextBoxEmail")).sendKeys(email);
        $(By.id("ContentPlaceHolderContent_TextBoxPassword")).sendKeys(password);
        $(By.id("ContentPlaceHolderContent_ButtonLogin")).click();
        FeedPage feedPage = new FeedPage();
        feedPage.isPageOpen();
        return feedPage;
    }

}

