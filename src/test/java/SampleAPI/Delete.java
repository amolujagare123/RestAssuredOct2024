package SampleAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Delete {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all().contentType("application/json")
                .when().delete("/api/users/2")
                .then().log().all().assertThat().statusCode(204);
    }
}
