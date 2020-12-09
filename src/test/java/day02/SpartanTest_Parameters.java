package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class SpartanTest_Parameters {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://52.86.149.122:8000" ;
        RestAssured.basePath = "/api" ;
    }

    @DisplayName("Testing /spartans/{id}")
    @Test
    public void testingSingleSpartan(){

        given()
                .log().all()
                .pathParam("id",55).
        when()
                .get("spartans/{id}").

        then()
                .statusCode(200);


            }


    @DisplayName("Testing /spartans/{id}")
    @Test
    public void testingSingleSpartan2(){

        given()
                .log().all().
        when()
                .get("spartans/{id}",55).
        then()
                .statusCode(200);

    }

    @DisplayName("Testing /spartans/{id} Body")
    @Test
    public void testingSingleSpartanBody(){

        given()
                .log().all()
                .pathParam("id",55).
        when()
                .get("spartans/{id}").
        then()
                .log().all()
                .statusCode(200)
                // .body("JSON Path", is("THE VALUE"))
                .body("id",is(55))
                .body("name",   is("Karmen") )
                .body("gender", is("Female") )
                .body("phone",  is(5052029186L) )
                ;

    }

}
