package DeckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import pojo.DeckOfCards.Cards;
import pojo.DeckOfCards.DeckOfCardsResponsePOJO;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class DeckOfCards {

    @Test
    public void deckOfCardsTest()
    {
        RestAssured.baseURI = "https://deckofcardsapi.com";

        String respStr = given().log().all()
                .queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();

        JsonPath jsonpath = new JsonPath(respStr);
        String deckID = jsonpath.get("deck_id");

        DeckOfCardsResponsePOJO responseObj = given().log().all()
                .queryParam("count", "2")
                .when().get("/api/deck/" + deckID + "/draw/")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(DeckOfCardsResponsePOJO.class);

        // print url of image
        System.out.println("======== PNG Images url ========");
        ArrayList<Cards> cards = responseObj.getCards();
        for (int i=0;i< cards.size() ; i++)
        {
            System.out.println(cards.get(i).getImage());
        }
        System.out.println("======== SVG Images url ========");

        // print url of svg image

        for (int i=0;i< cards.size() ; i++)
        {
            System.out.println(cards.get(i).getImages().getSvg());
        }

    }
}
