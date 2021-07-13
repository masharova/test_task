package getTest;

import io.restassured.RestAssured;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTest {
    private final String expectedResult = "Death Star";
    private final String fieldName = "name";
    private final String API_URL = "https://swapi.dev/api/starships/9/";

    @Test
    public void verifyThatNameContainsCorrectName() {
        given().header("content-type", "application/json")
                .get(API_URL)
                .then().log().body();
        assertThat(RestAssured.given()
                .response()
                .statusCode(200)
                .body(fieldName, equalTo(expectedResult)));
    }
}
