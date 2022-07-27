package com.accesshq.web.pages;

public class PG_Common {

    public static String lnk_Common(String identifier) {
        return "//a[text()='"+identifier+"']";
    }

    public static String lbl_CommonByText(String identifier) {
        return "//div[text()='"+identifier+"']";
    }

    public static String lbl_HeaderH4(String identifier) {
        return "//h4[text()='"+identifier+"']";
    }

    public static String lbl_HeaderH3(String identifier) {
        return "//h3[text()='"+identifier+"']";
    }

    public static String lbl_HeaderH2(String identifier) {
        return "//h2[text()='"+identifier+"']";
    }

    public static String lbl_DivCommonByText(String identifier) {
        return "//div[text()='"+identifier+"']";
    }

    public static String btn_CommonByText(String identifier) {
        return "//span[text()='"+identifier+"']";
    }

    public static String btn_CommonBySpanText(String identifier) {
        return "//span[text()='"+identifier+"']";
    }
}
