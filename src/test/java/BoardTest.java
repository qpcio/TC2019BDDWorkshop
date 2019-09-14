import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.IsEqual.equalTo;

public class BoardTest {
    private String url = "https://api.trello.com/1/";
    private static String key = "69ca272b48ebe66ff934cc6b092897e0";
    private static String token = "1a49b879cdb6d8f739f2ec26e747ff5c5e12871297c0eb9106aff350f54a9c4a";
    static private Map<String, String> parameters = new HashMap<String, String>();

    private String kolumnaAid = "5d73d5fdf35f43615a5571c6";
    private String kolumnaBid = "5d73d60416904388c9ddcf49";
    private String kolumnaCid = "5d73d6073426502c58ca8d67";
    private String boardId = "5d73d5ddfb18cf75b4be33f0";
    private String globalBoardId;


    @BeforeClass
    public static void populateMap() {
//        System.out.println("russian debug beforeclass");
        parameters.put("key", key);
        parameters.put("token", token);
    }

//    @Before
//    public void nothing(){
//        System.out.println("Polish before");
//    }
//
//    @After
//    public void nonothing(){
//        System.out.println("Ukrainian after");
//    }
//
//    @AfterClass
//    public static void nothing2(){
//        System.out.println("German afterclass");
//    }

    @Test
    public void getBoardCorrectly() {
        Response response = given()
                .when()
                .get(url + "boards/3nCXKl7N?key=" + key + "&token=" + token)
                .then()
                .extract()
                .response();

        assertTrue(response.statusCode() == 200);
        assertEquals("private", response.path("prefs.permissionLevel"));
    }

    @Test
    public void getBoardCorrectly2() {
        ValidatableResponse response = given()
                .queryParameters(parameters)
                .when()
                .get(url + "boards/3nCXKl7N")
                .then()
                .statusCode(200);
    }

    @Test
    public void getCards(){
        Response response = given()
                .queryParameters(parameters)
                .when()
                .get(url+"lists/"+kolumnaAid+"/cards")
                .then()
//                .log().body()                 //wyrzuca log calego body response'a
                .body("name[0]", equalTo("Karta A1"))
                
                .extract().response();

        assertEquals(3, response.jsonPath().getList("$").size());
//        assertEquals(1, response.jsonPath().getList("idMembersVoted[0]").size());
        assertTrue(response.jsonPath().getList("name").contains("Karta A2"));
        assertEquals("Karta A1", response.path("name[0]"));
    }

    @Test
    public void createBoard(){
        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .queryParam("key",key)
                .queryParam("token",token)
                .queryParam("name","Automatyczny board")
                .when()
                .post(url+"boards/")
                .then()
                .statusCode(200)
                .log().body();
        System.out.println(response.extract().response().path("id").toString());
        globalBoardId =  response.extract().response().path("id").toString();

    }
}
