package com.sevenrmartsupermarket.pages;

	import java.util.Date;
	import java.text.SimpleDateFormat;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.sevenrmartsupermarket.utilities.PageUtility;



	public class ManageDeliveryBoyPage {

		WebDriver driver;
		Properties properties = new Properties();
		PageUtility pageUtility  = new PageUtility(driver);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7)); 
		
		//@FindBy(xpath = "//a[contains(text(),'New')]")
//		@FindBy(xpath = "//div//a[contains(@class, 'btn-danger') and contains(@href, 'Deliveryboy/add')]")
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
		WebElement newLink;
		@FindBy(xpath = "//input[@id='name']")
		WebElement nameField;
		@FindBy(xpath = "//input[@id='email']")
		WebElement emailField;
		@FindBy(xpath = "//input[@id='phone']")
		WebElement phoneNumberField;
		@FindBy(xpath = "//textarea[@id='address']")
		WebElement addressField;
		@FindBy(xpath = "//input[@id='username']")
		WebElement usernameField;
		@FindBy(xpath = "//input[@id='password']")
		WebElement passwordField;
		@FindBy(xpath = "//button[@name='create']")
		WebElement savebutton;
		@FindBy(xpath = "//a[@type='button']")
		WebElement cancel;
		@FindBy(xpath="//tbody/tr[1]/td[6]//span")
		WebElement active;
		
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
		WebElement successMessge;

		public ManageDeliveryBoyPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}

		public void clickOnAddNewDeliveryboy()  {
			//wait.until(ExpectedConditions.visibilityOf(newLink));
			newLink.click();
			 System.out.println("Clicked on Add New Delivery Boy.");
		
		}

		public void enterName(String Name) {
			nameField.sendKeys(Name);
			  System.out.println("Entered Name: " + Name);
		}

		public void enterEmail(String email) {
			emailField.sendKeys(email);
			   System.out.println("Entered Email: " + email);	
		}

		public void enterPhoneNumber(String PhNo) {
			phoneNumberField.sendKeys(PhNo);
			  System.out.println("Entered Phone Number: " + PhNo);
			
		}

		public void enterAddress(String addr) {
			addressField.sendKeys(addr);
			System.out.println("Entered Address: " + addr);
			
		}

		public void enterUsername(String User_name) {
			usernameField.sendKeys(User_name);
			   System.out.println("Entered Username: " + User_name);
			   
		}

		public void enterPassword(String pass_word) {
			passwordField.sendKeys(pass_word);
			System.out.println("Entered Password: " + pass_word);
			
		}
		/*public void scrollpage() {
			pageUtility  = new PageUtility(driver);
			pageUtility.scrolldown(savebutton);
			  System.out.println("Scrolled down");
			
		}*/
		
		public void scrollpage() {
			pageUtility  = new PageUtility(driver);
			pageUtility.mouse_move(savebutton);
		}


		public void clickonSave() {
			
			savebutton.click();
			System.out.println("savebutton");
		}
		
		
		
		public void enterdeliveryboyinfo(String Name, String email, String PhNo,String addr,String User_name,String pass_word)  {
			clickOnAddNewDeliveryboy();
			enterName(Name);
			enterEmail(email);
			enterPhoneNumber(PhNo);
			enterAddress(addr);
			enterUsername(User_name);
			enterPassword(pass_word);
			scrollpage() ;
			clickonSave();
		}
		


		public String  getsucsefullmessagetxt() {
			String  message=successMessge.getText().trim();
			System.out.println(message);
			return message;		
			
	}
		/* public String getTimestamp() {
			 LocalDateTime currentDateTime = LocalDateTime.now();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
			 String formattedDateTime = currentDateTime.format(formatter);
			return formattedDateTime;

		    }  */

		 public String getTimestamp() {
			 String timeStamp = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(new Date());
			return timeStamp;

		    } 
			
		}

