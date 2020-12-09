package day03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class Practice1 {

    @BeforeAll
    // in JUnit 5 @BeforeAll is static method
    // if we do not make static it does not work because that`s how it's defined in the doc
    public static void init(){
        //example of setting the port separately from baseURI
        RestAssured.baseURI = "http://52.86.149.122";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @DisplayName("simple test")
    @Test
    public void test1(){

        given()
                .log()
                .queryParam("gender","Female").
        when()
                .get("/spartans/search").
        then()
                .statusCode(200)
                ;




    }

}
