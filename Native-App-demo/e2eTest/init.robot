*** Settings ***
Documentation     A resource file with reusable keywords and variables.
...
...               The system specific keywords created here form our own
...               domain specific language. They utilize keywords provided
...               by the imported SeleniumLibrary.
Library           Appiumlibrary

Suite Setup       Open Native App
#Suite Teardown    Close Application

*** Variables ***
${SERVER}         0.0.0.0:4723
${BROWSER}        Chrome
${DELAY}          0
${BASE URL}       http://${SERVER}/wd/hub
${platformName}     iOS
${platformVersion}    11.1
${deviceName}     iPhone 8 Plus
${automationName}   XCUITest
${app}   /Users/Hong/Library/Developer/Xcode/DerivedData/TestApp-brzmicadfkdgmkbqhquyfxiyidmm/Build/Products/Debug-iphonesimulator/TestApp.app
${element_one}   xpath=//XCUIElementTypeTextField[@name="IntegerA"]
${element_two}   xpath=//XCUIElementTypeTextField[@name="IntegerB"]
${sum_button}   xpath=//XCUIElementTypeButton[@name="ComputeSumButton"]
*** Test Cases ***
Test Cumpate Sum
  [documentation]  test case 1
  Input Text   ${element_one}   1
  Input Text   ${element_two}   2
  Click Element  ${element_two}
  Element Text Should Be  ${sum_button}  3



*** Keywords ***
Open Native App
    [documentation]   open native app
    Open Application  ${BASE URL}  platformName=${platformName}  platformVersion=${platformVersion}
    ...  deviceName=${deviceName}  app={app}