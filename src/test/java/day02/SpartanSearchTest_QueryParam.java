package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class SpartanSearchTest_QueryParam {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://52.86.149.122:8000" ;
        RestAssured.basePath = "/api" ;
    }
    //http://54.174.216.245:8000/api/spartans/search?gender=male&nameContains=ea
    @DisplayName("Testing/spartans/search Endpoint")
    @Test
    public void testSearch(){

        given()
                .log().all()
                .queryParam("gender","Male")
                .queryParam("nameContains","a").
        when()
                .get("spartans/search").
        then()
                .log().all()
                .statusCode(200)
            //assert number of elements according to your results then
                .body("numberOfElements", is(37))
                ;








    }





}
