package week5.day2assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelServiceNow {
	public static String[][] getData(String filename) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./TestData/"+filename+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		XSSFRow header = sheet.getRow(0);
		int colCount = header.getLastCellNum();
		String[][] data= new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				String scellval = cell.getStringCellValue();
				data[i-1][j]=scellval;
			}
		}
		return data;
	}

}
