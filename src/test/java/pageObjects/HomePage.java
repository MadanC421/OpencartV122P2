package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//First Page Object Class
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement  lnkMyAccount;

	@FindBy(xpath="(//a[normalize-space()='Register'])[1]")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login") // Login link added in step5
	WebElement linkLogin;
	
		

public void clickMyAccount()
{
	lnkMyAccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin()
{
	linkLogin.click();
}


}

