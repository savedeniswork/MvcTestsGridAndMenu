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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By

/*
 * To test pagination this test case switch on different pages
 * and counts the rows in each page grid and checks they are less
 * than the page numbers configured. Finally the system checks 
 * the pagination label.
 */

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.click(findTestObject('MvcApp/span_k-icon k-i-arrow-end-right'))

gridRows = DriverFactory.getWebDriver().findElements(By.xpath("//tbody[@role='rowgroup']/tr"))

totalGridRows=gridRows.size()

assert (totalGridRows<=20)
 
WebUI.click(findTestObject('MvcApp/span_k-icon k-i-arrow-end-left'))

gridRows = DriverFactory.getWebDriver().findElements(By.xpath("//tbody[@role='rowgroup']/tr"))

totalGridRows=gridRows.size()

assert (totalGridRows<=20)

WebUI.click(findTestObject('MvcApp/span_k-icon k-i-arrow-right'))

gridRows = DriverFactory.getWebDriver().findElements(By.xpath("//tbody[@role='rowgroup']/tr"))

totalGridRows=gridRows.size()

assert (totalGridRows<=20)

WebUI.click(findTestObject('MvcApp/a_k-link k-pager-nav'))

gridRows = DriverFactory.getWebDriver().findElements(By.xpath("//tbody[@role='rowgroup']/tr"))

totalGridRows=gridRows.size()

assert (totalGridRows<=20)

//Check the pagination label is from 1 to 20
WebUI.verifyElementPresent(findTestObject('MvcApp/span_1 - 20 page label'),5)

WebUI.closeBrowser()

