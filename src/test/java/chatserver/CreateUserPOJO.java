package chatserver;

import io.restassured.RestAssured;
import pojo.chatServer.ChatServerCreateUserPojo;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUserPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:80/chat/lhc_web/index.php/site_admin";

        ChatServerCreateUserPojo ob = new ChatServerCreateUserPojo();
        ob.setUsername("username123");
        ob.setPassword("password123");
        ob.setEmail("example@example.com");
        ob.setName("John");
        ob.setSurname("Doe");
        ob.setChat_nickname("johnnyD");

        ArrayList<Integer> twoValues = new ArrayList<>();
        twoValues.add(1);
        twoValues.add(2);

        ArrayList<Integer> value1 = new ArrayList<>();
        value1.add(1);

        ArrayList<Integer> value2 = new ArrayList<>();
        value2.add(2);

        ob.setDepartments(twoValues);
        ob.setDepartment_groups(value1);
        ob.setDepartments_read(value2);
        ob.setUser_groups(value1);

        given().log().all()
                //.auth().oauth2("amol5555")
                .auth().preemptive().basic("admin","admin123")
                .body(ob)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }
}
