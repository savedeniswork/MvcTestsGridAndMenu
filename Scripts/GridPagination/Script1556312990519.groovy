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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By

/*
 * To test pagination this test case switch on different pages
 * and counts the rows in each page grid and checks they are less
 * than the page numbers configured. Finally the system checks 
 * the pagination label.
 */
'Open browser.'
WebUI.openBrowser('')

'Load URL.'
WebUI.navigateToUrl(GlobalVariable.baseURL)

'Click the button arrow to go to the last page in the grid.'
WebUI.click(findTestObject('MvcApp/span_k-icon k-i-arrow-end-right'))

'Find all elements that are rows in the grid and asign the array of elements to gridRows variable.'
gridRows = DriverFactory.getWebDriver().findElements(By.xpath('//tbody[@role=\'rowgroup\']/tr'))

'Count the size of the gridRows array, to calculate the total number of rows in the grid.'
totalGridRows = gridRows.size()

'Check that the total rows shown in the grid are less that the configured (e.g. 20).'
assert totalGridRows <= configPage

'Click the button arrow to go to the first page in the grid.'
WebUI.click(findTestObject('MvcApp/span_k-icon k-i-arrow-end-left'))

'Check the paginationn is 20 items per page, hence the label is from 1 to 20'
WebUI.verifyElementPresent(findTestObject('MvcApp/span_1 - 20 page label'), 5)

'Find all elements that are rows in the grid and asign the array of elements to gridRows variable.'
gridRows = DriverFactory.getWebDriver().findElements(By.xpath('//tbody[@role=\'rowgroup\']/tr'))

'Count the size of the gridRows array, to calculate the total number of rows in the grid.'
totalGridRows = gridRows.size()

'Check that the total rows shown in the grid are less that the configured (e.g. 20).'
assert totalGridRows <= configPage

'Click the button arrow to go to the next page in the grid.'
WebUI.click(findTestObject('MvcApp/span_k-icon k-i-arrow-right'))

'Find all elements that are rows in the grid and asign the array of elements to gridRows variable.'
gridRows = DriverFactory.getWebDriver().findElements(By.xpath('//tbody[@role=\'rowgroup\']/tr'))

'Count the size of the gridRows array, to calculate the total number of rows in the grid.'
totalGridRows = gridRows.size()

'Check that the total rows shown in the grid are less that the configured (e.g. 20).'
assert totalGridRows <= configPage

'Click the button arrow to go to the previous page in the grid.'
WebUI.click(findTestObject('MvcApp/a_k-link k-pager-nav'))

'Find all elements that are rows in the grid and asign the array of elements to gridRows variable.'
gridRows = DriverFactory.getWebDriver().findElements(By.xpath('//tbody[@role=\'rowgroup\']/tr'))

'Count the size of the gridRows array, to calculate the total number of rows in the grid.'
totalGridRows = gridRows.size()

'Check that the total rows shown in the grid are less that the configured (e.g. 20).'
assert totalGridRows <= configPage

'Close browser'
WebUI.closeBrowser()

