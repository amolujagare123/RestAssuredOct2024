package SampleAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUSer {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";

        given().log().all()
              //  .header("Content-Type","application/json")
                .contentType("application/json")
                .body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }
}
