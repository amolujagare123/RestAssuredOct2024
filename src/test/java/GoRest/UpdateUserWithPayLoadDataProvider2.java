package GoRest;

import io.restassured.RestAssured;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.GoRestPalyLoad.GoRestPayLoad.getUpdatePayLoad;
import static util.ForDataProvider.getMyData;

public class UpdateUserWithPayLoadDataProvider2 {

    @Test(dataProvider = "getData")
    public void goRestTest(String name,String email,String gender,String status) {

        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .auth().oauth2("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
             //   .header("Authorization","Bearer 0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .contentType("application/json")
                .body(getUpdatePayLoad(name,email,gender,status))
                 .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(200);
    }

    @DataProvider
    Object[][] getData() throws IOException {

        return getMyData("Data/sample_data.xlsx","Sheet1");
    }
}
