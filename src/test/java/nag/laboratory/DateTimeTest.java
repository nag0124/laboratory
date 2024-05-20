package nag.laboratory;

import static org.assertj.core.api.Assertions.*;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import nag.laboratory.datetime.DateTime;
import nag.laboratory.datetime.DateTimeResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DateTimeTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    void post() {
        // when
        Response response = RestAssured
                .given().log().all()
                .when()
                .post("/date-time")
                .then().log().all()
                .extract().response();

        // then
        System.out.println(OffsetDateTime.now());
        assertThat(response.jsonPath().getString("createdTime")).isNotNull();
    }

}
