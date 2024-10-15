package SampleAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in/";

        given().log().all()
                .contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"amol\",\n" +
                        "    \"job\": \"Test lead\"\n" +
                        "}")
                .when().patch("/api/users/2")
                .then().log().all().assertThat()
                .statusCode(200)
                .body("name",equalTo("amol"))
                .header("Connection","keep-alive")
                .time(lessThan(300L));
    }
}
