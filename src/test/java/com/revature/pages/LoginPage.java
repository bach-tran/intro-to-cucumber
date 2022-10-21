package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object Model design pattern
// Page object model is a design pattern that aims to reduce redundancy in having to always write code that will find
// the same element over and over in different test cases and/or steps (in the case of cucumber)

// Ex. Imagine you have 1000 test cases, and all 1000 test cases utilize the same WebElement
// A frontend developer comes along and changes the id of the element, which is what we were using to locate the element
// 1000 test cases are now broken. To fix it, we must go one-by-one through each broken test case and update the locator
// to reflect the change made to the id of the element

// If we were using the page object model design pattern, this would've been avoided, because we only need to update
// the locator in one single location
public class LoginPage {

    @FindBy(id="username")
    public WebElement usernameInput;

    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy(xpath="//button[text()='submit']")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        // PageFactory: A feature of Selenium that reduces the need to use findElement by introducing the @FindBy annotation
        PageFactory.initElements(driver, this); // This will go and utilize the @FindBy annotations and get
        // the elements automatically for us
    }

}
