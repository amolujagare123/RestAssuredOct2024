package GoRest;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUserUsingJsonFile {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://gorest.co.in/";

        Path path = Paths.get("Data/GoRestCreateUser.json");

        byte[] jsonFile = Files.readAllBytes(path);

        String payload = new String(jsonFile);

        given().log().all()
                .auth().oauth2("0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
             //   .header("Authorization","Bearer 0ebaaac6f293e3feb16eb863a7be8cfc92cf5fa55f015171f26d6be106323d8a")
                .contentType("application/json")
                .body(payload)
                 .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(200);
    }
}
