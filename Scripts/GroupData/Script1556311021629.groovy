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
 * To group data by values of some of the columns.
 * First a column is filtered, then the data in it is grouped.
 * Finaly the test checks a header for grouped data is visible.
 */

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

'Filter column to contain text.'
WebUI.click(findTestObject('MvcApp/a_Column Settings for Ship Name'))

WebUI.mouseOver(findTestObject('MvcApp/span_Filter'))

WebUI.waitForElementVisible(findTestObject('MvcApp/span_Is equal to'), 5)

WebUI.waitForElementClickable(findTestObject('MvcApp/span_Is equal to'), 5)

WebUI.click(findTestObject('MvcApp/span_Is equal to'))

WebUI.click(findTestObject('MvcApp/li_Contains'))

WebUI.setText(findTestObject('MvcApp/input_Filter textbox'), '5')

WebUI.click(findTestObject('MvcApp/button_Filter'))

'Drag and drop the column to group by it.'
WebUI.dragAndDropToObject(findTestObject('Object Repository/MvcApp/a_Ship Name'), findTestObject('Object Repository/MvcApp/div_Area to Group By'))

'Check grouping is done by the group header title.'
WebUI.verifyElementVisible(findTestObject('MvcApp/p_Grouped Items Header'))

