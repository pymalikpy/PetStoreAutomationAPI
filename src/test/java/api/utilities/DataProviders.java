package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
public class DataProviders {


    @DataProvider(name="Data")
    public Object[][] getAllData() throws IOException
    {
        String path = System.getProperty("user.dir") + "//testData//api_test_data.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1");
        int colcount = xl.getCellCount("Sheet1", 1);

        Object[][] apiData = new Object[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                apiData[i - 1][j] = xl.getCellData("Sheet1", i, j);
            }
        }
        return apiData;
    }
    @DataProvider(name="UserNames")
    public Object[][] getUserNames() throws IOException
    {
        String path = System.getProperty("user.dir") + "//testData//api_test_data.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1");

        Object[][] apiData = new Object[rownum][1]; // Adjusted to return Object[][]
        for (int i = 1; i <= rownum; i++) {
            apiData[i - 1][0] = xl.getCellData("Sheet1", i, 1); // Single column data
        }
        return apiData;
    }




}
