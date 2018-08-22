package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvoicesPage extends PageObject {

	Actions builder = new Actions(driver);

	@FindBy(xpath = "//*[@id=\"app\"]/div[22]/main/div/div/div[1]/div/div[1]/h4")
	WebElement invoicesListText;

	@FindBy(xpath = "//*[@id=\"app\"]/div[22]/main/div/div/div[1]/div/div[2]/div/div/div[1]/div/div/div[1]/div/div/div/div[1]")
	WebElement clientList;

	@FindBy(xpath = "//*[@id=\"app\"]/div[19]/div/div/div[2]/a")
	WebElement tamaraJovanovic;

	@FindBy(id = "filter-from")
	WebElement fromDate;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[4]/button/div")
	WebElement date1;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/table/tbody/tr[4]/td[3]/button/div")
	WebElement date24;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/table/tbody/tr[2]/td[4]/button/div")
	WebElement date8;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/button[1]/div/i")
	WebElement fromLastMonth;

	@FindBy(id = "filter-from-ok")
	WebElement from_ok;

	@FindBy(id = "filter-to")
	WebElement toDate;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[4]/button/div")
	WebElement dateTo1;

	@FindBy(id = "filter-to-ok")
	WebElement to_ok;

	@FindBy(xpath = "//*[@id=\"filter-period\"]/div/i")
	WebElement monthButton;

	@FindBy(id = "this-month")
	WebElement thisMonth;

	@FindBy(id = "last-month")
	WebElement lastMonth;

	@FindBy(id = "reset-dates")
	WebElement resetDates;

	@FindBy(xpath = "//*[@id=\"filter-reset\"]/div/i")
	WebElement refresh;

	@FindBy(xpath = "//*[@id=\"inv-status-btn-2018-MKO1\"]/div/i[1]")
	WebElement changeStatusButton;

	@FindBy(xpath = "//*[@id=\"inv-status-btn-2018-XDR2\"]/div")
	WebElement changeStatusDropDown;

	@FindBy(xpath = "//*[@id=\"app\"]/div[16]/div/div/div[2]/a/div")
	WebElement sent;

	@FindBy(id = "inv-status-dialog-yes-2018-XDR2")
	WebElement sentYes;

	@FindBy(id = "inv-status-dialog-no-2018-MKO1")
	WebElement sentNo;

	@FindBy(id = "context-402")
	WebElement optionsButton;

	@FindBy(id = "context-edit-402")
	WebElement editButton;

	@FindBy(id = "context-preview-402")
	WebElement previewButton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[8]/div/div/nav/div/a/div/i")
	WebElement exitButton;

	@FindBy(xpath = "//*[@id=\"context-delete-257\"]/div/i")
	WebElement deleteButton;

	@FindBy(id = "context-download-dialog-yes-402")
	WebElement deleteButtonYes;

	@FindBy(id = "context-download-dialog-no-402")
	WebElement deleteButtonNo;

	@FindBy(id = "add-new-invoice")
	WebElement addNewInvoices;

	@FindBy(css = "#inv-status-2018-XDR2")
	WebElement sentText;

	@FindBy(xpath = "//*[@id=\"app\"]/div[8]/div/div/nav/div/a/div")
	WebElement previewXButton;

	public InvoicesPage(WebDriver driver) {
		super(driver);

	}

	public String sentVerify() {
		return sentText.getText();
	}

	public String invoiceVerify() {
		return invoicesListText.getText();
	}

	public void selectClient() {
		clientList.click();
		tamaraJovanovic.click();
	}

	public void selectFromDate1() {
		Action date1st = builder.moveToElement(fromDate).click().moveToElement(date1).click().moveToElement(from_ok)
				.click().build();
		date1st.perform();

	}

	public void selectFromDate24() {
		wait.until(ExpectedConditions.elementToBeClickable(fromDate));
		Action date25th = builder.moveToElement(fromDate).click().click().moveToElement(fromLastMonth).click()
				.moveToElement(date24).click().moveToElement(from_ok).click().build();
		date25th.perform();

	}

	public void selectFromDate8() {

		Action date8th = builder.moveToElement(fromDate).click().moveToElement(date8).click().moveToElement(from_ok)
				.click().build();
		date8th.perform();

	}

	public void selectToDate1() {
		Action toDate1st = builder.moveToElement(toDate).click().moveToElement(dateTo1).click().moveToElement(to_ok)
				.click().build();
		toDate1st.perform();

	}

	public void thisMonthButton() {
		monthButton.click();
		thisMonth.click();
	}

	public void lastMonthButton() {
		monthButton.click();
		thisMonth.click();
	}

	public void resetDateButton() {
		monthButton.click();
		resetDates.click();
	}

	public void clickRefreshButton() {
		refresh.click();
	}

	public void changeStatusSent() {
		Action changeStatusAction = builder.moveToElement(changeStatusButton).click()
				.moveToElement(changeStatusDropDown).click().moveToElement(sent).click().moveToElement(sentYes).click()
				.build();
		changeStatusAction.perform();

	}

	public void clickPreview() {
		Action previewClickAction = builder.moveToElement(optionsButton).click().moveToElement(previewButton).click()
				.moveToElement(previewXButton).click().build();
		previewClickAction.perform();

	}

	public void clickDeleteYes() {

		optionsButton.click();
		deleteButton.click();
		deleteButtonYes.click();

	}

	public void clickDeleteNo() {
		Action deleteClickNo = builder.moveToElement(optionsButton).click().moveToElement(deleteButton).click()
				.moveToElement(deleteButtonNo).click().build();
		deleteClickNo.perform();

	}

	public void clickEdit() {
		AddNewInvoicesPage addInv = new AddNewInvoicesPage(driver);
		Action editBasis = builder.moveToElement(optionsButton).click().moveToElement(editButton).click()
				.moveToElement(addInv.basisField).doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("Basis2")
				.moveToElement(addInv.save).click().moveToElement(addInv.back).click().build();
		editBasis.perform();

	}

}
