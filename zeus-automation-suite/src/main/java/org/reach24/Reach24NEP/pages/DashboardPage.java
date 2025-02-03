package org.reach24.Reach24NEP.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.epam.ta.reportportal.ws.annotations.In;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.util.Inandoutstream;
import org.reach24.Reach24NEP.util.PropsReader;
import org.reach24.Reach24NEP.util.Wait;

import javax.swing.*;

public class DashboardPage {
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Inandoutstream inandoutstream=new Inandoutstream();
	Wait wait;
	DriverActions driverActions;
	JsActions jsActions;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
		driverActions = new DriverActions(driver);
		jsActions = new JsActions(driver);
	}

	public void switchTabTo(String tabName) {
		if (tabName.equalsIgnoreCase("All")) {
			String tabSwitch = "//*[@id='incidents-tab']//h5[contains(text(), '" + tabName + "')]";
			wait.forElementToBeClickable(driver.findElement(By.xpath(tabSwitch)));
			jsActions.jsclick(driver.findElement(By.xpath(tabSwitch)));
		} else {
			String switchTo = "//*[@id='incidents-tab']//*[contains(@href,'" +tabName+ "')]";
			wait.forElementToBeClickable(driver.findElement(By.xpath(switchTo)));
			jsActions.jsclick(driver.findElement(By.xpath(switchTo)));
		}
	}

	@FindBy(xpath = "//*[@id='incidents-datatable_filter']//input[@type='search']")
	private WebElement searchBoxElement;

	public void searchEvent(String eventId) {
		System.out.println("Search Event on Dashboard");
		driverActions.hardwaitBasedOnInput(5000);
		switchTabTo("All");
		wait.forElementToBeDisplayed(searchBoxElement);
		searchBoxElement.clear();
		driverActions.driverSendKeys(searchBoxElement,eventId);
		driverActions.hardwaitBasedOnInput(2000);
	}

	public void searchDraftEvent(String eventID) {
		driverActions.hardwaitBasedOnInput(1000);
		searchBoxElement.clear();
		searchBoxElement.sendKeys(eventID);
	}

	@FindBy(xpath = "//*[@id='event-snapshot-datatable_filter']//input[@type='search']")
	private WebElement searchBox;

	public void searchotherEvent(String eventId) {
		wait.forElementToBeDisplayed(searchBox);
		driverActions.hardwaitBasedOnInput(2000);
		searchBox.clear();
		String[] splitId = eventId.split(" ");
		searchBox.sendKeys(splitId);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-picture-o fa-lg']")
//	@FindBy(xpath = "//*[@id=\"incidents-datatable\"]/tbody/tr/td[3]/div/i")
	private WebElement attachmentImage;
	
	public void clickAttachments() {	
		attachmentImage.click();
	}

	@FindBy(xpath = "//a[@class='dt-button show_hide_column']")
	private WebElement showHideButton;
	public void showHideColumn(String BoxName, String ShowHide){
		jsActions.jsclick(showHideButton);
		driverActions.hardwaitBasedOnInput(2000);
		WebElement BoxElement=driver.findElement(By.xpath("//span[text()='"+ BoxName +"']/parent::a"));
		if(ShowHide.equalsIgnoreCase("Show")){
			if(driverActions.isActive(BoxElement)){
				System.out.println(BoxName+" not clicked");
				driver.navigate().refresh();
				driverActions.hardwaitBasedOnInput(2000);
				return;
			} else{
				jsActions.jsclick(BoxElement);
				System.out.println(BoxName+" clicked");
				driver.navigate().refresh();
			}
		} else if (ShowHide.equalsIgnoreCase("Hide")) {
			if(driverActions.isActive(BoxElement)){
				System.out.println("Checkbox clicked");
				jsActions.jsclick(BoxElement);
				driver.navigate().refresh();
			} else{
				System.out.println(BoxName+" not clicked");
				driver.navigate().refresh();
				driverActions.hardwaitBasedOnInput(2000);
				return;
			}
		}
		driverActions.hardwaitBasedOnInput(2000);
	}

	public String getValueOnDashboardTable(String Header){
		List<WebElement> thList=driver.findElements(By.xpath("//*[@id='incidents-datatable_wrapper']//table[@role='grid']/thead/tr/th"));
		for(int i=1;i<=thList.size();i++){
			String headerSearch= "(//*[@id='incidents-datatable_wrapper']//table[@role='grid']/thead/tr/th["+i+"])[1]";
			if(driverActions.driverGetText(driver.findElement(By.xpath(headerSearch))).equalsIgnoreCase(Header)){
				String valueSearch = "//div[@class='dataTables_scrollBody']//tr[@class='odd' and @role='row']/td[" + i + "]";
				return driverActions.driverGetText(driver.findElement(By.xpath(valueSearch)));
			}
			WebElement scroll=driver.findElement(By.className("dataTables_scrollBody"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft+=80", scroll);
		}
		return "Value not found";
	}
	
	public HashMap<String, String> getInfoFromDashboardPage(String tabname) {
		HashMap<String, String> dashboardMap = new HashMap<String, String>();
		String tempKey;
		String tempValue;
		String headerSearch;
		String valueSearch;
		driverActions.hardwaitBasedOnInput(4000);
		for (int count = 1; count <= 50; count++) {
			try {
				if (tabname.equalsIgnoreCase("All")) {

					 headerSearch = "//*[@id='incidents-datatable_wrapper']//table[@role='grid']/thead/tr/th["
							+ count + "]";
					 valueSearch = "//div[@class='dataTables_scrollBody']//tr[@class='odd' and @role='row']/td["
							+ count + "]";
				} else {

					  headerSearch = " //*[@id='event-snapshot-datatable_wrapper']//table[@role='grid']/thead/tr/th["
							+ count + "]";
					  valueSearch = "//div[@class='dataTables_scrollBody']//*[@id='event-snapshot-datatable']//tr[@class='odd' and @role='row']/td["
							+ count + "]";
				}


				tempKey = driverActions.driverGetText(driver.findElement(By.xpath(headerSearch)));
				tempValue = driverActions.driverGetText(driver.findElement(By.xpath(valueSearch)));

				System.out.println(tempKey + " = " + tempValue);
				if (tempKey != null)
					dashboardMap.put(tempKey, tempValue);
			} catch (NoSuchElementException e) {
				break;
			}
		}

		return dashboardMap;

	}

	@FindBy(xpath="//select[@class='schedule_status_filter select2-offscreen']")
	private WebElement dropdownSelect;
	public void selectDashboardTableDropdown(String dropdown) throws IOException {
		driverActions.hardwaitBasedOnInput(2000);
		switchTabTo("submitted");
		Select drpTableDropdown = new Select(dropdownSelect);
		System.out.println("Dropdown to select : "+ dropdown);
		if(dropdown.equalsIgnoreCase("Pending Confirmation")){
			drpTableDropdown.selectByValue("scheduled_unconfirmed");
			drpTableDropdown.selectByValue("all");
			driverActions.hardwaitBasedOnInput(4000);
			drpTableDropdown.selectByValue("scheduled_unconfirmed");
		} else if (dropdown.equalsIgnoreCase("Scheduled Confirmation")) {
			drpTableDropdown.selectByValue("scheduled_confirmed");
			drpTableDropdown.selectByValue("all");
			driverActions.hardwaitBasedOnInput(4000);
			drpTableDropdown.selectByValue("scheduled_confirmed");
		} else if (dropdown.equalsIgnoreCase("Unscheduled")) {
			drpTableDropdown.selectByValue("unscheduled");
			drpTableDropdown.selectByValue("all");
			driverActions.hardwaitBasedOnInput(4000);
			drpTableDropdown.selectByValue("unscheduled");
		} else if(dropdown.equalsIgnoreCase("All")){
			drpTableDropdown.selectByValue("all");
		}else{
			System.out.println("Invalid tenant selected");
		}
		driverActions.hardwaitBasedOnInput(4000);
		wait.forElementToBeDisplayed(searchBoxElement);
		searchBoxElement.clear();
		driverActions.driverSendKeys(searchBoxElement,inandoutstream.loadScheduleEventID());
		driverActions.hardwaitBasedOnInput(4000);
	}
	@FindBy(xpath = "(//div[@class='dataTables_scrollBody']/table/tbody/tr/td)[1]/div/a")
	private WebElement firstEventId;
	@FindBy(xpath = "(//div[@class='dataTables_scrollBody']/table/tbody/tr/td)[5]")
	private WebElement scheduledTimeOnTable;
	public void validateDashboardTableRow(String validate) throws IOException {
		driverActions.hardwaitBasedOnInput(6000);
		if(validate.equalsIgnoreCase("EventID")){
			String displayedEventID=driverActions.driverGetText(firstEventId);
			displayedEventID=(displayedEventID.charAt(2)=='0')?displayedEventID.substring(3):displayedEventID.substring(2);
			Assert.assertEquals("The Event ID is successfully validated",inandoutstream.loadScheduleEventID(),displayedEventID);
		} else if (validate.equalsIgnoreCase("Schedule Time")) {
			String scheduledTimeLoaded=inandoutstream.loadScheduledTimeSlot();
			System.out.println("Scheduled Time Slot Loaded :" + scheduledTimeLoaded);
			String scheduleTimeSubstring=scheduledTimeLoaded.substring(5,scheduledTimeLoaded.length()-3);
			System.out.println("Scheduled Time Slot Loaded Substring :" + scheduleTimeSubstring);
			Assert.assertTrue("The Scheduled Time is successfully validated",driverActions.driverGetText(scheduledTimeOnTable).contains(scheduleTimeSubstring));
		}
	}

	@FindBy(xpath = "//div[@class='make-switch switch-mini has-switch org_struct']/div[1]/label[1]")
	private WebElement switchOrg;
	public void enableShowOrgEvents(){
		String checkedClass=driver.findElement(By.xpath("//div[@class='make-switch switch-mini has-switch org_struct']/div[1]")).getAttribute("class");
		if(checkedClass.contains("switch-off")) {
			System.out.println("Org Switch is OFF");
			jsActions.jsclick(switchOrg);
			driverActions.hardwaitBasedOnInput(3000);
		}
	}

	@FindBy(xpath = "//a[contains(@class,'dt-button reporting_tenants_filter_btn')]")
	private WebElement reportingTenantBtn;
	@FindBy(xpath = "//div[@id='reporting-tenants-filter-modal']/div/div/div[2]/div/div/ul/li/input")
	private WebElement reportingTenantSearch;
	@FindBy(xpath = "//select[@id='reporting_tenants_filter']")
	private WebElement reportingTenantSelect;
	@FindBy(xpath = "//div[@id='reporting-tenants-filter-modal']/div/div/div[3]/button")
	private WebElement reportingTenantCloseBtn;
	@FindBy(xpath = "//div[@aria-labelledby='reporting-tenants-filter-modal']/div/div/div/div/div/ul/li")
	private WebElement selectedOrgTenants;

	public void enterReportingTenants(String childTenant){
		String ReportingTenantClass=driver.findElement(By.xpath("//a[contains(@class,'dt-button reporting_tenants_filter_btn')]")).getAttribute("class");
		if(ReportingTenantClass.contains("reporting-tenants-filter-highlight")){
			jsActions.jsclick(reportingTenantBtn);
			driverActions.hardwaitBasedOnInput(2000);
			int selectedOrgTenantsSize=driver.findElements(By.xpath("//div[@aria-labelledby='reporting-tenants-filter-modal']/div/div/div/div/div/ul/li")).size();
			System.out.println(selectedOrgTenantsSize);
			for(int i=1;i<selectedOrgTenantsSize;i++){
				WebElement ithSelectOrgTenant=driver.findElement(By.xpath("//div[@aria-labelledby='reporting-tenants-filter-modal']/div/div/div/div/div/ul/li["+i+"]/a"));
				jsActions.jsclick(ithSelectOrgTenant);
				driverActions.hardwaitBasedOnInput(2000);
			}
//			jsActions.jsclick(reportingTenantCloseBtn);
//			driver.navigate().refresh();
//			driverActions.hardwaitBasedOnInput(2000);
//			jsActions.jsclick(reportingTenantBtn);
			wait.forElementToBeClickable(reportingTenantSearch);
			jsActions.jsInput(reportingTenantSearch,childTenant);
			System.out.println(childTenant);
			wait.forElementToBeClickable(reportingTenantSelect);
			Select drpTenant = new Select(reportingTenantSelect);
			drpTenant.selectByVisibleText(childTenant);
			wait.forElementToBeClickable(reportingTenantCloseBtn);
			jsActions.jsclick(reportingTenantCloseBtn);
			driverActions.hardwaitBasedOnInput(2000);
		} else if (!ReportingTenantClass.contains("reporting-tenants-filter-highlight")) {
			jsActions.jsclick(reportingTenantBtn);
			driverActions.hardwaitBasedOnInput(2000);
			jsActions.jsInput(reportingTenantSearch,childTenant);
			System.out.println(childTenant);
			Select drpTenant = new Select(reportingTenantSelect);
			drpTenant.selectByVisibleText(childTenant);
			jsActions.jsclick(reportingTenantCloseBtn);
			driverActions.hardwaitBasedOnInput(2000);
		}
	}
	
	// Agent Assignment NEP

		@FindBy(xpath = "(//button[@class='agent-assignment-history'])[1]")
		private WebElement agentAssignmentHistory;

		@FindBy(xpath = "(//button[@type='button'][normalize-space()='Close'])[9]")   //  (//button[text()='Close'])[8]
		private WebElement closeBtn;

	    @FindBy(xpath = "//span[@class='agent-name']")
	    private WebElement agentAssignDashBoard;

	    @FindBy(xpath = "//input[@aria-owns='select2-results-15']")
	    private WebElement inputAgentName;

		public void createAgentAssignmentOnEventDashboardPage(String agent) {
			driverActions.hardwaitBasedOnInput(2000);
			showHideColumn("Assigned Agent","Show");
			if(agent.contains("Observer")){
				int size=driver.findElements(By.xpath("//span[@class='agent-name']")).size();
				Assert.assertEquals(0,size);
				System.out.println("This is an Observer.");
				return;
			}
			wait.forElementToBeClickable(agentAssignDashBoard);
			jsActions.jsclick(agentAssignDashBoard);
			wait.forElementToBeClickable(inputAgentName);
			inputAgentName.click();
			inputAgentName.sendKeys(agent);
			driverActions.hardwaitBasedOnInput(2000);
			inputAgentName.sendKeys(Keys.ENTER);
			driverActions.hardwaitBasedOnInput(2000);
		}
		
		public void viewAgentAssignmentOnEventDashboardPage(String agent) {
				driverActions.hardwaitBasedOnInput(2000);
				showHideColumn("Assigned Agent","Show");
				wait.forElementToBeClickable(agentAssignmentHistory);
				jsActions.jsclick(agentAssignmentHistory);
				driverActions.hardwaitBasedOnInput(4000);
				int size=driver.findElements(By.xpath("//tbody[@id='event-agent-assignment-log-table']/tr")).size();
				WebElement latestAgent=driver.findElement(By.xpath("//tbody[@id='event-agent-assignment-log-table']/tr["+size+"]/td[2]"));
				WebElement latestAction=driver.findElement(By.xpath("//tbody[@id='event-agent-assignment-log-table']/tr["+size+"]/td[4]"));
				Assert.assertEquals(driverActions.driverGetText(latestAgent),agent);
				Assert.assertEquals(driverActions.driverGetText(latestAction),"Assigned");
				jsActions.jsclick(closeBtn);
				driverActions.hardwaitBasedOnInput(2000);
		}

		@FindBy(xpath = "//a[@class='head-tenant-name']")
		private WebElement tenantIcon;
		
		@FindBy(xpath = "//li[@id=\"company-users-tab\"]//h5[1]")
		private WebElement userBtn;
		
		@FindBy(xpath = "//button[@class='confirm']")
		private WebElement okBtn;
		
		@FindBy(xpath = "//a[text()='In-active']")
		private WebElement inactiveBtn;
		
		@FindBy(xpath = "//a[text()='Active']")
		private WebElement activeBtn;
		
		@FindBy(xpath = "(//i[@class='fa fa-refresh fa-fw'])[1]")
		private WebElement restoreBtn;
		
		@FindBy(xpath = "//button[@class='confirm']")
		private WebElement okBtn1;
		
		
		public void deleteUser(String agent) {
			wait.forElementToBeClickable(tenantIcon);
			jsActions.jsclick(tenantIcon);
			wait.forElementToBeClickable(userBtn);
			jsActions.jsclick(userBtn);
			driverActions.hardwaitBasedOnInput(2000);
			WebElement deleteIcon=driver.findElement(By.xpath("//td[text()='"+agent+"']/following-sibling::td[4]/span[4]"));
			deleteIcon.click();
			driverActions.hardwaitBasedOnInput(2000);
			wait.forElementToBeClickable(okBtn);
			Actions action=new Actions(driver);
			action.moveToElement(okBtn).click().build().perform();
			System.out.println("-------User Deleted Successfully--------");
		}

		public void verifyActiveInactiveStatusOnDashboardPage(String user) {
			wait.forElementToBeClickable(tenantIcon);
			jsActions.jsclick(tenantIcon);
			wait.forElementToBeClickable(userBtn);
			jsActions.jsclick(userBtn);
			driverActions.hardwaitBasedOnInput(2000);
			int size0=driver.findElements(By.xpath("//td[text()='"+user+"']")).size();
			Assert.assertEquals(0,size0);
			wait.forElementToBeClickable(inactiveBtn);
			jsActions.jsclick(inactiveBtn);
			driverActions.hardwaitBasedOnInput(3000);
			int size1=driver.findElements(By.xpath("//td[text()='"+user+"']")).size();
			Assert.assertEquals(1,size1);
			wait.forElementToBeClickable(restoreBtn);
			jsActions.jsclick(restoreBtn);
			driverActions.hardwaitBasedOnInput(2000);
			wait.forElementToBeClickable(okBtn);
			Actions action=new Actions(driver);
			action.moveToElement(okBtn).click().build().perform();
			driverActions.hardwaitBasedOnInput(2000);
			int size2=driver.findElements(By.xpath("//td[text()='"+user+"']")).size();
			Assert.assertEquals(0,size2);
			wait.forElementToBeClickable(activeBtn);
			jsActions.jsclick(activeBtn);
			driverActions.hardwaitBasedOnInput(3000);
			int size3=driver.findElements(By.xpath("//td[text()='"+user+"']")).size();
			Assert.assertEquals(1,size3);

		}
		
	@FindBy(xpath = "(//div[@id='s2id_dash_col_filter'])[1]/a/span[1]/i")
	private WebElement eventFilter;
	@FindBy(xpath = "//div[@class='select2-drop select2-display-none fixedWidthDrop select2-with-searchbox select2-drop-active']/div/input")
	private WebElement eventFilterTextBox;
	@FindBy(xpath = "//div[@class='select2-drop select2-display-none fixedWidthDrop select2-with-searchbox select2-drop-active']/ul/li[1]")
	private WebElement eventFilterFirstOption;
	@FindBy(xpath = "//div[@id='incidents-datatable_filter']/label/div/input")
	private WebElement eventFilterFirstNumber;
		public void searchEquipmentNumber() throws IOException {
			driver.navigate().refresh();
			driver.switchTo().parentFrame();
			switchTabTo("All");
			wait.forElementToBeClickable(eventFilter);
			eventFilter.click();
			wait.forElementToBeClickable(eventFilterTextBox);
			eventFilterTextBox.sendKeys("Equipment#");
//			jsActions.jsInput(eventFilterTextBox,"Equipment#");
			driverActions.hardwaitBasedOnInput(5000);
			wait.forElementToBeClickable(eventFilterFirstOption);
			eventFilterFirstOption.click();
//			jsActions.jsclick(eventFilterFirstOption);
			wait.forElementToBeClickable(eventFilterFirstNumber);
			eventFilterFirstNumber.clear();
			eventFilterFirstNumber.sendKeys(inandoutstream.loadEquipmentNumber());
//			jsActions.jsInput(eventFilterFirstNumber,inandoutstream.loadEquipmentNumber());
			driverActions.hardwaitBasedOnInput(5000);
			String displayedEventID=driverActions.driverGetText(firstEventId);
			inandoutstream.saveScheduleEventID(displayedEventID);
			wait.forElementToBeClickable(eventFilter);
			eventFilter.click();
			wait.forElementToBeClickable(eventFilterTextBox);
			eventFilterTextBox.sendKeys("Event#");
			driverActions.hardwaitBasedOnInput(5000);
			wait.forElementToBeClickable(eventFilterFirstOption);
			eventFilterFirstOption.click();
			driverActions.hardwaitBasedOnInput(3000);
		}

	public void validateDashboard(){
		int scFilterCount=driver.findElements(By.xpath("//a[@class='dt-button sc_filter_btn']")).size();
		Assert.assertEquals(1,scFilterCount);
		int equipmentTypeCount=driver.findElements(By.xpath("//a[@class='dt-button equipment_type_filter_btn']")).size();
		Assert.assertEquals(1,equipmentTypeCount);
		int driverWithUnitCount=driver.findElements(By.xpath("//a[@class='dt-button driver_with_filter_btn']")).size();
		Assert.assertEquals(1,driverWithUnitCount);
		int statusCount=driver.findElements(By.xpath("//a[@class='dt-button status_filter_btn']")).size();
		Assert.assertEquals(1,statusCount);
		int searchEventCount=driver.findElements(By.xpath("//span[text()='Search Event #']")).size();
		Assert.assertEquals(1,searchEventCount);
		driverActions.hardwaitBasedOnInput(10000);
	}

	public void eventSorting(String tabName){
		switchTabTo(tabName);
		driver.navigate().refresh();
		driverActions.hardwaitBasedOnInput(8000);
		Select drpCount = new Select(driver.findElement(By.xpath("//select[@name='incidents-datatable_length']")));
		drpCount.selectByValue("100");
		driverActions.hardwaitBasedOnInput(8000);
		WebElement noOfEntries=driver.findElement(By.xpath("//div[@id='incidents-datatable_info']"));
		String noOfEntriesText=driverActions.driverGetText(noOfEntries);
		noOfEntriesText=noOfEntriesText.replaceAll(",","");
		System.out.println(noOfEntriesText);
		int lengthOFText=noOfEntriesText.length();
		int startEntry=0;
		int endEntry=0;
		for(int k=0;k<lengthOFText;k++){
			if(noOfEntriesText.charAt(k)=='o' && noOfEntriesText.charAt(k+1)=='f'){
				startEntry=k+3;
			}
			if(noOfEntriesText.charAt(k)=='e' && noOfEntriesText.charAt(k+1)=='n'){
				endEntry=k-2;
			}
		}
		int totalNumbers=endEntry-startEntry;
		System.out.println(startEntry);
		System.out.println(endEntry);
		System.out.println(totalNumbers);
		int totalEvents=0;
		for(int j=startEntry;j<=endEntry;j++){
			totalEvents= (int) (totalEvents+Integer.parseInt(String.valueOf(noOfEntriesText.charAt(j)))*Math.pow(10,totalNumbers));
			totalNumbers--;
		}
		System.out.println("Total Events-->"+totalEvents);
		int totalCycles= totalEvents / 100;
		ArrayList<String> al = new ArrayList<String>();
		for(int l=0;l<totalCycles-1;l++){
			int size=driver.findElements(By.xpath("(//*[@id='incidents-datatable_wrapper']//table[@role='grid']/tbody)[1]/tr")).size();
			if(size>0){
				for(int i=1;i<=size;i++){
					try{
						WebElement eventIDElement=driver.findElement(By.xpath("(//*[@id='incidents-datatable_wrapper']//table[@role='grid']/tbody)[1]/tr["+i+"]/td[1]/div/a"));
						String eventID= driverActions.driverGetText(eventIDElement);
						if(!eventID.equalsIgnoreCase("Text Not Displayed") && !al.contains(eventID)){
							al.add(eventID);
						}
					}catch (Exception e){
						System.out.println("Element not found.");
					}

				}
			}
			WebElement nextTable=driver.findElement(By.xpath("//li[@class='paginate_button next']/a"));
			jsActions.jsclick(nextTable);
			driverActions.hardwaitBasedOnInput(10000);
			for(int j=0;j<20;j++){
				WebElement eventIDElement1=driver.findElement(By.xpath("(//*[@id='incidents-datatable_wrapper']//table[@role='grid']/tbody)[1]/tr[1]/td[1]/div/a"));
				String eventID1= driverActions.driverGetText(eventIDElement1);
				boolean contains= al.contains(eventID1);
				System.out.println(eventID1 +" is present " + contains);
				if(contains){
					driverActions.hardwaitBasedOnInput(2000);
				}
				if(!contains){
					break;
				}
			}
		}
		System.out.println(al);
		for(int i=0;i<al.size()-1;i++){
			String firstEvent=al.get(i);
			String secondEvent=al.get(i+1);
			System.out.println("Comparing "+ firstEvent + " <-----> " +secondEvent);
			String firstEvent2Char=firstEvent.substring(0,2);
			String secondEvent2Char=secondEvent.substring(0,2);
			int firstEventDigits=Integer.parseInt(firstEvent.substring(2));
			int secondEventDigits=Integer.parseInt(secondEvent.substring(2));
			if(firstEvent2Char.equalsIgnoreCase(secondEvent2Char)){
				Assert.assertTrue(firstEventDigits>secondEventDigits);
			}
			if(firstEvent2Char.charAt(0)==secondEvent2Char.charAt(0) & firstEvent2Char.charAt(1)>secondEvent2Char.charAt(1)){
				Assert.assertTrue(firstEventDigits<secondEventDigits);
			}
			if(firstEvent2Char.charAt(0)>secondEvent2Char.charAt(0) & firstEvent2Char.charAt(1)>secondEvent2Char.charAt(1)){
				Assert.assertTrue(firstEventDigits<secondEventDigits);
			}
			if(firstEvent2Char.charAt(0)>secondEvent2Char.charAt(0) & firstEvent2Char.charAt(1)<secondEvent2Char.charAt(1)){
				Assert.assertTrue(firstEventDigits<secondEventDigits);
			}
		}
	}

	@FindBy(xpath = "//span[@class='menu-title' and text()='Events']/preceding-sibling::i")
	private WebElement eventsLinkLeftPanel;
	@FindBy(xpath = "//span[@class='submenu-title' and text()='Batch Upload']/parent::a")
	private WebElement batchUploadLinkLeftPanel;
	public void selectBatchUpload(){
			Actions actions=new Actions(driver);
			wait.forElementToBeClickable(eventsLinkLeftPanel);
			actions.moveToElement(eventsLinkLeftPanel).build().perform();
		    wait.forElementToBeClickable(batchUploadLinkLeftPanel);
		    jsActions.jsclick(batchUploadLinkLeftPanel);
	}
}
