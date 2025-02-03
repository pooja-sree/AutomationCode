package com.rev.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Patient_Dashboard {

    WebDriver driver;
    Waiting waitfn;

    ToastMessage toast;

    public Patient_Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitfn = new Waiting(driver);
        toast = new ToastMessage(driver);

    }

    @FindBy(xpath = "(//a[contains(@class,'inline-flex items-center rounded-md text-sm font-medium ring-offset-background')])[1]")
    public WebElement Dashboard;

    @FindBy(xpath = "//span[@class='w-full inline-block text-left']")
    public WebElement Account_dropdown;

    @FindBy(xpath = "//div[text()='My Account']")
    public WebElement My_Account;

    @FindBy(name = "firstName")
    public WebElement Firstname;

    @FindBy(name = "lastName")
    public WebElement Lastname;

    @FindBy(xpath = "(//div[contains(@class, 'react-date-picker')])[1]")
    public WebElement Date_of_birth;

    @FindBy(name = "month")
    public WebElement Date_of_birth_Month;

    @FindBy(name = "day")
    public WebElement Date_of_birth_Day;

    @FindBy(name = "year")
    public WebElement Date_of_birth_Year;

    @FindBy(name = "guardianName")
    public WebElement Guardianname;

    @FindBy(name = "address")
    public WebElement Address;

    @FindBy(name = "city")
    public WebElement City;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(xpath = "//label[text()='Country']//following::button[1]")
    public WebElement country;

    @FindBy(xpath = "//label[text()='Country']//following::select")
    public WebElement country_dd;

    @FindBy(name = "zipcode")
    public WebElement Postalcode;

    @FindBy(xpath = "//button[@value='male']")
    public WebElement Male;

    @FindBy(xpath = "//button[@value='female']")
    public WebElement Female;

    @FindBy(xpath = "//button[@value='others']")
    public WebElement other;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement Update_Profile;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0 text-center'])[4]")
    public WebElement Patient_Forms_count;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0 text-center'])[5]")
    public WebElement Patient_Form_Status;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0 font-medium'])[5]")
    public WebElement Practice_Forms_count;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0 font-medium'])[6]")
    public WebElement Practice_Form_status;

    @FindBy(xpath = "//a[@class='text-sm underline']")
    public WebElement All_visit;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0'])[1]")
    public WebElement Visit;

    @FindBy(xpath = "//th[text()='Visit Name']//following::td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0 font-medium']//following::a[@class='underline']")
    public WebElement visit;


    @FindBy(xpath = "//span[text()='Form Status']//following::button[1]")
    public WebElement Form_Status_filter;

    @FindBy(xpath = "//span[text()='Visit Status']//following::button[1]")
    public WebElement Visit_Status_Filter;

    @FindBy(xpath = "//span[text()='All']")
    public WebElement All;

    @FindBy(xpath = "//span[text()='Assigned']")
    public WebElement Assigned;

    @FindBy(xpath = "//span[text()='In Progress']")
    public WebElement InProgress;

    @FindBy(xpath = "//span[text()='Submitted']")
    public WebElement submitted;

    @FindBy(xpath = "//span[text()='Report Generated']")
    public WebElement Report_Generated;

    @FindBy(xpath = "//span[text()='Upcoming']")
    public WebElement Upcoming;

    @FindBy(xpath = "//span[text()='Visit Completed']")
    public WebElement VisitCompleted;
    @FindBy(xpath = "//span[text()='Plan Completed']")
    public WebElement Plancompleted;

    @FindBy(xpath = "//section/ol/li/div[2]/div")
    public WebElement toastmessage;

    @FindBy(xpath = "//table[@class='caption-bottom text-sm rounded overflow-hidden w-full']")
    public WebElement Table;

    @FindBy(xpath = "//input[@placeholder='Search by Visit Name']")
    public WebElement SearchbyVisit;

    @FindBy(xpath = "//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0']")
    public WebElement SearchResult;

    @FindBy(xpath = "//a[contains(@class,'font-medium text-white hover:text-white')]")
    public WebElement Patient_Profile;

    public String Visit_Dashboard = "https://app-dev.reveliadx.com/AutomationPracts/patient/visits";


    public void Patient_Profile_Validation() {
        String profile = Patient_Profile.getText();
        Assert.assertEquals(profile,"Profile");

    }

    public void Patient_Profile() {

        Account_dropdown.click();
        My_Account.click();
        Actions action = new Actions(driver);

        action.doubleClick(Firstname).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Firstname.sendKeys(Keys.BACK_SPACE);
        Firstname.sendKeys("pooja");

        action.click(Lastname).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Lastname.sendKeys(Keys.BACK_SPACE);
        Lastname.sendKeys("K");

        action.click(Date_of_birth_Year);
        Date_of_birth_Year.clear();
        Date_of_birth_Year.sendKeys("1998");
        action.click(Date_of_birth_Day).perform();
        Date_of_birth_Day.sendKeys(Keys.BACK_SPACE);
        Date_of_birth_Day.sendKeys("12");
        action.click(Date_of_birth_Month).perform();
        Date_of_birth_Month.sendKeys(Keys.BACK_SPACE);
        Date_of_birth_Month.sendKeys("03");

        action.doubleClick(Address).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Address.sendKeys((Keys.BACK_SPACE));
        Address.sendKeys("18/34 Perumal 1st Street, Pursawalkam");

        action.doubleClick(City).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        City.sendKeys(Keys.BACK_SPACE);
        City.sendKeys("Chennai");

        action.doubleClick(state).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        state.sendKeys(Keys.BACK_SPACE);
        state.sendKeys("Tamilnadu");

        country.click();
        Select dd = new Select(country_dd);
        dd.selectByValue("USA");

        action.doubleClick(Postalcode).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Postalcode.sendKeys(Keys.BACK_SPACE);
        Postalcode.sendKeys("98765");

        Gender();

        action.moveToElement(Update_Profile).perform();
        Update_Profile.click();

        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Profile updated", "Profile updated");

        Patient_Profile_Validation();

        DashboardPatient();
        SearchByVisit();
        DashboardPatient();
        VisitStatusFilter();
        DashboardPatient();
        FormStatusFilter();
        visit();

    }

    public void DashboardPatient() {
        Dashboard.click();
        View_All_visit();
        Patient_Status_Check();
    }

    public void Gender() {
        if (!Female.isSelected()) {
            Female.click();
        } else if (!Male.isSelected()) {
            Male.click();
        }
    }

    public void Patient_Status_Check() {
        String forms = Patient_Forms_count.getText();
        String form_status = Patient_Form_Status.getText();
        String visit = Visit.getText();
        if(!visit.equals("Initial Visit")){

        if (form_status.equals("Assigned")) {
            Assert.assertEquals(forms, "0/6");
        }

        if (form_status.equals("Submitted")) {
            Assert.assertEquals(forms, "6/6");
        }

        if (forms.equals("0/6") && (form_status.equals("In Progress"))) {
            Assert.assertEquals(form_status, "In Progress");
        }
    }
    else {
            if (form_status.equals("Assigned")) {
                Assert.assertEquals(forms, "0/5");
            }

            if (form_status.equals("Submitted")) {
                Assert.assertEquals(forms, "5/5");
            }

            if (forms.equals("0/5") && (form_status.equals("In Progress"))) {
                Assert.assertEquals(form_status, "In Progress");}
    }}

    public void Practice_Status_Check() {
        String forms = Practice_Forms_count.getText();
        String form_status = Practice_Form_status.getText();

            if (form_status.equals("Assigned")) {
                Assert.assertEquals(forms, "0/5");
            }

            if (form_status.equals("Submitted")) {
                Assert.assertEquals(forms, "5/5");
            }

            if (forms.equals("0/5") && (form_status.equals("In Progress"))) {
                Assert.assertEquals(form_status, "In Progress");
            }

        }

    public void View_All_visit() {
        Actions action = new Actions(driver);
        action.moveToElement(All_visit).perform();
        All_visit.click();
//        waitfn.URL(Visit_Dashboard);
//        toast.CheckURL(Visit_Dashboard, "Visit Page");

    }

    public void visit() {
       Visit.click();
        }

    public void FormStatusFilter() {
        //In Progress Status
        Form_Status_filter.click();
        InProgress.click();
        List<WebElement> IRows = Table.findElements(By.tagName("tr"));
        for (int i = 0; i < IRows.size(); i++) {
            WebElement Row = IRows.get(i);
            List<WebElement> cells = Row.findElements(By.xpath("//td[contains(@class,'[&:has([role=checkbox])]:pr-0')]"));
            if (cells.size() == 1) {
                String Formsts = cells.get(0).getText();
                Assert.assertEquals(Formsts, "No Results Found");
            } else {
                if (cells.size() > 1) {
                    String Formsts = cells.get(6).getText();
                    Assert.assertEquals(Formsts, "In Progress");
                }

            }
        }
        //Submitted Status
        Form_Status_filter.click();
        submitted.click();
        List<WebElement> SRows = Table.findElements(By.tagName("tr"));
        for (int i = 0; i < SRows.size(); i++) {
            WebElement Row = SRows.get(i);
            List<WebElement> cells = Row.findElements(By.xpath("//td[contains(@class,'[&:has([role=checkbox])]:pr-0')]"));
            if (cells.size() == 1) {
                String Formsts = cells.get(0).getText();
                Assert.assertEquals(Formsts, "No Results Found");
            } else {
                if (cells.size() > 1) {
                    String Formsts = cells.get(6).getText();
                    Assert.assertEquals(Formsts, "Submitted");
                }

            }
        }
        //Report Generated Status
        Form_Status_filter.click();
        Report_Generated.click();
        List<WebElement> RRows = Table.findElements(By.tagName("tr"));
        for (int i = 0; i < RRows.size(); i++) {
            WebElement Row = RRows.get(i);
            List<WebElement> cells = Row.findElements(By.xpath("//td[contains(@class,'[&:has([role=checkbox])]:pr-0')]"));
            if (cells.size() == 1) {
                String Formsts = cells.get(0).getText();
                Assert.assertEquals(Formsts, "No Results Found");
            } else {
                if (cells.size() > 1) {
                    String Formsts = cells.get(6).getText();
                    Assert.assertEquals(Formsts, "Report Generated");
                }

            }
        }
        //Assigned Status
        Form_Status_filter.click();
        Assigned.click();
        List<WebElement> ARows = Table.findElements(By.tagName("tr"));
        for (int i = 0; i < ARows.size(); i++) {
            WebElement Row = ARows.get(i);
            List<WebElement> cells = Row.findElements(By.xpath("//td[contains(@class,'[&:has([role=checkbox])]:pr-0')]"));
            if (cells.size() == 1) {
                String Formsts = cells.get(0).getText();
                Assert.assertEquals(Formsts, "No Results Found");
            } else {
                if (cells.size() > 1) {
                    String Formsts = cells.get(6).getText();
                    Assert.assertEquals(Formsts, "Assigned");
                }
            }
        }
    }


    public void VisitStatusFilter() {
        //Upcoming
        Visit_Status_Filter.click();
        Upcoming.click();
        List<WebElement> URows = Table.findElements(By.tagName("tr"));
        for (int i = 0; i < URows.size(); i++) {
            WebElement Row = URows.get(i);
            List<WebElement> cells = Row.findElements(By.xpath("//td[contains(@class,'[&:has([role=checkbox])]:pr-0')]"));
            if (cells.size() == 1) {
                String Formsts = cells.get(0).getText();
                Assert.assertEquals(Formsts, "No Results Found");
            } else {
                if (cells.size() > 1) {
                    String Formsts = cells.get(3).getText();
                    Assert.assertEquals(Formsts, "Upcoming");
                }
            }
        }


        //VisitCompleted
        Visit_Status_Filter.click();
        VisitCompleted.click();
        List<WebElement> VRows = Table.findElements(By.tagName("tr"));
        for (int i = 0; i < VRows.size(); i++) {
            WebElement Row = VRows.get(i);
            List<WebElement> cells = Row.findElements(By.xpath("//td[contains(@class,'[&:has([role=checkbox])]:pr-0')]"));
            if (cells.size() == 1) {
                String Formsts = cells.get(0).getText();
                Assert.assertEquals(Formsts, "No Results Found");
            } else {
                if (cells.size() > 1) {
                    String Formsts = cells.get(3).getText();
                    Assert.assertEquals(Formsts, "Visit Completed");
                }
            }
        }

        //PlanCompleted
        Visit_Status_Filter.click();
        Plancompleted.click();
        List<WebElement> PRows = Table.findElements(By.tagName("tr"));
        for (int i = 0; i < PRows.size(); i++) {
            WebElement Row = PRows.get(i);
            List<WebElement> cells = Row.findElements(By.xpath("//td[contains(@class,'[&:has([role=checkbox])]:pr-0')]"));
            if (cells.size() == 1) {
                String Formsts = cells.get(0).getText();
                Assert.assertEquals(Formsts, "No Results Found");
            } else {
                if (cells.size() > 1) {
                    String Formsts = cells.get(3).getText();
                    Assert.assertEquals(Formsts, "Plan Completed");
                }
            }
        }
    }

    public void SearchByVisit() {
        SearchbyVisit.sendKeys("Initial");
        Assert.assertEquals(SearchResult.getText(), "Initial Visit");
        SearchbyVisit.clear();
    }

}

