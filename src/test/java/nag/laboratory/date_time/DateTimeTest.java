package nag.laboratory.date_time;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("datetime")
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
        assertThat(response.jsonPath().getString("createdTime")).isNotNull();
    }

    @Test
    void postNGet() {
        // given
        RestAssured.post("/date-time");

        // when & then
        RestAssured.get("/date-time")
                .then().log().all();
    }

}
