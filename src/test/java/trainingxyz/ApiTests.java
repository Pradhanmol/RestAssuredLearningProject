package trainingxyz;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.junit.jupiter.api.TestTemplate;
import org.modals.Product;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class ApiTests {
    @Test
    public void getRequest(){
        RestAssured.baseURI = "http://localhost:8888/api_testing";

        var response = given().when().get("/category/read.php").then();
        response.log().body();

    }
    @Test
    public void getQueryParamReq(){
        String endPoint = "http://localhost:8888/api_testing/product/read_one.php";
        var response = given()
                .queryParam("id",1003)
                .when()
                .get(endPoint)
                // assrtion implementation
                .then().assertThat().statusCode(200);

        response.log().body();
    }
    // post req
    @Test
    public void createProduct(){
        String endPoint = "http://localhost:8888/api_testing/product/create.php";
        String payload = "{"
                + "\"name\": \"water bottle\","
                + "\"description\": \"blue water bottle holds 64 ounces\","
                + "\"price\": 12,"
                + "\"category_id\": 3"
                + "}";
        var response = given()
                .body(payload)
                .when()
                .post(endPoint)
                .then();
        response.log().body();
    }
    //put req
    @Test
    public void updateProduct(){
        String endPoint = "http://localhost:8888/api_testing/product/update.php";
        String payload = "{"
                + "\"name\": \"water bottle\","
                + "\"description\": \"blue water bottle holds 64 ounces\","
                + "\"price\": 15,"
                + "\"category_id\": 3"
                + "}";
        var response = given().body(payload)
                .when().post(endPoint)
                .then();
        response.log().body();
    }
    @Test
    public void deleteProduct(){
        String endPoint = "http://localhost:8888/api_testing/product/delete.php";
        String payload =  "{"
                + "\"id\": 19"
                + "}";
        var response = given().body(payload)
                .when().delete(endPoint)
                .then();
        response.log().body();
    }

    @Test
    public void createSeralizedProduct(){
        String endPoint = "http://localhost:8888/api_testing/product/create.php";

        Product product = new Product(
                "Water bottle",
                "Blue Water",
                12,
                3,"anmol"
        );
        var response = given().body(product).when().post(endPoint).then();
        response.log().body();
    }
    @Test
    public void getDeserializedProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        //"id":"2","name":"Cross-Back Training Tank","description":"The most awesome phone of 2013!","price":"299.00","category_id":"2","category_name":"Active Wear - Women"}
        Product expectedProduct = new Product(
                2,
                "Cross-Back ",
                "The most awesome phone of 2013!",
                299.00,
                2,
                "Active Wear - Women"
        );

        Product actualProduct =
                given().
                        queryParam("id", "2").
                        when().
                        get(endpoint).
                        as(Product.class);

        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));
    }

    @Test
    public void getProducts(){
        String endpoint = "http://localhost:8888/api_testing/product/read.php";
        given().
                when().
                get(endpoint).
                then().
                log().
                headers().
                assertThat().
                statusCode(200).
                header("Content-Type", equalTo("application/json; charset=UTF-8")).
                body("records.size()", greaterThan(0)).
                body("records.id", everyItem(notNullValue())).
                body("records.name", everyItem(notNullValue())).
                body("records.description", everyItem(notNullValue())).
                body("records.price", everyItem(notNullValue())).
                body("records.category_id", everyItem(notNullValue())).
                body("records.category_name", everyItem(notNullValue())).
                body("records.id[0]", equalTo("25"));
    }

    @Test(invocationCount = 5)
    public void validateTheJSon(){
        baseURI = "https://reqres.in/api";
       Response res = given().
                when().get(baseURI+"/users?page=2");

       res.then().assertThat()
                .time(lessThan(Long.valueOf(300)))
                .body(matchesJsonSchemaInClasspath("user.json"))
                .log().body();
        System.out.println(res.timeIn(TimeUnit.MILLISECONDS));
    }

}
