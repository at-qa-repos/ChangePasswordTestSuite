package com.changePassword.tests;

import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import com.changePassword.pages.ChangePasswordPage;
import com.changePassword.utils.ExcelUtils;

public class ChangePasswordTest {

	HashMap<String, String> testData;
	
	@Test
	public void verifyDuplicateNewPasswordTest() {	
		try {
			System.out.println("---Test Started - Verify the duplicate new password---");
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + "/TestData/TestDataExcelSheet.xlsx", "Data", "TC_01");
			String oldPassword = testData.get("OLDPASSWORD");
			String newPassword = testData.get("NEWPASSWORD");
			ChangePasswordPage cp = new ChangePasswordPage();
			Assert.assertTrue(cp.changePassword(oldPassword, newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifySimilarNewPasswordTest() {	
		try {
			System.out.println("---Test Started - Verify the similar new password---");
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + "/TestData/TestDataExcelSheet.xlsx", "Data", "TC_02");
			String oldPassword = testData.get("OLDPASSWORD");
			String newPassword = testData.get("NEWPASSWORD");
			ChangePasswordPage cp = new ChangePasswordPage();
			Assert.assertTrue(cp.changePassword(oldPassword, newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyNewPasswordLengthLimitTest() {
		try {
			System.out.println("---Test Started - Verify the limit of the new password length---");
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + "/TestData/TestDataExcelSheet.xlsx", "Data", "TC_03");
			String oldPassword = testData.get("OLDPASSWORD");
			String newPassword = testData.get("NEWPASSWORD");
			ChangePasswordPage cp = new ChangePasswordPage();
			Assert.assertTrue(cp.changePassword(oldPassword, newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyNewPasswordDuplicateCharactersLimitTest() {
		try {
			System.out.println("---Test Started - Verify the duplicate characters limit for the new password---");
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + "/TestData/TestDataExcelSheet.xlsx", "Data", "TC_04");
			String oldPassword = testData.get("OLDPASSWORD");
			String newPassword = testData.get("NEWPASSWORD");
			ChangePasswordPage cp = new ChangePasswordPage();
			Assert.assertTrue(cp.changePassword(oldPassword, newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyNewPasswordSpecialCharactersLimitTest() {
		try {
			System.out.println("---Test Started - Verify the special characters limit for the new password---");
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + "/TestData/TestDataExcelSheet.xlsx", "Data", "TC_05");
			String oldPassword = testData.get("OLDPASSWORD");
			String newPassword = testData.get("NEWPASSWORD");
			ChangePasswordPage cp = new ChangePasswordPage();
			Assert.assertTrue(cp.changePassword(oldPassword, newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyNewPasswordNumbersLimitTest() {
		try {
			System.out.println("---Test Started - Verify the limit of numbers in the new password---");
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + "/TestData/TestDataExcelSheet.xlsx", "Data", "TC_06");
			String oldPassword = testData.get("OLDPASSWORD");
			String newPassword = testData.get("NEWPASSWORD");
			ChangePasswordPage cp = new ChangePasswordPage();
			Assert.assertTrue(cp.changePassword(oldPassword, newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyValidNewPasswordTest() {
		try {
			System.out.println("---Test Started - Verify the valid new password---");
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + "/TestData/TestDataExcelSheet.xlsx", "Data", "TC_07");
			String oldPassword = testData.get("OLDPASSWORD");
			String newPassword = testData.get("NEWPASSWORD");
			ChangePasswordPage cp = new ChangePasswordPage();
			Assert.assertTrue(cp.changePassword(oldPassword, newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
