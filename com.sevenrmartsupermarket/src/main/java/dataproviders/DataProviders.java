package dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.Excel;

public class DataProviders {
	
	Excel excel= new Excel();


	@DataProvider(name="sevenmartsupermarket")
	public Object[][] login()
	{
		return new Object [][] {{"anwr","Man"},{"Gigo","Jijo"},{"Jesica","Manu"}};
	}
	
	@DataProvider(name="multilogin")
	public Object[][]adminlogin(){
	
		excel.setExcelFile("LoginData", "adminuser");
		return excel.getMultidimentionalData(3, 2);
	
	}
}