package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//Data provider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException {
	String path = ".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testData
	
	ExcelUtility xlutil = new ExcelUtility(path); //crate an object for xlutility
	int totalrows = xlutil.getRowCount("Sheet1");
	int totalcols = xlutil.getCellCount("Sheet1", 1);
	
	String logindata[][] = new String [totalrows][totalcols];//Created for two dimensions array which can store login data
	for(int i=1; i<=totalrows;i++) //1 //read the data from xl and storing in two dimenssional array
	{
		for(int j=0; j<totalcols; j++) //0 i is row and j is column
		{
			logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
		}
	
	}
	  return logindata; //returning two dimension array
	
	}
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4

}
