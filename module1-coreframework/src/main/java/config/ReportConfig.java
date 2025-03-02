package config;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
public class ReportConfig {

    public static void generateReport() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "target/cucumber-reports/" + timeStamp;

        File reportOutputDirectory = new File(reportPath);
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/cucumber.json");

        Configuration config = new Configuration(reportOutputDirectory, "ProjectName");
        // Add metadata to the report
        config.addClassifications("Platform", System.getProperty("os.name"));
        config.addClassifications("Environment", "QA");

// Capture browser details dynamically
        String browser = System.getProperty("browser", "Chrome"); // Default is Chrome
        config.addClassifications("Browser", browser);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        reportBuilder.generateReports();
    }



}
