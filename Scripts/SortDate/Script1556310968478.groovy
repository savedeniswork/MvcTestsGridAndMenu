import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testdata.TestData as TestData

/*
 * To test sorting by date this test case sorts ascending and descending
 * and saves the value in the first row in the grid.
 * Hence the smalles and the biggest. Finaly the test compares the values
 * to check the sorting is working.
 */

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.click(findTestObject('MvcApp/a_Column Settings for Order Date'))

WebUI.click(findTestObject('MvcApp/span_Sort Ascending'))

smallestValue = WebUI.getText(findTestObject('MvcApp/td_3'))

WebUI.click(findTestObject('MvcApp/a_Column Settings for Order Date'))

WebUI.click(findTestObject('MvcApp/span_Sort Descending'))

biggestValue = WebUI.getText(findTestObject('MvcApp/td_3'))

WebUI.verifyGreaterThanOrEqual(biggestValue.compareTo(smallestValue), 0)


