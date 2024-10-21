package GoRest.specBuilder;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.GoRest.GoRestCreateUserPojo;

import static io.restassured.RestAssured.given;

public class CreateUserPOJO {

    public static void main(String[] args) {

       /* RestAssured.baseURI = "https://gorest.co.in/";

        GoRestCreateUserPojo ob = new GoRestCreateUserPojo();
        ob.setName("Alice");
        ob.setEmail("alice.williams@reqres.in");
        ob.setGender("female");
        ob.setStatus("active");

        given().log().all()
                .auth().oauth2("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .contentType("application/json")
                .body(ob)
                 .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);*/

        GoRestCreateUserPojo ob = new GoRestCreateUserPojo();
        ob.setName("Alice");
        ob.setEmail("alice.williams@reqres.in");
        ob.setGender("female");
        ob.setStatus("active");

  /*      OAuth2Scheme auth = new OAuth2Scheme();
       auth.setAccessToken("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a");*/

        RequestSpecification requestSpecification
                = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")

                .addHeader("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .setContentType("application/json")
                .build();

        RequestSpecification request 
                = given().log().all()
                .spec(requestSpecification)
                .body(ob);

        Response response = request.when().post("/public/v2/users");

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        String responseStr = response.then().log().all()
                .spec(responseSpecification)
                .extract().response().asString();

    }
}
