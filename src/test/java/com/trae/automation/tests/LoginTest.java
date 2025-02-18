package com.trae.automation.tests;

import com.trae.automation.base.BaseTest;
import com.trae.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "password123");
    }
}