package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginSteps {

    @Given("User is at the login page")
    public void user_is_at_the_login_page() {
        BasicRunner.driver.get("http://127.0.0.1:5500/login.html");
    }

    @When("User types in a username of {string}")
    public void user_types_in_a_username_of(String username) {
        WebElement usernameInput = BasicRunner.driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);
    }

    @When("User types in a password of {string}")
    public void user_types_in_a_password_of(String password) {
        WebElement passwordInput = BasicRunner.driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        WebElement loginButton = BasicRunner.driver.findElement(By.xpath("//button[text()='submit']"));
        loginButton.click();
    }

    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() throws InterruptedException {
        Thread.sleep(1000);
        String actualUrl = BasicRunner.driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, "http://127.0.0.1:5500/homepage.html");
    }

    @Then("User should receive a popup alert saying {string}")
    public void user_should_receive_a_popup_alert_saying(String expectedAlertText) throws InterruptedException {
        Thread.sleep(1000);
        String actualAlertText = BasicRunner.driver.switchTo().alert().getText();

        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

}
