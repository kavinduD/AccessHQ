package com.accesshq.web.tests;

import com.aventstack.extentreports.Status;
import com.accesshq.web.pages.*;
import com.accesshq.web.utils.report.ExtentTestManager;
import com.accesshq.web.utils.wrappers.KeyBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class TestFunctions extends KeyBase {
	
	public static void bc_Login(String url, String Username, String Password) {
        writeToReport("Login scenario started");
        navigateToURL(url);
        writeToReport("Successfully Navigated to: "+url+".");
        click(PG_Home.lbl_Person());
        pause(4000);
        type(PG_Login.tf_Username(),Username);
        type(PG_Login.tf_Password(),Password);
        click(PG_Login.btn_Signin());
        pause(4000);
        writeToReport("Login scenario ended");
    }

    public static void bc_VerifyHomePageAndLogout() {
            writeToReport("Verify Home screen started");
            pause(5000);
            click(PG_Home.lbl_Person());
            isDisplayed(PG_Home.lbl_WelcomeBob());
            String pageUrl = driver.getCurrentUrl();
            click(PG_Home.lbl_Person());
            click(PG_Home.btn_Logout());
            click(PG_Common.btn_CommonByText("Yes"));
            pause(5000);
            navigateToURL(pageUrl);
            isDisplayed(PG_Home.lbl_Home());
            writeToReport("Verify Home screen ended");
    }

    public static void bc_PlaceAnOrder() {
            writeToReport("Place an order scenario started");
            click(PG_Home.lbl_Menu());
            click(PG_Menu.ele_Tab("Drinks"));
            //Click on Espresso Thickshake
            click(PG_Menu.ele_OrderITemByText("Espresso Thickshake"));
            click(PG_Menu.ele_Tab("Pizzas"));
            // Click on Margherita
            click(PG_Menu.ele_OrderITemByText("Margherita"));
            pause(4000);
            click(PG_Menu.ele_OrderITemByText("Margherita"));
            pause(4000);
            isDisplayed(PG_Menu.ele_MenuItemsNumber("3"));
            click(PG_Menu.ele_OrderNavigationMenuIcon());


            writeToReport("Place an order scenario ended");
    }

    public static void bc_CalculateTotal() {
            writeToReport("Calculate Order scenario started");
            String EspressoThickshake = getText(PG_Menu.lbl_SubTotal("Espresso Thickshake"));
            String Margherita = getText(PG_Menu.lbl_SubTotal("Margherita"));
            double EspressoThickshakeNo=Double.parseDouble(EspressoThickshake);
            double MargheritaNo=Double.parseDouble(Margherita);

            Double Total = EspressoThickshakeNo + MargheritaNo;
            isDisplayed(PG_Menu.lbl_Total(Total.toString()));

        writeToReport("Calculate Order scenario ended");
    }
}
