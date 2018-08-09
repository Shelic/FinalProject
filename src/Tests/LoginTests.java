package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.InvoicesPage;

public class LoginTests extends Browser {

	@Test(priority = 0)
	public void invalidLogin() {

		LoginPage login = new LoginPage(driver);

		driver.get("http://app.invoice-factory.source-code.rs/login");

		login.fillInputs("marijanaselic@gmail.com", "");
		login.clickLogin();

		login.fillInputs(" ", "");
		login.clickLogin();
		login.waitErrorEmail();

		Assert.assertEquals(login.errorEmailText(), "The email field is required.");

		login.fillInputs("", "qwe123");
		login.clickLogin();
		login.waitErrorEmail();

		Assert.assertEquals(login.errorEmailText(), "The email field is required.");

	}

	@Test(priority = 1)
	public void incorectLogin() {

		LoginPage login = new LoginPage(driver);

		login.fillInputs("hfsjkdfkfh@gmail.com", "qwe123");
		login.clickLogin();
		login.waitInvalidLogin();

		Assert.assertEquals(login.invalidLoginText(), "Invalid credentials.");

		login.fillInputs("marijanaselic@gmail.com", "ksfjlkss");
		login.clickLogin();
		login.waitInvalidLogin();

		Assert.assertEquals(login.invalidLoginText(), "Invalid credentials.");

	}

	@Test(priority = 2)
	public void passwordCheck() {

		LoginPage login = new LoginPage(driver);

		login.clear();

		login.fillInputs("", "12h5g");
		login.clickLogin();
		login.waitShortPass();

		Assert.assertEquals(login.shortPassText(), "The password field must be at least 6 characters.");

		login.fillInputs("", "kfjug1458ghuj4745juik");
		login.clickLogin();
		login.waitLongPass();

		Assert.assertEquals(login.longPassText(), "The password field may not be greater than 20 characters.");
	}

	@Test(priority = 3)
	public void validLogin() {
		LoginPage login = new LoginPage(driver);
		InvoicesPage invoices = new InvoicesPage(driver);

		login.fillInputs("marijanaselic@gmail.com", "qwe123");
		login.clickLogin();

		invoices.invoiceVerify();
	}

}
