package com.accesshq.web.tests;

import com.accesshq.web.pages.PG_Common;
import com.accesshq.web.utils.data.DataReader;
import com.accesshq.web.utils.data.LoginDataReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.accesshq.web.utils.report.ExtentTestManager.startTest;

public class TestSuite extends TestFunctions {

    LoginDataReader loginDataReader = new LoginDataReader();

    @DataProvider(name = "dt_01")
    public Object[][] dataTable_tc_01() {
        return DataReader.readExcel("tc_01");
    }

    @Test(dataProvider = "dt_01")
    public void tc_01(String tc_ID) {
        startTest(tc_ID, "Validate Login and Profile Validation");
        bc_Login(loginDataReader.getPropertyValue("url"),loginDataReader.getPropertyValue("Username"),loginDataReader.getPropertyValue("Password"));
        bc_VerifyHomePageAndLogout();

    }

    @DataProvider(name = "dt_02")
    public Object[][] dataTable_tc_02() {
        return DataReader.readExcel("tc_02");
    }

    @Test(dataProvider = "dt_02")
    public void tc_02(String tc_ID) {
        startTest(tc_ID, "Validate Order Count and Item Subtotal");
        bc_Login(loginDataReader.getPropertyValue("url"),loginDataReader.getPropertyValue("Username"),loginDataReader.getPropertyValue("Password"));
        bc_PlaceAnOrder();
        bc_CalculateTotal();
    }

}
