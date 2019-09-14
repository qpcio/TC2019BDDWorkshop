package StepsDef;

import Utils.BoardUtils;
import com.jayway.restassured.response.Response;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.TestCase.assertEquals;


import static com.jayway.restassured.RestAssured.given;

public class BoardsSteps {
//    String key;
//    String token;
//    private String url = "https://api.trello.com/1/";
//    Response response;
    BoardUtils boardUtils = new BoardUtils();

    @Given("I use {string} and {string}")
    public void i_use_and(String key, String token) {
//        this.key = key;
//        this.token = token;
          boardUtils.setKey(key);
          boardUtils.setToken(token);
    }

    @When("I get board {string}")
    public void i_get_board(String boardId) {
//        response = given()
//                .when()
////                .log().all()
//                .get(url + "boards/"+boardId+"?key=" + key + "&token=" + token)
//                .then()
//                .extract()
//                .response();
        boardUtils.getBoard(boardId);
    }

    @Then("Response code is <{int}>")
    public void response_code_is(int responseCode) {
        //assertEquals(responseCode,response.statusCode());
        assertEquals(responseCode,boardUtils.getResponseCode());
    }

    @Then("Board privacy is {string}")
    public void boardPrivacyIs(String privacy) {
        //assertEquals(privacy,response.path("prefs.permissionLevel"));
        assertEquals(privacy,boardUtils.getPrivacy());
    }

    @When("I create board {string}")
    public void iCreateBoard(String boardName) {
         boardUtils.createBoard(boardName);
    }
}
