package Utils;

import com.jayway.restassured.response.Response;

public abstract class BaseUtils {

    protected String key = "69ca272b48ebe66ff934cc6b092897e0";
    protected String token = "1a49b879cdb6d8f739f2ec26e747ff5c5e12871297c0eb9106aff350f54a9c4a";
    protected String url = "https://api.trello.com/1/";
    protected String boardUrlPart = "boards";
    protected Response response;

    public void setKey(String key) {
        this.key = key;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getResponseCode(){
        return response.statusCode();
    }
}
