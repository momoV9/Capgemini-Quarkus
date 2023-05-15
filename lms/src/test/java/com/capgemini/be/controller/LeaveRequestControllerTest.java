package com.capgemini.be.controller;

import com.capgemini.be.lms.model.LeaveRequest;
import com.capgemini.be.lms.model.LeaveType;
import com.capgemini.be.lms.model.Reason;
import com.capgemini.be.lms.model.Status;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class LeaveRequestControllerTest {

    @Test
    public void testSendLeaveRequestToSync() {
        // Arrange
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setLocalEmployeeId(1);
        leaveRequest.setLeaveType(LeaveType.VACATION);
        leaveRequest.setStartDate(LocalDate.of(2023, 5, 16));
        leaveRequest.setEndDate(LocalDate.of(2023, 5, 30));
        leaveRequest.setReason(Reason.MARRIAGE);
        leaveRequest.setStatus(Status.APPROVED);
        int expectedStatusCode = 204;

        // Act
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(leaveRequest)
                .when()
                .post("/leaves")
                .then()
                .extract()
                .response();

        // Assert
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
}
