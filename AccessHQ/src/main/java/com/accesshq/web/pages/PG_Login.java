package com.accesshq.web.pages;

public class PG_Login {
    public static String lbl_Header() {
        return "//h3";
    }

    public static String tf_Username() {
        return "//label[text()='Username']/following-sibling::input";
    }

    public static String tf_Password() {
        return "//label[text()='Password']/following-sibling::input";
    }

    public static String btn_Signin() {
        return "//span[text()='Login']";
    }
}
