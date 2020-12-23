package day03;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PutDeleteRequestExample {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://52.86.149.122";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @DisplayName("Updating existing Data")
    @Test
    public void updateSpartan(){

        String updatedBody = "{\n" +
                "  \"name\"  : \"Wonder Woman\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"phone\": 1234567890\n" +
                "}" ;

        given()
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .log().all().
        when()
                .put("/spartans/{id}",132).
                then()
                .statusCode(204);
    }

    @Test
    public void testDelete(){

        when()
                .delete("spartans/{id}",132).
                then()
                .statusCode(204)

        ;




    }


}
