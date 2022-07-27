package com.accesshq.web.utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Execution-Report/Extent-Report/Report.html");
        reporter.config().setReportName("Execution Report");
        reporter.config().setDocumentTitle("Execution Report");
        extentReports.setSystemInfo("Company Name", "AccessHQ");
        extentReports.setSystemInfo("Author", "Kavindu Dilshan");
        reporter.config().setTheme(Theme.STANDARD);
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
