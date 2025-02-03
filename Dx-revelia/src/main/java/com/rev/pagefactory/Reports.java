package com.rev.pagefactory;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Reports extends Patient_Dashboard {

    WebDriver driver;

    Waiting waitfn;
    ToastMessage toast;

    public Reports(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
        waitfn = new Waiting(driver);
        toast = new ToastMessage(driver);
    }
    @FindBy(xpath = "(//button[contains(@class,'inline-flex items-center rounded-md text-sm font-medium ring-offset-background transition-colors')])[2]")
    public WebElement Report;

    @FindBy(xpath = "//div[@class='card bg-gray-100 mt-5']")
    public WebElement EmptyReport;

    @FindBy(xpath = "//button[contains(@class,'inline-flex items-center justify-center rounded-md text-sm font-medium ring-offset-background transition-colors')]")
    public WebElement ViewReport;

    @FindBy(xpath = "(//button[contains(@class,'inline-flex items-center justify-center rounded-md text-sm font-medium ring-offset-background transition-colors')])[2]")
    public WebElement DownloadReport;

    @FindBy(id = "symptom_trend")
    public WebElement SelectAll;

    @FindBy(xpath = "(//button[contains(@class,'inline-flex items-center justify-center rounded-md text-sm font-medium ring-offset-background transition-colors')])[5]")
    public WebElement Cancel;

    @FindBy(xpath = "(//button[contains(@class,'inline-flex items-center justify-center rounded-md text-sm font-medium ring-offset-background transition-colors')])[6]")
    public WebElement Download;

    @FindBy(xpath = "//div/div/h1[@class='text-xl font-medium']")
    public WebElement ReportValiation;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0'])[1]")
    public WebElement Visit;

    public void Report() throws AWTException {

        DashboardPatient();
        waitfn.Visibility(Visit);
        Visit.click();
        waitfn.Visibility(Report);
        Report.click();
        String validation = ReportValiation.getText();
        Assert.assertEquals(validation,"Report");
        try{
        waitfn.Visibility(ViewReport);
        ViewReport.click();

    DownloadReport.click();

    waitfn.Visibility(SelectAll);
    SelectAll.click();
        if(Download.isEnabled()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Download);

            Download.click();}

    Robot robot = new Robot();

    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);}

    catch (Exception e){
            String txt = EmptyReport.getText();
            Assert.assertEquals(txt,"Your Practitioner is analyzing your forms and a report will be shared with you soon!");
        }



        }}
