package chatserver;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.chatServerPayLoad.UpdateUserPayload.getUpdateUserPayLoad;

public class UpdateUserWithpayload {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                //.auth().oauth2("amol5555")
                .auth().preemptive().basic("admin","admin123")
                .body(getUpdateUserPayLoad())
                .when().put("/restapi/user/296")
                .then().log().all().assertThat().statusCode(200);
    }
}
