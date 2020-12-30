import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class cimriDemo {
    @Test
    public void cimriTest(){
        RestAssured.baseURI = "https://graphql-2.cimri.com/";
        String response =  given().log().all()
                .header("Content-type","application/json")
                .header("cimri-platform-name","CIMRI_DESKTOP")
                .header("accept-encoding","gzip, deflate, br")
                .header("accept-language","tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7,pl;q=0.6")
                .body("{\n" +
                        "    \"query\": 42, \n" +
                        "    \"variables\": \n" +
                        "    {\n" +
                        "        \"productId\": 652985901\n" +
                        "    }\n" +
                        "\n" +
                        "}")
                .when().post()
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
    }
}
