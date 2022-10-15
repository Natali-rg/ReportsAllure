package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationsRest {
    public static RequestSpecification setRecSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }
    public static ResponseSpecification setResponceSpec200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification setResponceSpec201(){
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
    public static void setSpecForRestAssured(RequestSpecification requestSpecification,ResponseSpecification responseSpecification){
        RestAssured.requestSpecification=requestSpecification;
        RestAssured.responseSpecification=responseSpecification;
    }


}
