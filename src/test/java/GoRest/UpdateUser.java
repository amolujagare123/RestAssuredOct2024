package GoRest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in/";

        String responseStr = given().log().all()
                .auth().oauth2("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                //   .header("Authorization","Bearer 0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .contentType("application/json")
                .body("{\n" +
                        "        \"name\": \"Rohini Rajput\",\n" +
                        "        \"email\": \"rohini22@gmail.com\",\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"status\": \"active\"\n" +
                        "    }")
                .when().patch("/public/v2/users/7463199")
                .then().log().all().assertThat()
                .statusCode(200).extract().response().asString();

        System.out.println("The response string is \n"+responseStr);

        JsonPath jsonPath = new JsonPath(responseStr);

        String email = jsonPath.getString("email");

        System.out.println("email="+email);

        int id = jsonPath.getInt("id");
        System.out.println("id="+id);


    }
}
