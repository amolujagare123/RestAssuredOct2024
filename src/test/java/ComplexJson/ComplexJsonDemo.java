package ComplexJson;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ComplexJsonDemo {

    @Test
    public void complexJsonTest() throws IOException {
        Path path = Paths.get("Data/complexJson.json");
        byte[] jsonFile = Files.readAllBytes(path);

        String responseStr = new String(jsonFile);

        System.out.println(responseStr);

        JsonPath jsonPath = new JsonPath(responseStr);

       // 1. Print No of courses returned by API

        int size = jsonPath.get("courses.size()");
        System.out.println("Size="+size);

        // 2.Print Purchase Amount
        int purchaseAmount = jsonPath.get("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);

        // 3. Print Title of the first course

        String courseName = jsonPath.get("courses[0].title");
        System.out.println("courseName="+courseName);

        // 4. Print All course titles and their respective Prices

        System.out.println("------------------------");
        System.out.println("courseTitle\t\tcoursePrice");
        System.out.println("------------------------");
        for(int i=0;i<size;i++) {
            String courseTitle = jsonPath.get("courses["+i+"].title");
            int coursePrice = jsonPath.get("courses["+i+"].price");

            System.out.println(courseTitle+"\t\t"+coursePrice);
        }

        // 5. Print no of copies sold by RPA Course
        System.out.println("------------------------");
        for(int i=0;i<size;i++) {


            String courseTitle = jsonPath.get("courses["+i+"].title");
            if(courseTitle.equalsIgnoreCase("RPA")) {
                int courseCopies = jsonPath.get("courses[" + i + "].copies");
                System.out.println(courseTitle + " Copies Sold = " + courseCopies);
            }
        }

        // 6. Verify if Sum of all Course prices matches with Purchase Amount

    }

}
