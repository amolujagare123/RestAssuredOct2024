package GoRest.specBuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static payload.GoRestPalyLoad.GoRestPayLoad.getUpdatePayLoad;

public class UpdateUserWithPayLoadParam {

    public static void main(String[] args) {

     /*   RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .auth().oauth2("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
             //   .header("Authorization","Bearer 0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .contentType("application/json")
                .body(getUpdatePayLoad("tushar","tushar@gmail.com","male","active"))
                 .when().patch("/public/v2/users/7463199")
                .then().log().all().assertThat().statusCode(200);*/


        // 1. create the object of request specification

        RequestSpecification requestSpecification
                = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .addHeader("Authorization"
                        ,"Bearer 0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .setContentType("application/json").build();

        // 2. call given with requestSpecification object through spec method
        // store it into an object ( request )

        RequestSpecification request = given().log().all().spec(requestSpecification)
                .body(getUpdatePayLoad("tushar", "tushar@gmail.com", "male", "active"));


        // 3. using request object created in previous step call method when
        // store it into response object
        Response response = request.when().post("/public/v2/users/7463199");

        // 4. create the object of responseSpecification
        ResponseSpecification responseSpecification
                = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        // 5. call then with responseSpecification object through spec method
        // store it into an object ( responseStr ) - optionally
        String responseStr = response.then().log().all()
                .spec(responseSpecification)
                .extract().response().asString();


    }
}
