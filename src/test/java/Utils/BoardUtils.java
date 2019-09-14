package Utils;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;

import static com.jayway.restassured.RestAssured.given;

public class BoardUtils extends BaseUtils {
    private String boardId = "5d73d5ddfb18cf75b4be33f0";

    public void getBoard(String boardId) {
        response = given()
                .when()
//                .log().all()
                .get(url + boardUrlPart + "/" + boardId + "?key=" + key + "&token=" + token)
                .then()
                .extract()
                .response();
    }

    public void createBoard(String boardName) {
        response = given()
                .contentType(ContentType.JSON)
                .queryParam("key", key)
                .queryParam("token", token)
                .queryParam("name", boardName)
                .when()
                .post(url + "boards/")
                .then()
                .extract()
                .response();
        this.boardId = response.path("id").toString();

    }

    public String getPrivacy() {
        return response.path("prefs.permissionLevel");
    }


}
