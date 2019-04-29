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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.click(findTestObject('MvcApp/a_Column Settings for Ship Name'))

WebUI.click(findTestObject('MvcApp/span_Sort Ascending'))

smallestValue = WebUI.getText(findTestObject('MvcApp/td_4'))

WebUI.click(findTestObject('MvcApp/a_Column Settings for Ship Name'))

WebUI.click(findTestObject('MvcApp/span_Sort Descending'))

biggestValue = WebUI.getText(findTestObject('MvcApp/td_4'))

WebUI.verifyGreaterThanOrEqual(biggestValue.compareTo(smallestValue), 0)

