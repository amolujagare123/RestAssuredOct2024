package SampleAPI;

import io.restassured.RestAssured;
import pojo.sampleAPI.SampleCreateUserPOJO;
import pojo.sampleAPI.SampleCreateUserResponsePOJO;

import static io.restassured.RestAssured.given;

public class CreateUserWithPojo2 {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";

        SampleCreateUserPOJO ob = new SampleCreateUserPOJO();
        ob.setName("Yatin");
        ob.setJob("Electrician");

        SampleCreateUserResponsePOJO responseObject = given().log().all()
                //  .header("Content-Type","application/json")
                .contentType("application/json")
                .body(ob)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .extract().response().as(SampleCreateUserResponsePOJO.class);

        System.out.println("name="+responseObject.getName());
        System.out.println("job="+responseObject.getJob());
        System.out.println("id="+responseObject.getId());
        System.out.println("created AT="+responseObject.getCreatedAt());

    }
}
