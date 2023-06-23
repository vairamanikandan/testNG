package testNG1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pojosample extends baseclass {
	public pojosample() {
		PageFactory.initElements( driver, this);
	}

  	@FindBy(id = "inputEmail")
	private WebElement email;

	@FindBy(xpath = "//input[@name='inputPassword']")
	private WebElement password;

	@FindBy(name = "SIGN IN")
	private WebElement signin;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignin() {
		return signin;
	}

}
