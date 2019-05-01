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
 * To test different type of menu items like
 * inactive, active, with menu items, liked to external link.
 * Every type of menu item is checked by its specific properties.
 */

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.baseURL)

WebUI.verifyElementVisible(findTestObject('MvcApp/span_Menu - inactive'))

'The verification below is not working, as the element actully is NOT cliable'
WebUI.verifyElementClickable(findTestObject('MvcApp/span_Menu - inactive'),FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('MvcApp/span_Menu Item 5'))

WebUI.verifyElementClickable(findTestObject('MvcApp/span_Menu Item 5'))

WebUI.verifyElementVisible(findTestObject('MvcApp/span_Menu Item 2 - Children'))

WebUI.mouseOverOffset(findTestObject('MvcApp/span_Menu Item 2 - Children'),15,15)

WebUI.verifyElementClickable(findTestObject('MvcApp/span_Menu Item 2 - Children'))

WebUI.verifyElementPresent(findTestObject('MvcApp/span_Submenu Item 21'),5)

WebUI.verifyElementClickable(findTestObject('MvcApp/span_Submenu Item 21'))

WebUI.verifyElementVisible(findTestObject('MvcApp/a_Menu Item 1 - External Link'))

WebUI.verifyElementClickable(findTestObject('MvcApp/a_Menu Item 1 - External Link'))

WebUI.verifyElementAttributeValue(findTestObject('MvcApp/a_Menu Item 1 - External Link'),'href','https://docs.telerik.com/aspnet-mvc/helpers/menu/overview',5)

WebUI.closeBrowser()

