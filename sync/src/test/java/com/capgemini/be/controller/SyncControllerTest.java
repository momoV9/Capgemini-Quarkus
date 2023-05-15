//package com.capgemini.be.controller;
//
//import com.capgemini.be.lms.model.LeaveRequest;
//import com.capgemini.be.lms.model.LeaveType;
//import com.capgemini.be.lms.model.Reason;
//import com.capgemini.be.lms.model.Status;
//import com.capgemini.be.service.SyncService;
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@QuarkusTest
//public class SyncControllerTest {
//
//
//    private SyncController syncController;
//
//
//    private SyncService syncService;
//
//    public SyncControllerTest(SyncController syncController, SyncService syncService) {
//        this.syncController = syncController;
//        this.syncService = syncService;
//    }
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testSyncLeaveRequest() {
//        // Arrange
//        LeaveRequest leaveRequest = new LeaveRequest();
//        leaveRequest.setLocalEmployeeId(1);
//        leaveRequest.setLeaveType(LeaveType.VACATION);
//        leaveRequest.setStartDate(LocalDate.of(2023, 5, 16));
//        leaveRequest.setEndDate(LocalDate.of(2023, 5, 30));
//        leaveRequest.setReason(Reason.MARRIAGE);
//        leaveRequest.setStatus(Status.APPROVED);
//        int expectedStatusCode = 204;
//
//        // Act
//        Response response = RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(leaveRequest)
//                .when()
//                .post("/sync")
//                .then()
//                .extract()
//                .response();
//
//        // Assert
//        Mockito.verify(syncService, Mockito.times(1)).logRequest(leaveRequest);
//        assertEquals(expectedStatusCode, response.getStatusCode());
//    }
//}
