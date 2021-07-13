# ChangePasswordTestSuite

Introduction: 
- This Test Automation Framework is created using Java + JUnit + Maven. 

Prerequisites:
- Java jdk-1.8 or higher
- Apache Maven 3 or higher
- Eclipse Neon or higher

Execution:
- Clone/Download the repository
- Open Eclipse and Import the project
- Run the tests as JUnit test

Summary:
There are a total of 7 unit tests. Only Valid password will pass, others are negartive tests that will fail(deliberately).
- verifyDuplicateNewPasswordTest
- verifySimilarNewPasswordTest
- verifyNewPasswordLengthLimitTest
- verifyNewPasswordDuplicateCharactersLimitTest
- verifyNewPasswordSpecialCharactersLimitTest
- verifyNewPasswordNumbersLimitTest
- verifyValidNewPasswordTest

Tests/Test Cases handled:
- Password requirement: All the Password requirement been handled with the help of "checkNewPassword" method. Returns true if the password is valid.
- Similarity - password is not similar to old password < 80% match: This has been handled with the help of LevenshteinDistance alogorithm.
- Apart from these similar password check has been added.

Data:
- Data is getting fetched from an Excel file(Excel Utils), we have seperate data for all the tests.

Logging:
- I have added Console output - so that the user can see the password requirement/issue/message.
