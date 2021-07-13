package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import page.LoginPage;

public class LoginPageTest {
    private LoginPage loginPage;

    public LoginPageTest() {
        this.loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Verify error message is displayed upon registration with invalid email pattern")
    public void isErrorMessageIsDisplayedUponRegistration() {
        final String RED_ERROR_MESSAGE = "Red error single isn't display";
        final String INVALID_VALUE = "invalid";

        loginPage.openLoginPage();
        loginPage.entersValueInEmailField(INVALID_VALUE);
        Assert.assertTrue(RED_ERROR_MESSAGE, loginPage.isErrorSingDisplayed());
        loginPage.checkErrorPopupDisplay();
    }

    @Test
    @DisplayName("Verify message under password field indicates a completeness of password requirements")
    public void isMessageUnderPasswordFieldIsDisplayed() {
        final String FIRST_INVALID_VALUE = "AAA";
        final String SECOND_INVALID_VALUE = "AAAaaa";

        loginPage.openLoginPage();
        loginPage.entersValueInPasswordField(FIRST_INVALID_VALUE);
        Assert.assertTrue(loginPage.isLeastCharactersMessageChangedToClassFromColorRed());
        Assert.assertTrue(loginPage.isLowercaseMessageChangedToClassFromColorRed());
        loginPage.entersValueInPasswordField(SECOND_INVALID_VALUE);
        Assert.assertTrue(loginPage.isLeastCharactersMessageChangedToClassFromColorRed());
        Assert.assertTrue(loginPage.isLowercaseMessageChangedToClassFromColorGreen());
    }

    @Test
    @DisplayName("Verify error message is displayed upon registration with already existent username")
    public void isErrorMessageDisplayedWithAlreadyExistentUsername() {
        final String EXISTING_USER = "masharova";

        loginPage.openLoginPage();
        loginPage.entersValueInEmailField(EXISTING_USER);
        Assert.assertTrue(loginPage.isErrorSingDisplayed());
        Assert.assertTrue(loginPage.checkErrorPopupDisplay());
        Assert.assertTrue(loginPage.isMessageContainsUsernameEntered());
    }
}
