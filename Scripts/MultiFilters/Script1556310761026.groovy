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
 * To test more than one filters this test case select column and filter
 * e.g. greater than, less than, equal for it. Then selects another one
 * and applies filter for it. Finaly the test checks
 * the values in the rows present in the grid after filtering.
 */

'Open browser.'
WebUI.openBrowser('')

'Load URL.'
WebUI.navigateToUrl(GlobalVariable.baseURL)


'Click the button to invoke column setting menu for certain column.'
WebUI.click(findTestObject('MvcApp/a_Column Settings for Freight'))

'Click the menu for Filter.'
WebUI.mouseOver(findTestObject('MvcApp/span_Filter'))

'Wait for the subemnu frame with filter options to be visible.'
WebUI.waitForElementVisible(findTestObject('MvcApp/span_Is equal to'), 5)

'Wait for the subemnu frame with filter options to be clickable.'
WebUI.waitForElementClickable(findTestObject('MvcApp/span_Is equal to'), 5)

'Click on option Is equal to.'
WebUI.click(findTestObject('MvcApp/span_Is equal to'))

'Click on option Is greater than.'
WebUI.click(findTestObject('MvcApp/li_Is greater than'))

'Wait for filter value up or down arrow to be visible.'
WebUI.waitForElementVisible(findTestObject('MvcApp/span_Filter up arrow'),5)

'Click up arrow N times to set the value N'
for(def i=0;i<filterValues;i++){
	WebUI.click(findTestObject('MvcApp/span_Filter up arrow'))
}

'Click the filter button to apply the filter settings.'
WebUI.click(findTestObject('MvcApp/button_Filter'))

'Click the button to invoke column setting menu for certain column.'
WebUI.click(findTestObject('MvcApp/a_Column Settings for Ship Name'))

'Click the menu for Filter.'
WebUI.mouseOver(findTestObject('MvcApp/span_Filter2'))

'Wait for the subemnu frame with filter options to be visible.'
WebUI.waitForElementVisible(findTestObject('MvcApp/span_Is equal to2'), 5)

'Wait for the subemnu frame with filter options to be clickable.'
WebUI.waitForElementClickable(findTestObject('MvcApp/span_Is equal to2'), 5)

'Click on option Is equal to.'
WebUI.click(findTestObject('MvcApp/span_Is equal to2'))

'Click on option Contains.'
WebUI.click(findTestObject('MvcApp/li_Contains'))

'Enter text to filter for.'
WebUI.setText(findTestObject('MvcApp/input_Filter textbox2'), filterText)

'Click the filter button to apply the filter settings.'
WebUI.click(findTestObject('MvcApp/button_Filter2'))

'Iterate through all presented rows in the grid.'
while (WebUI.waitForElementPresent(findTestObject('MvcApp/td_Dynamic',[('testRow'):filterRow,('testCol'):filterCol]),5,FailureHandling.CONTINUE_ON_FAILURE))
{
	'Check filter by "Is grater than" is working for numeric values by comparing filtered cells in the grid with the filtered number.'
	WebUI.verifyGreaterThan(Integer.parseInt(WebUI.getText(findTestObject('MvcApp/td_Dynamic',[('testRow'):filterRow,('testCol'):filterCol]))), filterValues)
	
	'Check filter by "Contains" is also applied for text values by comparing filtered cells in the grid with the filtered number.'
	assert (WebUI.getText(findTestObject('MvcApp/td_Dynamic',[('testRow'):filterRow,('testCol'):filterColTxt])).contains(filterText))
	
	filterRow=filterRow+1
	
}
