package com.Pg4.Pg.Util;

import com.Pg4.Pg.Pages.Login;

public class BeforeandAfterScenarios extends BasePage{

PropsReader props = new PropsReader();


Login log = new Login(driver);

    Validation Check = new Validation();
public BeforeandAfterScenarios(){
    super();
}


public void Login(String Usertype){
    try{
        switch (Usertype){

            case "Practitioner" :
                driver.get(PropsReader.BaseUrl);
                log.Practitioner_Email();
                log.Practitioner_Password();
                log.SigninButton();
                wait.URL(log.Practitioner_url);
                Check.CheckURL(log.Practitioner_url, "Practitioner Login Successful");
                break;

            case "Patient" :
                driver.get(PropsReader.BaseUrl);
                log.Patient_Email();
                log.Patient_Password();
                log.SigninButton();
               wait.URL("https://mypractice.pg3.lmapps.io/patient/dashboard??lng=en");
//                Check.CheckURL(log.Patient_url,"Patient Login Successfull");
                Check.CheckURL("https://mypractice.pg3.lmapps.io/patient/dashboard??lng=en","Login success");
                break;

            default:
                throw new CustomException("Invalid Usertype");


        }
    } catch (CustomException e) {

        e.printStackTrace();
    }




}

}
