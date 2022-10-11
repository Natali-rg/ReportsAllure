import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {

    static final String URL="http://127.0.0.1:8080/";

    @Test
    public void test(){
        String str=given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"users/120")
                .then().log().all()
                .extract().body().jsonPath().get().toString();

        System.out.println("JSON BODY"+str);
    }
}
