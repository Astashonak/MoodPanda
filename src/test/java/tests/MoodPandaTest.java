package tests;

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
}
