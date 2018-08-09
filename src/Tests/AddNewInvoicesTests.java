package Tests;

import org.testng.annotations.Test;

import Pages.AddNewInvoicesPage;

public class AddNewInvoicesTests extends Browser {

	@Test(priority = 10)
	public void emptyInvoice() {

		AddNewInvoicesPage newInv = new AddNewInvoicesPage(driver);

		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");
		newInv.clickSave();

	}

	@Test(priority = 11)
	public void withoutTitle() {

		AddNewInvoicesPage newInv = new AddNewInvoicesPage(driver);

		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");

		newInv.clickDropDownTo();

		newInv.clickDropDownFrom();

		newInv.clickBasis("456");

		newInv.clickCurrency();

		newInv.selectBankField();

		newInv.clickSave();

	}

	@Test(priority = 12)
	public void cancelButton() {

		AddNewInvoicesPage newInv = new AddNewInvoicesPage(driver);

		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");

		newInv.clickDropDownTo();

		newInv.clickDropDownFrom();

		newInv.clickBasis("456");

		newInv.clickCurrency();

		newInv.selectBankField();

		newInv.clickCancel();
	}

	@Test(priority = 13)
	public void backButton() {

		AddNewInvoicesPage newInv = new AddNewInvoicesPage(driver);

		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");

		newInv.clickBack();

	}

	@Test(priority = 14)
	public void logoutButton() {

		AddNewInvoicesPage newInv = new AddNewInvoicesPage(driver);

		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");

		newInv.clickLogout();
	}

}
