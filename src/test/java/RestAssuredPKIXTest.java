import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.SSLHandshakeException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RestAssuredPKIXTest {
    @Test
    public void should_throw_pkix_exception() {
        Response response = given().contentType(ContentType.HTML)
                .when()
                .get("https://untrusted-root.badssl.com/")
                .then()
                .extract().response();
        assertEquals(HttpStatus.SC_OK, response.statusCode());
    }
}
