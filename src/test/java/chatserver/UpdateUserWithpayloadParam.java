package chatserver;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.chatServerPayLoad.UpdateUserPayload.getUpdateUserPayLoad;
import static payload.chatServerPayLoad.UpdateUserPayload.getUserPayLoad;

public class UpdateUserWithpayloadParam {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        String username = "john_doe2024";
        String password = "P@ssword123!";
        String name = "John";
        String surname = "Doe";
        String email = "johndoe2024@example.com";
        String nickname = "Johnny";

        given().log().all()
                //.auth().oauth2("amol5555")
                .auth().preemptive().basic("admin","admin123")
                .body(getUserPayLoad(username,password,name,surname,email,nickname))
                .when().put("/restapi/user/296")
                .then().log().all().assertThat().statusCode(200);
    }
}
