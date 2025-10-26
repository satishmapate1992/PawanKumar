package listener_ExtentReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public WebDriver driver;

	public void onStart(ITestContext context) {
		//sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/extentreport.html");
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportsDir = System.getProperty("user.dir") + File.separator + "reports";
        new File(reportsDir).mkdirs();

        String reportPath = reportsDir + File.separator + "ExtentReport_" + timestamp + ".html";
        sparkReporter = new ExtentSparkReporter(reportPath);
        
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Regression Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("User", System.getProperty("user.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.PASS, result.getName()+" Test case passed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, result.getName()+" Test case failed");
		test.log(Status.FAIL, result.getThrowable().getMessage()+" Test case failed");

        // If WebDriver is available, capture screenshot
		 Object driverObject = result.getTestContext().getAttribute("WebDriver");
		 if (driverObject instanceof WebDriver) {
		        driver = (WebDriver) driverObject;
		        String screenshotPath = TakeScreenShot.captureScreenShot(driver, result.getMethod().getMethodName());
		        test.addScreenCaptureFromPath(screenshotPath);
		    } else {
		        System.out.println("WebDriver not found in context.");
		    }
        
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, result.getName()+" Test case Skip");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
