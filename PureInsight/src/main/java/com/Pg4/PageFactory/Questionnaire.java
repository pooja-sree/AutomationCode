package com.Pg4.PageFactory;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Questionnaire {
    WebDriver driver;
    Waitfunctions waitfn;

    Random random;



    public Questionnaire(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitfn = new Waitfunctions(driver);
        random = new Random();



    }

    @FindBy(xpath = "//button[@class=' w-100 btn bgc-primary text-light px-5' and text()='Agree']")
    WebElement Agree_Button;
    @FindBy(xpath = "//div[@class='pg-title my-3 textc-primary__p w-75']")
    WebElement Que_Validation;

    @FindBy(xpath = "//button[contains(text(),'questionnaire')]")
    WebElement Questionnaire_button;

    @FindBy(xpath = "//div[@class='pgs-text text_primary']")
    WebElement Section;

    @FindBy(xpath = "//div[@class='me-2' and text()='Anxiety']")
    WebElement Anxiety_Disorder_Section;

    @FindBy(xpath = "//div[@class='cursor-pointer me-2 my-2 msq-radio ']")
    WebElement TypicalWork;

    public String Form_url = "https://mypractice.pg3.lmapps.io/patient/msq";

    @FindBy(xpath = "//div[@class='cursor-pointer me-2 my-2 msq-radio ' and text()='Yes']")
    WebElement YesBtn;

    @FindBy(xpath = "//div[@class='cursor-pointer me-2 my-2 msq-radio ' and text()='No']")
    WebElement NoBtn;

    @FindBy(id = "weight")
    WebElement Weight;

    @FindBy(id="option_0")
    WebElement FeetorHours;

    @FindBy(id="option_1")
    WebElement InchesorMinutes;

    @FindBy(id="vigorous_physical_activity")
    WebElement Vigourous_PhyActivity;

    @FindBy(id = "moderate_physical_activity")
    WebElement Moderate_PhyActivity;

    @FindBy(xpath = "//input[@class='w-100 my-2 msq-input' and @placeholder='Enter a concern']")
    WebElement Text_Concern;

    @FindBy(xpath = "//button[@class='btn btn-primary__p px-5' and text()='complete']")
    WebElement Complete;

    @FindBy(xpath = "//button[@class='btn btn-primary__p px-5' and text()='Next Section']")
    WebElement Next;

    @FindBy(xpath = "//div[@class='d-flex justify-content-between']/div[@class='pg4-text__heading textc-primary__p']")
    WebElement Questionnaire_Complete_toast;

   @FindBy(xpath = "//div[@class='pg-heading__sub textc-primary__p']")
   WebElement Question;




public void Consent_Agree(){
    waitfn.scrollToElement(driver,Agree_Button);
    Agree_Button.click();
}
    public void Que_btn(){
        waitfn.scrollToElement(driver,Questionnaire_button);
        Questionnaire_button.click();
    }

    public void sleep() {
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);
        if (HeaderSection("Sleep")) {
            List<WebElement> SleepList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
            waitfn.VisibilityAll(SleepList);
            for (WebElement SleepElement : SleepList) {
                List<WebElement> SleepQue = SleepElement.findElements(By.xpath(".//span"));
                int SleepIndex = random.nextInt(SleepQue.size());
                WebElement SleepSelect = SleepQue.get(SleepIndex);
                waitfn.scrollToElement(driver, SleepSelect);
                waitfn.Visibility(SleepSelect);
                SleepSelect.click();
            }
            waitfn.scrollToElement(driver,TypicalWork);
            waitfn.Visibility(TypicalWork);
            TypicalWork.click();
            waitfn.scrollToElement(driver, Next);
            Next.click();
        }}




    public void Mental_Health_and_Mood(){
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Mental Health & Mood")){
        List<WebElement> HealthList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));

        waitfn.VisibilityAll(HealthList);
        for (WebElement HealthElement : HealthList) {
            List<WebElement> HealthQues = HealthElement.findElements(By.xpath(".//span"));
            int HealthIndex = random.nextInt(HealthQues.size());
            WebElement HealthSelect = HealthQues.get(HealthIndex);
            waitfn.scrollToElement(driver, HealthSelect);
            waitfn.Visibility(HealthSelect);
            HealthSelect.click();
            waitfn.HardWaitBasedOnInput(2000);
        }
        waitfn.scrollToElement(driver,Next);
        Next.click();

}}


    public void Digestive_Health(){
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Digestive Health")){
        List<WebElement> DigestiveList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));

        waitfn.VisibilityAll(DigestiveList);
        for (WebElement DigestElement : DigestiveList) {
            List<WebElement> DigestQue = DigestElement.findElements(By.xpath(".//span"));
            int DigestiveIndex = random.nextInt(DigestQue.size());
            WebElement DigestSelect = DigestQue.get(DigestiveIndex);
            waitfn.scrollToElement(driver, DigestSelect);
            waitfn.Visibility(DigestSelect);
            DigestSelect.click();
            waitfn.HardWaitBasedOnInput(2000);

        }
        waitfn.scrollToElement(driver,Next);
        Next.click();
    }}

    public void Energy_and_Fatigue(){
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Energy & Fatigue")){
        List<WebElement> EnergyList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
        waitfn.VisibilityAll(EnergyList);
        for (WebElement EnergyElement : EnergyList) {
            List<WebElement> EnergyQue = EnergyElement.findElements(By.xpath(".//span"));
            int EnergyIndex = random.nextInt(EnergyQue.size());
            WebElement EnergySelect = EnergyQue.get(EnergyIndex);
            waitfn.scrollToElement(driver, EnergySelect);
            waitfn.Visibility(EnergySelect);
            EnergySelect.click();
            waitfn.HardWaitBasedOnInput(2000);
        }
        waitfn.scrollToElement(driver,Next);
        Next.click();
    }}

    public void Metabolic_Health(){
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Metabolic Health")){
        List<WebElement> MetabolicList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
        waitfn.VisibilityAll(MetabolicList);
        for (WebElement MetabolicElement : MetabolicList){
           List<WebElement> MetabolicQue = MetabolicElement.findElements(By.xpath(".//span"));
           int MetabolicIndex= random.nextInt(MetabolicQue.size());
           WebElement MetabolicSelect = MetabolicQue.get(MetabolicIndex);
            waitfn.scrollToElement(driver, MetabolicSelect);
            waitfn.Visibility(MetabolicSelect);
            MetabolicSelect.click();
            waitfn.HardWaitBasedOnInput(2000);
        }
        waitfn.scrollToElement(driver,Next);
        Next.click();
    }}

    public void Immune_Health(){
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Immune Health")){
        List<WebElement> ImmuneList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
        waitfn.VisibilityAll(ImmuneList);
        for (WebElement ImmuneElement : ImmuneList) {
            List<WebElement> ImmuneQue = ImmuneElement.findElements(By.xpath(".//span"));
            int ImmuneIndex = random.nextInt(ImmuneQue.size());
            WebElement ImmuneSelect = ImmuneQue.get(ImmuneIndex);
            waitfn.scrollToElement(driver, ImmuneSelect);
            waitfn.Visibility(ImmuneSelect);
            ImmuneSelect.click();
            waitfn.HardWaitBasedOnInput(2000);
        }
        waitfn.scrollToElement(driver,Next);
        Next.click();
    }}

    public void Cognitive()
    {
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Cognitive")){
        List<WebElement> CognitiveList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
        waitfn.VisibilityAll(CognitiveList);
        for (WebElement CognitiveElement : CognitiveList) {
            List<WebElement> CognitiveQue = CognitiveElement.findElements(By.xpath(".//span"));
            int CognitiveIndex = random.nextInt(CognitiveQue.size());
            WebElement CognitiveSelect = CognitiveQue.get(CognitiveIndex);
            waitfn.scrollToElement(driver, CognitiveSelect);
            waitfn.Visibility(CognitiveSelect);
            CognitiveSelect.click();
            waitfn.HardWaitBasedOnInput(2000);
        }
        waitfn.scrollToElement(driver,Next);
        waitfn.HardWaitBasedOnInput(500);
        Next.click();
    }}

    public void Musculoskeletal()
    {
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Musculoskeletal")){
        List<WebElement> MuscList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
        waitfn.VisibilityAll(MuscList);
        for (WebElement SkeletalElement : MuscList) {
            List<WebElement> SkeletalQue = SkeletalElement.findElements(By.xpath(".//span"));
            int SkeletalIndex = random.nextInt(SkeletalQue.size());
            WebElement MuscularSelect = SkeletalQue.get(SkeletalIndex);
            waitfn.scrollToElement(driver, MuscularSelect);
            waitfn.Visibility(MuscularSelect);
            MuscularSelect.click();
            waitfn.HardWaitBasedOnInput(2000);
        }
        waitfn.scrollToElement(driver,Next);
        Next.click();
        waitfn.HardWaitBasedOnInput(500);
    }}

    public void Hormones()
    {
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Hormones")){
        List<WebElement> HormonesList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
        waitfn.VisibilityAll(HormonesList);
        for (WebElement HormoneElement : HormonesList) {
         List<WebElement> HormoneQue= HormoneElement.findElements(By.xpath(".//span"));
            int HormoneIndex = random.nextInt(HormoneQue.size());
            WebElement HormoneSelect = HormoneQue.get(HormoneIndex);
            waitfn.scrollToElement(driver, HormoneSelect);
            waitfn.Visibility(HormoneSelect);
            HormoneSelect.click();
            waitfn.HardWaitBasedOnInput(2000);
        }
        waitfn.scrollToElement(driver,Next);
        Next.click();}
        waitfn.HardWaitBasedOnInput(500);

}


    public void General() {
        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("General")) {

            YesorNo();
            Weight.click();
            Select selectweight = new Select(Weight);
            selectweight.selectByValue("90");

            waitfn.scrollToElement(driver, FeetorHours);
            FeetorHours.click();
            Select selectFeet = new Select(FeetorHours);
            selectFeet.selectByValue("6");

            waitfn.scrollToElement(driver, InchesorMinutes);
            InchesorMinutes.click();
            Select selectInches = new Select(InchesorMinutes);
            selectInches.selectByValue("4");

            waitfn.scrollToElement(driver, Vigourous_PhyActivity);
            Vigourous_PhyActivity.click();
            Select VigActivity = new Select(Vigourous_PhyActivity);
            VigActivity.selectByValue("2");

            waitfn.scrollToElement(driver, Moderate_PhyActivity);
            Moderate_PhyActivity.click();
            Select ModActivity = new Select(Moderate_PhyActivity);
            ModActivity.selectByValue("2");

            YesorNo();

            waitfn.scrollToElement(driver, Text_Concern);
            List<WebElement> concern = driver.findElements(By.xpath("//input[@class='w-100 my-2 msq-input' and @placeholder='Enter a concern']"));
            for (WebElement Txtconcern : concern) {
                Txtconcern.sendKeys("Test");
            }

        waitfn.scrollToElement(driver, Complete);
        Complete.click();
        waitfn.scrollToElement(driver,Questionnaire_Complete_toast);
        waitfn.HardWaitBasedOnInput(1000);

    }}

    public void YesorNo(){
        waitfn.scrollToElement(driver,YesBtn);
        if(!YesBtn.isSelected()){
            YesBtn.click();
        }
        else {
            NoBtn.click();
        }
    }

    public void Anxiety() {

        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if (HeaderSection("Anxiety")) {
            List<WebElement> AnxietyList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));

            waitfn.VisibilityAll(AnxietyList);
            for (WebElement Anx : AnxietyList) {


                List<WebElement> AnxSelect = Anx.findElements(By.xpath(".//span"));
                int AnxIndex = random.nextInt(AnxSelect.size());
                WebElement AnxietySelect = AnxSelect.get(AnxIndex);
                waitfn.scrollToElement(driver, AnxietySelect);
                waitfn.Visibility(AnxietySelect);
                AnxietySelect.click();
                waitfn.HardWaitBasedOnInput(500);

            }

            List<WebElement> WorkDiff = driver.findElements(By.xpath("//div[@class='cursor-pointer me-2 my-2 msq-radio ']"));

            int RandomIndex = random.nextInt(WorkDiff.size());
            WebElement WorkDifficultySelect = WorkDiff.get(RandomIndex);
            waitfn.Visibility(WorkDifficultySelect);
            WorkDifficultySelect.click();

            waitfn.HardWaitBasedOnInput(500);
            waitfn.scrollToElement(driver, Complete);
            Complete.click();

        }}

    public void Mood(){

        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Mood")){
        List<WebElement> MoodList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));

        waitfn.VisibilityAll(MoodList);
        for (WebElement Mood : MoodList){


            List  <WebElement> MoodQue = Mood.findElements(By.xpath(".//span"));
            int MoodIndex = random.nextInt(MoodQue.size());
            WebElement MoodSelect = MoodQue.get(MoodIndex);
            waitfn.scrollToElement(driver,MoodSelect);
            waitfn.Visibility(MoodSelect);
            MoodSelect.click();
        }
        waitfn.scrollToElement(driver,Complete);
        Complete.click();
    }}

    public void Stress(){


            waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Stress")){

            List<WebElement> StressList = driver.findElements(By.xpath("//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
waitfn.VisibilityAll(StressList);
            for (WebElement Stress : StressList){


                List  <WebElement> StressQue = Stress.findElements(By.xpath(".//span"));
                int StressIndex = random.nextInt(StressQue.size());
                WebElement StressSelect = StressQue.get(StressIndex);
                waitfn.scrollToElement(driver,StressSelect);
                waitfn.Visibility(StressSelect);
                StressSelect.click();
            }
            waitfn.scrollToElement(driver,Complete);
            Complete.click();

    }}

    public void SleepQualityIndex() {

        waitfn.URL(Form_url);
        waitfn.HardWaitBasedOnInput(5000);

        if(HeaderSection("Sleep")) {
            WebElement Question1 = driver.findElement(By.xpath("//div[@id='PSQI-1']//div//following::div[1]"));
            if (Question1.isDisplayed()) {
                Hours(Question1.findElement(By.xpath("./div[1]/select")));
                Minutes(Question1.findElement(By.xpath("./div[2]/select")));
            }

            WebElement Question2 = driver.findElement(By.xpath("//div[@id='PSQI-2']//child::div[@class='d-flex mt-3 flex-wrap']"));
            if (Question2.isDisplayed()) {
                List<WebElement> SleepTimeInMin = Question2.findElements(By.xpath("./div[@class='cursor-pointer me-2 my-2 msq-radio ']"));
                int RandomIndex = random.nextInt(SleepTimeInMin.size());
                WebElement SleepTimeSelect = SleepTimeInMin.get(RandomIndex);
                waitfn.scrollToElement(driver, SleepTimeSelect);
                waitfn.Visibility(SleepTimeSelect);
                SleepTimeSelect.click();
            }


            WebElement Question3 = driver.findElement(By.xpath("//div[@id='PSQI-3']//div//following::div[1]"));
            waitfn.scrollToElement(driver, Question3);
            if (Question3.isDisplayed() && !Question1.equals(Question3)) {
                Hours(Question3.findElement(By.xpath("./div[1]/select")));
                Minutes(Question3.findElement(By.xpath("./div[2]/select")));
            }

            WebElement Question4 = driver.findElement(By.xpath("//div[@id='PSQI-4']//div//following::div[3]"));
            waitfn.scrollToElement(driver, Question4);
            if (Question4.isDisplayed() && !Question1.equals(Question4)) {
                Hours(Question4.findElement(By.xpath("./select")));
            }


            WebElement Question5 = driver.findElement(By.xpath("(//div[@class='pg4-card'])[5]"));
            waitfn.scrollToElement(driver, Question5);
            if (Question5.isDisplayed()) {
                List<WebElement> TroubleSleepList = Question5.findElements(By.xpath(".//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));
                for (WebElement TroubleSleepingRate : TroubleSleepList) {
                    List<WebElement> TroubleSleepQue = TroubleSleepingRate.findElements(By.xpath(".//span"));
                    int TroubleSleepIndex = random.nextInt(TroubleSleepQue.size());
                    WebElement TroubleSleepSelect = TroubleSleepQue.get(TroubleSleepIndex);
                    waitfn.scrollToElement(driver, TroubleSleepSelect);
                    waitfn.Visibility(TroubleSleepSelect);
                    TroubleSleepSelect.click();
                }

            }

            WebElement Question6 = driver.findElement(By.xpath("//div[@id='PSQI-6']//child::div[@class='d-flex mt-3 flex-wrap']"));
            if (Question6.isDisplayed()) {
                List<WebElement> SleepQuality = Question6.findElements(By.xpath("./div[@class='cursor-pointer me-2 my-2 msq-radio ']"));
                int SleepQualityIndex = random.nextInt(SleepQuality.size());
                WebElement SleepQualitySelect = SleepQuality.get(SleepQualityIndex);
                waitfn.scrollToElement(driver, Question6);
                SleepQualitySelect.click();
            }

            WebElement Question7 = driver.findElement(By.xpath("//div[@id='PSQI-7']//child::div[@class='d-flex mt-3 flex-wrap']"));
            waitfn.scrollToElement(driver, Question7);
            if (Question7.isDisplayed()) {
                List<WebElement> Medicine = Question7.findElements(By.xpath("./div[@class='cursor-pointer me-2 my-2 msq-radio ']"));
                int MedIndex = random.nextInt(Medicine.size());
                WebElement MedicineSelect = Medicine.get(MedIndex);
                waitfn.scrollToElement(driver, MedicineSelect);
                MedicineSelect.click();
            }

            WebElement Question8 = driver.findElement(By.xpath("//div[@id='PSQI-8']//child::div[@class='d-flex mt-3 flex-wrap']"));
            waitfn.scrollToElement(driver, Question8);
            if (Question8.isDisplayed()) {
                List<WebElement> StayAwake = Question8.findElements(By.xpath("./div[@class='cursor-pointer me-2 my-2 msq-radio ']"));
                int AwakeIndex = random.nextInt(StayAwake.size());
                WebElement AwakeSelect = StayAwake.get(AwakeIndex);
                waitfn.scrollToElement(driver, AwakeSelect);
                AwakeSelect.click();
            }

            WebElement Question9 = driver.findElement(By.xpath("//div[@id='PSQI-9']//child::div[@class='d-flex mt-3 flex-wrap']"));
            waitfn.scrollToElement(driver, Question9);
            if (Question9.isDisplayed()) {
                List<WebElement> Enthusiasm = Question9.findElements(By.xpath("./div[@class='cursor-pointer me-2 my-2 msq-radio ']"));
                int EnthusiasticIndex = random.nextInt(Enthusiasm.size());
                WebElement EnthusiasmSelect = Enthusiasm.get(EnthusiasticIndex);
                waitfn.scrollToElement(driver, EnthusiasmSelect);
                EnthusiasmSelect.click();
            }

            WebElement Question10 = driver.findElement(By.xpath("//div[@id='PSQI-10']//child::div[@class='d-flex mt-3 flex-wrap']"));
            waitfn.scrollToElement(driver, Question10);
            if (Question10.isDisplayed()) {
                List<WebElement> Partner = Question10.findElements(By.xpath("./div[@class='cursor-pointer me-2 my-2 msq-radio ']"));
                int PartnerIndex = random.nextInt(Partner.size());
                WebElement PartnerSelect = Partner.get(PartnerIndex);
                waitfn.scrollToElement(driver, PartnerSelect);
                PartnerSelect.click();
            }

            WebElement Question11 = driver.findElement(By.xpath("(//div[@class='pg4-card'])[11]"));
            waitfn.scrollToElement(driver, Question11);
            List<WebElement> SleepDisturbanceList = Question11.findElements(By.xpath(".//div[@class='col-12 col-md-4 col-lg-5 pg-text fw-bold  my-4 my-lg-auto']//following::div[1]"));

            for (WebElement SleepDisturb : SleepDisturbanceList) {

                List<WebElement> SleepDisturbQue = SleepDisturb.findElements(By.xpath(".//span"));
                int SleepDisturbIndex = random.nextInt(SleepDisturbQue.size());
                WebElement SleepDisturbSelect = SleepDisturbQue.get(SleepDisturbIndex);
                waitfn.scrollToElement(driver, SleepDisturbSelect);
                waitfn.Visibility(SleepDisturbSelect);
                SleepDisturbSelect.click();

            }
            WebElement Question12 = driver.findElement(By.xpath("//div[@id='PSQI-10f']//child::div[@class='d-flex mt-3 flex-wrap']"));
            waitfn.scrollToElement(driver, Question12);
            if (Question12.isDisplayed()) {
                List<WebElement> TroubleSleep = Question12.findElements(By.xpath("./div[@class='cursor-pointer me-2 my-2 msq-radio ']"));
                int TroubleSleepIndex = random.nextInt(TroubleSleep.size());
                WebElement SleepSelect = TroubleSleep.get(TroubleSleepIndex);
                waitfn.scrollToElement(driver, SleepSelect);
                SleepSelect.click();
            }

            waitfn.scrollToElement(driver, Complete);
            Complete.click();
        }

    }

    public void Hours(WebElement HourElement){

        waitfn.scrollToElement(driver, HourElement);
        HourElement.click();
        Select selectHour = new Select(HourElement);
        selectHour.selectByValue("4");

    }

    public void Minutes(WebElement MinElement){
        waitfn.scrollToElement(driver, MinElement);
        MinElement.click();
        Select selectMin = new Select(MinElement);
        selectMin.selectByValue("15");
    }

    public boolean HeaderSection(String Name){
        List<WebElement> SectionName = driver.findElements(By.xpath("//div[@class='me-2']"));
        for(WebElement Sections : SectionName){
            waitfn.scrollToElement(driver,Sections);
            String Header = Sections.getText().trim();
            if(Header.equalsIgnoreCase(Name)){
                return true;
            }
        }
        return false;
    }


}














