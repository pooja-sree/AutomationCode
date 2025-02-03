package com.puregenomics.at.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.dataprovider.ReadExcelData;
import com.puregenomics.at.pageFactory.PatientDashboard_Elements;
import com.puregenomics.at.pageFactory.Questionnaire_Elements;
import com.puregenomics.at.pageFactory.Report_Elements;


public class Questionnaire_cases extends BaseClass{ 

	private Logger log = Logger.getLogger(Questionnaire_cases.class);
	PatientDashboard_Elements patient = new PatientDashboard_Elements(driver);
	Questionnaire_Elements quest = new Questionnaire_Elements(driver);
	Report_Elements report = new Report_Elements(driver);
	ConfigFileReader configs= new ConfigFileReader();

	
	public void questionnaire_screen() {
		try{
			/*WebElement element = patient.click_gotodash();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			log.info("Navigate to patient dashboard");
			Thread.sleep(2000);*/
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,260)");
			Thread.sleep(2000);
			/*if(quest.click_start_ques().isDisplayed()) {
				WebElement s_ques = quest.click_start_ques();
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();", s_ques);
				Thread.sleep(2000);
				Assert.assertTrue(quest.get_quesitionnaire().isDisplayed());
				log.info("Questionnaire screen is loaded successfully");
			} else*/ if(quest.click_update_ques().isDisplayed()) {
				WebElement u_ques = quest.click_update_ques();
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();", u_ques);
				} else {
					log.info("Practitioner is not invited the patient to start questionnaire");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void welcome_question() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	    for(WebElement question:quest.get_questions_text()) {
 		   String get_question = question.getText();
 		   if(get_question.equals(excelData.get("1").get("Questions"))) {
 			   log.info("Welcome Question is matched");
 			   for(WebElement answer:quest.get_ans()) {
 				   String get_answer = answer.getText();
 				   if(get_answer.equals(excelData.get("1").get("Answer"))) {
 					   log.info("Welcome answer is matched");
 					  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", answer);
 					   JavascriptExecutor executor = (JavascriptExecutor)driver;
 					   executor.executeScript("arguments[0].click();", answer);
 					   log.info("Welcome answer is clicked");
 					   Thread.sleep(5000);
 					   break;
 				   } else {
 					  log.error("Welcome answer is not clicked");
 				   }
 			  }break;
 		   } else {
 			   log.info("Welcome Question is not matched");
 		   }
 	   }
	}
	
	
	public void dob_question() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	    for(WebElement question:quest.get_questions_text()) {
 		   String get_question = question.getText();
 		   if(get_question.equals(excelData.get("2").get("Questions"))) {
 			   log.info("DOB Question is matched");
 			   quest.enter_date().click();
 			   quest.enter_date().sendKeys(Keys.CONTROL, "a");
 			   log.info("Existing date is cleared");
 			   Thread.sleep(2000);
 			   quest.enter_date().sendKeys(excelData.get("2").get("Answer"));
 			   Thread.sleep(2000);
 			   Assert.assertTrue(quest.click_ok().isDisplayed());
 			   quest.click_ok().click();
 			   log.info("DOB data is entered");
 			   Thread.sleep(5000);
 			   break;
 	   }else {
 		   log.info("DOB Question is not matched");
 	   }
		
	}
	
	}
	
	
	public void gender_question() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	    for(WebElement question:quest.get_questions_text()) {
 		   String get_question = question.getText();
 		  if(get_question.equals(excelData.get("3").get("Questions"))) {
			   log.info("Gender Question is matched");
			   for(WebElement answer:quest.get_ans()) {
				  String get_answer = answer.getText();
				  if(get_answer.equals(excelData.get("3").get("Answer"))) {
					  log.info("Answer is matched");
					  JavascriptExecutor executor = (JavascriptExecutor)driver;
					  executor.executeScript("arguments[0].click();", answer);
					  log.info("Gender answer is clicked");
					  Thread.sleep(5000);
					  break;
				  }else {
					  log.error("Answer is not matched");
				  }
			   }break;
 		  }else {
 			  log.error("Gender question is not matched");
 		  }
 	    }
		
	}
	
	public void race_question() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	    for(WebElement question:quest.get_questions_text()) {
 	    	String get_question = question.getText();
 	    	if(get_question.equals(excelData.get("4").get("Questions"))) {
 	    		log.info("Race Question is matched");
 	    		for(WebElement answer: quest.get_ans()) {
 	    			String get_answer = answer.getText();
 	    			if(get_answer.equals(excelData.get("4").get("Answer"))) {
 	    				log.info("Race answer is matched");
 	    				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
 	    				executor1.executeScript("arguments[0].click();", answer);
 	    				Thread.sleep(2000);
 	    				quest.click_ok().click();
 	    				log.info("Race answer is clicked");
 	 	    			Thread.sleep(5000);
 	 	    			break;
 	    			}else {
 	    				log.info("Race answer is not matched");
 	    			}
 	    			
			   }break;
 		  }else {
 			  log.info("Race question is not matched");
 		  }
 	   }
	}
	
	public void ethnicity_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	    for(WebElement question:quest.get_questions_text()) {
 	    	String get_question = question.getText();
 	    	if(get_question.equals(excelData.get("5").get("Questions"))) {
 	    		log.info("Ethnicity Question is matched");
 			   for(WebElement answer:quest.get_ans()) {
 				  String get_answer = answer.getText();
 				  if(get_answer.equals(excelData.get("5").get("Answer"))) {
 					  log.info("Ethnicity answer is matched");
 					  JavascriptExecutor executor = (JavascriptExecutor)driver;
 					  executor.executeScript("arguments[0].click();", answer);
 					  log.info("Ethnicity answer is clicked");
 					  Thread.sleep(5000);
 					  break;
 				  }else {
 					  log.error("Ethnicity answer is not matched");
 				  }
 			   }break;
 	    	}else {
 	    		log.info("Ethnicity question is not matched");
 	    	}
 	    }
	}
	
	public void living_question() throws Exception {
 		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   	for(WebElement question:quest.get_questions_text()) {
 	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("6").get("Questions"))) {
	    		log.info("Living Environment Question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("6").get("Answer"))) {
	    				log.info("Living Environment answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Living Environment is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Living Environment answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Living Environment question is not matched");
	    	}
 	   	}
	}
	
	public void sunExposure_question() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   	for(WebElement question:quest.get_questions_text()) {
 	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("7").get("Questions"))) {
	    		log.info("Sun exposure Question is matched");
	    		String get_answer = quest.click_sun_yes().getText();
	    		System.out.println(get_answer);
	    		Assert.assertEquals(get_answer, excelData.get("7").get("Answer"));
	    		log.info("Sun exposure answer is matched");
	    		quest.click_sun_yes().click();
	    		log.info("Sun exposure is clicked");
	    		Thread.sleep(5000);
	    		break;
	    	}else {
	    		log.info("Sun exposure question is not matched");
	    	}
 	   	
 	   	}
	
	}
	
	public void healthconcern_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   	for(WebElement question:quest.get_questions_text()) {
 	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("8").get("Questions"))) {
	    		log.info("Health concern Question is matched");
	    		quest.enter_hc().sendKeys(excelData.get("8").get("Answer"));
	    		Thread.sleep(2000);
	    		quest.click_ok().click();
	    		log.info("Health concern answer is entered");
	    		Thread.sleep(5000);
	    		break;
	    	}else {
	    		log.info("Health concern question is not matched");
	    	}
 	   	}
	}
	
	public void allergies_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   	for(WebElement question:quest.get_questions_text()) {
 	   		String get_question = question.getText();
 	   		if(get_question.equals(excelData.get("9").get("Questions"))) {
 	   			log.info("Allergy condition question is matched");
 	   			String get_answer = quest.click_yes_allergy().getText();
 	   			System.out.println(get_answer);
 	   			Assert.assertEquals(get_answer, excelData.get("9").get("Answer"));
 	   			log.info("Allergy condition answer is matched");
 	   			quest.click_yes_allergy().click();
 	   			log.info("Allergy condition is clicked");
 	   			Thread.sleep(5000);
 	   			break;
 	   		}else {
    		log.info("Allergy condition question is not matched");
 	   		}
 	   	}
 	   	
 	   for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("10").get("Questions"))) {
	    		log.info("Allergy substances question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("10").get("Answer"))) {
	    				log.info("Allergy substances answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Allergy substances is clicked");
	    				Thread.sleep(2000);
	    				quest.click_ok().click();
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Allergy substances answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Allergy substances question is not matched");
	    	}
	   	}
 	   	
	}
	
	public void sleep_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   	for(WebElement question:quest.get_questions_text()) {
 	   		String get_question = question.getText();
 	   		if(get_question.equals(excelData.get("11").get("Questions"))) {
 	   			log.info("Sleep condition question is matched");
 	   			String get_answer = quest.click_no_sleep().getText();
 	   			System.out.println(get_answer);
 	   			Assert.assertEquals(get_answer, excelData.get("11").get("Answer"));
 	   			log.info("Sleep condition answer is matched");
 	   			quest.click_no_sleep().click();
 	   			log.info("Sleep condition is clicked");
 	   			Thread.sleep(5000);
 	   			break;
 	   		}else {
    		log.info("Sleep condition question is not matched");
 	   		}
 	   	}
 	   	if(excelData.get("11").get("Answer").equals("No")) {
 		  for(WebElement question:quest.get_questions_text()) {
 		   		String get_question = question.getText();
 		    	if(get_question.equals(excelData.get("12").get("Questions"))) {
 		    		log.info("Wakeup question is matched");
 		    		for(WebElement answer:quest.get_ans()) {
 		    			String get_answer = answer.getText();
 		    			if(get_answer.equals(excelData.get("12").get("Answer"))) {
 		    				log.info("Wakeup answer is matched");
 		    				JavascriptExecutor executor = (JavascriptExecutor)driver;
 		    				executor.executeScript("arguments[0].click();", answer);
 		    				log.info("Wakeup is clicked");
 		    				Thread.sleep(2000);
 		    				quest.click_ok().click();
 		    				Thread.sleep(5000);
 		    				break;
 		    			}else {
 						  log.error("Wakeup answer is not matched");
 		    			}
 		    		}break;
 		    	}else {
 		    			log.error("Wakeup question is not matched");
 		    	}
 		   	}
 	 	   	
 	   } else {
 		   log.info("Sleep condition is Yes");
 	   } 	   	
	}
	
	
	public void exercise_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   	for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("13").get("Questions"))) {
	    		log.info("Exercise condition question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("13").get("Answer"))) {
	    				log.info("Exercise condition answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Exercise condition is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Exercise condition answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Exercise condition question is not matched");
	    	}
	   	}
 	   	
 	   	if(excelData.get("13").get("Answer")!= "0 times per week") {
 	   		for(WebElement question:quest.get_questions_text()) {
 	   			String get_question = question.getText();
 	   			if(get_question.equals(excelData.get("14").get("Questions"))) {
 	   				log.info("Exercise soreness condition question is matched");
 	   				String get_answer = quest.click_yes_soreness().getText();
 	   				System.out.println(get_answer);
 	   				Assert.assertEquals(get_answer, excelData.get("14").get("Answer"));
 	   				log.info("Exercise soreness condition answer is matched");
 	   				quest.click_yes_soreness().click();
 	   				log.info("Exercise soreness condition is clicked");
 	   				Thread.sleep(5000);
 	   				break;
 	   			}else {
 	   				log.info("Exercise soreness condition question is not matched");
 	   			}
 	   		}
 	   		for(WebElement question:quest.get_questions_text()) {
	   			String get_question = question.getText();
	   			if(get_question.equals(excelData.get("15").get("Questions"))) {
	   				log.info("Exercise sports condition question is matched");
	   				String get_answer = quest.click_yes_sports().getText();
	   				System.out.println(get_answer);
	   				Assert.assertEquals(get_answer, excelData.get("15").get("Answer"));
	   				log.info("Exercise sports condition answer is matched");
	   				quest.click_yes_sports().click();
	   				log.info("Exercise sports condition is clicked");
	   				Thread.sleep(5000);
	   				break;
	   			}else {
	   				log.info("Exercise sports condition question is not matched");
	   			}
 	   		}
 	   	}else {
 	   		log.info("Exercise condition is not required");
 	   }
 	 	
 	   	
	}

	public void nutrientDiet_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   	for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("16").get("Questions"))) {
	    		log.info("Diet option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("16").get("Answer"))) {
	    				log.info("Diet option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Diet option is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Diet option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Diet option question is not matched");
	    	}
	   	}
 	   	
 	   for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("17").get("Questions"))) {
	    		log.info("Food type question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("17").get("Answer"))) {
	    				log.info("Food type answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Food type is clicked");
	    				Thread.sleep(2000);
	    				quest.click_ok().click();
	    				log.info("Food type is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Food type answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Food type question is not matched");
	    	}
	   	}
	
 	  for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("18").get("Questions"))) {
	    		log.info("Number of meals option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("18").get("Answer"))) {
	    				log.info("Number of meals option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Number of meals option is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Number of meals option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Number of meals option question is not matched");
	    	}
	   	}
	
 	 for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("19").get("Questions"))) {
	    		log.info("Snacks option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("19").get("Answer"))) {
	    				log.info("Snacks option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Snacks option is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Snacks option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Snacks option question is not matched");
	    	}
	   	}
 	 
 	 	for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("20").get("Questions"))) {
				log.info("Skipping meals condition question is matched");
				String get_answer = quest.click_yes_meals().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("20").get("Answer"));
				log.info("Skipping meals condition answer is matched");
				quest.click_yes_meals().click();
				log.info("Skipping meals condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Skipping meals condition question is not matched");
			}
		}
 	 	
 	 	for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("21").get("Questions"))) {
	    		log.info("Snacks option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("21").get("Answer"))) {
	    				log.info("Snacks option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Snacks option is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Snacks option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Snacks option question is not matched");
	    	}
	   	}
 	 	
 	 	for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("22").get("Questions"))) {
	    		log.info("Eating behaviour option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("22").get("Answer"))) {
	    				log.info("Eating behaviour option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Eating behaviour option is clicked");
	    				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", quest.click_ok());
	    				quest.click_ok().click();
	    				log.info("Eating behaviour is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Eating behaviour option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Eating behaviour option question is not matched");
	    	}
	   	
 	 	}
	}


	public void caffeineConsumption() throws Exception{
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("23").get("Questions"))) {
	    		log.info("caffeinated option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("23").get("Answer"))) {
	    				log.info("caffeinated option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("caffeinated option is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("caffeinated option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("caffeinated option question is not matched");
	    	}
	   	}
		
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("24").get("Questions"))) {
				log.info("Reduce caffeine condition question is matched");
				String get_answer = quest.click_yes_consumes().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("24").get("Answer"));
				log.info("Reduce caffeine condition answer is matched");
				quest.click_yes_consumes().click();
				log.info("Reduce caffeine condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Reduce caffeine condition question is not matched");
			}
		}
	}


	public void alcohol_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("25").get("Questions"))) {
				log.info("Consume alcohol condition question is matched");
				String get_answer = quest.click_yes_alcohol().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("25").get("Answer"));
				log.info("Consume alcohol condition answer is matched");
				quest.click_yes_alcohol().click();
				log.info("Consume alcohol condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Consume alcohol condition question is not matched");
			}
		}
		
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("26").get("Questions"))) {
	    		log.info("Drinking behaviour option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("26").get("Answer"))) {
	    				log.info("Drinking behaviour option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Drinking behaviour option is clicked");
	    				quest.click_ok().click();
	    				log.info("Drinking behaviour is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Drinking behaviour option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Drinking behaviour option question is not matched");
	    	}  	
 	 	}
		
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("27").get("Questions"))) {
				log.info("Consume drugs condition question is matched");
				String get_answer = quest.click_yes_drugs().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("27").get("Answer"));
				log.info("Consume drugs condition answer is matched");
				quest.click_yes_drugs().click();
				log.info("Consume drugs condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Consume drugs condition question is not matched");
			}
		}
	}


	public void smoking_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("28").get("Questions"))) {
				log.info("Smoker condition question is matched");
				String get_answer = quest.click_no_smoker().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("28").get("Answer"));
				log.info("Smoker condition answer is matched");
				quest.click_no_smoker().click();
				log.info("Smoker condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Smoker condition question is not matched");
			}
		}
		
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("29").get("Questions"))) {
				log.info("Second Smoker condition question is matched");
				String get_answer = quest.click_no_secondsmoker().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("29").get("Answer"));
				log.info("Second Smoker condition answer is matched");
				quest.click_no_secondsmoker().click();
				log.info("Second Smoker condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Second Smoker condition question is not matched");
			}
		}
	}


	public void environmental_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("30").get("Questions"))) {
	    		log.info("Environmental exposure option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("30").get("Answer"))) {
	    				log.info("Environmental exposure option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Environmental exposure option is clicked");
	    				quest.click_ok().click();
	    				log.info("Environmental exposure is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Environmental exposure option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Environmental exposure option question is not matched");
	    	}  	
 	 	}
	}

	public void stress_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("31").get("Questions"))) {
	    		log.info("Stress level option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("31").get("Answer"))) {
	    				log.info("Stress level option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Stress level option is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Stress level option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Stress level option question is not matched");
	    	}  	
 	 	}
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("32").get("Questions"))) {
				log.info("Pressure condition question is matched");
				String get_answer = quest.click_yes_pressure().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("32").get("Answer"));
				log.info("Pressure condition answer is matched");
				quest.click_yes_pressure().click();
				log.info("Pressure condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Pressure condition question is not matched");
			}
		}
		
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("33").get("Questions"))) {
				log.info("Relaxation condition question is matched");
				String get_answer = quest.click_no_relation().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("33").get("Answer"));
				log.info("Relaxation condition answer is matched");
				quest.click_no_relation().click();
				log.info("Relaxation condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Relaxation condition question is not matched");
			}
		}
	}
	
	public void mood_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("34").get("Questions"))) {
	    		log.info("Mood issues option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("34").get("Answer"))) {
	    				log.info("Mood issues option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Mood issues option is clicked");
	    				quest.click_ok().click();
	    				log.info("Mood issues is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Mood issues option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Mood issues option question is not matched");
	    	}  	
 	 	}
	}
	
	public void focus_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	   for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("35").get("Questions"))) {
				log.info("Focus condition question is matched");
				String get_answer = quest.click_yes_focus().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("35").get("Answer"));
				log.info("Focus condition answer is matched");
				quest.click_yes_focus().click();
				log.info("Focus condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.error("Focus condition question is not matched");
			}
		}	
	}

	public void addictiveRisk_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("36").get("Questions"))) {
	    		log.info("addictiveRisk option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("36").get("Answer"))) {
	    				log.info("addictiveRisk option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("addictiveRisk option is clicked");
	    				quest.click_ok().click();
	    				log.info("addictiveRisk is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("addictiveRisk option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("addictiveRisk option question is not matched");
	    	}  	
 	 	}
	}

	public void energy_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("37").get("Questions"))) {
	    		log.info("Energy level option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("37").get("Answer"))) {
	    				log.info("Energy level option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Energy level option is clicked");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Energy level option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Energy level option question is not matched");
	    	}  	
 	 	}
	}
	
	public void immune_quesitons() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("38").get("Questions"))) {
	    		log.info("Immune health option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("38").get("Answer"))) {
	    				log.info("Immune health option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Immune health option is clicked");
	    				quest.click_ok().click();
	    				log.info("Immune health is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Immune health option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Immune health option question is not matched");
	    	}  	
 	 	}
	}
	
	public void cognitive_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("39").get("Questions"))) {
	    		log.info("Cognitive health option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("39").get("Answer"))) {
	    				log.info("Cognitive health option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Cognitive health option is clicked");
	    				quest.click_ok().click();
	    				log.info("Cognitive health is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Cognitive health option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Cognitive health option question is not matched");
	    	}  	
 	 	}
		
	}
	
	public void cardiovascular_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("40").get("Questions"))) {
	    		log.info("Cardiovascular health option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("40").get("Answer"))) {
	    				log.info("Cardiovascular health option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Cardiovascular health option is clicked");
	    				quest.click_ok().click();
	    				log.info("Cardiovascular health is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Cardiovascular health option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Cardiovascular health option question is not matched");
	    	}  	
		}	
	}
	
	public void gastorintertinal_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("41").get("Questions"))) {
	    		log.info("Gastorintestinal health option question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("41").get("Answer"))) {
	    				log.info("Gastorintestinal health option answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Gastorintestinal health option is clicked");
	    				quest.click_ok().click();
	    				log.info("Gastorintestinal health is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Gastorintestinal health option answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Gastorintestinal health option question is not matched");
	    	}  	
		}	
	}
	
	public void metabolic_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
 	    for(WebElement question:quest.get_questions_text()) {
 		   String get_question = question.getText();
 		   if(get_question.equals(excelData.get("42").get("Questions"))) {
 			   log.info("Height Question is matched");
  			   quest.enter_height().sendKeys(excelData.get("42").get("Answer"));
 			   Thread.sleep(2000);
 			   Assert.assertTrue(quest.click_ok().isDisplayed());
 			   quest.click_ok().click();
 			   log.info("Height data is entered");
 			   Thread.sleep(5000);
 			   break;
 		   }else {
 		   log.info("Height Question is not matched");
 		   }
 	    }
 	    
 	   for(WebElement question:quest.get_questions_text()) {
 		   String get_question = question.getText();
 		   if(get_question.equals(excelData.get("43").get("Questions"))) {
 			   log.info("Weight Question is matched");
  			   quest.enter_weight().sendKeys(excelData.get("43").get("Answer"));
 			   Thread.sleep(2000);
 			   Assert.assertTrue(quest.click_ok().isDisplayed());
 			   quest.click_ok().click();
 			   log.info("Weight data is entered");
 			   Thread.sleep(5000);
 			   break;
 		   }else {
 		   log.info("Weight Question is not matched");
 		   }
 	    }
 	   	for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("44").get("Questions"))) {
	    		log.info("Weight Management issues question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("44").get("Answer"))) {
	    				log.info("Weight Management issues answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Weight Management issues is clicked");
	    				quest.click_ok().click();
	    				log.info("Weight Management issues is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Weight Management issues answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Weight Management issues question is not matched");
	    	}  	
		}	
 	   for(WebElement question:quest.get_questions_text()) {
	   		String get_question = question.getText();
	    	if(get_question.equals(excelData.get("45").get("Questions"))) {
	    		log.info("Blood sugar issues question is matched");
	    		for(WebElement answer:quest.get_ans()) {
	    			String get_answer = answer.getText();
	    			if(get_answer.equals(excelData.get("45").get("Answer"))) {
	    				log.info("Blood sugar  issues answer is matched");
	    				JavascriptExecutor executor = (JavascriptExecutor)driver;
	    				executor.executeScript("arguments[0].click();", answer);
	    				log.info("Blood sugar  issues is clicked");
	    				quest.click_ok().click();
	    				log.info("Blood sugar  issues is confirmed");
	    				Thread.sleep(5000);
	    				break;
	    			}else {
					  log.error("Blood sugar issues answer is not matched");
	    			}
	    		}break;
	    	}else {
	    			log.error("Blood sugar issues question is not matched");
	    	}  	
 	   }
	}
	
	public void medication_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("46").get("Questions"))) {
				log.info("Medication condition question is matched");
				String get_answer = quest.click_yes_medication().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("46").get("Answer"));
				log.info("Medication condition answer is matched");
				quest.click_yes_medication().click();
				log.info("Medication condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Medication condition question is not matched");
			}
		}
		if(excelData.get("46").get("Answer").equals("Yes")) {
			for(WebElement question:quest.get_questions_text()) {
		   		String get_question = question.getText();
		    	if(get_question.equals(excelData.get("47").get("Questions"))) {
		    		log.info("Medication types question is matched");
		    		for(WebElement answer:quest.get_ans()) {
		    			String get_answer = answer.getText();
		    			if(get_answer.equals(excelData.get("47").get("Answer"))) {
		    				log.info("Medication types answer is matched");
		    				JavascriptExecutor executor = (JavascriptExecutor)driver;
		    				executor.executeScript("arguments[0].click();", answer);
		    				log.info("Medication types is clicked");
		    				quest.click_ok().click();
		    				log.info("Medication types is confirmed");
		    				Thread.sleep(5000);
		    				break;
		    			}else {
						  log.error("Medication types answer is not matched");
		    			}
		    		}break;
		    	}else {
		    			log.error("Medication types question is not matched");
		    	}  	
	 	   }
		}else {
			log.info("Medication is not required");
		}
	}
	
	public void supplement_questions() throws Exception {
		ReadExcelData ex = new ReadExcelData(configs.getexcel_path(), 0);
 	   	Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
		for(WebElement question:quest.get_questions_text()) {
			String get_question = question.getText();
			if(get_question.equals(excelData.get("48").get("Questions"))) {
				log.info("Supplement condition question is matched");
				String get_answer = quest.click_yes_supplements().getText();
				System.out.println(get_answer);
				Assert.assertEquals(get_answer, excelData.get("48").get("Answer"));
				log.info("Supplement condition answer is matched");
				quest.click_yes_supplements().click();
				log.info("Supplement condition is clicked");
				Thread.sleep(5000);
				break;
			}else {
				log.info("Supplement condition question is not matched");
			}
		}
		if(excelData.get("48").get("Answer").equals("Yes")) {
			for(WebElement question:quest.get_questions_text()) {
		   		String get_question = question.getText();
		    	if(get_question.equals(excelData.get("49").get("Questions"))) {
		    		log.info("Supplement types question is matched");
		    		for(WebElement answer:quest.get_ans()) {
		    			String get_answer = answer.getText();
		    			if(get_answer.equals(excelData.get("49").get("Answer"))) {
		    				log.info("Supplement types answer is matched");
		    				JavascriptExecutor executor = (JavascriptExecutor)driver;
		    				executor.executeScript("arguments[0].click();", answer);
		    				log.info("Supplement types is clicked");
		    				quest.click_ok().click();
		    				log.info("Supplement types is confirmed");
		    				Thread.sleep(5000);
		    				break;
		    			}else {
						  log.error("Supplement types answer is not matched");
		    			}
		    		}break;
		    	}else {
		    			log.error("Supplement types question is not matched");
		    	}  	
	 	   }
		}else {
			log.info("Supplement is not required");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void review() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(quest.get_review_text()));
		Assert.assertTrue(quest.get_review_text().isDisplayed());
		log.info("Review screen is loaded");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", quest.click_confirm());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", quest.click_confirm());
		log.info("Questionnaire answer is confirmed");
		Thread.sleep(3000);
		Assert.assertTrue(quest.verify_questuploading().isDisplayed());
		log.info("Questionnaire uploading screen is displayed");
		FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver);
//		wait1.withTimeout(8, TimeUnit.MINUTES);
//		wait1.pollingEvery(90, TimeUnit.SECONDS);
		wait1.ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOf((patient.click_viewReport())));
		log.info("Dashboard screen is loaded");
		Thread.sleep(3000);
		Assert.assertTrue(patient.get_ques_status().isDisplayed());
		log.info("Questionnaire status is updated as completed");
	}
	
	
	public void validate_report() throws Exception {
		patient.click_viewReport().click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(report.get_reportSummary_title()));
		Assert.assertTrue(report.get_reportSummary_title().isDisplayed());
		log.info("Report screen is loaded");
		Thread.sleep(2000);
		String quest_status = report.get_quest_status().getText();
		Assert.assertEquals("Completed", quest_status);
		log.info("Questionnaire is completed");
	}
	
	
	
}
	
