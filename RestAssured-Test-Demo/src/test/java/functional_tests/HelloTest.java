package src.test.java.functional_tests;

import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.core.IsEqual.equalTo;
import com.google.gson.*;

public class HelloTest {
    @Before
    public void before() {
        System.out.println("say test function");

    }
    @Test
    public void first_get_json_test() {
            given().
                    accept("application/json").
                    when().
                    get("https://jsonplaceholder.typicode.com/todos/1").
                    then().
                    statusCode(200).assertThat().
                    body(matchesJsonSchemaInClasspath("data-schema.json")).
                    body("userId", equalTo(1)).
                    body("title", equalTo("delectus aut autem"));

    }

//可运行代码
//    @Test
//    public void second_post_jsonArray_test() {
//        JsonArray notifications = new JsonArray();
//        JsonObject notification = new JsonObject();
//        notification.addProperty("key", "value");
//        notifications.add(notification);
//       given().
//                contentType("application/json;charset=UTF-8").
//               body(notifications.toString()).
//                when().
//                    post("https://XXX").
//                    then().
//                    statusCode(200);
//    }

}
