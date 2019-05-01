import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*
 * To test the option to show and hide some columns in the grid.
 * After each action the column visibility is checked.
 */

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.click(findTestObject('Object Repository/MvcApp/a_Column Settings for OrderID'))

WebUI.click(findTestObject('Object Repository/MvcApp/span_Columns'))

WebUI.mouseOverOffset(findTestObject('Object Repository/MvcApp/span_Columns'),20,20)

WebUI.waitForElementVisible(findTestObject('MvcApp/input_OrderID Hide Show'),5)

WebUI.waitForElementClickable(findTestObject('MvcApp/input_OrderID Hide Show'),5)

WebUI.click(findTestObject('MvcApp/input_OrderID Hide Show'))

WebUI.verifyElementNotVisible(findTestObject('Object Repository/MvcApp/a_Order ID'))

WebUI.click(findTestObject('MvcApp/input_Freight Hide Show'))

WebUI.verifyElementNotVisible(findTestObject('Object Repository/MvcApp/a_Freight'))

WebUI.click(findTestObject('MvcApp/input_OrderID Hide Show'))

WebUI.verifyElementVisible(findTestObject('Object Repository/MvcApp/a_Order ID'))

WebUI.click(findTestObject('Object Repository/MvcApp/a_Order ID'))

WebUI.closeBrowser()

