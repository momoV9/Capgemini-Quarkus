package com.capgemini.be.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class MetricsControllerTest {

    @Test
    void testMetricsEndpointReturns200() {
        given()
                .when()
                .get("http://localhost:8081/metrics")
                .then()
                .statusCode(200);
    }
}
