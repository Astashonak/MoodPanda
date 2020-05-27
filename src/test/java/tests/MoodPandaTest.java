package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test(invocationCount = 1)
    public void login() {
        loginPage
                .openPage()
                .login("astashonak12@mailinator.com", "password12")
                .openRateHappinessModal()
                .updateMood(8)
                .goToMyDiary();
    }

    @Test(description = "Проверка смены аватарки")
    public void changeAvatar(){
        loginPage
                .openPage()
                .login("astashonak12@mailinator.com", "password12")
                .openAvatar()
                .chooseAvatarImage()
                .verifyMessage("Success!");
    }

    @Test(description = "Проверка сохранения после внесений изменений в профиль")
    @Description("Тест")
    public void saveEditFirstName(){
        loginPage
                .openPage()
                .login("astashonak12@mailinator.com", "password12")
                .openEditProfile()
                .changeName("Princess")
                .verifyMessage("Success!");
    }
}
