package com.Pg4.Pg.Pages;

import com.Pg4.Pg.Util.Validation;
import com.Pg4.Pg.Util.Wait;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Forms {


    public String Patient_url = "https://mypractice.pg3.lmapps.io/patient/dashboard??lng=en";
    public String Form_url = "https://mypractice.pg3.lmapps.io/patient/msq";
    WebDriver driver;
    Validation Valid;
    Wait Wait;
    @FindBy(xpath = "//button[@class='pg4-btn pg4-btn_primary w-sm-100 mx-0 mx-lg-5']")
    WebElement Questionnaire_button;
    @FindBy(css = ".msq-section__item ")
    WebElement section;
    @FindBy(xpath = "//div[@class='me-2']")
    WebElement Header;
    @FindBy(xpath = "//div[@class='cursor-pointer me-2 my-2 msq-radio ']")
    WebElement TypicalWork;
    @FindBy(xpath = "//button[@class='btn btn-primary__p px-5']")
    WebElement Next;

    //@FindBy(xpath ="//button[@class=' w-100 btn bgc-primary text-light px-5' and text()='Agree']")
    @FindBy(css = "css=.bgc-primary:nth-child(1)")
    WebElement Agree;

    public Forms(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Valid = new Validation();
        Wait = new Wait(driver);
    }

    public void Execute_Questionnaire() {
        Wait.URL(Patient_url);
//if(Agree.isDisplayed()){
//    Wait.Visibility(Agree);
//    Agree.click();
//}

        Wait.Presence_of_element(By.xpath("//button[@class='pg4-btn pg4-btn_primary w-sm-100 mx-0 mx-lg-5']"));
        Wait.scrollToElement(driver, Questionnaire_button);
        Questionnaire_button.click();
        Sleep();
        Mental_Health_and_Mood();
        Digestive_Health();
        Energy_and_Fatigue();
        Metabolic_Health();
        Immune_Health();
        Cognitive();
        Musculoskeletal();
        Hormones();
        General();


    }

//    public void VerifyHeader() {
//        Wait.URL(Patient_url);
//        List<WebElement> sections = driver.findElements(By.xpath("//div[@class='msq-section__item bg_tertiary']"));
//        int count = sections.size();
//        List<String> ExpectedHeader = Arrays.asList("Digestive Health","Energy & Fatigue","Metabolic Health","Immune Health","Cognitive","Musculoskeletal","Hormones","General");
//        Wait.Presence_of_element(By.xpath("//div[@class='msq-section__item bg_tertiary']"));
//        for(int i=0; i<= count; i++) {
//            String selected_section = "(//div[@class='msq-section__item bg_tertiary'])["+i+"]";
//            System.out.println(selected_section);
//            String Name = Header.getText();
//            System.out.println(Name);
//            Assert.assertTrue(selected_section.contains("bg_tertiary"), "Selected");
//            Assert.assertTrue(ExpectedHeader.equals(Name),"Name doesn't match the header");
//        }
//    }


    public void select_echoice(){

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

    List<WebElement> choice = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'cursor-pointer my-lg-2 msq-multi_radio ')]//child::span[text()='3']")));
    //int numChoices = choice.size();

        for (int i = 1; i <= choice.size(); i++) {
        String xpath = "(//div[@class='cursor-pointer my-lg-2 msq-multi_radio ']//following::span[text()='3'])[" + i + "]";
        WebElement select = driver.findElement(By.xpath(xpath));
        Wait.Presence_of_element(By.xpath(xpath));
        Wait.scrollToElement(driver,select);
        select.click();

    }}

    public void select_choice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    List<WebElement> choice = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'cursor-pointer my-lg-2 msq-multi_radio ')]//child::span[text()='3']")));

        for (int i = 1; i < choice.size(); i++) { // Example: Interacting with the first 3 choices
            try {
                // Fetch the element dynamically in each iteration
//                Wait.Visibility((WebElement) choice);
                WebElement choices = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class,'cursor-pointer my-lg-2 msq-multi_radio ')]//span[text()='3'])[" + i + "]")
                ));

                // Scroll and interact with the element
                Wait.scrollToElement(driver, choices);
                choices.click();
                System.out.println("Choice clicked: " + choices.getText());

            } catch (StaleElementReferenceException e) {
                // Re-fetch the element if a stale exception occurs and retry the operation
                System.out.println("StaleElementReferenceException caught. Retrying...");
                i--;  // Decrease the index to retry the current iteration
            }
        }

    }


    public void Sleep() {
        Wait.URL(Form_url);
        select_choice();
        Wait.Visibility(TypicalWork);
        TypicalWork.click();
        Wait.scrollToElement(driver,Next);
        Next.click();

    }

    public void Mental_Health_and_Mood(){
        Wait.URL(Form_url);
        Wait.hardwaitBasedOnInput(100);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();

    }

    public void Digestive_Health(){
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
        Wait.hardwaitBasedOnInput(500);

    }

    public void Energy_and_Fatigue(){
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
    }

    public void Metabolic_Health()
    {
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
    }

    public void Immune_Health()
    {
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
    }

    public void Cognitive()
    {
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
    }

    public void Musculoskeletal()
    {
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
    }

    public void Hormones()
    {
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
    }

    public void General()
    {
        Wait.URL(Form_url);
        select_choice();
        Wait.scrollToElement(driver,Next);
        Next.click();
    }
}
