package com.rev.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Plans extends Patient_Dashboard{
    WebDriver driver;
    Waiting waitfn;
    ToastMessage toast;
    public Plans(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
        waitfn = new Waiting(driver);
        toast = new ToastMessage(driver);
    }
    @FindBy(xpath = "(//button[contains(@class,'inline-flex items-center rounded-md text-sm font-medium ring-offset-background transition-colors')])[5]")
    public WebElement Plans;

    @FindBy(xpath = "(//button[contains(@class,'inline-flex items-center justify-center rounded-md text-sm font-medium ring-offset-background transition-colors')])")
    public WebElement Download;

    @FindBy(xpath = "//p[@class='text-center max-w-prose text-sm text-primary/90']")
    public WebElement EmptyPlan;

    public void Plan(){

        DashboardPatient();
        visit();
        Plans.click();
        try{
            waitfn.Visibility(Download);
            Download.click();
        } catch (Exception e) {
                String txt = EmptyPlan.getText();
                Assert.assertEquals(txt,"Your practitioner has not shared any plans with you at the moment!");
        }
    }


}
