package page;

import com.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private static final String LOGIN_PAGE_URL = "https://github.com/join?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home";
    private final String RED_COLOR_CLASS = "color-text-danger text-bold";
    private final String GREEN_COLOR_CLASS = "color-text-success";
    private final String CLASS_ATTRIBUTE = "class";

    @FindBy(xpath = "//dl[@class='form-group my-3 required']/dd/input[@id='user_login']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='user[password]']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@data-more-than-n-chars]")
    private WebElement atLeastCharactersMessage;

    @FindBy(xpath = "//span[@data-letter-requirement]")
    private WebElement lowercaseMessage;

    @FindBy(xpath = "//input[@class='form-control input py-1 is-autocheck-errored']")
    private WebElement emailFieldWithError;

    @FindBy(xpath = "//dd[@class='error']")
    private WebElement errorPopup;

    @FindBy(xpath = "//div[@class='mb-1']")
    private WebElement suggestedUserNames;

    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public void openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    public void entersValueInEmailField(String text) {
        emailField.sendKeys(text);
    }

    public boolean isErrorSingDisplayed() {
        WaitUtils.implicitWait(driver);

        return emailFieldWithError.isDisplayed();
    }

    public boolean checkErrorPopupDisplay() {
        WaitUtils.implicitWait(driver);

        return errorPopup.isDisplayed();
    }

    public void entersValueInPasswordField(String text) {
        passwordField.clear();
        passwordField.sendKeys(text);
    }

    public boolean isLeastCharactersMessageChangedToClassFromColorRed() {
        return atLeastCharactersMessage.getAttribute(CLASS_ATTRIBUTE).equals(RED_COLOR_CLASS);
    }

    public boolean isLowercaseMessageChangedToClassFromColorRed() {
        return lowercaseMessage.getAttribute(CLASS_ATTRIBUTE).equals(RED_COLOR_CLASS);
    }

    public boolean isLowercaseMessageChangedToClassFromColorGreen() {
        return lowercaseMessage.getAttribute(CLASS_ATTRIBUTE).equals(GREEN_COLOR_CLASS);
    }

    public boolean isMessageContainsUsernameEntered() {
        final String EXPECTED_MESSAGE = "Username masharova is not available.";

        return suggestedUserNames.getText().equals(EXPECTED_MESSAGE);
    }
}
