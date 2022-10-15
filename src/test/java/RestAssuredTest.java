import data.User;
import data.UserForPost;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import specifications.SpecificationsRest;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RestAssuredTest {

    static final String URL="http://127.0.0.1:8080/";

    @BeforeClass
    public static void initt(){
        SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setRecSpec(URL),SpecificationsRest.setResponceSpec200());

    }

    @Test
    public void test1(){//get request BODY in String format
        String str=given()
                .when()
                .get("users/120")
                .then().log().all()//вывод в консоль
                .extract().body().jsonPath().get().toString();

        System.out.println("JSON BODY"+str);
    }
    @Test
    public void test2(){
        given()
                .when()
                .get("users/120")
                .then().log().all()//вывод в консоль
                .body("email",equalTo("lucy@email.com"));
    }
    @Test
    public void test3(){
        given()
                .when()
                .get("users")//проверяет список юзеров
                .then().log().all()//вывод в консоль
                .body("email",equalTo("lucy@email.com"));
    }
    @Test
    public void test4(){//проверяет, что поле email не пустое
        given()
                .when()
                .get("users")
                .then().log().all()//вывод в консоль
                .body("email",notNullValue())
                .body("id",notNullValue());//id не пустое
    }
    @Test
    public void test5(){//парсит юзера как обьект и выводит имя юзера
        User user=given()
                .when()
                .get("users/120")
                .then().log().all()//вывод в консоль
                .extract().as(User.class);
        System.out.println(user.username);

    }
    @Test
    public void test6(){//
        List<User> users=given()//парсит список юзеров и выводит имена
                .when()
                .get("users")
                .then().log().all()//вывод в консоль
                .extract().body().jsonPath().getList(".",User.class);
        for (User x:users){
            System.out.println(x.username);
        }
    }
    @Test
    public void test7(){
        SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setRecSpec(URL),SpecificationsRest.setResponceSpec201());
        UserForPost user=new UserForPost("Madlen", "mad457@mail.com","Mad41255");
        Response response=given()
                .when()
                .body(user)
                .post("users")
                .then().log().all()
                .extract().response();
        System.out.println((String) response.jsonPath().get("id"));
    }

}
