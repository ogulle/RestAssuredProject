package day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class OpenMovieDB_Test {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://www.omdbapi.com" ;

    }

    @DisplayName("Test Movie API")
    @Test
    public void testMovies(){

        given()
                .log().all()
                .queryParam("apikey","9c74259d")
                .queryParam("t","Boss Baby")
                .queryParam("plot", "full").
        when()
                .get().
        then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("Title",is("The Boss Baby"))
                .body("Year",is("2017"))
                .body("Ratings[0].Value",is("6.3/10"))
                .body("Ratings[2].Value",is("50/100"))
                // checking title contains Boss Baby
                // if you are searching for exact match use is equalTo
                .body("Title",containsString("Boss Baby"))

                ;

    }


}
