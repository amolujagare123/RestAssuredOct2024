package SampleAPI;

import io.restassured.RestAssured;
import pojo.sampleAPI.Data;
import pojo.sampleAPI.SampleGetAllUserResponsePOJO;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetAllUsersRespPojo {


    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";

        SampleGetAllUserResponsePOJO responseObj = given().log().all().queryParam("page", "2")
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().as(SampleGetAllUserResponsePOJO.class);

        // print all first names

        ArrayList<Data> data = responseObj.getData();

        for (int i=0;i<data.size();i++)
        {
            System.out.println("First Name="+data.get(i).getFirst_name());
        }

    }
}
