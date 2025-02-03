package com.pg4.pg.Testcase;

import com.Pg4.Pg.Pages.Forms;
import com.Pg4.Pg.Util.BasePage;

public class Questionnaire_TC extends BasePage {

    Forms Que;

    public Questionnaire_TC() {
        super();
        Que = new Forms(driver);
    }

   public void Answer(){
        Que.Execute_Questionnaire();
   }
}
