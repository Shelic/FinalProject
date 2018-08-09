package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.InvoicesPage;

public class InvoicesTests extends Browser {

	@Test(priority = 4)
	public void clients() {
		InvoicesPage invoice = new InvoicesPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/invoices");

		Assert.assertEquals(invoice.invoiceVerify(), "Invoices List");

		invoice.selectClient();
	}

	@Test(priority = 5)
	public void date() {
		InvoicesPage invoice = new InvoicesPage(driver);

		invoice.selectFromDate1();

		invoice.selectToDate1();

		invoice.selectFromDate8();

		invoice.selectFromDate24();
	}

	@Test(priority = 6)
	public void monthButton() {
		InvoicesPage invoice = new InvoicesPage(driver);

		invoice.thisMonthButton();

		invoice.lastMonthButton();

		invoice.resetDateButton();

		invoice.clickRefreshButton();
	}

	@Test(priority = 7)
	public void changeStatus() {
		InvoicesPage invoice = new InvoicesPage(driver);

		invoice.changeStatusSent();

		Assert.assertEquals(invoice.sentVerify(), "Sent");
	}

	@Test(priority = 8)
	public void optionsButton() {
		InvoicesPage invoice = new InvoicesPage(driver);

		invoice.clickPreview();

		invoice.clickDeleteNo();

		Assert.assertEquals(invoice.invoiceVerify(), "Invoices List");
	}

	@Test(priority = 9)
	public void editTest() {
		InvoicesPage invoice = new InvoicesPage(driver);

		invoice.clickEdit();

	}

}
