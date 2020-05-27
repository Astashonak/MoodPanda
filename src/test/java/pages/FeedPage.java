package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage extends BasePage {

    By updateButton = By.id("LinkUpdate");
    By accountButton = By.id("Settings");
    By avatarButton = byText("Avatar");
    By editProfileButton = byText("Edit profile");

    public FeedPage openPage() {
        open("https://moodpanda.com/Feed/");
        return this;
    }

    public FeedPage isPageOpen() {
        return this;
    }

    public RateHappinessModal openRateHappinessModal() {
        $(updateButton).click();
        RateHappinessModal rateHappinessModal = new RateHappinessModal();
        rateHappinessModal.isModalOpened();
        return rateHappinessModal;
    }

    public AvatarPage openAvatar() {
        $(accountButton).click();
        $(avatarButton).click();
        AvatarPage avatarPage = new AvatarPage();
        avatarPage.isPageOpen();
        return avatarPage;
    }

    public EditProfilePage openEditProfile() {
        $(accountButton).click();
        $(editProfileButton).click();
        EditProfilePage editProfilePage = new EditProfilePage();
        editProfilePage.isPageOpen();
        return editProfilePage;
    }
}
