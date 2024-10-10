package SampleAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all().contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"amol\",\n" +
                        "    \"job\": \"Test lead\"\n" +
                        "}")
                .when().patch("/api/users/2")
                .then().log().all().assertThat().statusCode(200);
    }
}
