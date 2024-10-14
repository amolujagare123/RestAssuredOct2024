package chatserver;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static payload.chatServerPayLoad.UpdateUserPayload.getUserPayLoad;
import static util.ForDataProvider.getMyData;

public class CreateUserPayLoadDP {

    @Test (dataProvider = "getData")
    public void createUserTest(String username,String password,String name,String surname,String email,String nickName) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                //.auth().oauth2("amol5555")
                .auth().preemptive().basic("admin","admin123")
                .body(getUserPayLoad(username,password,name,surname,email,nickName))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }

    @DataProvider
    Object[][] getData() throws IOException {
        return getMyData("Data/user_data_with_email.xlsx","Sheet1");
    }
}
