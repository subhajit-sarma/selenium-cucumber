package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtilities {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null){
            ExtentSparkReporter spark = new ExtentSparkReporter("target/exten-report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
