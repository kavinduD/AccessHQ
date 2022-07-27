package com.accesshq.web.pages;

public class PG_Menu {
    public static String ele_Tab(String TabItemName) {
        return "//div[contains(normalize-space(),'"+TabItemName+"')]/i";
    }

    public static String ele_OrderITemByText(String OrderItemName) {
        return "//span[text()='"+OrderItemName+"']/../../../following-sibling::div//span[text()='Order']";
    }

    public static String ele_MenuItemsNumber(String MeniItemsNumber) {
        return "(//span[@class='order-count' and text()='"+MeniItemsNumber+"'])[1]";
    }

    public static String ele_OrderNavigationMenuIcon() {
        return "//div[contains(@class,'down')]//i[text()='room_service']";
    }

    public static String lbl_SubTotal(String OrderItemName) {
        return "//td[text()='"+OrderItemName+"']/following-sibling::td[@class='text-right']";
    }

    public static String lbl_Total(String Total) {
        return "//strong[@class='order-total display-1 mt-1' and text()='Total: "+Total+"']";
    }

}
