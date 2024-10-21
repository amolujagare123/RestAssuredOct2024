package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
              //          .header("Authorization","Bearer 0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .auth().oauth2("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .contentType("application/json")
                .when().get("/public/v2/users")
                .then().log().all().assertThat().statusCode(200);
    }
}
