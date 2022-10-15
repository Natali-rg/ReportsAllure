import org.junit.BeforeClass;
import org.junit.Test;
import specifications.SpecificationsRest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class restAssuredTestHW {

    static final String URL="http://127.0.0.1:8080/";
    @BeforeClass
    public static void initt(){
        SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setRecSpec(URL),SpecificationsRest.setResponceSpec200());

    }

    @Test
    public void test1(){
        given()
                .when()
                .get("users/findByUsername/Bill")
                .then().log().all();//вывод в консоль

    }

    @Test
    public void test2(){//проверяет, что поле email не пустое
        given()
                .when()
                .get("users")
                .then().log().all()//вывод в консоль
                .body("email",notNullValue());
    }

}
