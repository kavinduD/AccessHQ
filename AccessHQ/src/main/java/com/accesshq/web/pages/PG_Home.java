package com.accesshq.web.pages;

public class PG_Home {
    public static String lbl_WelcomeBob() {
        return "//h2[contains(normalize-space(),'Welcome')]/em[text()='bob']";
    }

    public static String btn_Logout() {
        return "(//div[text()='Logout'])[last()]";
    }

    public static String lbl_Home() {
        return "//span[contains(normalize-space(),'Home')]";
    }

    public static String lbl_Person() {
        return "//i[text()='person']";
    }

    public static String lbl_Menu() {
        return "//span[contains(normalize-space(),'Menu')]";
    }

}
