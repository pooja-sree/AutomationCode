package org.reach24.Reach24NEP.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.reach24.Reach24NEP.dtos.EventDetailsDTO;

public class Inandoutstream {

	EventDetailsDTO eventInfoFromCreation = new EventDetailsDTO();
	String equipmentnumbertractor;
	String equipmentnumbertrailer;
	String equipmentnumbercontainer;
	String equipmentnumberchassis;
	String equipmentTypelist;
	String chassisnumber;
	String containernumber;
	String tractornumber;
	String trailernumber;
	
	static Properties prop = new Properties();
		
	
	@SuppressWarnings("deprecation")
	public void savechassisnumber(String equipmentnumberchassis) throws IOException{
		File file = new File("./src/test/resources/config/Duplicate/chassisnumber.properties");
		FileOutputStream outputStream = new FileOutputStream(file);
		prop.setProperty("chassisnumber", equipmentnumberchassis);
		prop.save(outputStream, "Equipment number chassis");
		outputStream.close();
    }
	@SuppressWarnings("deprecation")
	public void savecontainernumber(String equipmentnumbercontainer) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/containernumber.properties");
		FileOutputStream outputStream1 = new FileOutputStream(file);
		prop.setProperty("containernumber", equipmentnumbercontainer);
		prop.save(outputStream1, "Equipment number container");
		outputStream1.flush();
		outputStream1.close();
	}
	@SuppressWarnings("deprecation")
	public void savetractornumber(String equipmentnumbertractor) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/tractornumber.properties");
		FileOutputStream outputStream2 = new FileOutputStream(file);
		prop.setProperty("tractornumber", equipmentnumbertractor);
		prop.save(outputStream2, "Equipment number tractor");
		outputStream2.flush();
		outputStream2.close();
	}

	@SuppressWarnings("deprecation")
	public void savetrailernumber(String equipmentnumbertrailer) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/trailernumber.properties");
		FileOutputStream outputStream3 = new FileOutputStream(file);
		prop.setProperty("trailernumber", equipmentnumbertrailer);		
		prop.save(outputStream3, "Equipment number trailer");
		outputStream3.flush();
		outputStream3.close();
	}
	@SuppressWarnings("deprecation")
	public void saveScheduledTimeSlot(String scheduleTimeSlot) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/scheduleTimeSlot.properties");
		FileOutputStream outputStream3 = new FileOutputStream(file);
		prop.setProperty("scheduleTimeSlot", scheduleTimeSlot);
		prop.save(outputStream3, "Scheduled Time Slot");
		outputStream3.flush();
		outputStream3.close();
	}

	@SuppressWarnings("deprecation")
	public void saveScheduleEventID(String scheduleEventID) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/scheduleEventID.properties");
		FileOutputStream outputStream3 = new FileOutputStream(file);
		prop.setProperty("scheduleEventID", scheduleEventID);
		prop.save(outputStream3, "Scheduled Event ID");
		outputStream3.flush();
		outputStream3.close();
	}

	@SuppressWarnings("deprecation")
	public void saveEventID(String eventID) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/scheduleEventID.properties");
		FileOutputStream outputStream3 = new FileOutputStream(file);
		prop.setProperty("eventID", eventID);
		prop.save(outputStream3, "Event ID");
		outputStream3.flush();
		outputStream3.close();
	}

	@SuppressWarnings("deprecation")
	public void saveEquipmentNumber(String equipmentNumber) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/equipmentnumber.properties");
		FileOutputStream outputStream3 = new FileOutputStream(file);
		prop.setProperty("equipmentNumber", equipmentNumber);
		prop.save(outputStream3, "Equipment Number");
		outputStream3.flush();
		outputStream3.close();
	}
	@SuppressWarnings("deprecation")
	public void saveInvoiceNumber(String invoiceNumber, String tenant) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/invoiceNumber.properties");
		FileOutputStream outputStream3 = new FileOutputStream(file);
		prop.setProperty(tenant+"InvoiceNumber", invoiceNumber);
		prop.save(outputStream3, "Invoice Number");
		outputStream3.flush();
		outputStream3.close();
	}

    public static String loadtractornumber(String tractornumber)throws IOException
    {
    	File file = new File("./src/test/resources/config/Duplicate/tractornumber.properties");
    	FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("tractornumber");

    } 
    public String loadtrailernumber(String trailernumber) throws IOException {
    	File file = new File("./src/test/resources/config/Duplicate/trailernumber.properties");
    	FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("trailernumber");
	}

    public static String loadchassisnumber(String chassisnumber) throws IOException {
    	File file = new File("./src/test/resources/config/Duplicate/chassisnumber.properties");
    	FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("chassisnumber");
	}

	public String loadcontainernumber(String containernumber) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/containernumber.properties");
    	FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("containernumber");
	}

	public String loadScheduledTimeSlot() throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/scheduleTimeSlot.properties");
		FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("scheduleTimeSlot");
	}

	public String loadScheduleEventID() throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/scheduleEventID.properties");
		FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("scheduleEventID");
	}

	public String loadEventID() throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/scheduleEventID.properties");
		FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("eventID");
	}

	public String loadEquipmentNumber() throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/equipmentnumber.properties");
		FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty("equipmentNumber");
	}

	public String loadInvoiceNumber(String tenant) throws IOException {
		File file = new File("./src/test/resources/config/Duplicate/invoiceNumber.properties");
		FileInputStream inputstream=new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty(tenant+"InvoiceNumber");
	}



}
