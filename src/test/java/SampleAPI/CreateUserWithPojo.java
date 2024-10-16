package SampleAPI;

import io.restassured.RestAssured;
import pojo.sampleAPI.SampleCreateUserPOJO;

import static io.restassured.RestAssured.given;

public class CreateUserWithPojo {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";

        SampleCreateUserPOJO ob = new SampleCreateUserPOJO();
        ob.setName("Yatin");
        ob.setJob("Electrician");

        given().log().all()
              //  .header("Content-Type","application/json")
                .contentType("application/json")
                .body(ob)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }
}
