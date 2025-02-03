package org.reach24.Reach24NEP.dtos;

import org.reach24.Reach24NEP.util.ReusableMethods;

public class CommonVariables {
	
	static ReusableMethods reuseCode = new ReusableMethods();
	static String name = reuseCode.randomAlphaNumericName(3, 2);
	
	// Tenant creation variables
		public static String tenandName = "AutoTest_" + name;
		public static String tenandAliceName = name;
		public static String description = "Auto created Tenant";

		// Event Creation variables
		public static String address = "San Francisco";
		public static String breakDownNotes = "Break failure";
		public static String comment = "Test Comment";
		public static String driverName = "No Driver";
		public static String driverPhoneNumber = "0000000000";
		public static String vehicleType = "Truck";
		public static String vehicleColor = "Black";
		public static String caller = "TestCaller";
}


