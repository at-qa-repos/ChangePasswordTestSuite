package com.changePassword.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class ChangePasswordPage {

	private static final String PASSWORD_PATTERN =
			"(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=\\S+$).{18,}";

	private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

	/*This method checks whether the new password is valid or not.
	Returns true if the password is valid*/
	public boolean checkNewPassword(String password){
		boolean isValid = false;
		Matcher matcher = pattern.matcher(password);
		isValid = matcher.matches();
		if(!isValid){
			System.out.println("The Pattern matched failed. Please refer the Password requirements.");
			return isValid;
		}
		if(countOfSpecialCharacters(password)>4){
			System.out.println("The count of Special characters is more than 4. Please refer the Password requirements.");
			isValid = false;
			return isValid;
		}
		if(!isNumberInPasswordLessThan50Percent(password)){
			System.out.println("There are more than 50% number in the passowrd. Please refer the Password requirements.");
			isValid = false;
			return isValid;
		}
		if(isNumberOfOccuranceOfCharMoreThan4(password)){
			System.out.println("A character appears more than 4 times. Please refer the Password requirements.");
			isValid = false;
			return isValid;
		}
		return isValid;
	}

	/*This method checks if the number of occurance of a character is not more than 4
	Returns true if the count of repeated char is more than 4*/
	public boolean isNumberOfOccuranceOfCharMoreThan4(String password){
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, ++count);
			} else {
				map.put(c, 1);
			}
		}
		for (Map.Entry<Character,Integer> entry : map.entrySet())
			if(entry.getValue()>4){
				return true;
			}
		return false;
	}

	/*This method checks if the occurance of numbers is not more than 50% of total length
	Returns true if the count of occurance of numbers is less than 50%*/
	public boolean isNumberInPasswordLessThan50Percent(String password){
		int count = 0;
		boolean flag = false;
		int halfPasswordLength = password.length()/2;
		for(int i=0;i<password.length();i++){
			if(password.charAt(i) >= '0' && password.charAt(i) <= '9'){
				count++;
			}
		}
		if(count<halfPasswordLength){
			flag = true;
		}
		return flag;
	}

	/*This method returns the count of the number of Special Characters*/
	public int countOfSpecialCharacters(String password){
		int count = 0;
		for(int i=0;i<password.length();i++){
			if(password.charAt(i)=='!' || password.charAt(i)=='@' || password.charAt(i)=='#' || password.charAt(i)=='$' || password.charAt(i)=='&' || password.charAt(i)=='*'){
				count++;
			}
		}
		return count;
	}

	/*This method check the Similarity between the two strings, return the distance in double*/
	public static double checkSimilarity(String s1, String s2) {
		String longer = s1, shorter = s2;
		if (s1.length() < s2.length()) { // longer should always have greater length
			longer = s2; shorter = s1;
		}
		int longerLength = longer.length();
		if (longerLength == 0) { 
			return 1.0; /* both strings are zero length */ 
		}
		LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
		return (longerLength - levenshteinDistance.apply(longer, shorter)) / (double) longerLength;
	}

	/*This method checks whether the new password is valid or not.
	 * Also verifies if the password is not similar to old password < 80% match
	Returns true if the password can be changed*/
	public boolean changePassword(String oldPassword, String newPassword){			
		boolean canChangePassword = false;
		if(newPassword.equals(oldPassword)){
			System.out.println("The new password is same as the old password. Please refer the Password requirements.");
			return canChangePassword;
		}
		if(checkNewPassword(newPassword)){
			canChangePassword = true;
		}
		if(checkSimilarity(oldPassword, newPassword)>0.8){
			System.out.println("The new password is 80% similar to the old password. Please refer the Password requirements.");
			canChangePassword = false;
		}
		if(canChangePassword){
			System.out.println("The entered password is valid");
		}
		else{
			System.out.println("The entered password is inValid");
		}
		return canChangePassword;
	}
}
