package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

	@FindBy(id = "login-form-email")
	WebElement email;

	@FindBy(id = "login-pass")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div/div/div/form/div[1]/div[2]/div/div[1]/div[2]/div/i")
	WebElement visibilityButton;

	@FindBy(id = "login-form-btn")
	WebElement loginButton;

	@FindBy(css = "#app > div > main > div > div > div > div > form > div.v-card__text > div:nth-child(1) > div > div.v-text-field__details > div > div > div")
	WebElement errorEmail;

	@FindBy(css = "#app > div > main > div > div > div > div > form > div.v-card__text > div:nth-child(2) > div > div.v-text-field__details > div.v-messages.error--text > div > div")
	WebElement errorPass;

	@FindBy(css = "#app > div > main > div > div > div > div > form > div.v-card__text > div.v-input.input-group--dirty.v-text-field.v-input--has-state.v-input--is-label-active.v-input--is-dirty.error--text > div > div.v-text-field__details > div > div > div")
	WebElement invalidEmail;

	@FindBy(css = "#app > div > main > div > div > div > div > form > div.v-card__text > div.v-input.input-group--dirty.v-text-field.v-input--has-state.v-input--is-label-active.v-input--is-dirty.error--text > div > div.v-text-field__details > div.v-messages.error--text > div > div")
	WebElement shortPass;

	@FindBy(css = "#app > div > main > div > div > div > div > form > div.v-card__text > div.v-input.input-group--dirty.v-text-field.v-input--has-state.v-input--is-label-active.v-input--is-dirty.error--text > div > div.v-text-field__details > div.v-messages.error--text > div > div")
	WebElement longPass;

	@FindBy(css = "#app > div > div > div > div > p")
	WebElement invalidLogin;

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void clear() {
		email.clear();
		password.clear();
	}

	public void waitInvalidLogin() {
		wait.until(ExpectedConditions.visibilityOf(invalidLogin));
	}

	public void waitErrorEmail() {
		wait.until(ExpectedConditions.visibilityOf(errorEmail));
	}

	public void waitErrorPass() {
		wait.until(ExpectedConditions.visibilityOf(errorPass));
	}

	public void waitInvalidEmail() {
		wait.until(ExpectedConditions.visibilityOf(invalidEmail));
	}

	public void waitShortPass() {
		wait.until(ExpectedConditions.textToBePresentInElement(shortPass,
				"The password field must be at least 6 characters."));
	}

	public void waitLongPass() {
		wait.until(ExpectedConditions.textToBePresentInElement(longPass,
				"The password field may not be greater than 20 characters."));
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void fillInputs(String email, String password) {

		this.email.clear();
		this.email.clear();
		this.email.sendKeys(email);

		this.password.clear();
		this.password.clear();
		this.password.sendKeys(password);
	}

	public String errorEmailText() {
		return errorEmail.getText();
	}

	public String passEmailText() {
		return errorPass.getText();
	}

	public String invalidEmailText() {
		return invalidEmail.getText();
	}

	public String shortPassText() {
		return shortPass.getText();
	}

	public String longPassText() {
		return longPass.getText();
	}

	public String invalidLoginText() {
		return invalidLogin.getText();
	}

	public boolean verifyLogIn() {
		return loginButton.isDisplayed();
	}

	public void clickVisibilityButton() {
		visibilityButton.click();
	}

}
