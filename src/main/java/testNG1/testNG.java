package testNG1;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNG  extends baseclass{
	@BeforeClass
	private void launchthebrowser() {
		launchbrowser();
		WindowMaximize();

	}
@Test(priority = -2)
public void tc1() {
	launchUrl("https://www.redbus.in/");
	
	//pojosample f = new pojosample();
	//passText("vairamani",f.getEmail());
	//passText("12345", f.getPassword());

}
@Test(priority = 5)
//(invocationCount = 4)
public void tc2() {
	launchUrl("https://www.google.com/intl/en_in/gmail/about/");

}
@Test(priority = -51)
//(invocationCount = 4)
public void tc6() {
	launchUrl("https://www.inmakes.com/");

}
@Test(priority = 56)
//(invocationCount = 4)
public void tc3() {
	launchUrl("https://www.flipkart.com/");

}
@Test(priority = -7)
//(invocationCount = 4)
public void tc5() {
	launchUrl("https://www.amazon.in/");

}
@Test(priority = 9)
//(invocationCount = 4)
public void tc4() {
	launchUrl("https://www.facebook.com/");

}
@Test(priority = -26)
//(invocationCount = 4)
public void tc7() {
	launchUrl("https://www.youtube.com/");

}
//@Test
//(enabled = false)
//public void tc3() {
	//launchUrl("https://www.google.com/intl/en_in/gmail/about/");

//}

//@BeforeMethod
//private void startdate() {
	//Date d = new Date();
	//System.out.println(d);
	

//}

//@AfterMethod
//private void enddate() {
	//Date d = new Date();
	//System.out.println(d);

//}


//@AfterClass
//private void closebrowser() {
	//System.out.println( "browser close");

//}
}
