package selenium;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomNameGenerator {

	public static void main(String[] args) {
		
		 int alphaCount = 4; // Number of alphabetic characters
	        int numCount = 6; // Number of numeric characters
	        String randomName = generateRandomName(alphaCount, numCount);
	        System.out.println("Random Name: " + randomName);
		// TODO Auto-generated method stub
		
	}
	
	public static String generateRandomName(int alphaCount, int numCount) {
        String name = RandomStringUtils.randomAlphabetic(alphaCount) + RandomStringUtils.randomNumeric(numCount);
        return name;
    }

}
