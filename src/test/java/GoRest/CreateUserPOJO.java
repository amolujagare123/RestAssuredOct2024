package GoRest;

import io.restassured.RestAssured;
import pojo.GoRest.GoRestCreateUserPojo;

import static io.restassured.RestAssured.given;

public class CreateUserPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in/";

        GoRestCreateUserPojo ob = new GoRestCreateUserPojo();
        ob.setName("Alice");
        ob.setEmail("alice.williams@reqres.in");
        ob.setGender("female");
        ob.setStatus("active");

        given().log().all()
                .auth().oauth2("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
             //   .header("Authorization","Bearer 0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .contentType("application/json")
                .body(ob)
                 .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);
    }
}
