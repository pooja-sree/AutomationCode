package org.reach24.Reach24NEP.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;

public class ReusableMethods {

	public String randomAlphaNumericName(int alphaCount, int numCount) {
		String name = RandomStringUtils.randomAlphabetic(alphaCount) + RandomStringUtils.randomNumeric(numCount);
		return name;
	}
	public String randomServiceCenterName(int numCount) {
		String name = "AutoService" + RandomStringUtils.randomNumeric(numCount);
		return name;
	}
	public String randomServiceCenterEmail(int numCount) {
		String name = "satheesh+" + RandomStringUtils.randomNumeric(numCount) + "@reach24.net";
		return name;
	}
	public String getDate(int date) {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, date);
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        return dateFormat.format(cal.getTime());
	}
}
