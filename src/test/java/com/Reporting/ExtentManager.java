package com.Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("DemoWeb Shop Test Validation Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Application", "Demo Webshop");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Author", "Jwala");
        return extentReports;
    }
}
