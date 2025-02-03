package com.rev.pagefactory;

import io.cucumber.java.bs.A;
import org.apache.velocity.runtime.directive.contrib.For;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class Forms extends Patient_Dashboard {
    WebDriver driver;

    Waiting waitfn;
    ToastMessage toast;

    public Forms(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitfn = new Waiting(driver);
        toast = new ToastMessage(driver);

    }

    @FindBy(xpath = "(//td[contains(@class,'font-medium w-full grid items-center gap-2')])[1]")
    public WebElement Aboutyouform;

    @FindBy(xpath = "(//td[contains(@class,'font-medium w-full grid items-center gap-2')])[2]")
    public WebElement Pastmedicalhist;

    @FindBy(xpath = "(//td[contains(@class,'font-medium w-full grid items-center gap-2')])[3]")
    public WebElement Currentlifestyle;

    @FindBy(xpath = "(//td[contains(@class,'font-medium w-full grid items-center gap-2')])[4]")
    public WebElement historyform;

    @FindBy(xpath = "(//td[contains(@class,'font-medium w-full grid items-center gap-2')])[5]")
    public WebElement Goalform;
    @FindBy(xpath = "//p[@class='text-xl text-primary font-semibold mb-1 mt-4']")
    public WebElement SubSection;
    @FindBy(xpath = "//label[contains(@class,'text-sm font-medium leading-none peer-disabled:cursor-not-allowed')]//following::input")
    public WebElement Inputtxt;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement Save;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement Submit;

    @FindBy(xpath = "(//button[text()='Previous'])[1]")
    public WebElement Previous;

    @FindBy(xpath = "(//button[text()='Next'])[1]")
    public WebElement Next;

    @FindBy(xpath = "//label[@class='text-sm font-medium leading-none peer-disabled:cursor-not-allowed peer-disabled:opacity-70']//following::input[6]")
    public WebElement Inputtext;

    @FindBy(xpath = "(//button[contains(@class,'aspect-square h-4 w-4 rounded-full border border-primary text-primary ring-offset-background focus:outline-none focus-visible:ring-2')])[1]")
    public WebElement RadioYes;

    @FindBy(xpath = "(//button[contains(@class,'aspect-square h-4 w-4 rounded-full border border-primary text-primary ring-offset-background focus:outline-none focus-visible:ring-2')])[4]")
    public WebElement RadioNo;


    @FindBy(xpath = "(//div[contains(@class, 'react-date-picker')])[1]")
    public WebElement Date_of_birth;

    @FindBy(name = "month")
    public WebElement Date_of_birth_Month;

    @FindBy(name = "day")
    public WebElement Date_of_birth_Day;

    @FindBy(name = "year")
    public WebElement Date_of_birth_Year;

    @FindBy(xpath = "//button[contains(@class,'flex h-10 w-full items-center justify-between rounded-md border border-input bg-background')]")
    public WebElement measurement;

    @FindBy(xpath = "//span[text()='kgs']")
    public WebElement kgs;

    @FindBy(xpath = "//span[text()='lbs']")
    public WebElement lbs;

    @FindBy(xpath = "//span[text()='cm']")
    public WebElement cm;

    @FindBy(xpath = "//span[text()='ft.in']")
    public WebElement ft;

    @FindBy(xpath = "(//input[contains(@class,'flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background')])[8]")
    public WebElement BPinput;

    @FindBy(xpath = "(//input[contains(@class,'flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background')])[9]")
    public WebElement BPcomment;

    @FindBy(xpath = "//button[text()='Add']")
    public WebElement Add;

    @FindBy(xpath = "//button[text()='Upload files']")
    public WebElement Upload;

    @FindBy(xpath = "//span[text()='4']")
    public WebElement Ageyear;
    @FindBy(xpath = "//span[text()='8']")
    public WebElement Agemonth;

    @FindBy(xpath = "//span[text()='11']")
    public WebElement Ageday;

    @FindBy(xpath = "(//button[contains(@class,'flex h-10 items-center justify-between rounded-md')])[1]")
    public WebElement Agetypeyear;

    @FindBy(xpath = "(//button[contains(@class,'flex h-10 items-center justify-between rounded-md')])[2]")
    public WebElement Agetypemonth;

    @FindBy(xpath = "(//button[contains(@class,'flex h-10 items-center justify-between rounded-md')])[3]")
    public WebElement Agetypeday;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/main/div/div[2]/div/div[1]/div/div[3]/div/div/div/div[4]/div[2]/div[2]/div[2]/div/button")
    public WebElement Header;

    @FindBy(xpath = "//button[text()='Submit anyway']")
    public WebElement Submitanyway;

    @FindBy(xpath = "//h1[@class='text-xl font-medium']")
    public WebElement Forminfo;


    public void Aboutyou() {

        DashboardPatient();
        visit();
        Aboutyouform.click();
        VisitFocus();
        FocusAreas();
        MedicalTeam();
        VitalSigns();
        Medications();
        supplements();
        Allergies();
        MedicationandSupplementDosing();
        PriorMedicationandsupplementuse();
        AgeLastFeltWell();
        ChangeofHealthEvent();
    }

    public void VisitFocus() {

        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Successful Visit");
        Inputtxt.sendKeys("Happy");
        Next.click();
    }

    public void FocusAreas() {

        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Focus Areas");
        List<WebElement> choice = driver.findElements(By.xpath("//label[@class='font-medium peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-base']"));
        for (int i = 0; i <= 4; i++) {
            choice.get(i).click();
        }
        Next.click();
    }

    public void MedicalTeam() {

        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Medical Team");
        RadioYes.click();
        Inputtxt.sendKeys("Physician & 9093564748");
        Dob();
        Inputtext.sendKeys("Dr.X");
        Next.click();
    }

    public void Dob() {
        Date_of_birth.click();
        Date_of_birth_Month.sendKeys("04");
        Date_of_birth_Day.sendKeys("17");
        Date_of_birth_Year.sendKeys("1990");
    }

    public void VitalSigns() {
        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Vital Signs");

        List<WebElement> vitalinput = driver.findElements(By.xpath("//input[contains(@class,'flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background')]"));
        int count = vitalinput.size();
        for (int i = 0; i < count - 2; i++) {
            if (i % 2 != 0) {
                WebElement comments = vitalinput.get(i);
                comments.sendKeys("Test");
            } else {
                WebElement vitals = vitalinput.get(i);
                vitals.sendKeys("50");
            }
        }
        measurement.click();

        lbs.click();

        BPinput.sendKeys("120");
        BPcomment.sendKeys("Test");
        Dob();
        Next.click();
    }

    public void Medications() {

        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Medications");

        List<WebElement> Med = driver.findElements(By.xpath("//input[contains(@class,'flex h-10 w-full rounded-md border')]"));
        for (WebElement element : Med) {
            element.sendKeys("Medications");
        }
        Dob();
        Add.click();
//        Actions act = new Actions(driver);
//        act.moveToElement(Upload);
//        Upload.click();
//        String File = "C:\\Users\\pooja\\Downloads\\ReveliaDx.pdf";
//        StringSelection transfer = new StringSelection(File);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(transfer, null);
//        Robot rob;
//        try {
//            rob = new Robot();
//        } catch (AWTException e) {
//            throw new RuntimeException(e);
//        }
//        rob.keyPress(KeyEvent.VK_CONTROL);
//        rob.keyPress(KeyEvent.VK_V);
//        rob.keyRelease(KeyEvent.VK_V);
//        rob.keyRelease(KeyEvent.VK_CONTROL);
//        rob.keyPress(KeyEvent.VK_ENTER);
//        rob.keyRelease(KeyEvent.VK_ENTER);

        Next.click();
    }

    public void supplements() {
        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Supplements");

        List<WebElement> Med = driver.findElements(By.xpath("//input[contains(@class,'flex h-10 w-full rounded-md border')]"));
        for (WebElement element : Med) {
            element.sendKeys("Supplements");
        }
        Dob();
        Add.click();
        Next.click();

    }

    public void Allergies() {
        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Allergies");
        RadioYes.click();
        Inputtxt.sendKeys("Food");
        RadioNo.click();
        Next.click();

    }

    public void MedicationandSupplementDosing() {
        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Medication & Supplement Dosing");
        List<WebElement> choice = driver.findElements(By.xpath("//label[@class='font-medium peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-base']"));
        for (int i = 0; i < 4; i++) {
            choice.get(i).click();
        }
        Inputtxt.sendKeys("Comments");
        Next.click();

    }

    public void PriorMedicationandsupplementuse() {

        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Prior Medication & Supplement Use");
        List<WebElement> choice = driver.findElements(By.xpath("//label[@class='font-medium peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-base']"));
        for (int i = 0; i < 4; i++) {
            choice.get(i).click();
        }
        Inputtxt.sendKeys("Comments");
        Next.click();
    }

    public void AgeLastFeltWell() {
        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Age Last Felt Well");
        RadioYes.click();
        Age();
        Actions act = new Actions(driver);
        act.moveToElement(Save).perform();
        Save.click();
        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Your answers are saved successfully","Save");
        Next.click();

    }

    public void Age() {
        Agetypeyear.click();
        Ageyear.click();
        Agetypemonth.click();
        Agemonth.click();
        Agetypeday.click();
        Ageday.click();
    }

    public void ChangeofHealthEvent() {
        waitfn.Visibility(SubSection);
        String title = SubSection.getText();
        Assert.assertEquals(title, "Change of Health Event");

        List<WebElement> Event = driver.findElements(By.xpath("//label[@class='font-medium peer-disabled:cursor-not-allowed peer-disabled:opacity-70 text-base']"));
        for (int i = 0; i <= 0; i++) {
            Event.get(i).click();
        }
        waitfn.Visibility(Header);
        Inputtxt.sendKeys("None");
        Next.click();
        Age();
        Actions act = new Actions(driver);
        act.moveToElement(Submit).perform();
        Submit.click();
        act.moveToElement(Submitanyway).perform();
        Submitanyway.click();
        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Your answers are submitted successfully","Submit");
        String Visitpage = Forminfo.getText();
        Assert.assertEquals(Visitpage,"Form Information");
    }

}
