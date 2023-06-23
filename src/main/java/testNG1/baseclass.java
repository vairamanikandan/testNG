package testNG1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class baseclass {

	public static WebDriver driver;

	public static void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void WindowMaximize() {
		driver.manage().window().maximize();

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void closeEntireBrowser() {
		driver.quit();

	}

	public static void clickBtn(WebElement ele) {
		ele.click();
	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location + imgName.png");
		FileUtils.copyFile(image, f);

	}

	public static Actions a;

	public static void moveTheCursor(WebElement tarWebElement) {
		a = new Actions(driver);
		a.moveToElement(tarWebElement).perform();
	}

	public static void dragDrop(WebElement dragElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragElement, dropElement).perform();
	}

	public static JavascriptExecutor js;

	public static void ScrollThePage(WebElement tarEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarEle);

	}

	public static void ScrollThePage1(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excellocation.xsxl");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("data");
		Row row1 = mysheet.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNum);
		int cellType = cell1.getCellType();

		String value = "";
		if (cellType == 1) {
			String Value = cell1.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell1)) {
			Date dd = cell1.getDateCellValue();
			SimpleDateFormat mm = new SimpleDateFormat();
			String format = mm.format(dd);

		}

		else {
			double d = cell1.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}

	}

	public static void createNameExcel(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File(writeData);
		Workbook mnk = new XSSFWorkbook();
		Sheet newsheet = mnk.createSheet();
		Row newRow = newsheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		mnk.write(fos);

	}

	public static void createcell(int getTheRow, int getTheCell, String exisitingdata,String writenewdata) throws IOException {
		File f = new File("excel location.xsxl");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet cresheet = wb.getSheet("data");
		Row crerow = cresheet.getRow(getTheRow);
		Cell crecell = crerow.getCell(getTheCell);
		String sCV = crecell.getStringCellValue();
		if (sCV.equals(exisitingdata)) {
			crecell.setCellValue(writenewdata);
		}
		FileOutputStream fg = new FileOutputStream(f);
		wb.write(fg);
	}
public static void main(String[] arg) throws IOException  {
		
		File f = new File("C:\\Users\\vaira\\OneDrive\\Desktop\\collection\\seleniuminmakes\\New folder\\datadriven\\excel\\newfile.xsxl");
		
		Workbook w = new XSSFWorkbook();
		Sheet createsht = w.createSheet("datas");
		Row newRow = createsht.createRow(0);
		createsht.getRow(0).createCell(0).setCellValue("Selenium");
		createsht.getRow(0).createCell(1).setCellValue("java");
		createsht.getRow(0).createCell(2).setCellValue("Data Driven");
		createsht.getRow(0).createCell(3).setCellValue("POM");
				
		createsht.createRow(1);
		createsht.getRow(1).createCell(0).setCellValue("Appium");
		createsht.getRow(1).createCell(1).setCellValue("Cucumber");
		createsht.getRow(1).createCell(2).setCellValue("Junit");
		createsht.getRow(1).createCell(3).setCellValue("TestNG");
		FileOutputStream mnb = new FileOutputStream(f);
		w.write(mnb);
		
	}
}
