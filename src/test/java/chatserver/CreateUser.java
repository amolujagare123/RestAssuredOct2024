package chatserver;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        given().log().all()
                //.auth().oauth2("amol5555")
                .auth().preemptive().basic("admin","admin123")
                .body("{\n" +
                        "\"username\": \"user_1728525251\", \n" +
                        "\"password\": \"dvwSie1WEXNs\", \n" +
                        "\"email\": \"user_1728525251@example.org\", \n" +
                        "\"name\": \"John\",\n" +
                        " \"surname\": \"Doe\", \n" +
                        "\"chat_nickname\": \"JohnD_1728525251\",\n" +
                        "  \"departments\": [\n" +
                        "    1,\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"departments_read\": [\n" +
                        "    2\n" +
                        "  ],\n" +
                        "  \"department_groups\": [\n" +
                        "    1\n" +
                        "  ],\n" +
                        "  \"user_groups\": [\n" +
                        "    1\n" +
                        "  ]\n" +
                        "}\n")
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
