package src.test.java.integrational_tests;

import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;


public class WorldTest {
    @Test
    public void first_get_json_test() {
        System.out.println("say test integration");
        given().
                accept("application/json").
                when().
                get("https://jsonplaceholder.typicode.com/todos/1").
                then().
                statusCode(200).assertThat().
                body("userId", equalTo(1)).
                body("title", equalTo("delectus aut autem"));
    }

}
