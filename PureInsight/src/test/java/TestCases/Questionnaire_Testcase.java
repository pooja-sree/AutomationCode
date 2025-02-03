package TestCases;

import com.Pg4.PageFactory.Questionnaire;
import com.Pg4.PageFactory.Validation;
import com.Pg4.PageFactory.Waitfunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Questionnaire_Testcase extends Questionnaire {

    WebDriver driver;
    Questionnaire Ques;
    Validation validate;

    Waitfunctions WaitFN;




    public Questionnaire_Testcase(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Ques = new Questionnaire(driver);
        validate = new Validation(driver);
        WaitFN = new Waitfunctions(driver);

    }

    public void Execute_Forms(){

//        Consent_Agree();
//        Consent_Agree();
//        Consent_Agree();
        MultiSymptom_Questionnaire();
        Generalized_Anxiety_Disorder_Questionnaire();
        Patient_Health_Questionnaire();
        Perceived_Stress_Scale_Questionnaire();
        Pittsburgh_Sleep_Quality_Index_Questionnaire();


    }




    public void MultiSymptom_Questionnaire(){

        if(QuestionnaireSection("Multi-Symptom Questionnaire")){

        Ques.Que_btn();
        validate.questionnaireValidation("MULTI-SYMPTOM QUESTIONNAIRE", "MultiSymptom Questionnaire Page is launched");
        Ques.sleep();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Mental_Health_and_Mood();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Digestive_Health();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Energy_and_Fatigue();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Metabolic_Health();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Immune_Health();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Cognitive();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Musculoskeletal();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.Hormones();
        validate.MultiSymptom_Questionnaire_HeaderValidation();
        Ques.General();
        validate.QuestionnaireCompletion();}
    }

    public void Generalized_Anxiety_Disorder_Questionnaire(){

        if(QuestionnaireSection("Generalized Anxiety Disorder Questionnaire (GAD-7)")){
        Ques.Que_btn();
        validate.questionnaireValidation("GENERALIZED ANXIETY DISORDER QUESTIONNAIRE (GAD-7)", "Generalized Anxiety Disorder Questionnaire (GAD-7) Page is launched");
        Anxiety();
        validate.QuestionnaireCompletion();
        //validate.Questionnaire_Completed_toast_Validation("Generalized Anxiety Disorder Questionnaire isCompleted","Questionnaire Completed!");


    }}
    public void Patient_Health_Questionnaire(){

        if(QuestionnaireSection("Patient Health Questionnaire (PHQ-9)")) {
            Ques.Que_btn();
            validate.questionnaireValidation("PATIENT HEALTH QUESTIONNAIRE (PHQ-9)", "Patient Health Questionnaire (PHQ-9) is Launched");
            Ques.Mood();
            validate.QuestionnaireCompletion();

        }

    }

    public void Perceived_Stress_Scale_Questionnaire(){

        if(QuestionnaireSection("Perceived Stress Scale Questionnaire (PSS-4)")) {
            Ques.Que_btn();
            validate.questionnaireValidation("PERCEIVED STRESS SCALE QUESTIONNAIRE (PSS-4)", "Perceived Stress Scale Questionnaire (PSS-4) is Launched");
            Ques.Stress();
            validate.QuestionnaireCompletion();

        }

    }

    public void Pittsburgh_Sleep_Quality_Index_Questionnaire()
    {

        if(QuestionnaireSection("Pittsburgh Sleep Quality Index Questionnaire (PSQI)")) {
            Ques.Que_btn();
            validate.questionnaireValidation("PITTSBURGH SLEEP QUALITY INDEX QUESTIONNAIRE (PSQI)", "Pittsburgh Sleep Quality Index Questionnaire (PSQI) is Launched");
            SleepQualityIndex();
            validate.QuestionnaireCompletion();
        }

    }

    public boolean QuestionnaireSection(String Name){
        List<WebElement> SectionName = driver.findElements(By.xpath("//div[@class='pg4-text__heading textc-primary__p']"));
        for(WebElement Sections : SectionName){
            String Header = Sections.getText().trim();
            System.out.println(Header);
            if(Header.equalsIgnoreCase(Name)){
                return true;
            }
        }
        return false;
    }

}
