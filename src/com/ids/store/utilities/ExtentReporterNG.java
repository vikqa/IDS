package  com.ids.store.utilities;

import java.io.File;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	int count = 0;

	
	@Override
	public synchronized void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
				
		
		extent = new ExtentReports(outputDirectory + File.separator + "Automation_Report.html", true);
	extent.loadConfig(new File(".\\extent-config.xml"));
		extent.addSystemInfo("Selenium Version", "3.0.0");
		extent.addSystemInfo("Environment", "Vikas System");
		extent.addSystemInfo("Created By", "IDS infotech");

		for (ISuite suite : suites) {
			
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				count = result.size();
				ITestContext context = r.getTestContext();
				String con = context.getName();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS, con);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL, con);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP, con);
			}
		}
		
		extent.flush();
		extent.close();
	//EmailHelper mail = new EmailHelper();
	//mail.sendMailToManagement();	
	//mail.sendMailToUsers();
	
	}

	private void buildTestNodes(IResultMap tests, LogStatus status, String con) {
		
		ExtentTest test;

		
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest( result.getMethod().getMethodName(),result.getMethod().getDescription());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				if (count > 1) {					
					for (String group : result.getMethod().getGroups())
						test.assignAuthor(group);
					test.assignCategory(con);
				} else {					
					for (String group : result.getMethod().getGroups())
						test.assignAuthor(group);
					test.assignCategory(con);
					
				}

				String path = result.getAttribute("imagePath").toString();
				// if(!path.isEmpty()){
				String image = test.addScreenCapture(path);
				if (result.getStatus() == ITestResult.FAILURE) {
					
					test.log(status, image, result.getThrowable());
				} else if (result.getStatus() == ITestResult.SKIP) {
					test.log(status, "Test skipped " + result.getThrowable());

				} else {
					test.log(status, image, "Test passed ");
				}

				// }else{
				// if (result.getStatus() == ITestResult.FAILURE) {
				// test.log(status, result.getThrowable());
				// } else if (result.getStatus() == ITestResult.SKIP) {
				// test.log(status, "Test skipped " + result.getThrowable());
				//
				// } else {
				// test.log(status, "Test passed ");
				// }
				// }

				extent.endTest(test);

			
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
